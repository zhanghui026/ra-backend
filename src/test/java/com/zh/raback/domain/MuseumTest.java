package com.zh.raback.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.zh.raback.web.rest.TestUtil;

public class MuseumTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Museum.class);
        Museum museum1 = new Museum();
        museum1.setId(1L);
        Museum museum2 = new Museum();
        museum2.setId(museum1.getId());
        assertThat(museum1).isEqualTo(museum2);
        museum2.setId(2L);
        assertThat(museum1).isNotEqualTo(museum2);
        museum1.setId(null);
        assertThat(museum1).isNotEqualTo(museum2);
    }
}
