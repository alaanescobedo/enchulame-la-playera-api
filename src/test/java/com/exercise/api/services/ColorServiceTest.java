package com.exercise.api.services;

import com.exercise.api.entities.Color;
import com.exercise.api.repositories.IColorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ColorServiceTest {

    @Autowired
    private IColorRepository colorRepository;

    @Autowired
    private ColorService colorService;

    private Color color;

    @BeforeEach
    void setUp() {
        color = new Color();
        color.setName("Red");
        color.setId(1L);

        colorService.addColor(color);
    }

    @DisplayName("Debería agregar un color")
    @Test
    void addColor() {

        Color color = new Color();
        color.setName("Blue");
        color.setId(2L);

        colorService.addColor(color);

        Color colorAdded = colorRepository.findById(color.getId()).orElse(null);

        assertNotNull(colorAdded);
        assertEquals(colorAdded.getName(), color.getName());
    }

    @DisplayName("Debería obtener todos los colores")
    @Test()
    void getAllColors() {
        Color color = new Color();
        color.setName("Blue");
        color.setId(2L);

        colorRepository.save(color);

        List<Color> colors = colorService.getAllColors();

        assertNotNull(colors);
        assertEquals(colors.size(), 2);
    }

    @DisplayName("Debería actualizar un color")
    @Test
    void updateColor() {
        Color color1 = new Color();
        color1.setName("White");

        colorService.updateColor(color.getId(), color1);

        Color colorUpdated = colorRepository.findById(color.getId()).orElse(null);

        assertNotNull(colorUpdated);
        assertEquals(colorUpdated.getName(), color1.getName());
        assertEquals(color.getId(), colorUpdated.getId());
    }

    @DisplayName("Debería eliminar un color")
    @Test
    void deleteColorById() {
        colorService.deleteColorById(color.getId());

        Color colorDeleted = colorRepository.findById(color.getId()).orElse(null);

        assertNull(colorDeleted);
    }
}