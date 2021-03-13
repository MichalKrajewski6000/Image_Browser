/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package przegladarkaobrazow;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

/**
 *
 * @author Nerazeem
 */
public class Browser extends javax.swing.JFrame {

    /**
     * Creates new form Browser
     */
    public Browser() {
        initComponents();
    }
    JLabel etykieta = new JLabel();
    JFileChooser fc = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Obrazy", "jpg", "png");
    
    //pobranie rozszerzenia pliku
    String rozszerzenie(File plik)
    {
        String ext;
        
        String fileName = plik.getName();
        
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        {
            ext = fileName.substring(fileName.lastIndexOf(".")+1);
        }           
        else 
            ext = "";
        return ext;
    }
    
    //sprawdzanie rozszerzeń plików
    boolean checkExt(File f)
    {
        if(("png".equals(rozszerzenie(f))) || ("jpg".equals(rozszerzenie(f))))
            {
                return true;
            }
            else
            {
                return false;
            }
    }
    
    //lista obrazów w katalogu
    File[] listFiles()
    {
        int i=0,j=0;
        File dir = fc.getCurrentDirectory();
        File[] pliki = dir.listFiles();
        
        for(File plik : pliki)
        {
            if(checkExt(plik))
            {
                i++;
            }
        } 
        File[] obrazy = new File[i];
        
        for(File plik : pliki)
        {
            if(checkExt(plik))
            {
                obrazy[j]=plik;
                j++;
            }
        } 
        return obrazy;
    }         
    
    //wyświetlenie obrazu 
    void setImage(File plik)
    {                  
        etykieta.setIcon(new ImageIcon(plik.toString()));
        etykieta.setHorizontalAlignment(JLabel.CENTER);
            
        ScrollPane.getViewport().add(etykieta);
    }
    
    //manager plików
    void FileChooser()
    {
        fc.setFileFilter(filter);
        
        var returnVal = fc.showOpenDialog(jMenu1);
        if(returnVal == JFileChooser.APPROVE_OPTION) 
        {
            File plik = fc.getSelectedFile();
            setImage(plik);
        }
    }
    
    int findIndex(File[] arr, File f)
    {
        int i=0, index = 0;
        
        for(File p : arr)
        {
            if(p.getName().equals(f.getName()))
            {
                index = i;
            }
            else
                i++;
        }
        
        return index;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrollPane = new javax.swing.JScrollPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Poprzednie");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrevActionPerformed(evt);
            }
        });

        jButton2.setText("Następne");
        jButton2.setActionCommand("Next");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setText("Otwórz");
        jMenuItem1.setActionCommand("Open");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Zamknij");
        jMenuItem2.setActionCommand("Close");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPane)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(261, 261, 261)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(201, 201, 201)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(326, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenActionPerformed
        FileChooser();
    }//GEN-LAST:event_OpenActionPerformed

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CloseActionPerformed

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        File[] obrazy = listFiles();
        Icon ikona = etykieta.getIcon();
        File currentImg = new File(ikona.toString());
        
        int indeks = findIndex(obrazy, currentImg);
        
        if(indeks == obrazy.length-1)
        {
            indeks=0;
            
            setImage(obrazy[indeks]);
        }
        else
        {
            indeks++;
            
            setImage(obrazy[indeks]);
        }
    }//GEN-LAST:event_NextActionPerformed

    private void PrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrevActionPerformed
        File[] obrazy = listFiles();
        Icon ikona = etykieta.getIcon();
        File currentImg = new File(ikona.toString());
        
        int indeks = findIndex(obrazy, currentImg);
        
        if(indeks == 0)
        {
            indeks=obrazy.length-1;
            
            setImage(obrazy[indeks]);
        }
        else
        {
            indeks--;
            
            setImage(obrazy[indeks]);
        }
    }//GEN-LAST:event_PrevActionPerformed

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
            java.util.logging.Logger.getLogger(Browser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Browser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Browser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Browser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Browser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
}
