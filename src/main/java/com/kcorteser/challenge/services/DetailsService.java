package com.kcorteser.challenge.services;

import com.kcorteser.challenge.entities.Details;
import com.kcorteser.challenge.repositories.DetailsRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import static com.kcorteser.challenge.constants.Globals.*;

import static com.kcorteser.challenge.services.UtilService.responseJson;

@Service
public class DetailsService {
    static Logger log = LogManager.getLogger(DetailsService.class);

    @Autowired
    private DetailsRepository detailsRepository;


    public Map<String, Object> filter(String type, LocalDate date){
        Optional<List<Details>> list = detailsRepository.findAllByTypeLikeIgnoreCaseAndDate(type,date);
        if(list.isEmpty()) return responseJson(MESSAGE_ERROR_EMPTY,MESSAGE_TYPE_ERROR);
        if(list.get().isEmpty()) return responseJson(MESSAGE_ERROR_EMPTY,"succes");
        Map<String,Object> mapResponse = new HashMap<>();
        mapResponse.put("data",list.get());
        return mapResponse;
    }

}
