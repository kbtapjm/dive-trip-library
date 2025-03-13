package io.divetrip.library.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@Slf4j
@UtilityClass
public class ObjectMapperUtils {

    public String writeValueAsString(Object object) {
        if (Objects.isNull(object)) return StringUtils.EMPTY;

        String value = StringUtils.EMPTY;
        try {
            value = new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            log.error("JsonProcessingException: {}", ex.getMessage(), ex);
        }

        return value;
    }

}
