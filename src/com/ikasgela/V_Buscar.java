package com.ikasgela;

import javax.swing.*;

public class V_Buscar {
    private JComboBox<String> comboBox1;
    private JTextField consulta_textField;
    private JButton buscar_Button;
    protected JPanel search_Panel;
    private JLabel name_Label;
    private JLabel number_Label;
    private JLabel email_Label;

    public V_Buscar(Agenda agenda) {
        comboBox1.addItem("NOMBRE");
        comboBox1.addItem("TELEFONO");
        comboBox1.addItem("EMAIL");


        buscar_Button.addActionListener(e -> {
            if (!consulta_textField.getText().equals("")) {
                CampoBusqueda filtro = CampoBusqueda.valueOf(comboBox1.getSelectedItem().toString());
                String consulta = consulta_textField.getText();
                Contacto busqueda = agenda.Buscar(consulta, filtro);
                if (busqueda != null) {
                    name_Label.setText(busqueda.getNombre());
                    number_Label.setText(busqueda.getTelefono());
                    email_Label.setText(busqueda.getEmail());
                } else {
                    JOptionPane.showMessageDialog(null, "Contacto no encontrado", "No Encontrado",
                            JOptionPane.INFORMATION_MESSAGE);
                    consulta_textField.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error de dato de consulta revise " +
                                "que sea un tipo adecuado o no sea nulo", "Error Consulta",
                        JOptionPane.ERROR_MESSAGE);
            }

        });
    }
}
