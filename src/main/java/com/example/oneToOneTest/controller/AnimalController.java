package com.example.oneToOneTest.controller;

import com.example.oneToOneTest.dto.AnimalClientDTO;
import com.example.oneToOneTest.dto.AnimalDTO;
import com.example.oneToOneTest.dto.ClientDTO;
import com.example.oneToOneTest.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/animals")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @PostMapping(value = "simple")
    public ResponseEntity<AnimalDTO> simpleInsert(@RequestBody AnimalDTO dto){
        dto = animalService.simpleInsert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PostMapping(value = "complex")
    public ResponseEntity<AnimalDTO> complexInsert(@RequestBody AnimalDTO dto){
        dto = animalService.complexInsert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PostMapping(value = "simple2")
    public ResponseEntity<AnimalClientDTO> simpleInsert2(@RequestBody AnimalClientDTO dto){
        dto = animalService.simpleInsert2(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PostMapping(value = "complex2")
    public ResponseEntity<AnimalClientDTO> complexInsert2(@RequestBody AnimalClientDTO dto){
        dto = animalService.complexInsert2(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AnimalClientDTO> update(@PathVariable Long id, @RequestBody AnimalClientDTO dto){
        dto = animalService.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AnimalClientDTO> findById(@PathVariable Long id){
        AnimalClientDTO dto = animalService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<AnimalClientDTO>> findAll(){
        List<AnimalClientDTO> dto = animalService.findAll();
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        animalService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
