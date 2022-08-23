package com.example.core.processor;

import com.example.api.base.Error;
import com.example.api.error.GetYachtsServiceError;
import com.example.api.model.GetYachtsRequest;
import com.example.api.model.GetYachtsResponse;
import com.example.api.operation.GetYachtsProcessor;
import com.example.domain.service.GetYachtsService;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.stereotype.Service;

@Service
public class GetYachtsProcessorCore implements GetYachtsProcessor {

    private final GetYachtsService getYachtsService;

    public GetYachtsProcessorCore(GetYachtsService getYachtsService) {
        this.getYachtsService = getYachtsService;
    }

    @Override
    public Either<Error, GetYachtsResponse> process(GetYachtsRequest getYachtsRequest) {
        return Try.of(() -> {
                    return getYachtsService.getYachts(getYachtsRequest);
                })
                .toEither()
                .mapLeft(throwable -> {
                    return new GetYachtsServiceError();
                });
    }
}
