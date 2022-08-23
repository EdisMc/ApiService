package com.example.api.model;

import com.example.api.base.OperationInput;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetYachtsRequest implements OperationInput {
    List<YachtApiEntity> yachtEntities;
}
