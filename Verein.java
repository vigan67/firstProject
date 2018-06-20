import java.util.ArrayList;
import java.util.Iterator;
/**
 * Speichert Details über Vereinsmitgliedschaften.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Verein
{
    private ArrayList<Mitgliedschaft> mitglieder; 

    /**
     * Konstruktor für Objekte der Klasse Verein
     */
    public Verein()
    {
        // Initialisieren Sie die Datenfelder hier...
        mitglieder = new ArrayList<Mitgliedschaft>();
    }

    /**
     * Füge ein neues Mitglied in die Mitgliederliste ein.
     * @param mitglied Infos über das einzufügende Mitglied.
     */
    public void beitreten(Mitgliedschaft mitglied)
    {
        mitglieder.add(mitglied);
    }

    /**
     * @return die Anzahl der Mitglieder (Mitgliedschaft-Objekte)
     *         in diesem Verein.
     */
    public int anzahlMitglieder()
    {
        return mitglieder.size();
    }

    /**
     * Liefere die Anzahl der Mitglieder, die im angegebenen Monat
     * Mitglied geworden sind.
     * @param monat der Monat des Beitritts.
     * @return die Anzahl der Mitglieder, die im Monat beigetreten sind.
     */
    public int beigetretenInMonat(int monat)
    {
        if(monat > 1 && monat < 12)
        {
            int anzahl = 0;
            for (Mitgliedschaft mitgliedschaft : mitglieder )
            {
                if(monat == mitgliedschaft.gibMonat())
                {
                    anzahl ++;
                }
            }
            return anzahl;
        }
        else
        {
            System.out.println("Fehlermeldung: die zahl liegt nicht zwiechen 1 und 12");
            return 0;
        }
    }

    /**
     * Entferne alle Mitglieder aus der Sammlung des Vereins, die im
     * angegebenen Monat Mitglied geworde sind, und liefere sie in
     * einem getrennten Sammlungsobjekt zurück.
     * @param monat der Monat des Beitritts.
     * @param jahr des Jahre des Beitritts.
     * @return die neuen Mitglieder des angegebenen Monats und Jahres.
     */
    public ArrayList<Mitgliedschaft> entfernen(int monat, int jahr)
    {
        ArrayList<Mitgliedschaft> tmpMitglieder = new ArrayList<Mitgliedschaft>();
        if(monat > 1 && monat < 12)
        {
            Iterator<Mitgliedschaft> it = mitglieder.iterator();
            while(it.hasNext())
            {
                Mitgliedschaft mitglieder = it.next();
                if(mitglieder.gibMonat() == monat && mitglieder.gibJahr()==jahr)
                {
                    tmpMitglieder.add(mitglieder);
                    it.remove();
                }
            }
        }
        return tmpMitglieder;
    }
}
