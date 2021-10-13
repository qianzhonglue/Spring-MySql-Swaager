package com.clf.sim.api.demoapi.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/api/data")
public class DataController {
    @Autowired
    private DataService service;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Append New Measure Data, If devId == 0 or accountId == 0, first append device or account",
                  response = Boolean.class)
    public @ResponseBody Boolean
    addNewData(@ApiParam(required = true) @RequestBody Data data) {
        return service.addNewData(data);
    }
}
