/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.User;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author khisby
 */
public class DashboardComponent extends Component{
    private JButton JBlogout;
    private JButton JBadd;
    private JButton JBremove;
    private JTextField JTFnama;
    private JList JLtodo;
    private JList JLworking;
    private JList JLdone;
    private JPanel JPtop;
    private JPanel JPcenter;
    private JPanel JPcenterTop;
    private JPanel JPcenterBottom;
    private JPanel JPbottom;

    public DashboardComponent(User session) {
        BorderLayout layout = new BorderLayout(5,20);
        setLayout(layout);
        
        JBlogout = new JButton("Logout");
        JBadd = new JButton("Add Todo");
        JBremove = new JButton("Remove Todo");
        JTFnama = new JTextField();
        JLtodo = new JList();
        JLworking = new JList();
        JLdone = new JList();
        JPtop = new JPanel();
        JPcenter = new JPanel();
        JPcenterTop = new JPanel();
        JPcenterBottom = new JPanel();
        JPbottom = new JPanel();        
        
        JPtop.setLayout(new GridLayout(1,2));
        JPtop.add(new JLabel("Selamat Datang : " + session.getNamaPanggilan()));
        JPtop.add(JBlogout);
        
        JPbottom.setLayout(new GridLayout(1, 3));
        JPbottom.add(JTFnama);
        JPbottom.add(JBadd);
        JPbottom.add(JBremove);
        
        JPcenterTop.setLayout(new GridLayout(1,3));
        JPcenterTop.add(new JLabel("Todo", SwingConstants.CENTER));
        JPcenterTop.add(new JLabel("Working", SwingConstants.CENTER));
        JPcenterTop.add(new JLabel("Done", SwingConstants.CENTER));
        
        JPcenterBottom.setLayout(new GridLayout(1,3));
        JPcenterBottom.add(new JScrollPane(JLtodo));
        JPcenterBottom.add(new JScrollPane(JLworking));
        JPcenterBottom.add(new JScrollPane(JLdone));
        
        JPcenter.setLayout(new BorderLayout());
        JPcenter.add(JPcenterTop, BorderLayout.NORTH);
        JPcenter.add(JPcenterBottom, BorderLayout.CENTER);
        
        add(JPtop,BorderLayout.NORTH);
        add(JPcenter,BorderLayout.CENTER);
        add(JPbottom,BorderLayout.SOUTH);
    }

    public JButton getJBlogout() {
        return JBlogout;
    }

    public JButton getJBadd() {
        return JBadd;
    }

    public JButton getJBremove() {
        return JBremove;
    }

    public JTextField getJTFnama() {
        return JTFnama;
    }

    public JList getJLtodo() {
        return JLtodo;
    }

    public JList getJLworking() {
        return JLworking;
    }

    public JList getJLdone() {
        return JLdone;
    }
    
    
    
}
