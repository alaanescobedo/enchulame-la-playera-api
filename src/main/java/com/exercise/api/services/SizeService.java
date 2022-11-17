package com.exercise.api.services;

import com.exercise.api.entities.Size;
import com.exercise.api.repositories.ISizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeService implements ISizeService {

    @Autowired
    private ISizeRepository sizeRepository;

    @Override
    public void addSize(Size size) {
        sizeRepository.save(size);
    }

    @Override
    public List<Size> getAllSizes() {
        return sizeRepository.findAll();
    }

    @Override
    public void updateSize(Long id, Size size) {
        Size sizeToUpdate = sizeRepository.findById(id).orElse(null);
        if (sizeToUpdate == null) throw new IllegalStateException("Invalid size");
        sizeRepository.save(sizeToUpdate);
    }

    @Override
    public void deleteSize(Long id) {
        sizeRepository.deleteById(id);
    }
}
