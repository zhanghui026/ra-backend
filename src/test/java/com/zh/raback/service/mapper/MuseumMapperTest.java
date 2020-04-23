package com.zh.raback.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MuseumMapperTest {

    private MuseumMapper museumMapper;

    @BeforeEach
    public void setUp() {
        museumMapper = new MuseumMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(museumMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(museumMapper.fromId(null)).isNull();
    }
}
