package com.flock.test.flocktest.service;

import com.flock.test.flocktest.dto.CentroideDto;
import com.flock.test.flocktest.models.MockObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class ProvinceServiceTest {

    @Autowired
    private ProvinceService provinceServiceMock = Mockito.mock(ProvinceService.class) ;

    @BeforeEach
    void setUp() {
        MockObject mocks = new MockObject();
        Mockito.when(provinceServiceMock.getProvinceCoordinates("Cordoba")).then(invocationOnMock -> mocks.getCentroideMock());
        Mockito.when(provinceServiceMock.getProvinceName()).then(invocationOnMock -> mocks.getProvinces());
    }

    @Test
    void getProvince() {
        CentroideDto centroide = provinceServiceMock.getProvinceCoordinates("Cordoba");
        Assertions.assertEquals(centroide.getLat(), Float.valueOf((float) -32.142933));
        Assertions.assertEquals(centroide.getLon(), Float.valueOf((float) -63.801754));
    }

    @Test
    void getProvinceName() {
        List<String> provinces = provinceServiceMock.getProvinceName();
        Assertions.assertEquals(provinces.size(), 24);
        Assertions.assertTrue(provinces.stream().anyMatch(c -> c.equals("Córdoba")));
    }
}
