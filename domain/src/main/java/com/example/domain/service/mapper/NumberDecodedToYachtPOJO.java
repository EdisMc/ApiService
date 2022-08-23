package com.example.domain.service.mapper;

import com.example.api.model.YachtApiEntity;
import com.example.api.model.YachtPOJO;
import com.example.domain.model.NumberDecoded;

public interface NumberDecodedToYachtPOJO {
    YachtPOJO mapToYachtPOJO(NumberDecoded numberDecoded, YachtApiEntity yachtApiEntity);
}
