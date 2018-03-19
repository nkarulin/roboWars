package com.epam.module5;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class InputExample extends Frame implements KeyListener {

    public InputExample() {
        Frame f = new Frame("Pad");

        f.setSize(400, 400);
        f.setLayout(null);
        Label l = new Label();
        l.setBounds(34, 34, 88, 88);
        f.add(l);

        f.setVisible(true);
        f.addKeyListener(this);
    }

    public static void main(String arg[]) {
        new InputExample();
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {
        //System.out.println("Ty");
    }

    /**
     * Handle the key pressed event from the text field.
     */
    public void keyPressed(KeyEvent e) {
        System.out.println("pre" + e.getKeyCode());
    }

    /** Handle the key released event from the text field. */

}