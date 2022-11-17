package com.exercise.api.repositories;

import com.exercise.api.entities.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class IColorRepositoryTest {

    @Autowired
    private IColorRepository colorRepository;

    @DisplayName("Debería agregar un color")
    @Test
    public void addColor() {
        Color color = new Color();
        color.setName("white");

        colorRepository.save(color);

        Color colorAdded = colorRepository.findById(color.getId()).orElse(null);
        assertNotNull(colorAdded);
    }
}