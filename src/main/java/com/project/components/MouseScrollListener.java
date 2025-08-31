package com.project.components;

import com.project.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.*;

public class MouseScrollListener extends MouseAdapter implements MouseWheelListener {

    private static int UP = -1;
    private static int DOWN = 1;

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if(!Graph.calculateSenoids) return;

        int notches = e.getWheelRotation(); // Obtém a quantidade de "notches" de scroll
        if(notches == UP) {
            Globals.HARMONICS++;
        } else {
            Globals.HARMONICS--;
        }
        Window.graph.repaint();
    }
}
