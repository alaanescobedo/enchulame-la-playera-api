package com.exercise.api.services;

import com.exercise.api.entities.Size;
import com.exercise.api.repositories.ISizeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class SizeServiceTest {

    @Autowired
    private ISizeRepository sizeRepository;

    @Autowired
    private SizeService sizeService;

    private Size size;

    @BeforeEach
    void setUp() {
        size = new Size();
        size.setName("S");

        sizeRepository.save(size);
    }

    @Test
    void addSize() {
        Size size = new Size();
        size.setName("M");

        sizeService.addSize(size);

        assertEquals(2, sizeRepository.findAll().size());
    }

    @Test
    void getAllSizes() {
        Size size = new Size();
        size.setName("M");

        sizeService.addSize(size);

        assertEquals(2, sizeService.getAllSizes().size());
    }

    @Test
    void updateSize() {

        size.setName("M");

        sizeService.updateSize(size.getId(), size);

        Size updatedSize = sizeRepository.findById(size.getId()).orElse(null);

        assertNotNull(updatedSize);
        assertEquals("M", updatedSize.getName());
        assertEquals(1, sizeRepository.findAll().size());
        assertEquals(size.getId(), updatedSize.getId());
    }

    @Test
    void deleteSize() {
        sizeService.deleteSize(size.getId());
        assertEquals(0, sizeRepository.findAll().size());
    }
}