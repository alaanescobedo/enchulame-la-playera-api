package com.exercise.api.services;

import com.exercise.api.entities.Size;

import java.util.List;

public interface ISizeService {

    void addSize(Size size);

    List<Size> getAllSizes();

    void updateSize(Long id, Size size);

    void deleteSize(Long id);

}
