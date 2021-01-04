/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Handler;

import Entity.Todo;
import Entity.User;
import Model.TodoModel;
import Todolistdemo.App;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.TransferHandler;

/**
 *
 * @author khisby
 */
public class ListTransferHandler extends TransferHandler {

    private TodoModel model;
    private User user;
    private App app;
    int list_number;

    public ListTransferHandler(int list_number, TodoModel model, App app) {
        this.model = model;
        this.user = app.session;
        this.list_number = list_number;
        this.app = app;
    }

    @Override
    protected void exportDone(JComponent source, Transferable data, int action) {
        if (action == TransferHandler.MOVE) {
            JList sources = (JList) source;
            DefaultListModel listModel = (DefaultListModel) sources.getModel();
            int index_number = sources.getSelectedIndex();
//            listModel.remove(sources.getSelectedIndex());

            int index = -1;
            for (int i = 0; i < this.model.getAll().size(); i++) {

                Todo todo = this.model.getAll().get(i);

                if (todo.getUser().equals(this.user)) {
                    if (todo.getStatus() == this.list_number) {
                        index = index + 1;

                        if (index == index_number) {
                            model.remove(i);
                        }
                    }
                }

            }
        }
    }

    @Override
    protected Transferable createTransferable(JComponent c) {
        JList list = (JList) c;
        return new StringSelection(list.getSelectedValue().toString());
    }

    @Override
    public int getSourceActions(JComponent c) {
        return TransferHandler.COPY_OR_MOVE;
    }

    @Override
    public boolean canImport(TransferSupport support) {
        if (!support.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean importData(TransferSupport support) {
        if (!support.isDrop()) {
            return false;
        }

        JList list = (JList) support.getComponent();

        String data;

        try {
            data = (String) support.getTransferable().getTransferData(DataFlavor.stringFlavor);
        } catch (Exception e) {
            return false;
        }

//        DefaultListModel listModel = (DefaultListModel) list.getModel();
//        JList.DropLocation dl = (JList.DropLocation) support.getDropLocation();
//        int index = dl.getIndex();
//
//        listModel.add(index, data);
        
        this.model.add(new Todo(data, this.list_number, this.user));
        
        this.app.dashboard_controller.todo();
        return true;
    }

}
