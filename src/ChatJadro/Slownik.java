/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatJadro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pawel
 */
public class Slownik {

    private final ArrayList<String> slowa;
    private String path;
    private Scanner bufor;
    public static TreeSet<String> slownikDrzewo;

    public Slownik(String path) throws FileNotFoundException {
        slowa = new ArrayList<>(512);
        if (path != null && !path.equals("")) {
            this.path = path;
            bufor = new Scanner(new File(path));
            while (bufor.hasNext()) {
                slowa.add(bufor.next());
            }
        } else {
            System.out.println("sciezka do slownika jest null");
        }
    }

    public ArrayList<String> getSlowa() {
        return slowa;
    }

    public static void main(String[] args) {
        Slownik slownik = null;
        ArrayList<String> slowa = null;
        try {
            slownik = new Slownik("/home/pawel/NetBeansProjects/ChatNook/src/ChatJadro/test");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Slownik.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (slownik != null) {
            slowa = slownik.getSlowa();
            for (String s : slowa) {
                System.out.println(s);
            }
        }
        slownikDrzewo = new TreeSet<>();
        for (String s : slowa) {
            slownikDrzewo.add(s);
        }
        if(slownikDrzewo.contains("dwa"))
            System.out.println("zawiera slowo dwa");
    }
}
