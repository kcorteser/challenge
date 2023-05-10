package com.kcorteser.challenge.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kcorteser.challenge.services.DetailsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsondoc.core.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

import static com.kcorteser.challenge.constants.Globals.*;
import static com.kcorteser.challenge.services.UtilService.*;


@Api(name = "Detalles de la data", description = "Filtro de los datos", group = "Details")
@ApiVersion(since = "1.0")
@CrossOrigin("*")
@RestController
@RequestMapping("/details")
public class DetailsController {
    static Logger log = LogManager.getLogger(DetailsController.class);

    @Autowired
    private DetailsService detailsService;

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REQUEST_FILTER_DESCRIPTION)
    @ApiResponseObject
    @PostMapping(REQUEST_FILTER_URI)
    public Map<String, Object> filter(@ApiBodyObject(clazz = String.class) @RequestBody String json) {
        if (json == null || json.isEmpty()) {
            return responseJson(MESSAGE_ERROR_JSON, MESSAGE_TYPE_ERROR);
        }
        try {
            Map<String, Object> params = new ObjectMapper().readerFor(Map.class).readValue(json);
            String filter = getParamsString(params, "type");
            LocalDate date = (params.containsKey("date") && params.get("date") != null && !params.get("date").toString().isEmpty())
                    ? LocalDate.parse(params.get("date").toString())
                    : null;
            if (filter == null || filter.isBlank()) {
                return responseJson(MESSAGE_ERROR_JSON, MESSAGE_TYPE_ERROR);
            }
            return detailsService.filter(filter, date);
        } catch (Exception e) {
            log.error(MESSAGE_TYPE_ERROR, e.getMessage());
            log.info(e.getMessage());
            return responseJson(MESSAGE_ERROR_EXCEPTION, MESSAGE_TYPE_ERROR);
        }
    }
}






