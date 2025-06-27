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
    }

    public TelevisionResponseDto updateTelevision(Long id, TelevisionRequestDto televisionRequestDto) {
        Television television = this.televisionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Television " + id + " not found"));

        Television televisionNew = TelevisionMapper.toEntity(televisionRequestDto);
        television.setAmbiLight(televisionNew.getAmbiLight());
        television.setAvailableSize(televisionNew.getAvailableSize());
        television.setAmbiLight(televisionNew.getAmbiLight());
        television.setBluetooth(televisionNew.getBluetooth());
        television.setBrand(televisionNew.getBrand());
        television.setHdr(televisionNew.getHdr());
        television.setName(televisionNew.getName());
        television.setOriginalStock(televisionNew.getOriginalStock());
        television.setPrice(televisionNew.getPrice());
        television.setRefreshRate(televisionNew.getRefreshRate());
        television.setScreenQuality(televisionNew.getScreenQuality());
        television.setScreenType(televisionNew.getScreenType());
        television.setSmartTv(televisionNew.getSmartTv());
        television.setSold(televisionNew.getSold());
        television.setType(televisionNew.getType());
        television.setVoiceControl(televisionNew.getVoiceControl());
        television.setWifi(televisionNew.getWifi());

        Television returnTelevision = this.televisionRepository.save(television);
        return TelevisionMapper.toResponseDto(returnTelevision);
    }

    public TelevisionResponseDto patchTelevision(Long id, TelevisionRequestDto televisionRequestDto) {
        Television television = this.televisionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Television " + id + " not found"));

        Television televisionNew = TelevisionMapper.toEntity(televisionRequestDto);

        if (televisionNew.getAmbiLight() != null) {
            television.setAmbiLight(televisionNew.getAmbiLight());
        }
        if (televisionNew.getAvailableSize() != null) {
            television.setAvailableSize(televisionNew.getAvailableSize());
        }
        if (televisionNew.getBluetooth() != null) {
            television.setBluetooth(televisionNew.getBluetooth());
        }
        if (televisionNew.getBrand() != null) {
            television.setBrand(televisionNew.getBrand());
        }
        if (televisionNew.getHdr() != null) {
            television.setHdr(televisionNew.getHdr());
        }
        if (televisionNew.getName() != null) {
            television.setName(televisionNew.getName());
        }
        if (televisionNew.getOriginalStock() != null) {
            television.setOriginalStock(televisionNew.getOriginalStock());
        }
        if (televisionNew.getPrice() != null) {
            television.setPrice(televisionNew.getPrice());
        }
        if (televisionNew.getRefreshRate() != null) {
            television.setRefreshRate(televisionNew.getRefreshRate());
        }
        if (televisionNew.getScreenQuality() != null) {
            television.setScreenQuality(televisionNew.getScreenQuality());
        }
        if (televisionNew.getScreenType() != null) {
            television.setScreenType(televisionNew.getScreenType());
        }
        if (televisionNew.getSmartTv() != null) {
            television.setSmartTv(televisionNew.getSmartTv());
        }
        if (televisionNew.getSold() != null) {
            television.setSold(televisionNew.getSold());
        }
        if (televisionNew.getType() != null) {
            television.setType(televisionNew.getType());
        }
        if (televisionNew.getVoiceControl() != null) {
            television.setVoiceControl(televisionNew.getVoiceControl());
        }
        if (televisionNew.getWifi() != null) {
            television.setWifi(televisionNew.getWifi());
        }

        Television returnTelevision = this.televisionRepository.save(television);
        return TelevisionMapper.toResponseDto(returnTelevision);
    }
}

