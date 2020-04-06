package com.zh.raback.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CommandMapperTest {

    private CommandMapper commandMapper;

    @BeforeEach
    public void setUp() {
        commandMapper = new CommandMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(commandMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(commandMapper.fromId(null)).isNull();
    }
}
