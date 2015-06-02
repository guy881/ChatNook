/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatJadro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pawel Klasa wczytuje plik źródlowy i dzieli tekst na sufiksy i
 * prefiksy
 */
public class Wejscie {

    private final File plik;
    private final Scanner odczyt;
    private static int obecnyWyraz;
    private static int rzadNGramow;
    private static ArrayList<String> slowa;

    public ArrayList<String> getSlowa() {
        return slowa;
    }

    public Wejscie(String nazwaPliku, int rzad) throws FileNotFoundException {//wejscie z pliku
        this.plik = new File(nazwaPliku);
        this.odczyt = new Scanner(this.plik);
        Wejscie.rzadNGramow = rzad;
        Wejscie.slowa = new ArrayList<>(512);
        Wejscie.obecnyWyraz = 0;
        while (odczyt.hasNext()) {
            slowa.add(odczyt.next());
        }
    }

    public Wejscie(ArrayList<String> slowa, int rzad) {//wejscie z wysyłanych wiadomości
        Wejscie.obecnyWyraz = 0;
        Wejscie.rzadNGramow = rzad;
        Wejscie.slowa = slowa;

        this.plik = null;
        this.odczyt = null;
    }

    public final boolean hasNext() {
        return this.odczyt.hasNext();
    }

    public String nextPref() {
        if (obecnyWyraz >= slowa.size()) {
            return null;
        }
        if (rzadNGramow == 1) {
            return slowa.get(obecnyWyraz++);
        }
        StringBuilder pref = new StringBuilder();

        for (int i = 0; i < rzadNGramow - 1; i++) {
            if (i + obecnyWyraz >= slowa.size()) {
                return null;
            }
            pref.append(slowa.get(i + obecnyWyraz));
            pref.append(" ");
        }
        obecnyWyraz++;
        return pref.toString();
    }

    public String nextSuf() {
        if (rzadNGramow == 1) {
            return "";
        }
        int index = obecnyWyraz + 1;
        if (index < slowa.size()) {
            return slowa.get(index);
        } else {
            return null;
        }
    }

    public static void main(String args[]) {
        Wejscie teksty = null;
        String pref;
        String suf;
        try {
            teksty = new Wejscie("/home/pawel/NetBeansProjects/Chat/src/ChatJadro/test", 3);
        } catch (FileNotFoundException e) {
            System.out.println("zly plik");
        }
        if (teksty != null) {
            while (true) {
                if ((pref = teksty.nextPref()) == null || (suf = teksty.nextSuf()) == null) {
                    break;
                }
                System.out.println(pref + suf);
            }
        } else {
            System.out.println("testy == null");
        }
    }
}
