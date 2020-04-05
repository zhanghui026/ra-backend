package com.zh.raback.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FileManagerMapperTest {

    private FileManagerMapper fileManagerMapper;

    @BeforeEach
    public void setUp() {
        fileManagerMapper = new FileManagerMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(fileManagerMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(fileManagerMapper.fromId(null)).isNull();
    }
}
