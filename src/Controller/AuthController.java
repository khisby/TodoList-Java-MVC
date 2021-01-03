/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.User;
import Model.UserModel;
import Todolistdemo.App;
import View.LoginComponent;
import View.RegisterComponent;
import View.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author khisby
 */
public class AuthController{
    private App app;
    private UserModel model;
    private View view;
    
    public AuthController(App app) {
        this.model = app.user_model;
        this.view = app.view;
        this.app = app;
    }
    
    public void register(){
        this.view.reset();
        RegisterComponent registerComponent = new RegisterComponent();
        
        this.view.add(registerComponent);
        this.view.tampilkan();
        
        registerComponent.getJBregister().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User();
                user.setNama(registerComponent.getJTFnama().getText());
                user.setSandi(registerComponent.getJTFsandi().getText());
                
                String jenis_kelamin;
                if(registerComponent.getJRBlaki().isSelected()){
                    jenis_kelamin = "Laki - Laki";
                }else{
                    jenis_kelamin = "Perempuan";
                }
                
                user.setJenis_kelamin(jenis_kelamin);
                model.add(user);
                login();
            }
        });
        
        registerComponent.getJBlogin().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
    }
    
    public void login(){
        this.view.reset();
        LoginComponent loginComponent = new LoginComponent();
        
        this.view.add(loginComponent);
        this.view.tampilkan();
        
        loginComponent.getJBregister().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });
        
        loginComponent.getJBlogin().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = loginComponent.getJTFnama().getText();
                String sandi = loginComponent.getJTFsandi().getText();
                
                User user = null;
                for(User u : model.getAll()){
                    if(u.getNama().equals(nama) && u.getSandi().equals(sandi)){
                        user = u;
                    }
                }
                
                if(user == null){
                    loginComponent.showMessage("danger","Akun tidak ditemukan. Username Atau sandi Salah");
                }else{
                    app.session = user;
                    System.out.println("Login User");   
                    app.dashboard_controller.todo();
                }
            }
        });
    }
    
}
