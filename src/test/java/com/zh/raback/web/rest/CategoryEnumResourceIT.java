package com.zh.raback.web.rest;

import com.zh.raback.RabackApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Test class for the CategoryEnumControllerResource REST controller.
 *
 * @see CategoryEnumResource
 */
@SpringBootTest(classes = RabackApp.class)
public class CategoryEnumResourceIT {

    private MockMvc restMockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        CategoryEnumResource categoryEnumResource = new CategoryEnumResource();
        restMockMvc = MockMvcBuilders
            .standaloneSetup(categoryEnumResource)
            .build();
    }

    /**
     * Test findAll
     */
    @Test
    public void testFindAll() throws Exception {
        restMockMvc.perform(get("/api/category-enum-controller/find-all"))
            .andExpect(status().isOk());
    }
}
