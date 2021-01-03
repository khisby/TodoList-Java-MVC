/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author khisby
 */
public class Todo{
    private String nama_kegiatan;
    private int status;
    private User user;
    
    public Todo(String nama_kegiatan, int status, User user) {
        this.nama_kegiatan = nama_kegiatan;
        this.status = status;
        this.user = user;
    }

    public Todo() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public String getStatusName(){
        String nama_status;
        if(status == 1){
            nama_status = "Todo";
        }else if(status == 2){
            nama_status = "Working";
        }else{
            nama_status = "Done";
        }
        return nama_status;
    }

    public String getNama_kegiatan() {
        return nama_kegiatan;
    }

    public void setNama_kegiatan(String nama_kegiatan) {
        this.nama_kegiatan = nama_kegiatan;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
            
}
