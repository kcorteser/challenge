package com.kcorteser.challenge.controllers;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.jsondoc.core.annotation.ApiVersion;
import org.springframework.web.bind.annotation.*;
import static com.kcorteser.challenge.constants.Globals.*;

@Api(name = "Transaction Service", description = "Interfaces de transaccion", group = "Transaction")
@ApiVersion(since = "1.0")
@CrossOrigin("*")
@RestController
@RequestMapping({"/test","","/"})
public class Test {
    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = "")
    @ApiResponseObject
    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
}
