package nl.novi.TechItEasy.services;

import nl.novi.TechItEasy.dtos.TelevisionRequestDto;
import nl.novi.TechItEasy.mappers.TelevisionMapper;
import nl.novi.TechItEasy.models.Television;
import nl.novi.TechItEasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository repos) {
        this.televisionRepository = repos;
    }


    public Television createTelevision(TelevisionRequestDto televisionRequestDto) {
        return this.televisionRepository.save(TelevisionMapper.toEntity(televisionRequestDto));
    }

}

