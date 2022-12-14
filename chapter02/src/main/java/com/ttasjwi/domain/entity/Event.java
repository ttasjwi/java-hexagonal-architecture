package com.ttasjwi.domain.entity;

import com.ttasjwi.domain.policy.RegexEventParser;
import com.ttasjwi.domain.policy.SplitEventParser;
import com.ttasjwi.domain.vo.Activity;
import com.ttasjwi.domain.vo.EventId;
import com.ttasjwi.domain.vo.ParsePolicyType;
import com.ttasjwi.domain.vo.Protocol;

import java.time.OffsetDateTime;
import java.util.Objects;

public class Event implements Comparable<Event> {

    private EventId id;
    private OffsetDateTime timestamp;
    private Protocol protocol;
    private Activity activity;

    public Event(EventId id, OffsetDateTime timestamp, Protocol protocol, Activity activity) {
        this.id = id;
        this.timestamp = timestamp;
        this.protocol = protocol;
        this.activity = activity;
    }

    public static Event parsedEvent(String unparsedEvent, ParsePolicyType policyType) {
        switch (policyType) {
            case REGEX:
                return new RegexEventParser().parseEvent(unparsedEvent);
            case SPLIT:
                return new SplitEventParser().parseEvent(unparsedEvent);
            default:
                throw new IllegalArgumentException("Invalid policy");
        }
    }

    @Override
    public int compareTo(Event event) {
        return timestamp.compareTo(event.timestamp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id) && Objects.equals(timestamp, event.timestamp) && protocol == event.protocol && Objects.equals(activity, event.activity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timestamp, protocol, activity);
    }
}
