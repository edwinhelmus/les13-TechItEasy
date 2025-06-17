package nl.novi.TechItEasy.mappers;

import nl.novi.TechItEasy.dtos.TelevisionRequestDto;
import nl.novi.TechItEasy.dtos.TelevisionResponseDto;
import nl.novi.TechItEasy.models.Television;

public class TelevisionMapper {

    public static Television toEntity(TelevisionRequestDto televisionRequestDto) {
        Television television = new Television();
        television.setId(televisionRequestDto.id);
        television.setType(televisionRequestDto.type);
        television.setBrand(televisionRequestDto.brand);
        television.setName(televisionRequestDto.name);
        television.setPrice(televisionRequestDto.price);
        television.setAvailableSize(televisionRequestDto.availableSize);
        television.setRefreshRate(televisionRequestDto.refreshRate);
        television.setScreenType(televisionRequestDto.screenType);
        television.setScreenQuality(televisionRequestDto.screenQuality);
        television.setSmartTv(televisionRequestDto.smartTv);
        television.setWifi(televisionRequestDto.wifi);
        television.setVoiceControl(televisionRequestDto.voiceControl);
        television.setHdr(televisionRequestDto.hdr);
        television.setBluetooth(televisionRequestDto.bluetooth);
        television.setAmbiLight(televisionRequestDto.ambiLight);
        return television;
    }

    public static TelevisionResponseDto toResponseDto(Television television) {
        TelevisionResponseDto televisionResponseDto = new TelevisionResponseDto();
        televisionResponseDto.id = television.getId();
        televisionResponseDto.type = television.getType();
        televisionResponseDto.brand = television.getBrand();
        televisionResponseDto.name = television.getName();
        televisionResponseDto.price = television.getPrice();
        televisionResponseDto.availableSize = television.getAvailableSize();
        televisionResponseDto.refreshRate = television.getRefreshRate();
        televisionResponseDto.screenType = television.getScreenType();
        televisionResponseDto.screenQuality = television.getScreenQuality();
        televisionResponseDto.smartTv = television.getSmartTv();
        televisionResponseDto.wifi = television.getWifi();
        televisionResponseDto.voiceControl = television.getVoiceControl();
        televisionResponseDto.hdr = television.getHdr();
        televisionResponseDto.bluetooth = television.getBluetooth();
        televisionResponseDto.ambiLight = television.getAmbiLight();
        return televisionResponseDto;
    }
}
