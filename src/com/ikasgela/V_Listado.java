package com.ikasgela;

import javax.swing.*;

public class V_Listado {
    private JButton desc_Button;
    private JLabel name_Label;
    protected JPanel search_Panel;
    private JLabel number_Label;
    private JLabel email_Label;
    private JLabel currentIndex_Label;
    private JLabel total_Label;
    private JButton asc_Button;

    private int indice;

    public V_Listado(Agenda agenda) {
        indice = 0;
        total_Label.setText(String.valueOf(agenda.NumContactos()));
        currentIndex_Label.setText(String.valueOf(indice + 1));
        setInfo(agenda.BuscarUnico(indice));

        desc_Button.addActionListener(e -> {
            if (indice == 0) {
                indice = agenda.NumContactos() - 1;
            } else {
                indice--;
            }
            currentIndex_Label.setText(String.valueOf(indice + 1));
            setInfo(agenda.BuscarUnico(indice));
        });
        asc_Button.addActionListener(e -> {
            if (indice == agenda.NumContactos() - 1) {
                indice = 0;
            } else {
                indice++;
            }
            currentIndex_Label.setText(String.valueOf(indice + 1));
            setInfo(agenda.BuscarUnico(indice));
        });
    }

    public void setInfo(Contacto contacto_Show) {
        name_Label.setText(contacto_Show.getNombre());
        number_Label.setText(contacto_Show.getTelefono());
        email_Label.setText(contacto_Show.getEmail());
    }
}
