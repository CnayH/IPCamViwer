/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camviewer;

import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.opencv.core.Core;

/**
 *
 * @author coder
 */
public class CamViewer extends javax.swing.JFrame {

    /**
     * Creates new form CamViewer
     */
    public CamViewer() {
        try {
            initComponents();
            Properties prop = new Properties();
            prop.load(new FileInputStream("config.properties"));
            
            VideoThread myThread = new VideoThread(prop.getProperty("cam1"),panLeftCam);
            Thread t = new Thread(myThread);
            t.setDaemon(true);
            myThread.setRunnable(true);
            t.start();
            
            VideoThread myThread2 = new VideoThread(prop.getProperty("cam2"),panRightCam);
            Thread t2 = new Thread(myThread2);
            t2.setDaemon(true);
            myThread2.setRunnable(true);
            t2.start();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CamViewer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CamViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
        fullScreen();
    }
    
    private void fullScreen(){
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());
        setSize(xSize,ySize);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panLeftCam = new javax.swing.JPanel();
        panRightCam = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout panLeftCamLayout = new javax.swing.GroupLayout(panLeftCam);
        panLeftCam.setLayout(panLeftCamLayout);
        panLeftCamLayout.setHorizontalGroup(
            panLeftCamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        panLeftCamLayout.setVerticalGroup(
            panLeftCamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(panLeftCam, gridBagConstraints);

        javax.swing.GroupLayout panRightCamLayout = new javax.swing.GroupLayout(panRightCam);
        panRightCam.setLayout(panRightCamLayout);
        panRightCamLayout.setHorizontalGroup(
            panRightCamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        panRightCamLayout.setVerticalGroup(
            panRightCamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(panRightCam, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws MalformedURLException, IOException {


        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CamViewer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panLeftCam;
    private javax.swing.JPanel panRightCam;
    // End of variables declaration//GEN-END:variables
}
