package com.ttasjwi.domain.policy;

import com.ttasjwi.domain.entity.Event;
import com.ttasjwi.domain.vo.Activity;
import com.ttasjwi.domain.vo.EventId;
import com.ttasjwi.domain.vo.Protocol;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;

public class SplitEventParser implements EventParser {

    @Override
    public Event parseEvent(String event) {
        List<String> fields = Arrays.asList(event.split(" "));

        OffsetDateTime timestamp = LocalDateTime.parse(fields.get(0), FORMATTER).atOffset(ZoneOffset.UTC);
        EventId id = EventId.of(fields.get(1));
        Protocol protocol = Protocol.valueOf(fields.get(2));
        Activity activity = new Activity(fields.get(3), fields.get(5));

        return new Event(id, timestamp, protocol, activity);
    }
}
