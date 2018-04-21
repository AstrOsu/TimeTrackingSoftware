/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leon
 */
public class HomePage extends javax.swing.JFrame
{

    /**
     * Creates new form HomePage
     */
    public HomePage()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jToolBar1 = new javax.swing.JToolBar();
        startTracking = new javax.swing.JButton();
        endTracking = new javax.swing.JButton();
        exportGUI = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputField = new javax.swing.JTextArea();
        alarmGUI = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        OpenOptionsGUI = new javax.swing.JMenuItem();

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        startTracking.setText("Start Tracking");
        startTracking.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                startTrackingMouseClicked(evt);
            }
        });

        endTracking.setText("End Tracking");
        endTracking.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                endTrackingMouseClicked(evt);
            }
        });

        exportGUI.setText("Export");
        exportGUI.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                exportGUIMouseClicked(evt);
            }
        });

        outputField.setColumns(20);
        outputField.setRows(5);
        jScrollPane1.setViewportView(outputField);

        alarmGUI.setText("Make Alarm");
        alarmGUI.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                alarmGUIMouseClicked(evt);
            }
        });
        alarmGUI.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                alarmGUIActionPerformed(evt);
            }
        });

        jLabel1.setText("Time Tracker");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        OpenOptionsGUI.setText("Options");
        OpenOptionsGUI.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                OpenOptionsGUIMouseClicked(evt);
            }
        });
        jMenu2.add(OpenOptionsGUI);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(endTracking)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(alarmGUI))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(startTracking)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exportGUI)))
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 119, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(160, 160, 160))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startTracking)
                    .addComponent(exportGUI))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endTracking)
                    .addComponent(alarmGUI))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exportGUIMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_exportGUIMouseClicked
    {//GEN-HEADEREND:event_exportGUIMouseClicked
        if(!isRunning){
        ExportGUI ex = new ExportGUI();
        String[] test = new String[3];
        ExportGUI.main(test);
        }
    }//GEN-LAST:event_exportGUIMouseClicked

    private void startTrackingMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_startTrackingMouseClicked
    {//GEN-HEADEREND:event_startTrackingMouseClicked
        if(isRunning){
            //start tracking
            isRunning = true;
        }
        
    }//GEN-LAST:event_startTrackingMouseClicked

    private void endTrackingMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_endTrackingMouseClicked
    {//GEN-HEADEREND:event_endTrackingMouseClicked
        if(isRunning){
            return;
        }
        //stop tracking
        outputField.setText(BS.toString());
        isRunning = false;
    }//GEN-LAST:event_endTrackingMouseClicked

    private void alarmGUIActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_alarmGUIActionPerformed
    {//GEN-HEADEREND:event_alarmGUIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alarmGUIActionPerformed

    private void alarmGUIMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_alarmGUIMouseClicked
    {//GEN-HEADEREND:event_alarmGUIMouseClicked
        AlarmGUI al = new AlarmGUI();
        String[] test = new String[3];
        AlarmGUI.main(test);
    }//GEN-LAST:event_alarmGUIMouseClicked

    private void OpenOptionsGUIMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_OpenOptionsGUIMouseClicked
    {//GEN-HEADEREND:event_OpenOptionsGUIMouseClicked
        OptionsGUI al = new OptionsGUI();
        String[] test = new String[3];
        OptionsGUI.main(test);
    }//GEN-LAST:event_OpenOptionsGUIMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new HomePage().setVisible(true);
            }
        });
    }

    private blockStorage BS;
    
    private boolean isRunning = false;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem OpenOptionsGUI;
    private javax.swing.JButton alarmGUI;
    private javax.swing.JButton endTracking;
    private javax.swing.JButton exportGUI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextArea outputField;
    private javax.swing.JButton startTracking;
    // End of variables declaration//GEN-END:variables
}