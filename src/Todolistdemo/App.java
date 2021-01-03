/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Todolistdemo;

import Controller.AuthController;
import Controller.DashboardController;
import Entity.User;
import Model.TodoModel;
import Model.UserModel;
import View.View;

/**
 *
 * @author khisby
 */
public class App {
    public UserModel user_model;
    public TodoModel todo_model;
    public AuthController auth_controller;
    public DashboardController dashboard_controller;
    public View view;
    public User session;

    public App() {
        this.view = new View();
        this.user_model = new UserModel();
        this.todo_model = new TodoModel();
        this.auth_controller = new AuthController(this);
        this.dashboard_controller = new DashboardController(this);
    }

    void start() {
        this.auth_controller.login();
    }
    
}
