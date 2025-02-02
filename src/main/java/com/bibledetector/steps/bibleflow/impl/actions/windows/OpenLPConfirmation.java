package com.bibledetector.steps.bibleflow.impl.actions.windows;

import com.bibledetector.steps.bibleflow.types.impl.ActionInput;
import com.bibledetector.steps.bibleflow.types.step.Action;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OpenLPConfirmation {
    public static void display(Action action, ActionInput actionInput) {
        final boolean state;
        // Create the main frame (window)
        Frame frame = new Frame("OpenLP LIVE");

        // Create a label with initial text
        Label label = new Label("Proyectar en OpenLP el Texto: " + actionInput.toString() + "?" );

        // Create a button with text "Toggle"
        Button proyectarButton = new Button("Proyectar");
        Button cancelButton = new Button("No Proyectar");

        // Button click event handler
        proyectarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.execute(actionInput);
                Frame frame = (Frame) proyectarButton.getParent();
                frame.dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame frame = (Frame) cancelButton.getParent();
                frame.dispose();
            }
        });

        // Set layout manager for the frame (using FlowLayout for simplicity)
        frame.setLayout(new FlowLayout());

        // Add the label and button to the frame
        frame.add(label);
        frame.add(proyectarButton);
        frame.add(cancelButton);

        // Set the frame size and make it visible
        frame.setSize(300, 100);
        frame.setVisible(true);

        // Add window closing behavior
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
            }
        });
    }
}
