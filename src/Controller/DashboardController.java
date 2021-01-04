/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Handler.ListTransferHandler;
import Entity.Todo;
import Model.TodoModel;
import Todolistdemo.App;
import View.DashboardComponent;
import View.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author khisby
 */
public class DashboardController {

    private App app;
    private TodoModel model;
    private View view;
    private int list_number;
    private int index_number;

    public DashboardController(App app) {
        this.model = app.todo_model;
        this.view = app.view;
        this.app = app;

        list_number = -1;
        index_number = -1;
    }

    public void todo() {
//        this.model.add(new Todo("Ngoding Web PHP", 1, app.session));
//        this.model.add(new Todo("Ngoding Java", 2, app.session));
//        this.model.add(new Todo("Ngoding OOP", 1, app.session));
//        this.model.add(new Todo("Ngoding Python", 3, app.session));

        this.view.reset();
        DashboardComponent dashboardComponent = new DashboardComponent(app.session);

        DefaultListModel DFLtodo = new DefaultListModel();
        DefaultListModel DFLworking = new DefaultListModel();
        DefaultListModel DFLdone = new DefaultListModel();

        for (Todo todo : this.model.getAllByUser(app.session)) {
            if (todo.getStatus() == 1) {
                DFLtodo.addElement(todo.getNama_kegiatan());
            } else if (todo.getStatus() == 2) {
                DFLworking.addElement(todo.getNama_kegiatan());
            } else {
                DFLdone.addElement(todo.getNama_kegiatan());
            }
        }
        
//        dashboardComponent.getJTFnama().setDragEnabled(true);

        JList JLtodo = dashboardComponent.getJLtodo();
        JLtodo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JLtodo.setDragEnabled(true);
        JLtodo.setDropMode(DropMode.INSERT);
        JLtodo.setTransferHandler(new ListTransferHandler(1, this.model, app));
        JLtodo.setModel(DFLtodo);

        JList JLworking = dashboardComponent.getJLworking();
        JLworking.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JLworking.setDragEnabled(true);
        JLworking.setDropMode(DropMode.INSERT);
        JLworking.setTransferHandler(new ListTransferHandler(2, this.model, app));
        JLworking.setModel(DFLworking);

        JList JLdone = dashboardComponent.getJLdone();
        JLdone.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JLdone.setDragEnabled(true);
        JLdone.setDropMode(DropMode.INSERT);
        JLdone.setTransferHandler(new ListTransferHandler(3, this.model, app));
        JLdone.setModel(DFLdone);

        JLtodo.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                JLworking.clearSelection();
                JLdone.clearSelection();

                list_number = 1;
                index_number = JLtodo.getSelectedIndex();
            }
        });

        JLworking.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                JLtodo.clearSelection();
                JLdone.clearSelection();

                list_number = 2;
                index_number = JLworking.getSelectedIndex();
            }
        });

        JLdone.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                JLtodo.clearSelection();
                JLworking.clearSelection();

                list_number = 3;
                index_number = JLdone.getSelectedIndex();
            }
        });

        this.view.add(dashboardComponent);
        this.view.tampilkan();

        dashboardComponent.getJBlogout().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dashboardComponent.showMessage("info", "Berhasil Logout");
                app.auth_controller.login();
            }

        });

        dashboardComponent.getJBremove().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (list_number == -1 || index_number == -1) {
                    dashboardComponent.showMessage("danger", "Tidak ada item yang dipilih");
                } else {
                    int index = -1;
                    for (int i = 0; i < model.getAll().size(); i++) {

                        Todo todo = model.getAll().get(i);

                        if (todo.getUser().equals(app.session)) {
                            if (todo.getStatus() == list_number) {
                                index = index + 1;

                                if (index == index_number) {
                                    model.remove(i);
                                }
                            }
                        }

                    }

                    app.dashboard_controller.todo();
                }
            }
        });

        dashboardComponent.getJBadd().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (dashboardComponent.getJTFnama().getText().equals("")) {
                    dashboardComponent.showMessage("danger", "Isian Todo Tidak Boleh Kosong");
                } else {
                    String nama = dashboardComponent.getJTFnama().getText();
                    model.add(new Todo(nama, 1, app.session));
                    app.dashboard_controller.todo();
                }
            }
        });

    }

}
