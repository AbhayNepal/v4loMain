package com.v4lo.common.controller;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

    @GetMapping("/")
    public ResponseEntity<JSONObject> v4loMain(){
        JSONObject v4loRootResponse = new JSONObject();
        v4loRootResponse.put("project","v4loMain");
        v4loRootResponse.put("status","running");
        return new ResponseEntity<>(v4loRootResponse,HttpStatus.OK);
    }
}
