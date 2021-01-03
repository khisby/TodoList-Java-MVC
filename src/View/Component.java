/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author khisby
 */
public class Component extends JPanel{
    
    public void showMessage(String tipe, String pesan) {
        if(tipe.equals("danger")){
            JOptionPane.showMessageDialog(this, pesan, "Terjadi Kesalahan", JOptionPane.ERROR_MESSAGE);
        }else if(tipe.equals("info")){
            JOptionPane.showMessageDialog(this, pesan, "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
