/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author khisby
 */
public class View extends JFrame{

    public View() {
        initComponent();
    }
    
    public void initComponent(){
        JPanel contentPanel = new JPanel();
        Border padding = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        contentPanel.setBorder(padding);
        setContentPane(contentPanel);
        
        CardLayout cardLayout = new CardLayout();
        setLayout(cardLayout);

    }
    
    public void tampilkan(){
        setSize(700, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void reset(){
        getContentPane().removeAll();
        repaint();
    }
    
}
