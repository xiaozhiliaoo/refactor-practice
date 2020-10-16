package org.api.design.chapter7;

import javax.swing.*;

/**
 * @author lili
 * @date 2020/7/26 19:12
 * @notes
 */
public abstract class Anagrams extends JFrame implements UI {

    protected abstract WordLibrary getWordLibrary();

    protected abstract Scrambler getScrambler();

    @Override
    public void display() {
        initWord();
        setVisible(true);
    }

    private void initWord() {
    }
}
