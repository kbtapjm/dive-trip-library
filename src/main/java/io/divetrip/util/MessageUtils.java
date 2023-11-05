package io.divetrip.util;

import lombok.AllArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessageUtils {
    private final MessageSourceAccessor messageSourceAccessor;


}
