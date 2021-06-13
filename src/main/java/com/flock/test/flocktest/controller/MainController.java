package com.flock.test.flocktest.controller;

import com.flock.test.flocktest.dto.CentroideDto;
import com.flock.test.flocktest.service.ProvinceService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = "Province Controller", value = "Operations for Province Information Controller")
public class MainController {

    private ProvinceService provinceService;
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    public MainController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @GetMapping("/provincia")
    @ApiOperation(nickname = "getProvince", value = "Get a province by name", notes = "Allow get a province coordinate by it name.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Sucessful", response = ResponseEntity.class) })
    public CentroideDto getProvince(@ApiParam(value = "Province name.") @RequestParam String value) {
        CentroideDto centroide = this.provinceService.getProvinceCoordinates(value);
        logger.info("Resultado para " + value +": Longitud "  + centroide.getLon() + " - Latitud " + centroide.getLat() );
        return centroide;
    }

    @GetMapping("/nombresProvincias")
    @ApiOperation(nickname = "getProvinceName", value = "Get a list of province name", notes = "Allow get a list of province to use on getProvince endpoint.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Sucessful", response = ResponseEntity.class) })
    public List<String> getProvinceName() {
        List<String> provinces =  this.provinceService.getProvinceName();
        logger.info("Se encontraron " + provinces.size() + " nombres de provincias.");
        return provinces;
    }
}
