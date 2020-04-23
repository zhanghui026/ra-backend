package com.zh.raback.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.zh.raback.web.rest.TestUtil;

public class MuseumDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(MuseumDTO.class);
        MuseumDTO museumDTO1 = new MuseumDTO();
        museumDTO1.setId(1L);
        MuseumDTO museumDTO2 = new MuseumDTO();
        assertThat(museumDTO1).isNotEqualTo(museumDTO2);
        museumDTO2.setId(museumDTO1.getId());
        assertThat(museumDTO1).isEqualTo(museumDTO2);
        museumDTO2.setId(2L);
        assertThat(museumDTO1).isNotEqualTo(museumDTO2);
        museumDTO1.setId(null);
        assertThat(museumDTO1).isNotEqualTo(museumDTO2);
    }
}
