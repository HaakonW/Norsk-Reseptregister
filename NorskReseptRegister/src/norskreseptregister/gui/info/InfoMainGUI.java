/*
Filen inneholder klassen InfoMainGUI. Her skal man kunne hente ut informasjon....
Laget av  Haakon Winther
Sist endret 09-04-2014
*/

package norskreseptregister.gui.info;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import norskreseptregister.ObjektKlasser.Medisinliste;
import norskreseptregister.Reg.LegeRegister;
import norskreseptregister.Reg.PasientRegister;
import norskreseptregister.Reg.RegisterSystem;

public class InfoMainGUI extends JPanel
{
    private JTabbedPane tabbedPane;
    InfoMainHjemGUI panel1;
    LegeInfoGUI panel2;
    PasientInfoGUI panel3;
    MedisinInfoGUI panel4;
    private RegisterSystem system;
    private LegeRegister legeRegister;
    private PasientRegister pasientRegister;
    private Medisinliste medisinliste;

    public InfoMainGUI(RegisterSystem system, Medisinliste medisinliste)
    {
        this.medisinliste = medisinliste;
        panel1 = new InfoMainHjemGUI(this);
        panel2 = new LegeInfoGUI(system, legeRegister);
        panel3 = new PasientInfoGUI(system, pasientRegister);
        panel4 = new MedisinInfoGUI(system, medisinliste);
        tabbedPane = new JTabbedPane();
        ImageIcon hjem = new ImageIcon("src/norskreseptregister/gui/bilder/hjem.png");
        ImageIcon epille = new ImageIcon("src/norskreseptregister/gui/bilder/ikonpille.png");
        ImageIcon docinfo = new ImageIcon("src/norskreseptregister/gui/bilder/ikondocinfo.png");
        ImageIcon pasinfo = new ImageIcon("src/norskreseptregister/gui/bilder/ikonpasinfo.png");
        
        tabbedPane.addTab("Hjem", hjem, panel1, "Hjem");
        tabbedPane.addTab("Legeinfo", docinfo, panel2, "Lege");
        tabbedPane.addTab("PasientInfo", pasinfo, panel3, "Pasient");
        tabbedPane.addTab("Medisininfo", epille, panel4, "Legemiddel");
        add(tabbedPane);
    }
    
    //Get metode for TabbedPane
    public JTabbedPane getTabbedPane()
    {
        return tabbedPane;
    }
    
    //Metoden oppretter vinduet
    private static void createAndShowGUI(RegisterSystem system, Medisinliste medisinliste)
    {
        //Create and set up the window.
        JFrame frame = new JFrame("Informasjon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,400);
        frame.getContentPane().add(new InfoMainGUI(system, medisinliste), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
  }
    
}//end of class InfoMainGUI