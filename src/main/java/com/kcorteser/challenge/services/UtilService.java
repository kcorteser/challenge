package com.kcorteser.challenge.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class UtilService {
    static Logger log = LogManager.getLogger(UtilService.class);

    private UtilService() {
    }

    public static String getParamsString(Map<String, Object> params, String constant) {
        return (params.containsKey(constant) && params.get(constant) != null && params.get(constant).toString().length() > 0) ? params.get(constant).toString() : null;
    }
    public static Map<String, Object> responseJson(String message, String type) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("massage", message);
            result.put("type", type);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return result;
    }
}
