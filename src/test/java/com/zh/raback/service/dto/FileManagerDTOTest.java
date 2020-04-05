package com.zh.raback.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.zh.raback.web.rest.TestUtil;

public class FileManagerDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(FileManagerDTO.class);
        FileManagerDTO fileManagerDTO1 = new FileManagerDTO();
        fileManagerDTO1.setId(1L);
        FileManagerDTO fileManagerDTO2 = new FileManagerDTO();
        assertThat(fileManagerDTO1).isNotEqualTo(fileManagerDTO2);
        fileManagerDTO2.setId(fileManagerDTO1.getId());
        assertThat(fileManagerDTO1).isEqualTo(fileManagerDTO2);
        fileManagerDTO2.setId(2L);
        assertThat(fileManagerDTO1).isNotEqualTo(fileManagerDTO2);
        fileManagerDTO1.setId(null);
        assertThat(fileManagerDTO1).isNotEqualTo(fileManagerDTO2);
    }
}
