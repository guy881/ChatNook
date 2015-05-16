/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatJadro;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pawel
 */
public class NGram implements Comparable<NGram> {
    private static int obecnyWyraz = 0;
    private static int rzad = 3;
    private final String prefiks;
    private final String sufiks;
    private int prefiksWyst;
    private int sufiksWyst;

    public NGram(ArrayList<String> slowa) throws FileNotFoundException { //inicjalizacja z pliku
        prefiksWyst = 1;
        sufiksWyst = 1;
        int i;
        StringBuilder pref = new StringBuilder();
        for( i = 0; i < rzad - 1 && i + obecnyWyraz < slowa.size(); i++ ){
                pref.append( slowa.get( i + obecnyWyraz ));
                pref.append( " " );
        }
        this.prefiks = pref.toString();
        if( i + obecnyWyraz  < slowa.size() )
            this.sufiks = slowa.get(i + obecnyWyraz );
        else{
            this.sufiks = "";
            this.prefiksWyst = 0;
            this.sufiksWyst = 0;
        }
        
        obecnyWyraz++;
    }
    
    public final int getObecnyWyraz(){
        return NGram.obecnyWyraz;
    }
    public final void setRzad( int rzad ){
        NGram.rzad = rzad;
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

    public void incrPrefiksWyst() {
        this.prefiksWyst++;
    }

    public int getSufiksWyst() {
        return sufiksWyst;
    }

    public void incrSufiksWyst() {
        this.sufiksWyst++;
    }

    public String getNGram() {
        return prefiks + sufiks;
    }

    @Override
    public String toString() {
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

    public static void main(String args[]) throws FileNotFoundException {
        TekstyBazowe t = null;
        try {
            t = new TekstyBazowe("/home/pawel/NetBeansProjects/Chat/src/ChatJadro/");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NGram.class.getName()).log(Level.SEVERE, null, ex);
        }
        NGram[] ngramy = new NGram[100];

        if (t == null) {
            System.exit(1);
        }
        for (int i = 0; i < 100; i++) {
            if (!t.hasNext()) {
                break;
            }
        }
    }

    @Override
    public int compareTo(NGram n) {
        int cmp;
        cmp = this.prefiks.compareTo(n.prefiks);
        if (cmp < 0 || cmp > 0) {
            return cmp;
        } else {
            if (this != n){ // jeśli nie są to te same obiekty
                this.prefiksWyst++;
                n.prefiksWyst++;
            }
            cmp = this.sufiks.compareTo(n.sufiks);
            if (cmp < 0 || cmp > 0) {
                return cmp;
            } else {
                if (this != n) {
                    n.sufiksWyst++;
                    this.sufiksWyst++;
                }
                return cmp;
            }
        }
    }
}
