package org.api.design.chapter7.lookup;

import org.api.design.chapter7.WordLibrary;
import org.openide.util.Lookup;

/**
 * @author lili
 * @date 2020/7/26 22:05
 * @notes
 */
public class Main {
    public static void main(String[] args) {
        System.out.println();
        WordLibrary lookup = Lookup.getDefault().lookup(WordLibrary.class);
        System.out.println(lookup);
    }
}
