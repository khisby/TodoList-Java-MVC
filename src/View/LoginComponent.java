/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author khisby
 */
public class LoginComponent extends Component{
    private JTextField JTFnama;
    private JTextField JTFsandi;
    private JButton JBregister;
    private JButton JBlogin;

    public LoginComponent() {
        GridLayout layout = new GridLayout(20,1);
        setLayout(layout);
        
        JTFnama = new JTextField();
        JTFsandi = new JTextField();
        JBlogin = new JButton("Login");
        JBregister = new JButton("Register");
                
        add(new JLabel("Nama"));
        add(JTFnama);
        add(new JLabel("Sandi"));
        add(JTFsandi);
        add(JBlogin);
        add(JBregister);
    }

    public JButton getJBlogin() {
        return JBlogin;
    }

    public JTextField getJTFnama() {
        return JTFnama;
    }

    public JTextField getJTFsandi() {
        return JTFsandi;
    }

    public JButton getJBregister() {
        return JBregister;
    }
    
}
