/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convert;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

/**
 *
 * @author pawel
 */
public class DopelnianieSlow implements DocumentListener {

    public DopelnianieSlow(JTextArea pole) throws FileNotFoundException {
        this.poleTekstowe = pole;
        poleTekstowe.getDocument().addDocumentListener(this);
        InputMap im = poleTekstowe.getInputMap();
        ActionMap am = poleTekstowe.getActionMap();

        slowa = new Slownik("/home/pawel/NetBeansProjects/Chat/src/ChatJadro/listy.txt");

        im.put(KeyStroke.getKeyStroke("ENTER"), potwierdzAkcje);
        am.put(potwierdzAkcje, new PotwierdzAkcje());
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static enum Tryb {

        WPROWADZANIE, DOPELNIANIE
    };
    private final JTextArea poleTekstowe;
    private final String potwierdzAkcje = "confirm";
    private Tryb tryb = Tryb.WPROWADZANIE;
    private Slownik slowa;

    private class Dopelnij implements Runnable {

        String slowoZCzatu;
        int pozycja;

        public Dopelnij(String slowoZCzatu, int pozycja) {
            this.slowoZCzatu = slowoZCzatu;
            this.pozycja = pozycja;
        }

        public void run() {
            poleTekstowe.insert(slowoZCzatu, pozycja);
            poleTekstowe.setCaretPosition(pozycja + slowoZCzatu.length());
            poleTekstowe.moveCaretPosition(pozycja);
            tryb = Tryb.DOPELNIANIE;
        }
    }

    @Override
    public void insertUpdate(DocumentEvent ev) {
        if (ev.getLength() != 1) {
            return;
        }

        int pos = ev.getOffset();
        String content = null;
        try {
            content = poleTekstowe.getText(0, pos + 1);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        // Find where the word starts
        int w;
        for (w = pos; w >= 0; w--) {
            if (!Character.isLetter(content.charAt(w))) {
                break;
            }
        }
        if (pos - w < 2) {
            // Too few chars
            return;
        }

        ArrayList<String> slowaArray = slowa.getSlowa();
        String prefix = content.substring(w + 1).toLowerCase();
        int n = Collections.binarySearch(slowaArray, prefix);
        if (n < 0 && -n <= slowaArray.size()) {
            String match = slowaArray.get(-n - 1);
            if (match.startsWith(prefix)) {
                // A completion is found
                String completion = match.substring(pos - w);
                // We cannot modify Document from within notification,
                // so we submit a task that does the change later
                SwingUtilities.invokeLater(
                        new Dopelnij(completion, pos + 1));
            }
        } else {
            // Nothing found
            tryb = Tryb.WPROWADZANIE;
        }
    }

    private class PotwierdzAkcje extends AbstractAction {

        public void actionPerformed(ActionEvent ev) {
            if (tryb == Tryb.DOPELNIANIE) {
                int pos = poleTekstowe.getSelectionEnd();
                poleTekstowe.insert(" ", pos);
                poleTekstowe.setCaretPosition(pos + 1);
                tryb = Tryb.WPROWADZANIE;
            } else {
                poleTekstowe.replaceSelection("\n");
            }
        }
    }

    private class Slownik {

        private ArrayList<String> slowa;
        private String path;
        private File plikSlownika;
        private Scanner bufor;

        private Slownik(String path) throws FileNotFoundException {
            if (path != null && !path.equals("")) {
                this.path = path;
                bufor = new Scanner(new File(path));
                while (bufor.hasNext()) {
                    slowa.add(bufor.next());
                }
            }else
                System.out.println("sciezka do slownika jest null");
        }

        public ArrayList<String> getSlowa() {
            return slowa;
        }
    }

}
