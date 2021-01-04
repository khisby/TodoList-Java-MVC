/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Todo;
import Entity.User;
import java.util.ArrayList;

/**
 *
 * @author khisby
 */
public class TodoModel{
    private ArrayList<Todo> arr;

    public TodoModel() {
        this.arr = new ArrayList<>();
    }

    public void add(Todo entity) {
        this.arr.add(entity);
    }

    public void remove(int index) {
        this.arr.remove(index);
    }

    public ArrayList<Todo> getAll() {
        return this.arr;
    }

    public Todo getByIndex(int index) {
        return this.arr.get(index);
    }
    
    public ArrayList<Todo> getAllByUser(User user){
        ArrayList<Todo> arr = new ArrayList<Todo>();
        for(Todo todo : this.arr){
            if(todo.getUser().equals(user)){
                arr.add(todo);
            }
        }
        return arr;
    }
    
}
