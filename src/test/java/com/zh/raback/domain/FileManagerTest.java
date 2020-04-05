package com.zh.raback.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.zh.raback.web.rest.TestUtil;

public class FileManagerTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(FileManager.class);
        FileManager fileManager1 = new FileManager();
        fileManager1.setId(1L);
        FileManager fileManager2 = new FileManager();
        fileManager2.setId(fileManager1.getId());
        assertThat(fileManager1).isEqualTo(fileManager2);
        fileManager2.setId(2L);
        assertThat(fileManager1).isNotEqualTo(fileManager2);
        fileManager1.setId(null);
        assertThat(fileManager1).isNotEqualTo(fileManager2);
    }
}
