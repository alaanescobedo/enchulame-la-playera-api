package com.exercise.api.repositories;

import com.exercise.api.entities.Size;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ISizeRepositoryTest {


    @Autowired
    private ISizeRepository sizeRepository;

    @Test
    public void addSize() {
        Size size = new Size();
        size.setName("S");

        sizeRepository.save(size);
    }

}