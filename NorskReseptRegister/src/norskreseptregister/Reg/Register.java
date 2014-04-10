/*
Filen inneholder klassen Register som er den abstrakte superklassen
til alle registerne i programmet vårt.
Laget av Henrik Fischer Bjelland
Sist endret 09-04-2014
*/

package norskreseptregister.Reg;

import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import norskreseptregister.Interface.Kriterie;

public abstract class Register<T>
{
    private ArrayList<T> list;
    
    public Register()
    {
        list = new ArrayList<T>(); //instansiere en tom liste av <T>
    }

    public void SettInn(T nyttElement)
    {
        list.add(nyttElement);
    }

    // Finner alle elemente i lista som oppfyller kriterie
    public List<T> Finn(Kriterie<T> kriterie)
    {
        ArrayList<T> resultat = new ArrayList<T>();
        for (T element : list) 
        {
            if (kriterie.erOppfyltFor(element))
            {
                    resultat.add(element);
            }
        }
        return resultat;
    }
    
    public List<T> FinnAlle()
    {
        return list;
    }
    
    public void SkrivTilFil(String filNavn)
    {
        try (ObjectOutputStream utfil = new ObjectOutputStream(
                                        new FileOutputStream(filNavn)))
        {
            utfil.writeObject(list);  
            //utfil.close(); //kanskje denne skal bort? unødvendig?
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Fant ikke fila");
        }
        catch (IOException ioe)
        {
            System.out.println("Kan ikke skrive til fil!");
        }
    }
    
    public void LesTilFil(String filNavn)  
    {
        try (ObjectInputStream innfil = new ObjectInputStream(
                                        new FileInputStream(filNavn)))
        {
           list = ( ArrayList<T> )innfil.readObject();
           //innfil.close(); //kanskje denne skal bort? unødvendig?
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Fant ikke fila");
        }
        catch (IOException ioe)
        {
            System.out.println("Kan ikke skrive til fil!");
        }
        catch (ClassNotFoundException cnfe)
        {
            System.out.println("Finner ikke klassen");
        }
    }  
    
}//end of class Register