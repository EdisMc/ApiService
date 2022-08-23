package com.example.domain.model;

import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Make {
    public int id;
    public String name;
    public String niceName;
}