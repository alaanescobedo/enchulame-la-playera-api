package com.exercise.api.services;

import com.exercise.api.entities.Color;
import com.exercise.api.repositories.IColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService implements IColorService {

    @Autowired
    private IColorRepository colorRepository;

    @Override
    public void addColor(Color color) {
        colorRepository.save(color);
    }

    @Override
    public List<Color> getAllColors() {
        return colorRepository.findAll();
    }

    @Override
    public void updateColor(Long Id, Color color) {
        Color colorToUpdate = colorRepository.findById(Id).get();
        colorToUpdate.setName(color.getName());
        colorRepository.save(colorToUpdate);
    }

    @Override
    public void deleteColorById(Long id) {
        colorRepository.deleteById(id);
    }
}
