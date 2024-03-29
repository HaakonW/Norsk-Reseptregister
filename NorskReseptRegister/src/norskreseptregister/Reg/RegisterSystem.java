/*
 Filen inneholder klassen RegisterSystem
 Laget av Henrik Fischer Bjelland
 Sist endret 22-04-2014
 */
package norskreseptregister.Reg;

// Registersystem inneholder lege-,pasient- og reseptregisterne. Her er også metoden for å skrive og lese til fil.
public class RegisterSystem
{
    private LegeRegister legeRegister;
    private PasientRegister pasientRegister;
    private ReseptRegister reseptRegister;

    //Konstruktøren new'er opp alle registerne
    public RegisterSystem()
    {
        legeRegister = new LegeRegister();
        pasientRegister = new PasientRegister();
        reseptRegister = new ReseptRegister();
    }

    //Get-metode for å hente ut legeRegister
    public LegeRegister getLegeRegister()
    {
        return legeRegister;
    }

    //Get-metode for å hente ut pasientRegister
    public PasientRegister getPasientRegister()
    {
        return pasientRegister;
    }

    //Get-metode for å hente ut reseptRegister
    public ReseptRegister getReseptRegister()
    {
        return reseptRegister;
    }

    //Metode for å skrive til fil
    public void SkrivTilFil()
    {
        legeRegister.SkrivTilFil("LegeRegister.txt");
        pasientRegister.SkrivTilFil("PasientRegister.txt");
        reseptRegister.SkrivTilFil("ReseptRegister.txt");
    }

    //Meotde for å lese fra fil
    public void LesFraFil()
    {
        legeRegister.LesFraFil("LegeRegister.txt");
        pasientRegister.LesFraFil("PasientRegister.txt");
        reseptRegister.LesFraFil("ReseptRegister.txt");
    }
}// end of class System
