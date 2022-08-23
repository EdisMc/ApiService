package com.example.api.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class YachtApiEntity {

    private Long yachtId;
    private String number;
    private double price;
    private Boolean status;

}
