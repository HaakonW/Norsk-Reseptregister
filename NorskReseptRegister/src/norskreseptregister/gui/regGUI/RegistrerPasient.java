/*
 Filen inneholder klassen RegistrerPasient.
 Laget av Henrik Fischer Bjelland, Haakon Winther
 Sist endret 11-05-2014 
 */
package norskreseptregister.gui.regGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import norskreseptregister.HovedVindu;
import norskreseptregister.ObjektKlasser.Pasient;
import norskreseptregister.Reg.PasientRegister;

/* 
 RegistrerPasient er en subklasse av RegistrerPersonGUI. 
 Klassen er ment for å kunne registrere en Pasient i pasientregisteret
 */
public class RegistrerPasient extends RegistrerPersonGUI implements ActionListener
{
    private PasientRegister pasientRegister;

    public RegistrerPasient(PasientRegister pasientRegister)
    {
        super("Fødselsdato", "dd/mm/åååå");
        this.pasientRegister = pasientRegister;
        reg.addKeyListener(new Knappelytter());
    }

    /* 
     Metode som sjekker om feltene er fylt ut korrekt og registrerer pasienten
     i registeret hvis alt er riktig fylt inn. Det blir skrevet ut en feilmelding hvis pasienten allerede eksiterer
     eller feltene er fylt ut feil. 
     */
    private void nyPasient()
    {
        if (sjekkFornavn(fornavnfelt.getText()) && sjekkEtternavn(etternavnfelt.getText())
                && sjekkFodselsdato(infofelt.getText()))
        {
            Pasient ny = new Pasient(fornavnfelt.getText(), etternavnfelt.getText(),
                    infofelt.getText());
            ArrayList<Pasient> eksisterendePasienter = pasientRegister.FinnObjekterSomMatcher(new FinnPasientData(ny));
            if (eksisterendePasienter.size() > 0)
            {
                utskrift.setText("Pasienten finnes allerede.");
                fornavnfelt.requestFocus();
            }
            else
            {
                pasientRegister.SettInn(ny);
                utskrift.setText("Registrert pasient: \n" + ny.toString());
            }
        }
    }

    // Metode for å lytte på hvilken knapp som er trykket på og kaller deretter på en spesifikk metode
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == reg)
        {
            nyPasient();
            TomFelt();
        }
        else if (e.getSource() == hjelp)
        {
            HovedVindu.visBrukerveiledning();
        }
    }

    // Privat lytteklasse som gjør det mulig og trykke på ENTER-tasten under registrering i stede for å bruke musen
    private class Knappelytter implements KeyListener
    {
        public void keyPressed(KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_ENTER)
            {
                nyPasient();
                TomFelt();
            };
        }

        ;

        @Override
        public void keyTyped(KeyEvent e)
        {

        }

        @Override
        public void keyReleased(KeyEvent e)
        {

        }
    }
}//end of class Registrer Pasient
