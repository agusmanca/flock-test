package com.flock.test.flocktest.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ResponseDto {
    private Long inicio;
    private ParameterDto parametros;
    private List<ProvinceDto> provincias;
    private Long total;

    public ResponseDto() {}
}
