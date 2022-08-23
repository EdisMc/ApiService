package com.example.api.operation;

import com.example.api.base.Error;
import com.example.api.base.OperationProcessor;
import com.example.api.model.GetYachtsRequest;
import com.example.api.model.GetYachtsResponse;
import io.vavr.control.Either;

public interface GetYachtsProcessor extends OperationProcessor<GetYachtsRequest, GetYachtsResponse> {
    Either<Error, GetYachtsResponse> process(GetYachtsRequest getCarsRequest);
}
