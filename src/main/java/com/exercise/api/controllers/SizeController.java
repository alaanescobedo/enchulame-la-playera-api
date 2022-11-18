package com.exercise.api.controllers;

import com.exercise.api.entities.Size;
import com.exercise.api.repositories.ISizeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sizes")
@CrossOrigin(origins = "*")
public class SizeController {

    final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ISizeRepository sizeService;

    @PostMapping
    public ResponseEntity<?> addSize(@RequestBody Size size) {
        LOG.info(">>> Creating size: " + size.toString());
        try {
            sizeService.save(size);
            return new ResponseEntity<String>("Size added", null, 200);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllSizes() {
        LOG.info(">>> Getting all sizes");
        try {
            return new ResponseEntity<>(sizeService.findAll(), null, 200);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateSize(@PathVariable("id") Long id, @RequestBody Size size) {
        LOG.info(">>> Updating size: " + size.toString());
        try {
            Size sizeToUpdate = sizeService.findById(id).get();
            sizeToUpdate.setName(size.getName());
            sizeService.save(sizeToUpdate);
            return new ResponseEntity<String>("Size updated", null, 200);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSize(@PathVariable("id") Long id) {
        LOG.info(">>> Deleting size with id: " + id);
        try {
            sizeService.deleteById(id);
            return new ResponseEntity<String>("Size deleted", null, 200);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
