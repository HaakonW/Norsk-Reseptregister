/*
Filen inneholder klassen RegistrerPersonGUI.
Laget av  Henrik Fischer Bjelland
Sist endret 17-04-2014  
*/

package norskreseptregister.gui.regGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public abstract class RegistrerPersonGUI extends JPanel implements ActionListener 
{
    protected JButton reg, hjelper; 
    protected JTextField fornavnfelt, etternavnfelt, infofelt;
    protected JTextArea utskrift;
    private JLabel fornavnlabel, etternavnlabel, infolabel; 
    private JPanel panel1, panel2, panel3, panel4, panel5;
    private String fornavn;
    
    public RegistrerPersonGUI(String infolabeltekst, String infoFeltTekst)
    {
        fornavnlabel = new JLabel("Fornavn     ");
        fornavnfelt = new JTextField(20);
        etternavnlabel = new JLabel("Etternavn   ");
        etternavnfelt = new JTextField(20);
        infolabel = new JLabel(infolabeltekst);        
        infofelt = new JTextField(20);
        infofelt.setText(infoFeltTekst);
        
        reg = new JButton("Registrer");
        reg.setToolTipText("Trykk her for å registrere");
                    
        
        hjelper = new JButton("?");
        hjelper.setToolTipText("Trykk her for hjelp");
        hjelper.setPreferredSize(new Dimension(25, 25));
        hjelper.addActionListener(this);
     
        utskrift = new JTextArea(20, 20);
        utskrift.setEditable(false);       
        utskrift.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY, Color.black));

        ///LEGGER ELEMENTER INN I PANELER////
        panel1 = new JPanel();
        panel1.add(fornavnlabel);
        panel1.add(fornavnfelt);
        
        panel2 = new JPanel();
        panel2.add(etternavnlabel);
        panel2.add(etternavnfelt);
        
        panel3 = new JPanel();
        panel3.add(infolabel);
        panel3.add(infofelt);
        
        panel4 = new JPanel();
        panel4.add(reg);
       
        
        panel5 = new JPanel();
        panel5.add(utskrift);
        
          /***
         START INNSETTINGEN AV ELEMENTENE I LAYOUTEN
         OPPRETTER EN INT X OG INT Y FOR Å ENKELT KUNNE UTVIDE
         MED FLERE ELEMENTER        
         INSETS ER AVSTAND FRA TOP, VENSTRE, BUNN OG HØYRE
         ***/
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        
        int x= 0;
        int y = 0;
        
        gc.gridx = x;
        gc.gridy = y;
        gc.insets = new Insets(5, 5, 5, 10);
        //gc.anchor = GridBagConstraints.WEST;
        //gc.fill = GridBagConstraints.HORIZONTAL;
        add(panel1, gc);
        
        gc.gridx = x;
        gc.gridy = ++y;
        add(panel2, gc);
        
        gc.gridx = x;
        gc.gridy = ++y;
        add(panel3, gc);
        
        gc.gridx = x;
        gc.gridy = ++y;
        add(panel4, gc);
        
        y = 0;
        gc.gridx = ++x;
        gc.gridy = y; 
        gc.gridheight = 6;
        add(panel5, gc);  
        
        gc.gridx = ++x;
        gc.gridy = 6;       
        add(hjelper, gc);      
        
    }//end of konstruktør RegistrerLege

    ///METODE FOR Å TØMME FELTENE FOR NESTE PERSON SOM SKAL REGISTRERES INN///
    public void TomFelt()
    {
        fornavnfelt.setText("");
        etternavnfelt.setText("");
        infofelt.setText("");
    } 
}//end of class RegistrerLege
