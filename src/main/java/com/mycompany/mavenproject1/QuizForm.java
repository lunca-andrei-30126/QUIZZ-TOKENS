/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author lunca
 */
public class QuizForm extends javax.swing.JFrame {
int admin_tokens = 0;
int user_tokens = 0;
    /**
     * Creates new form QuizForm
     */
      // create an array of questions    
    String[] questions = {"1 + 1 = ?","3 - 3 = ?","5 + 5 = ?","10 X 9 = ?","100 - 50 = ?"};
    // create an array of options
    // the last item is the correct answer
    // we will check the selected answer from the user with the last item
    String[][] options = {{"100","9","2","0","2"},{"15","7","0","11","0"},{"20","10","50","5","10"},{"80","70","90","100","90"},{"60","50","40","25","50"}};

    // index to display the next question, correct to count the correct answers
    int index = 0, correct = 0;
    ButtonGroup bg = new ButtonGroup();
    public QuizForm() {
        initComponents();
          bg.add(jRadioButton1);
        bg.add(jRadioButton2);
        bg.add(jRadioButton3);
        bg.add(jRadioButton4);
        
        jButton_Next_QActionPerformed(null);
    }
    public void adminTokens()
    {
          Connection connection;
        PreparedStatement ps;
        int iduser = log_frame.id;
        try {
                String query ="SELECT TOKENS FROM users WHERE usertype = 'admin'"; 
               // System.out.println(iduser);
                connection=DriverManager.getConnection("jdbc:mysql://localhost/database1","root", "RawCry");
                 ps = connection.prepareStatement("SELECT TOKENS FROM users WHERE usertype = 'admin'");
                  ResultSet set = ps.executeQuery(query);
                  if(set.next())
                  {
                      int admin_tokens = set.getInt("tokens");
                     System.out.println(admin_tokens);
                      
                      
                    
                  }
                 
            } catch (SQLException ex) {
                Logger.getLogger(QuizForm.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void userTokens()
    {
          Connection connection;
        PreparedStatement ps;
        int iduser = log_frame.id;
        try {
                String query ="SELECT TOKENS FROM users WHERE idusers = 2"; 
               // System.out.println(iduser);
                connection=DriverManager.getConnection("jdbc:mysql://localhost/database1","root", "RawCry");
                 ps = connection.prepareStatement("SELECT TOKENS FROM users WHERE idusers = 2");
                  ResultSet set = ps.executeQuery(query);
                  if(set.next())
                  {
                      int user_tokens = set.getInt("tokens");
                     System.out.println(user_tokens);
                      
                      
                    
                  }
                 
            } catch (SQLException ex) {
                Logger.getLogger(QuizForm.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
     public void getSelectedOption(JRadioButton rbtn)
    {Connection connection;
       PreparedStatement ps;
        int iduser = log_frame.id;
        // get the selected value from the radiobutton
        // increment the index
        // disable the radiobuttons
        // check if the user selected the right answer
       // System.out.println(rbtn.getText());
       // System.out.println(options[index][4]);
         adminTokens();
           userTokens();
        if(rbtn.getText().equals(options[index][4]))
        {
            correct++;
          
        try {
            connection=DriverManager.getConnection("jdbc:mysql://localhost/database1","root", "RawCry");
            ps = connection.prepareStatement("UPDATE  users SET tokens = tokens - 10 WHERE usertype ='admin'");
            //admin_tokens=admin_tokens-10;
            ps.executeUpdate();
            //System.out.println(admin_tokens);
            connection=DriverManager.getConnection("jdbc:mysql://localhost/database1","root", "RawCry");
            ps = connection.prepareStatement("UPDATE  users SET tokens = tokens + 10 WHERE idusers ="+iduser);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuizForm.class.getName()).log(Level.SEVERE, null, ex);
        }
          
           
           
           
        }
    try {
        connection=DriverManager.getConnection("jdbc:mysql://localhost/database1","root", "RawCry");
         ps = connection.prepareStatement("SELECT idusers,username,password,usertype,tokens FROM users  ORDER BY tokens DESC");
            ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(QuizForm.class.getName()).log(Level.SEVERE, null, ex);
    }
           
        index++;
        enableRbuttons(false);
    }
     // enable/ disable radiobuttons
    public void enableRbuttons(boolean yes_or_no)
    {
        jRadioButton1.setEnabled(yes_or_no);
        jRadioButton2.setEnabled(yes_or_no);
        jRadioButton3.setEnabled(yes_or_no);
        jRadioButton4.setEnabled(yes_or_no);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel_Q_Container = new javax.swing.JPanel();
        Lbl_Question = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton_Next_Q = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel_Q_Container.setBackground(new java.awt.Color(204, 204, 204));

        Lbl_Question.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Lbl_Question.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Question.setText("Question here?");

        javax.swing.GroupLayout jPanel_Q_ContainerLayout = new javax.swing.GroupLayout(jPanel_Q_Container);
        jPanel_Q_Container.setLayout(jPanel_Q_ContainerLayout);
        jPanel_Q_ContainerLayout.setHorizontalGroup(
            jPanel_Q_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Lbl_Question, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
        );
        jPanel_Q_ContainerLayout.setVerticalGroup(
            jPanel_Q_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Lbl_Question, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );

        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton1.setText("jRadioButton2");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton2.setText("jRadioButton1");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton3.setText("jRadioButton3");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton4.setText("jRadioButton4");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jButton_Next_Q.setBackground(new java.awt.Color(255, 102, 0));
        jButton_Next_Q.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton_Next_Q.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Next_Q.setText("Next");
        jButton_Next_Q.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Next_QActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel_Q_Container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jButton_Next_Q, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel_Q_Container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton_Next_Q, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_Next_QActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Next_QActionPerformed
        // TODO add your handling code here:
        if(jButton_Next_Q.getText().equals("Restart The Quiz"))
        {
            // restart the quiz
            jButton_Next_Q.setText("Next");
            jPanel_Q_Container.setBackground(new java.awt.Color(204, 204, 204));
            index = 0;
            correct = 0;
        }
        
        if(index == questions.length)
        {
            // display the user score
            Lbl_Question.setText("Your Score: " + correct + " / " + questions.length);
            if(correct >= (float) questions.length/2)
            {
               jPanel_Q_Container.setBackground(Color.green);
            }
            else{
                jPanel_Q_Container.setBackground(Color.red);
            }
            
            jButton_Next_Q.setText("Restart The Quiz");
        }
        
        else{
               // enable radio buttons
             enableRbuttons(true);

             // display the next question
             Lbl_Question.setText(questions[index]);
             jRadioButton1.setText(options[index][0]);
             jRadioButton2.setText(options[index][1]);
             jRadioButton3.setText(options[index][2]);
             jRadioButton4.setText(options[index][3]);
             
             if(index == questions.length-1){
                 jButton_Next_Q.setText("Finish and See The Result");
             }
            
        }
        
        // clear the selection
        bg.clearSelection(); 
    }//GEN-LAST:event_jButton_Next_QActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
         getSelectedOption(jRadioButton3);
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
         getSelectedOption(jRadioButton2);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
         getSelectedOption(jRadioButton4);
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
         getSelectedOption(jRadioButton1);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(QuizForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuizForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuizForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuizForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new QuizForm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lbl_Question;
    private javax.swing.JButton jButton_Next_Q;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_Q_Container;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    // End of variables declaration//GEN-END:variables
}
