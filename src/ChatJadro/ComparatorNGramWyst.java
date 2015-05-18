/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatJadro;

import java.util.Comparator;

/**
 *
 * @author pawel
 */
public class ComparatorNGramWyst implements Comparator<NGram> { //porównuje NGramy po ilości wystąpień

    @Override
    public int compare(NGram o1, NGram o2) {
        int o1Wyst = o1.getSufiksWyst();
        int o2Wyst = o2.getSufiksWyst();
        if (o1Wyst < o2Wyst) {
            return 1;
        } else if (o1Wyst > o2Wyst) {
            return -1;
        } else {
            return 0;
        }
    }
}
