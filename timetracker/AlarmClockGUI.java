/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetracker;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.util.Calendar;

public class AlarmClockGUI {

    private JFrame frame;
    private JButton onOffButton;
    private JComboBox<String> alarmList;
    private JLabel remainingTime, currentTime,
            alarmTime;
    private final EventHandler eventHandler; //Handles GUI events
    private final boolean time24Mode = false; //Indicates 24H (true) or 12H (false) time
    private boolean isRunning = false;
    private blockStorage store;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                AlarmClockGUI acg = new AlarmClockGUI();
            }
        });
    }

    public AlarmClockGUI() {
        eventHandler = new EventHandler(); //Handles GUI events
        createFrameOptions();
    }

    class EventHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            //Make this track if the user is active, and update timeblocks accordingly
            
            /*if(isRunning){
               return;
            }
            isRunning = true;
            
            Scanner keyb = new Scanner(System.in);
            Calendar start = Calendar.getInstance(), now;
            timeBlock current = new timeBlock(start, "Hello");
            while(!keyb.hasNext()) {
            now = Calendar.getInstance();
            if(now.getTimeInMillis() - start.getTimeInMillis() > 60000){
                current.stop();
                store.addBlock(current);
            }
            }
            isRunning = false;

            */
        }
    }

    private void updateTimeDisplay() {
        String tempTime = String.format("%tT", new Date());
        if (time24Mode) {
            currentTime.setText(tempTime);
        } else {
            currentTime.setText(String.format("%tr", new Date()));
        }
    }

    private void createFrameOptions() {
        frame = new JFrame("Alarm Clock");
        frame.getContentPane().add(createMainPanel());
        createTimer(); //must follow main panel creation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.pack();
        frame.setLocationRelativeTo(null); //Centers frame. Must follow pack()
        frame.setVisible(true);
    }

    private JPanel createTimePanel() {
        JPanel timePanel = new JPanel(new GridBagLayout());

        remainingTime = new JLabel("00:00:00", SwingConstants.CENTER);
        remainingTime.setFont(
                remainingTime.getFont().deriveFont(36.0f));
        remainingTime.setPreferredSize(new Dimension(190, 80));
        remainingTime.setOpaque(true);
        remainingTime.setBorder(
                BorderFactory.createTitledBorder("Remaining Time"));
        currentTime = new JLabel(String.format("%tT", new Date()),
                SwingConstants.CENTER);
        currentTime.setFont(
                currentTime.getFont().deriveFont(16.0f));
        currentTime.setPreferredSize(new Dimension(164, 40));
        currentTime.setOpaque(false);
        currentTime.setBorder(
                BorderFactory.createTitledBorder("Current Time"));
        alarmTime = new JLabel("00:00:00", SwingConstants.CENTER);
        alarmTime.setFont(
                alarmTime.getFont().deriveFont(16.0f));
        alarmTime.setPreferredSize(new Dimension(164, 40));
        alarmTime.setOpaque(false);
        alarmTime.setBorder(
                BorderFactory.createTitledBorder("Inactive Time"));

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 2;
        c.fill = GridBagConstraints.VERTICAL;
        timePanel.add(remainingTime, c);
        c.gridx = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.NONE;
        timePanel.add(currentTime, c);
        c.gridy = 1;
        timePanel.add(alarmTime, c);
        return timePanel;
    }

    private JComboBox createAlarmList() {
        alarmList = new JComboBox<>();
        alarmList.addActionListener(eventHandler);
        alarmList.setActionCommand("List");
        alarmList.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        return alarmList;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        onOffButton = createButton("Start Time", eventHandler);
        onOffButton.setPreferredSize(new Dimension(88, 26));
        buttonPanel.add(onOffButton); //Not anonymous; button text changes
        buttonPanel.add(createButton("Pause Time", eventHandler));
        buttonPanel.add(createButton("Reset Time", eventHandler));
        buttonPanel.add(createButton("View Calendar", eventHandler));
        return buttonPanel;
    }

    private JButton createButton(String buttonName, ActionListener al) {
        JButton b = new JButton(buttonName);
        b.setActionCommand(buttonName);
        b.addActionListener(al);
        return b;
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.add(createTimePanel());
        mainPanel.add(Box.createRigidArea(new Dimension(10, 10)));
        mainPanel.add(createAlarmList());
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(createButtonPanel());
        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return mainPanel;
    }

    private void createTimer() {
        Timer timer = new Timer(1000, eventHandler);
        timer.setActionCommand("Timer");
        timer.setInitialDelay(0);
        timer.start();
    }
}