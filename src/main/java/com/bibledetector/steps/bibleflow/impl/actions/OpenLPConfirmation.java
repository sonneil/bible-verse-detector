package com.bibledetector.steps.bibleflow.impl.actions;

import com.bibledetector.steps.bibleflow.impl.actions.config.GoLiveOpenLPConfig;
import com.bibledetector.steps.bibleflow.types.impl.ActionInput;
import com.bibledetector.steps.bibleflow.types.step.Action;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

public class OpenLPConfirmation implements Action {

    @Override
    public void execute(ActionInput actionInput) {
        final boolean state;
        // Create the main frame (window)
        Frame frame = new Frame("OpenLP LIVE");

        // Create a label with initial text
        Label bibleTextLabel = new Label(actionInput.prettyString());

        bibleTextLabel.setForeground(Color.white);
        bibleTextLabel.setFont(new Font("Arial", Font.BOLD, 36));

        // Create a button with text "Toggle"
        Button proyectarButton = new Button("PROYECTAR");
        Button cancelButton = new Button("NO PROYECTAR");

        proyectarButton.setFont(new Font("Arial", Font.BOLD, 36));
        cancelButton.setFont(new Font("Arial", Font.BOLD, 36));

        // Set layout manager for the frame (using FlowLayout for simplicity)
        frame.setLayout(new GridLayout(4, 1));

        // Add the label and button to the frame
        frame.add(createCenteredPanel(bibleTextLabel));
        frame.add(proyectarButton);
        frame.add(cancelButton);

        // Set the frame size, color and make it visible
        int frameWidth = 800;
        int frameHeight = 500;
        frame.setSize(frameWidth, frameHeight);
        frame.setBackground(Color.BLACK);
        frame.setVisible(true);

        // Bring frame to front
        frame.toFront();

        // Position the frame at center
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frameWidth) / 2;
        int y = (screenSize.height - frameHeight) / 2;
        frame.setLocation(x, y);

        // Button click event handler
        proyectarButton.addActionListener(e -> {
            new GoLiveOpenLP().execute(actionInput);
            frame.dispose();
        });

        cancelButton.addActionListener(e -> {
            frame.dispose();
        });

        // Add window closing behavior
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                frame.dispose();
            }
        });

        // Create a timer to close the frame after configured time in seconds
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                frame.dispose();
            }
        }, GoLiveOpenLPConfig.CONFIRMATION_WINDOW_TIMEOUT_SECONDS * 1000);
    }

    // Helper method to create a centered panel for each component
    private Panel createCenteredPanel(Component comp) {
        Panel panel = new Panel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center the component
        panel.add(comp);
        return panel;
    }
}
