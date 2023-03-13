package com.ikasgela;

import javax.swing.*;
import java.awt.*;

public class V_Principal {
    protected JPanel principal_Panel;
    protected JButton newContact_Button;
    protected JButton seeContacts_Button;
    protected JButton search_Button;

    protected final Agenda agenda = new Agenda();


    public V_Principal() {
        newContact_Button.addActionListener(e -> {
            JFrame frame = new JFrame("Nuevo Contacto");
            frame.setContentPane(new V_Nuevo(agenda).nuevoContacto);
            frame.pack();
            frame.setVisible(true);
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension screenSize = toolkit.getScreenSize();
            int x = (screenSize.width - frame.getWidth()) / 2;
            int y = (screenSize.height - frame.getHeight()) / 2;
            frame.setLocation(x, y);
        });
        seeContacts_Button.addActionListener(e -> {

            if (agenda.contactoMap.size() > 0) {
                JFrame frame = new JFrame("Ver Contactos");
                frame.setContentPane(new V_Listado(agenda).search_Panel);
                frame.pack();
                frame.setVisible(true);
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                Dimension screenSize = toolkit.getScreenSize();
                int x = (screenSize.width - frame.getWidth()) / 2;
                int y = (screenSize.height - frame.getHeight()) / 2;
                frame.setLocation(x, y);
            } else {
                JOptionPane.showMessageDialog(null, "Hacen falta registros para poder " +
                        "visualizar esta pantalla", "Not Data Found", JOptionPane.INFORMATION_MESSAGE);
            }

        });
        search_Button.addActionListener(e -> {
            JFrame frame = new JFrame("Buscar");
            frame.setContentPane(new V_Buscar(agenda).search_Panel);
            frame.pack();
            frame.setVisible(true);
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension screenSize = toolkit.getScreenSize();
            int x = (screenSize.width - frame.getWidth()) / 2;
            int y = (screenSize.height - frame.getHeight()) / 2;
            frame.setLocation(x, y);
        });
    }

    public static void main(String[] args) {

        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        JFrame frame = new JFrame("Agenda");
        frame.setContentPane(new V_Principal().principal_Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
    }
}
