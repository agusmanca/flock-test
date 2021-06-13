package com.flock.test.flocktest.service;

import com.flock.test.flocktest.dto.CentroideDto;
import com.flock.test.flocktest.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProvinceService {

    public CentroideDto getProvinceCoordinates(String name) {

        CentroideDto centroide;
        String url = "https://apis.datos.gob.ar/georef/api/provincias?nombre=";

        ResponseEntity<ResponseDto> response = new RestTemplate().getForEntity(url + name, ResponseDto.class);

        if(response.hasBody()){
            centroide = response.getBody().getProvincias().get(0).getCentroide();
            return centroide;
        }
        return null;
    }

    public List<String> getProvinceName() {
        List<String> provinceName;
        String url = "https://apis.datos.gob.ar/georef/api/provincias";

        ResponseEntity<ResponseDto> response = new RestTemplate().getForEntity(url, ResponseDto.class);

        if(response.hasBody()){
            provinceName = response.getBody().getProvincias().stream().map(c -> c.getNombre()).collect(Collectors.toList());
            return provinceName;
        }
        return null;
    }

}
