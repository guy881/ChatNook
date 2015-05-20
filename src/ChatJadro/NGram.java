/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatJadro;

import java.io.FileNotFoundException;

/**
 *
 * @author pawel
 */
public class NGram implements Comparable<NGram> {
    private final String prefiks;
    private final String sufiks;
    private int prefiksWyst;
    private int sufiksWyst;

    public NGram(String prefiks, String sufiks) {
        this.prefiks = prefiks;
        this.sufiks = sufiks;
        this.prefiksWyst = 1;
        this.sufiksWyst = 1;
    }

    public String getPrefiks() {
        return prefiks;
    }

    public String getSufiks() {
        return sufiks;
    }

    public int getPrefiksWyst() {
        return prefiksWyst;
    }

    public int getSufiksWyst() {
        return sufiksWyst;
    }

    public String getNGram() {
        if (prefiks == null || sufiks == null) {
            return null;
        }
        return prefiks + sufiks;
    }

    @Override
    public String toString() {
        if (this.prefiks == null || this.sufiks == null) {
            return null;
        }
        StringBuilder s = new StringBuilder(this.prefiks);
        s.append(this.sufiks);
        s.append(" ( ");
        s.append(this.prefiksWyst);
        s.append(" , ");
        s.append(this.sufiksWyst);
        s.append(" )");
        String ngram = s.toString();
        return ngram;
    }
    
     @Override
    public int compareTo(NGram n) {
        int cmp;
        cmp = this.prefiks.compareTo(n.prefiks);
        if (cmp < 0 || cmp > 0) { //rózne prefiksy
            return cmp;
        } else {// te same prefiksy
            if (this != n) { // jeśli nie są to te same obiekty
                this.prefiksWyst++;
                n.prefiksWyst++;
            }
            cmp = this.sufiks.compareTo(n.sufiks);
            if (cmp < 0 || cmp > 0) {
                return cmp;
            } else {//te same sufiksy
                if (this != n) {
                    n.sufiksWyst++;
                    this.sufiksWyst++;
                }
                return cmp;
            }
        }
    }
    

    public static void main(String args[]) throws FileNotFoundException {
        Wejscie t = null;
        try {
            t = new Wejscie("/home/pawel/NetBeansProjects/Chat/src/ChatJadro/test", 3);
        } catch (FileNotFoundException ex) {
            System.out.println("Nie znaleziono pliku");
        }
        NGram[] ngramy = new NGram[100];

        if (t == null) {
            System.exit(1);
        }
        for (int i = 0; i < 100; i++) {
            ngramy[i] = new NGram(t.nextPref(), t.nextSuf());
            if (ngramy[i].getNGram() == null) {
                break;
            }
            System.out.println(ngramy[i].getNGram());
        }
    }
}
