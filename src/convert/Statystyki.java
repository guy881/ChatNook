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
        if (size > 0) {
            this.size = size;
        }
        najczestszeNGramy = n.subList(0, size - 1);
    }

    public NGram getNGram(int index) { // może zwrócić null
        if (index >= this.size) {
            return null;
        }
        return najczestszeNGramy.get(index);
    }
}
