package com.example.api;

import com.example.api.model.GetYachtsRequest;
import com.example.api.model.GetYachtsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "findYachts", url = "http://localhost:8082")
public interface ApiFeignInterface {

    @RequestMapping(method = RequestMethod.POST, value = "/getYachts")
    GetYachtsResponse getYachts(@RequestBody GetYachtsRequest getCarsRequest);
}
