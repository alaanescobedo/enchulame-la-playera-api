package com.exercise.api.controllers;

import com.exercise.api.entities.Color;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.exercise.api.repositories.IColorRepository;

@Controller
@RequestMapping("/colors")
@CrossOrigin(origins = "*")
public class ColorController {

    final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private IColorRepository colorService;

    @PostMapping
    public ResponseEntity<?> addColor(@RequestBody Color color) {
        LOG.info(">>> Creating color: " + color.toString());
        colorService.save(color);
        return new ResponseEntity<String>("Color added", null, 200);
    }

    @GetMapping
    public ResponseEntity<?> getAllColors() {
       try {
           return new ResponseEntity<>(colorService.findAll(), null, 200);
       } catch (Exception e) {
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateColor(@PathVariable("id") Long id, @RequestBody Color color) {
        LOG.info(">>> Updating color: " + color.toString());
        try {
            Color colorToUpdate = colorService.findById(id).get();
            colorToUpdate.setName(color.getName());
            colorService.save(colorToUpdate);
            return new ResponseEntity<String>("Color updated", null, 200);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteColor(@PathVariable("id") Long id) {
        LOG.info(">>> Deleting color with id: " + id);
        try {
            colorService.deleteById(id);
            return new ResponseEntity<String>("Color deleted", null, 200);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
