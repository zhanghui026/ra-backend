package com.zh.raback.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.zh.raback.web.rest.TestUtil;

public class CommandDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CommandDTO.class);
        CommandDTO commandDTO1 = new CommandDTO();
        commandDTO1.setId(1L);
        CommandDTO commandDTO2 = new CommandDTO();
        assertThat(commandDTO1).isNotEqualTo(commandDTO2);
        commandDTO2.setId(commandDTO1.getId());
        assertThat(commandDTO1).isEqualTo(commandDTO2);
        commandDTO2.setId(2L);
        assertThat(commandDTO1).isNotEqualTo(commandDTO2);
        commandDTO1.setId(null);
        assertThat(commandDTO1).isNotEqualTo(commandDTO2);
    }
}
