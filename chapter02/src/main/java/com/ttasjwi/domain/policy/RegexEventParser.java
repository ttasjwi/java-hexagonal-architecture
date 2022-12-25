package com.ttasjwi.domain.policy;

import com.ttasjwi.domain.entity.Event;
import com.ttasjwi.domain.vo.Activity;
import com.ttasjwi.domain.vo.EventId;
import com.ttasjwi.domain.vo.Protocol;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEventParser implements EventParser {

    private static final String REGEX = "(\\\"[^\\\"]+\\\")|\\S+";
    private static final Pattern PATTERN = Pattern.compile(REGEX, Pattern.MULTILINE);

    @Override
    public Event parseEvent(String event) {
        final Matcher matcher = PATTERN.matcher(event);
        List<String> fields = new ArrayList<>();

        while (matcher.find()) {
            fields.add(matcher.group(0));
        }

        OffsetDateTime timeStamp = LocalDateTime.parse(matcher.group(0), FORMATTER).atOffset(ZoneOffset.UTC);
        EventId id = EventId.of(matcher.group(1));
        Protocol protocol = Protocol.valueOf(matcher.group(2));
        Activity activity = new Activity(matcher.group(3), matcher.group(5));

        return new Event(id, timeStamp, protocol, activity);
    }
}
