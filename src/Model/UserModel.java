/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.User;
import java.util.ArrayList;

/**
 *
 * @author khisby
 */
public class UserModel{
    private ArrayList<User> arr;

    public UserModel() {
        this.arr = new ArrayList<>();
    }

    public void add(User entity) {
        this.arr.add(entity);
    }

    public void remove(int index) {
        this.arr.remove(index);
    }

    public ArrayList<User> getAll() {
        return this.arr;
    }

    public User getByIndex(int index) {
        return this.arr.get(index);
    }
    
}
