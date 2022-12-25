package com.ttasjwi.domain.policy;

import com.ttasjwi.domain.entity.Event;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public interface EventParser {

    DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
            .withZone(ZoneId.of("UTC"));

    Event parseEvent(String event);
}
