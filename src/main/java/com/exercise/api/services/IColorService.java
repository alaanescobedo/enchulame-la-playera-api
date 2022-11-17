package com.exercise.api.services;

import com.exercise.api.entities.Color;

import java.util.List;

public interface IColorService {

    void addColor(Color color);

    List<Color> getAllColors();

    void updateColor(Long Id, Color color);

    void deleteColorById(Long id);

}
