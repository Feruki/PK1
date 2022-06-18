package pk1.mv.datenhaltung;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import pk1.mv.fachlogik.Medium;


public class Medienverwaltung {
    private ArrayList<Medium> medien;
    private Iterator<Medium> it;

    public Medienverwaltung() {
        this.medien = new ArrayList<Medium>();
    }

    public void aufnehmen(Medium m) {
        medien.add(m);
    }

    public void zeigeMedien(OutputStream stream) {
        Collections.sort(medien, (m1, m2) -> ((Integer) m1.getJahr()).compareTo(m2.getJahr()));
        for(Medium m : medien) {
            m.druckeDaten(stream);
        }
    }

    public Medium sucheNeuesMedium() {
        int max = 0;
        for(Medium m : medien) {
            if(m.getJahr() > max) {
                max = m.getJahr();
            }
        }
        for(Medium m : medien) {
            if(m.getJahr() == max) {
                return m;
            }
        }
        return null;
    }

    public double berechneErscheinungsjahr() {
        double summe = 0;
        if(medien.size() > 1) {
            for(Medium m : medien) {
                summe += m.getJahr();
            }
            return summe / medien.size();
        } else {
            return summe;
        }
    }

    public Iterator<Medium> iterator() {
        return it = medien.iterator();
    }

    public void zeigeMedienMitIterator() {
        Collections.sort(medien, (m1, m2) -> ((Integer) m1.getJahr()).compareTo(m2.getJahr()));
        
        this.it = iterator();

        while(it.hasNext()) {
            it.next().druckeDaten(System.out);
        }
    }

    public void sucheNeuesMediumMitIterator() {
        this.it = iterator();

        Medium m = it.next();
        while(it.hasNext()) {
            Medium temp = it.next();
            if(temp.getJahr() > m.getJahr()) {
                m = temp;
            }
        }
        m.druckeDaten(System.out);
    }

    public double berechneErscheinungsjahrMitIterator() {
        this.it = iterator();

        double summe = 0;
        while(it.hasNext()) {
            Medium m = it.next();
            summe += m.getJahr();
        }
        return summe / medien.size();
    }

    public void speichern() {
        try(FileOutputStream fos = new FileOutputStream(new File(".\\Medienverwaltung.mv"));
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for(Medium m : medien) {
                oos.writeObject(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void laden() {
        try(FileInputStream fis = new FileInputStream(new File(".\\Medienverwaltung.mv"));
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            while(true) {
                try {
                    Medium m = (Medium) ois.readObject();
                    medien.add(m);
                } catch (EOFException eof) {
                    System.out.println("Medienverwaltung erfolgreich geladen!");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}