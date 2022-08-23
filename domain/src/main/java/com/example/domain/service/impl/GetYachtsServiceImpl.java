package com.example.domain.service.impl;

import com.example.api.model.GetYachtsRequest;
import com.example.api.model.GetYachtsResponse;
import com.example.domain.model.NumberDecoded;
import com.example.domain.service.GetYachtsService;
import com.example.domain.service.exception.ApiServiceException;
import com.example.domain.service.mapper.NumberDecodedToYachtPOJO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.stream.Collectors;

@Service
public class GetYachtsServiceImpl implements GetYachtsService {

    private final RestTemplate restTemplate;
    private final NumberDecodedToYachtPOJO numberDecodedToYachtPOJO;

    public GetYachtsServiceImpl(RestTemplate restTemplate, NumberDecodedToYachtPOJO numberDecodedToYachtPOJO) {
        this.restTemplate = restTemplate;
        this.numberDecodedToYachtPOJO = numberDecodedToYachtPOJO;
    }

    @Override
    public GetYachtsResponse getYachts(GetYachtsRequest getYachtsRequest) {

        try {
            return GetYachtsResponse
                    .builder()
                    .yachtsAvailable(
                            getYachtsRequest.getYachtEntities()
                                    .stream()
                                    .map(yachtEntity -> {
                                                String url = "https://auto.dev/api/vin/"
                                                        + yachtEntity.getNumber()
                                                        + "?apikey=ZrQEPSkKZGRvYnJldjQ4QGdtYWlsLmNvbQ";

                                                return numberDecodedToYachtPOJO
                                                        .mapToYachtPOJO(
                                                                restTemplate.getForObject(url, NumberDecoded.class),
                                                                yachtEntity);

                                            }
                                    )
                                    .collect(Collectors.toList())
                    )
                    .build();

        } catch (Exception e) {
            throw new ApiServiceException();
        }

    }

}
