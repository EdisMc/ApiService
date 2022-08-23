package com.example.domain.model;

import lombok.*;

import java.util.ArrayList;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NumberDecoded {
    public Make make;
    public ArrayList<Year> years;
    public ArrayList<Color> colors;
}
