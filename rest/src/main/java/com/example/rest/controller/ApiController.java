package com.example.rest.controller;

import com.example.api.base.Error;
import com.example.api.model.GetYachtsRequest;
import com.example.api.model.GetYachtsResponse;
import com.example.api.operation.GetYachtsProcessor;
import io.vavr.control.Either;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    private final GetYachtsProcessor getYachtsProcessor;

    public ApiController(GetYachtsProcessor getYachtsProcessor) {
        this.getYachtsProcessor = getYachtsProcessor;
    }


    @PostMapping("/getYachts")
    public ResponseEntity<?> getYachts(@RequestBody GetYachtsRequest getYachtsRequest) {
        Either<Error, GetYachtsResponse> result = getYachtsProcessor.process(getYachtsRequest);

        if (result.isLeft()) {
            return ResponseEntity
                    .status(result.getLeft().getCode())
                    .body(result.getLeft().getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(result.get());
    }
}
