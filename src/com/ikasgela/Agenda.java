package com.ikasgela;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Agenda {

    Map<String, Contacto> contactoMap = new HashMap<>();
    List<Contacto> contactoList = new ArrayList<>();


    public void NuevoContacto(Contacto contacto) {
        contactoMap.put(contacto.getTelefono(), contacto);
        contactoList.add(contacto);
    }

    public Contacto Buscar(String consulta, CampoBusqueda filtro) {
        Contacto deseado = null;

        if (filtro.name().equals(CampoBusqueda.NOMBRE.name())) {
            for (Map.Entry<String, Contacto> contactoEntry :
                    contactoMap.entrySet()) {
                if (contactoEntry.getValue().getNombre().equals(consulta)) deseado = contactoEntry.getValue();
            }
        } else if (filtro.name().equals(CampoBusqueda.EMAIL.name())) {
            for (Map.Entry<String, Contacto> contactoEntry :
                    contactoMap.entrySet()) {
                if (contactoEntry.getValue().getEmail().equals(consulta)) deseado = contactoEntry.getValue();
            }
        } else if (filtro.name().equals(CampoBusqueda.TELEFONO.name())) {
            for (Map.Entry<String, Contacto> contactoEntry :
                    contactoMap.entrySet()) {
                if (contactoEntry.getKey().equals(consulta)) deseado = contactoEntry.getValue();
            }
        }
        return deseado;

    }

    public int NumContactos() {
        return contactoMap.size();
    }

    public Contacto BuscarUnico(int indice) {
        return contactoList.get(indice);
    }


}
