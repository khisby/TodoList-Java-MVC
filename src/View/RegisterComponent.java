/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

/**
 *
 * @author khisby
 */
public class RegisterComponent extends Component{
    private JTextField JTFnama;
    private JTextField JTFsandi;
    private JRadioButton JRBlaki;
    private JRadioButton JRBperempuan;
    private JButton JBregister;
    private JButton JBlogin;
    private ButtonGroup BGjenis_kelamin;
    
    public RegisterComponent(){
        GridLayout layout = new GridLayout(12,1, 5, 10);
        setLayout(layout);

        JTFnama = new JTextField();
        JTFsandi = new JTextField();
        JRBlaki = new JRadioButton("Laki - Laki");
        JRBperempuan = new JRadioButton("Perempuan");
        JBregister = new JButton("Registrasi");
        JBlogin = new JButton("Login");
        BGjenis_kelamin = new ButtonGroup();
        
        JPanel Pjenis_kelamin = new JPanel();
        Pjenis_kelamin.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        Pjenis_kelamin.add(JRBlaki);
        Pjenis_kelamin.add(JRBperempuan);
        
        BGjenis_kelamin.add(JRBlaki);
        BGjenis_kelamin.add(JRBperempuan);
        
        add(new JLabel("Nama"));
        add(JTFnama);
        add(new JLabel("Sandi"));
        add(JTFsandi);
        add(new JLabel("Jenis Kelamin"));
        add(Pjenis_kelamin);
        add(JBregister);
        add(JBlogin);
        
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

    public JRadioButton getJRBlaki() {
        return JRBlaki;
    }

    public JRadioButton getJRBperempuan() {
        return JRBperempuan;
    }

    public JButton getJBregister() {
        return JBregister;
    }

    public ButtonGroup getBGjenis_kelamin() {
        return BGjenis_kelamin;
    }
    
    
    
}
