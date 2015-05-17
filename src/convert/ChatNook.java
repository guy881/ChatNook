/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 15 maj: 
 -problem z dodawaniem wpisanych wiadomości do bazy, nowe ngramy łączą się ze starymi,
 */
package convert;

import ChatJadro.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 *
 * @author pawel
 */
public class ChatNook extends javax.swing.JFrame {

    /**
     * Creates new form ChatNook
     */
    public ChatNook() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        panelGlowny = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        wprowadzanieTekstu = new javax.swing.JTextArea();
        wyslijBut = new javax.swing.JButton();
        UstawieniaBut = new javax.swing.JButton();
        statystykiBut = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        wiadomosci = new javax.swing.JTextArea();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ChatNook");
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        wprowadzanieTekstu.setColumns(20);
        wprowadzanieTekstu.setRows(5);
        wprowadzanieTekstu.setText("");
        wprowadzanieTekstu.setToolTipText("Tutaj wprowadź tekst, który chcesz wysłać.");
        wprowadzanieTekstu.setNextFocusableComponent(wprowadzanieTekstu);
        wprowadzanieTekstu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wprowadzanieTekstuMouseClicked(evt);
            }
        });
        wprowadzanieTekstu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                wprowadzanieTekstuKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(wprowadzanieTekstu);
        wprowadzanieTekstu.setLineWrap(true);
        wprowadzanieTekstu.setWrapStyleWord(true);

        wyslijBut.setBackground(new java.awt.Color(255, 122, 0));
        wyslijBut.setText("Wyślij");
        wyslijBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wyslijButActionPerformed(evt);
            }
        });

        UstawieniaBut.setText("Ustawienia");
        UstawieniaBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UstawieniaButActionPerformed(evt);
            }
        });

        statystykiBut.setText("Statystyki");
        statystykiBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statystykiButActionPerformed(evt);
            }
        });

        wiadomosci.setColumns(20);
        wiadomosci.setRows(5);
        jScrollPane1.setViewportView(wiadomosci);
        wiadomosci.setEditable(false);
        wiadomosci.setLineWrap(true);

        javax.swing.GroupLayout panelGlownyLayout = new javax.swing.GroupLayout(panelGlowny);
        panelGlowny.setLayout(panelGlownyLayout);
        panelGlownyLayout.setHorizontalGroup(
            panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlownyLayout.createSequentialGroup()
                .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelGlownyLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(UstawieniaBut)
                        .addGap(18, 18, 18)
                        .addComponent(statystykiBut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(wyslijBut, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelGlownyLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelGlownyLayout.setVerticalGroup(
            panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlownyLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wyslijBut)
                    .addComponent(statystykiBut)
                    .addComponent(UstawieniaBut))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        getContentPane().add(panelGlowny);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UstawieniaButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UstawieniaButActionPerformed
        UstawieniaFrame ustawienia = new UstawieniaFrame();
        ustawienia.setVisible(true);
    }//GEN-LAST:event_UstawieniaButActionPerformed

    private void statystykiButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statystykiButActionPerformed
        StatystykiFrame statystykiOkno = new StatystykiFrame();
        statystykiOkno.setVisible(true);
    }//GEN-LAST:event_statystykiButActionPerformed

    private void wprowadzanieTekstuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wprowadzanieTekstuMouseClicked

    }//GEN-LAST:event_wprowadzanieTekstuMouseClicked

    private void wyslijButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wyslijButActionPerformed
        String wiadomosc = wprowadzanieTekstu.getText();
        wiadomosci.append("Ty: ");
        wiadomosci.append(wiadomosc + "\n\n");
        wprowadzanieTekstu.setText("");
        
        String[] wprowadzoneSlowa = wiadomosc.split(" ");
        ArrayList<String> wiadomosciList = new ArrayList<>();
        wiadomosciList.addAll(Arrays.asList(wprowadzoneSlowa));
        Wejscie wejscieWiadomosci = new Wejscie(wiadomosciList, rzad);
        wprowadzNGramyDoBazy(wejscieWiadomosci);
        System.out.println("\n");
        wypiszNGramy();
    }//GEN-LAST:event_wyslijButActionPerformed

    private void wprowadzanieTekstuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_wprowadzanieTekstuKeyTyped

    }//GEN-LAST:event_wprowadzanieTekstuKeyTyped

    private static void wprowadzNGramyDoBazy(Wejscie wejscie) {
        NGram ngram = null;
        String pref;
        String suf;
        while ((pref = wejscie.nextPref()) != null && (suf = wejscie.nextSuf()) != null) {
            ngram = new NGram(pref, suf);
            baza.add(ngram);
        }
    }

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
            java.util.logging.Logger.getLogger(ChatNook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatNook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatNook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatNook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatNook().setVisible(true);
            }
        });

        Wejscie wejscie = null;

        try {
            wejscie = new Wejscie(path, rzad);
        } catch (FileNotFoundException e) {
            System.out.println("zly plik");
            System.exit(1);
        }
        baza = new TreeSet<>();

        wprowadzNGramyDoBazy(wejscie);
        wypiszNGramy();
    }

    private static void wypiszNGramy() {
        for (NGram ngram : baza) {
            System.out.println(ngram.toString());
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton UstawieniaBut;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelGlowny;
    private javax.swing.JButton statystykiBut;
    private javax.swing.JTextArea wiadomosci;
    private javax.swing.JTextArea wprowadzanieTekstu;
    private javax.swing.JButton wyslijBut;
    // End of variables declaration//GEN-END:variables

    private static String path = "/home/pawel/NetBeansProjects/Chat/src/ChatJadro/test";
    private static TreeSet<NGram> baza;
    private static int rzad = 3;
}
