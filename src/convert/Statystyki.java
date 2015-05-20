/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convert;

import ChatJadro.NGram;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pawel
 */
public class Statystyki {

    private final List<NGram> najczestszeNGramy;
    private int size = 10;

    public Statystyki(List<NGram> n, int size) {
        if (size > 0 && size < n.size()) {
            this.size = size;
        } else {
            size = n.size();
        }
        najczestszeNGramy = n.subList(0, size);
    }

    public NGram getNGram(int index) { // może zwrócić null
        if (index >= this.size -1) {
            return null;
        }
        return najczestszeNGramy.get(index);
    }

    public static void main(String args[]) {
        List<NGram> n = new ArrayList();
        for (int i = 0; i < 10; i++) {
            n.add(new NGram("#" + i, "0"));
        }
        Statystyki stat = new Statystyki(n, 10);
        for (int i = 0; i < 10; i++) {
            System.out.println(stat.getNGram(i));
        }
    }
}
