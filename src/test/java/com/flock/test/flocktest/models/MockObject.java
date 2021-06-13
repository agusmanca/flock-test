package com.flock.test.flocktest.models;

import com.flock.test.flocktest.dto.CentroideDto;

import java.util.Arrays;
import java.util.List;

public class MockObject {

    public CentroideDto getCentroideMock() {
        CentroideDto centroide = new CentroideDto();
        centroide.setLat(Float.valueOf((float) -32.142933));
        centroide.setLon(Float.valueOf((float) -63.801754));
        return centroide;
    }

    public List<String> getProvinces() {
        return Arrays.asList("Misiones","San Luis", "San Juan","Entre Ríos", "Santa Cruz","Río Negro",
                             "Chubut","Córdoba","Mendoza","La Rioja","Catamarca","La Pampa",
                             "Santiago del Estero","Corrientes","Santa Fe","Tucumán","Neuquén","Salta",
                             "Chaco","Formosa","Jujuy","Ciudad Autónoma de Buenos Aires","Buenos Aires",
                             "Tierra del Fuego, Antártida e Islas del Atlántico Sur");
    }
}
