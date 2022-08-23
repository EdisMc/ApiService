package com.example.domain.service;


import com.example.api.model.GetYachtsRequest;
import com.example.api.model.GetYachtsResponse;

public interface GetYachtsService {
    GetYachtsResponse getYachts(GetYachtsRequest getYachtsRequest);
}
