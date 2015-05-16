/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatJadro;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author pawel
 */
public class TekstyBazowe {

    private final File plik;
    private final Scanner odczyt;

    public TekstyBazowe(String nazwaPliku) throws FileNotFoundException {
        this.plik = new File(nazwaPliku);
        this.odczyt = new Scanner(this.plik);
    }

    public final boolean hasNext() {
        return this.odczyt.hasNext();
    }

    public final String dajSlowo() {
        if (this.odczyt.hasNext()) {
            return odczyt.next();
        } else {
            return null;
        }
    }

    public static void main(String args[]) {
        TekstyBazowe teksty = null;
        try {
            teksty = new TekstyBazowe("/home/pawel/NetBeansProjects/Chat/src/ChatJadro/README.html");
        } catch (FileNotFoundException e) {
            System.out.println("zly plik");
        }
        if (teksty != null) {
            while (teksty.hasNext()) {
                System.out.println(teksty.dajSlowo());
            }
        } else {
            System.out.println("testy == null");
        }
    }
}
