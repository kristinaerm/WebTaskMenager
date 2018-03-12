/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientmenager;

import exceptions.InvalidRecordFieldException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.SimpleTaskManager;

/**
 *
 * @author Кристина
 */
public class ClientMenager {

    /**
     * @param args the command line arguments
     */
    static int serverPort = 1024;
    static String address = "localhost";
    static Socket socket = null;
    static ObjectOutputStream out = null;
    static ObjectInputStream in = null;

    public static void main(String[] args) {
        // TODO code application logic here

        try {

            socket = new Socket(address, serverPort);
            System.out.println("Соединение с сервером установлено");

            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            Controller.setInputOutputStream(in, out);

            SimpleTaskManager frame = new SimpleTaskManager();
            frame.setResizable(false);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTray();

            frame.addWindowListener(new WindowListener() {
                @Override
                public void windowClosing(WindowEvent event) {
                    try {
                        Controller.saveTaskLog();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                    try {
                        in.close();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                    try {
                        out.close();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                    try {
                        socket.close();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                    System.exit(0);
                }

                @Override
                public void windowOpened(WindowEvent e) {

                }

                @Override
                public void windowClosed(WindowEvent e) {

                }

                @Override
                public void windowIconified(WindowEvent e) {

                }

                @Override
                public void windowDeiconified(WindowEvent e) {

                }

                @Override
                public void windowActivated(WindowEvent e) {
                }

                @Override
                public void windowDeactivated(WindowEvent e) {

                }
            });

        } catch (IOException | InvalidRecordFieldException ex) {
            Logger.getLogger(ClientMenager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
