/*
 * Filen inneholder klassen RegMainGUI.
 * Laget av  Henrik, Haakon, Peter 
 * Sist endret 09-04-2014 
 */

package norskreseptregister.gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import norskreseptregister.RegisterSystem;

public class RegMainGUI extends JPanel
{
    private JTabbedPane tabbedPane;
    RegistrerPasient tab1;
    RegistrerLege tab2;
    RegistrerResept tab3;
    private RegisterSystem system;
    RegMainHjemGUI panel1 = new RegMainHjemGUI();
    
    public RegMainGUI(RegisterSystem system)
    {
        super(new GridLayout(1, 1));
        this.system = system;
        tab1 = new RegistrerPasient(system.getPasientRegister());
        tab2 = new RegistrerLege(system.getLegeRegister());
        tab3 = new RegistrerResept(system.getReseptRegister());
        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon hjem = new ImageIcon("src/norskreseptregister/gui/bilder/hjem.png");
        ImageIcon doktor = new ImageIcon("src/norskreseptregister/gui/bilder/doktor.png");
        ImageIcon pasienten = new ImageIcon("src/norskreseptregister/gui/bilder/person.png");
        ImageIcon resept = new ImageIcon("src/norskreseptregister/gui/bilder/person.png");
        
        tabbedPane.addTab("Hjem", hjem, panel1, "Hjem");
        tabbedPane.addTab("Registrer Pasient", pasienten, tab1, "Pasient");
        tabbedPane.addTab("Registrer Lege", doktor, tab2, "Lege");
        tabbedPane.addTab("Registrer Resept", resept, tab3, "Resept");
        //tabbedPane.addTab("Registrer Resept", icon, tab3, "Resept");
        add(tabbedPane);
    }
    
  private static void createAndShowGUI(RegisterSystem system)
  {
    //Create and set up the window.
    JFrame frame = new JFrame("Admin");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(650,460);
    frame.getContentPane().add(new RegMainGUI(system), BorderLayout.CENTER);
    frame.pack();
    //Display the window.
   
    frame.setVisible(true);
  }

  public static void main(String[] args)
  {
    RegisterSystem system = new RegisterSystem();
    createAndShowGUI(system);
  }
    
}//end of class RegMainGUI
