package pk1.mv.fachlogik;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;
import javax.swing.JOptionPane;

import pk1.mv.datenhaltung.Medienverwaltung;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private Medienverwaltung mv;
    private JOptionPane focus = new JOptionPane();

    public Menu() {
        this.mv = new Medienverwaltung();  
    }

    public void start() {
        focus.hasFocus();

        System.out.println("Medienverwaltung\n");
        System.out.println("1. Audio aufnehmen");
        System.out.println("2. Bild aufnehmen");
        System.out.println("3. Zeige alle Medien");
        System.out.println("4. Medienliste in Datei schreiben");
        System.out.println("5. Zeige neues Medium");
        System.out.println("6. Berechne durchschnittliches Erscheinungsjahr");
        System.out.println("7. Speichern");
        System.out.println("8. Laden");
        System.out.println("9. Beenden");
        System.out.print("\nBitte Menuepunkt waehlen: ");

        int switchCase = sc.nextInt();
        switch(switchCase) {
            case 1:
                String audioTitel = JOptionPane.showInputDialog("Titel");
                if(audioTitel == null) {
                    JOptionPane.showMessageDialog(focus, "Eingabe abgebrochen");
                    start();
                    break;
                }
                int audioJahr = 0;
                int audioDauer = 0;
                try {
                    String audioJahrString = JOptionPane.showInputDialog(focus, "Jahr");
                    if(audioJahrString == null) {
                        JOptionPane.showMessageDialog(focus, "Eingabe abgebrochen");
                        start();
                        break;
                    } else if (audioJahrString.length() == 0) {
                        audioJahr = 0;
                    } else {
                        audioJahr = Integer.parseInt(audioJahrString);
                    }
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(focus, "Bitte gültiges Erscheinungsjahr eingeben");
                    start();
                    break;
                }
                String audioInterpret = JOptionPane.showInputDialog(focus, "Interpret");
                if(audioInterpret == null) {
                    JOptionPane.showMessageDialog(focus, "Eingabe abgebrochen");
                    start();
                    break;
                }
                try {
                    String audioDauerString = JOptionPane.showInputDialog(focus, "Dauer");
                    if(audioDauerString == null) {
                        JOptionPane.showMessageDialog(focus, "Eingabe abgebrochen");
                        start();
                        break;
                    } else if (audioDauerString.length() == 0) {
                        audioDauer = 0;
                    } else {
                        audioDauer = Integer.parseInt(audioDauerString);
                    }
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(focus, "Bitte gültige Dauer eingeben");
                    start();
                    break;
                }
                mv.aufnehmen(new Audio(audioTitel, audioJahr, audioInterpret, audioDauer));
                start();
                break;
            case 2:
                int bildJahr = 0;
                String bildTitel = JOptionPane.showInputDialog("Titel");
                if(bildTitel == null) {
                    JOptionPane.showMessageDialog(focus, "Eingabe abgebrochen");
                    start();
                    break;
                }
                try {
                    String bildJahrString = JOptionPane.showInputDialog(focus, "Jahr");
                    if(bildJahrString == null) {
                        JOptionPane.showMessageDialog(focus, "Eingabe abgebrochen");
                        start();
                        break;
                    } else if (bildJahrString.length() == 0) {
                        bildJahr = 0;
                    } else {
                        bildJahr = Integer.parseInt(bildJahrString);
                    }
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(focus, "Bitte gültiges Erscheinungsjahr eingeben");
                    start();
                    break;
                }
                String bildOrt = JOptionPane.showInputDialog("Ort");
                if(bildOrt == null) {
                    JOptionPane.showMessageDialog(focus, "Eingabe abgebrochen");
                    start();
                    break;
                }
                mv.aufnehmen(new Bild(bildTitel, bildJahr, bildOrt));
                start();
                break;
            case 3:
                mv.zeigeMedien(System.out);
                System.out.println();
                start();
                break;
            case 4:
                String dateiName = JOptionPane.showInputDialog(focus, "Dateiname");
                if(dateiName == null) {
                    JOptionPane.showMessageDialog(focus, "Eingabe abgebrochen");
                    start();
                    break;
                }
                if(dateiName.length() == 0) {
                    try {
                        throw new EmptyFilenameException();
                    } catch (EmptyFilenameException e) {
                        int confirm = JOptionPane.showConfirmDialog(focus, "Dateiname darf nicht leer sein!\nNeuen Dateinamen wählen?", "Hinweis", JOptionPane.YES_NO_OPTION);
                        if(confirm == JOptionPane.YES_OPTION) {
                            start(4);
                        } else {
                            start();
                        }
                    }
                }
                dateiName += ".mv";
                try (FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\" + dateiName))) {
                    mv.zeigeMedien(fos);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(focus, "Fehler beim Speichern");
                    start();
                    break;
                }
                start();
                break;
            case 5:
                mv.sucheNeuesMedium();
                System.out.println();
                start();
                break;
            case 6:
                System.out.println("Durchschnittliches Erscheinungsjahr: " + mv.berechneErscheinungsjahr()+"\n");
                start();
                break;
            case 7:
                mv.speichern();
                start();
                break;
            case 8:
                mv.laden();
                start();
                break;
            case 9:
                System.out.println("Medienverwaltung beendet.");
                break;
            default:
                System.out.println("Falsche Eingabe\n");
                start();
                break;
        }
    }

    public void start(int num) {
        focus.hasFocus();
        
        switch(num) {
            case 1:
                String audioTitel = JOptionPane.showInputDialog("Titel");
                if(audioTitel == null) {
                    JOptionPane.showMessageDialog(focus, "Eingabe abgebrochen");
                    start();
                    break;
                }
                int audioJahr = 0;
                int audioDauer = 0;
                try {
                    String audioJahrString = JOptionPane.showInputDialog(focus, "Jahr");
                    if(audioJahrString == null) {
                        JOptionPane.showMessageDialog(focus, "Eingabe abgebrochen");
                        start();
                        break;
                    } else if (audioJahrString.length() == 0) {
                        audioJahr = 0;
                    } else {
                        audioJahr = Integer.parseInt(audioJahrString);
                    }
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(focus, "Bitte gültiges Erscheinungsjahr eingeben");
                    start();
                    break;
                }
                String audioInterpret = JOptionPane.showInputDialog(focus, "Interpret");
                if(audioInterpret == null) {
                    JOptionPane.showMessageDialog(focus, "Eingabe abgebrochen");
                    start();
                    break;
                }
                try {
                    String audioDauerString = JOptionPane.showInputDialog(focus, "Dauer");
                    if(audioDauerString == null) {
                        JOptionPane.showMessageDialog(focus, "Eingabe abgebrochen");
                        start();
                        break;
                    } else if (audioDauerString.length() == 0) {
                        audioDauer = 0;
                    } else {
                        audioDauer = Integer.parseInt(audioDauerString);
                    }
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(focus, "Bitte gültige Dauer eingeben");
                    start();
                    break;
                }
                mv.aufnehmen(new Audio(audioTitel, audioJahr, audioInterpret, audioDauer));
                start();
                break;
            case 2:
                int bildJahr = 0;
                String bildTitel = JOptionPane.showInputDialog("Titel");
                if(bildTitel == null) {
                    JOptionPane.showMessageDialog(focus, "Eingabe abgebrochen");
                    start();
                    break;
                }
                try {
                    String bildJahrString = JOptionPane.showInputDialog(focus, "Jahr");
                    if(bildJahrString == null) {
                        JOptionPane.showMessageDialog(focus, "Eingabe abgebrochen");
                        start();
                        break;
                    } else if (bildJahrString.length() == 0) {
                        bildJahr = 0;
                    } else {
                        bildJahr = Integer.parseInt(bildJahrString);
                    }
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(focus, "Bitte gültiges Erscheinungsjahr eingeben");
                    start();
                    break;
                }
                String bildOrt = JOptionPane.showInputDialog("Ort");
                if(bildOrt == null) {
                    JOptionPane.showMessageDialog(focus, "Eingabe abgebrochen");
                    start();
                    break;
                }
                mv.aufnehmen(new Bild(bildTitel, bildJahr, bildOrt));
                start();
                break;
            case 3:
                mv.zeigeMedien(System.out);
                System.out.println();
                start();
                break;
            case 4:
                String dateiName = JOptionPane.showInputDialog(focus, "Dateiname");
                if(dateiName == null) {
                    JOptionPane.showMessageDialog(focus, "Eingabe abgebrochen");
                    start();
                    break;
                }
                if(dateiName.length() == 0) {
                    try {
                        throw new EmptyFilenameException();
                    } catch (EmptyFilenameException e) {
                        int confirm = JOptionPane.showConfirmDialog(focus, "Dateiname darf nicht leer sein!\nNeuen Dateinamen wählen?", "Hinweis", JOptionPane.YES_NO_OPTION);
                        if(confirm == JOptionPane.YES_OPTION) {
                            start(4);
                        } else {
                            start();
                        }
                    }
                }
                dateiName += ".mv";
                try (FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\" + dateiName))) {
                    mv.zeigeMedien(fos);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(focus, "Fehler beim Speichern");
                    start();
                    break;
                }
                start();
                break;
            case 5:
                mv.sucheNeuesMedium();
                System.out.println();
                start();
                break;
            case 6:
                System.out.println("Durchschnittliches Erscheinungsjahr: " + mv.berechneErscheinungsjahr()+"\n");
                start();
                break;
            case 7:
                mv.speichern();
                start();
                break;
            case 8:
                mv.laden();
                start();
                break;
            case 9:
                System.out.println("Medienverwaltung beendet.");
                break;
            default:
                System.out.println("Falsche Eingabe\n");
                start();
                break;
        }
    }
}
