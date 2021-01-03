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
public class User{
    private String nama;
    private String sandi;
    private String jenis_kelamin;

    public User(String nama, String sandi, String jenis_kelamin) {
        this.nama = nama;
        this.sandi = sandi;
        this.jenis_kelamin = jenis_kelamin;
    }

    public User() {
    }

    public String getNama() {
        return nama;
    }
    
    public String getNamaPanggilan() {
        String nama;
        if(this.jenis_kelamin.equals("Laki - Laki")){
            nama = "Mas " + this.nama;
        }else{
            nama = "Mbak " + this.nama;
        }
        
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSandi() {
        return sandi;
    }

    public void setSandi(String sandi) {
        this.sandi = sandi;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }
    
}
