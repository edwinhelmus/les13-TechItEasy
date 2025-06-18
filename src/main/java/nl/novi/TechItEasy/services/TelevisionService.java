package nl.novi.TechItEasy.services;

import nl.novi.TechItEasy.dtos.TelevisionRequestDto;
import nl.novi.TechItEasy.dtos.TelevisionResponseDto;
import nl.novi.TechItEasy.exceptions.ResourceNotFoundException;
import nl.novi.TechItEasy.mappers.TelevisionMapper;
import nl.novi.TechItEasy.models.Television;
import nl.novi.TechItEasy.repositories.TelevisionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository repos) {
        this.televisionRepository = repos;
    }


    public TelevisionResponseDto createTelevision(TelevisionRequestDto televisionRequestDto) {
        Television television = this.televisionRepository.save(TelevisionMapper.toEntity(televisionRequestDto));
        return TelevisionMapper.toResponseDto(television);
    }

    public TelevisionResponseDto getSingleTelevision(Long id) {
         Television television = this.televisionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Television " + id + " not found"));
        return TelevisionMapper.toResponseDto(television);
    }

    public List<TelevisionResponseDto> getAllTelevisions() {
        List<Television> televisions = this.televisionRepository.findAll();
        List<TelevisionResponseDto> responseDtos = new ArrayList<>();
        for (Television t : televisions) {
            responseDtos.add(TelevisionMapper.toResponseDto(t));
        }
        return responseDtos;
    }

    public List<TelevisionResponseDto> getAllTelevisionsByBrand(String brand) {
        List<Television> televisions = this.televisionRepository.findAllTelevisionsByBrandEqualsIgnoreCase(brand);
        List<TelevisionResponseDto> responseDtos = new ArrayList<>();
        for (Television t : televisions) {
            responseDtos.add(TelevisionMapper.toResponseDto(t));
        }
        return responseDtos;
    }

    public void deleteTelevision(Long id) {
        Television television = this.televisionRepository.findById(id)
              .orElseThrow(() -> new ResourceNotFoundException("Television " + id + " not found"));
        this.televisionRepository.deleteById(id);
        return;
    }


}

