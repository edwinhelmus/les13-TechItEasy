package nl.novi.TechItEasy.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class TelevisionRequestDto {
    public Long id;
    @Size(min=3, max=32)
    public String type;
    @Size(min=3, max=32)
    public String brand;
    @Size(min=3, max=64)
    public String name;
    @PositiveOrZero
    public Double price;
    @PositiveOrZero
    public Double availableSize;
    @PositiveOrZero
    public Integer refreshRate;
    public String screenType;
    public String screenQuality;
    public Boolean smartTv;
    public Boolean wifi;
    public Boolean voiceControl;
    public Boolean hdr;
    public Boolean bluetooth;
    public Boolean ambiLight;
}
