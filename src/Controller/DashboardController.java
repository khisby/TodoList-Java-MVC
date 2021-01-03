/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.TodoModel;
import Todolistdemo.App;
import View.View;

/**
 *
 * @author khisby
 */
public class DashboardController{
    private App app;
    private TodoModel model;
    private View view;

    public DashboardController(App app) {
        this.model = app.todo_model;
        this.view = app.view;
        this.app = app;
    }

    public void todo() {
        
    }
    
}
