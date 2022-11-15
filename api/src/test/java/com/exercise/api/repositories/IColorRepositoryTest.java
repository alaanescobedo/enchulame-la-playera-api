package com.exercise.api.repositories;

import com.exercise.api.entities.Color;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IColorRepositoryTest {

    @Autowired
    private IColorRepository colorRepository;

    @Test
    public void addColor() {
        Color color = new Color();
        color.setName("white");

        colorRepository.save(color);
    }
}