package com.example.api.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class YachtPOJO {

    private String yachtNumber;
    private String yachtBrand;
    private String price;
    private String status;

}
