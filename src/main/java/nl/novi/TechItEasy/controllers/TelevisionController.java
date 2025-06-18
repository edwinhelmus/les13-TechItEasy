package nl.novi.TechItEasy.controllers;

import jakarta.validation.Valid;
import nl.novi.TechItEasy.dtos.TelevisionRequestDto;
import nl.novi.TechItEasy.dtos.TelevisionResponseDto;
import nl.novi.TechItEasy.mappers.TelevisionMapper;
import nl.novi.TechItEasy.models.Television;
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

        List<TelevisionResponseDto> ResponseDtos = new ArrayList<>();
        if (brand == null) {
            ResponseDtos = televisionService.getAllTelevisions();
        } else {
            ResponseDtos = televisionService.getAllTelevisionsByBrand(brand);
        }
        return ResponseEntity.ok().body(ResponseDtos);
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

//    @PutMapping("/{id}")
//    public ResponseEntity<Object> updateTelevision(@PathVariable long id, @RequestBody Television television) {
//
//        Optional<Television> op = televisionRepository.findById(id);
//        if (op.isPresent()) {
//            Television television1 = op.get();
//            television1.setAmbiLight(television.getAmbiLight());
//            television1.setAvailableSize(television.getAvailableSize());
//            television1.setAmbiLight(television.getAmbiLight());
//            television1.setBluetooth(television.getBluetooth());
//            television1.setBrand(television.getBrand());
//            television1.setHdr(television.getHdr());
//            television1.setName(television.getName());
//            television1.setOriginalStock(television.getOriginalStock());
//            television1.setPrice(television.getPrice());
//            television1.setRefreshRate(television.getRefreshRate());
//            television1.setScreenQuality(television.getScreenQuality());
//            television1.setScreenType(television.getScreenType());
//            television1.setSmartTv(television.getSmartTv());
//            television1.setSold(television.getSold());
//            television1.setType(television.getType());
//            television1.setVoiceControl(television.getVoiceControl());
//            television1.setWifi(television.getWifi());
//
//            Television returnTelevision = televisionRepository.save(television1);
//            return ResponseEntity.ok().body(returnTelevision);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//
    @DeleteMapping("/{id}")
    public ResponseEntity<TelevisionResponseDto> deleteTelevision(@PathVariable("id") long id) {
        this.televisionService.deleteTelevision(id);
        return ResponseEntity.noContent().build();
    }
//
//    @PatchMapping("/{id}")
//    public ResponseEntity<Television> updatePartialTelevision(@PathVariable Long id, @RequestBody Television newTelevision) {
//        Optional<Television> television = televisionRepository.findById(id);
//
//        if (television.isEmpty()) {
//            throw new RecordNotFoundException("No television found with id: " + id);
//        } else {
//            Television television1 = television.get();
//            if (newTelevision.getAmbiLight() != null) {
//                television1.setAmbiLight(newTelevision.getAmbiLight());
//            }
//            if (newTelevision.getAvailableSize() != null) {
//                television1.setAvailableSize(newTelevision.getAvailableSize());
//            }
//            if (newTelevision.getBluetooth()) {
//                television1.setBluetooth(newTelevision.getBluetooth());
//            }
//            if (newTelevision.getBrand() != null) {
//                television1.setBrand(newTelevision.getBrand());
//            }
//            if (newTelevision.getHdr() != null) {
//                television1.setHdr(newTelevision.getHdr());
//            }
//            if (newTelevision.getName() != null) {
//                television1.setName(newTelevision.getName());
//            }
//            if (newTelevision.getOriginalStock() != null) {
//                television1.setOriginalStock(newTelevision.getOriginalStock());
//            }
//            if (newTelevision.getPrice() != null) {
//                television1.setPrice(newTelevision.getPrice());
//            }
//            if (newTelevision.getRefreshRate() != null) {
//                television1.setRefreshRate(newTelevision.getRefreshRate());
//            }
//            if (newTelevision.getScreenQuality() != null) {
//                television1.setScreenQuality(newTelevision.getScreenQuality());
//            }
//            if (newTelevision.getScreenType() != null) {
//                television1.setScreenType(newTelevision.getScreenType());
//            }
//            if (newTelevision.getSmartTv() != null) {
//                television1.setSmartTv(newTelevision.getSmartTv());
//            }
//            if (newTelevision.getSold() != null) {
//                television1.setSold(newTelevision.getSold());
//            }
//            if (newTelevision.getType() != null) {
//                television1.setType(newTelevision.getType());
//            }
//            if (newTelevision.getVoiceControl() != null) {
//                television1.setVoiceControl(newTelevision.getVoiceControl());
//            }
//            if (newTelevision.getWifi() != null) {
//                television1.setWifi(newTelevision.getWifi());
//            }
//
//            Television returnTelevision = televisionRepository.save(television1);
//            return ResponseEntity.ok().body(returnTelevision);
//        }
//    }

}

