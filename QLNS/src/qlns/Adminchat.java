/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package qlns;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class Adminchat extends javax.swing.JFrame {

    private ServerSocket serverSocket;
    private Socket adminSocket;
    private Socket employeeSocket;
    private DataInputStream adminIn;
    private DataInputStream employeeIn;
    private DataOutputStream adminOut;
    private DataOutputStream employeeOut;
    private boolean isEmployeeConnected = false;

    public Adminchat() {
        initComponents();
        setupServer();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        cc = new javax.swing.JTextArea();
        txtgui = new javax.swing.JTextField();
        btngui = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cc.setColumns(20);
        cc.setRows(5);
        jScrollPane1.setViewportView(cc);

        btngui.setText("Gửi");
        btngui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguiActionPerformed(evt);
            }
        });

        jLabel1.setText("Admin:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtgui, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btngui, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtgui, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btngui, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setupServer() {
        try {
            // Create a ServerSocket listening on port 5000
            serverSocket = new ServerSocket(5000);

            // Accept connections from Admin and Employee (as two clients)
            adminSocket = serverSocket.accept();
            employeeSocket = serverSocket.accept();

            // Set up input and output streams for both Admin and Employee
            adminIn = new DataInputStream(adminSocket.getInputStream());
            adminOut = new DataOutputStream(adminSocket.getOutputStream());

            employeeIn = new DataInputStream(employeeSocket.getInputStream());
            employeeOut = new DataOutputStream(employeeSocket.getOutputStream());

            // Start a new thread to read messages from the Employee
            new Thread(() -> {
                try {
                    while (true) {
                        String message = employeeIn.readUTF();
                        appendMessage("Employee: " + message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            isEmployeeConnected = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessageToEmployee(String message) {
        try {
            employeeOut.writeUTF(message);
            appendMessage("Admin: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void appendMessage(String message) {
        // Append the message to the textArea "cc"
        cc.append(message + "\n");
    }

    private void btnguiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguiActionPerformed
        String message = txtgui.getText();

        // Check if the message is not empty
        if (!message.isEmpty()) {
            sendMessageToEmployee(message);

            // Clear the input text field after sending
            txtgui.setText("");
        }
    }//GEN-LAST:event_btnguiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Adminchat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Adminchat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Adminchat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Adminchat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Adminchat().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btngui;
    private javax.swing.JTextArea cc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtgui;
    // End of variables declaration//GEN-END:variables
}
