package com.ikasgela;

import javax.swing.*;

public class V_Nuevo {
    private JTextField name_textField;
    private JTextField number_textField;
    private JTextField email_textField;
    private JButton clean_Button;
    private JButton save_Button;
    protected JPanel nuevoContacto;

    public V_Nuevo(Agenda agenda) {
        save_Button.addActionListener(e -> {
            if (!name_textField.getText().equals("") && !number_textField.getText().equals("")
                    && !email_textField.getText().equals("")) {
                if (!agenda.contactoMap.containsKey(number_textField.getText())) {
                    String name_Contact = name_textField.getText();
                    String number_Contact = number_textField.getText();
                    String email_Contact = email_textField.getText();

                    Contacto contacto_Actual = new Contacto(name_Contact, number_Contact, email_Contact);
                    agenda.NuevoContacto(contacto_Actual);
                    JOptionPane.showMessageDialog(null, "Contacto Guardado Correctamente :)",
                            "Guardado Exitoso", JOptionPane.INFORMATION_MESSAGE);
                    clean();
                } else {
                    JOptionPane.showMessageDialog(null, "Numero ya registrado", "Error Guardado",
                            JOptionPane.ERROR_MESSAGE);
                    clean();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No pueden haber campos vacios.", "Error Guardado",
                        JOptionPane.ERROR_MESSAGE);

            }


        });
        clean_Button.addActionListener(e -> clean());
    }

    public void clean() {
        name_textField.setText("");
        number_textField.setText("");
        email_textField.setText("");
    }
}
