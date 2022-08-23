package com.example.api.model;

import com.example.api.base.OperationResult;
import lombok.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetYachtsResponse implements OperationResult {
    List<YachtPOJO> yachtsAvailable;
}
