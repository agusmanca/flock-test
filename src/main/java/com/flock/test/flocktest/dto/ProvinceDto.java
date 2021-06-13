package com.flock.test.flocktest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProvinceDto {
    private CentroideDto centroide;
    private String id;
    private String nombre;

    public ProvinceDto() {}
}
