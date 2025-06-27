package nl.novi.TechItEasy.controllers;

import jakarta.validation.Valid;
import nl.novi.TechItEasy.dtos.TelevisionRequestDto;
import nl.novi.TechItEasy.dtos.TelevisionResponseDto;
import nl.novi.TechItEasy.services.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static nl.novi.TechItEasy.util.RestUtil.constructURI;


@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService televisionService;


    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    @GetMapping
    public ResponseEntity<List<TelevisionResponseDto>> getAllTelevisions(@RequestParam(value = "brand", required = false) String brand) {

        List<TelevisionResponseDto> responseDtos = new ArrayList<>();
        if (brand == null) {
            responseDtos = televisionService.getAllTelevisions();
        } else {
            responseDtos = televisionService.getAllTelevisionsByBrand(brand);
        }
        return ResponseEntity.ok().body(responseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionResponseDto> getTelevision(@PathVariable("id") long id) {
        TelevisionResponseDto responseDto = this.televisionService.getSingleTelevision(id);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping
    public ResponseEntity<TelevisionResponseDto> addTelevision(@Valid @RequestBody TelevisionRequestDto televisionRequestDto) {
        TelevisionResponseDto responseDto = this.televisionService.createTelevision(televisionRequestDto);
        return ResponseEntity.created(constructURI(responseDto.id)).body(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelevisionResponseDto> updateTelevision(@PathVariable long id, @RequestBody TelevisionRequestDto televisionRequestDto) {
        TelevisionResponseDto responseDto = this.televisionService.updateTelevision(id, televisionRequestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TelevisionResponseDto> deleteTelevision(@PathVariable("id") long id) {
        this.televisionService.deleteTelevision(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TelevisionResponseDto> updatePartialTelevision(@PathVariable Long id, @RequestBody TelevisionRequestDto televisionRequestDto) {
        TelevisionResponseDto responseDto = this.televisionService.patchTelevision(id, televisionRequestDto);
        return ResponseEntity.ok().body(responseDto);
    }

}

