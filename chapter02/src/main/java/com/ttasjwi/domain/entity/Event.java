package com.ttasjwi.domain.entity;

import com.ttasjwi.domain.vo.EventId;

import java.time.OffsetDateTime;
import java.util.Objects;

public class Event implements Comparable<Event> {

    private EventId id;
    private OffsetDateTime timestamp;
    private String protocol;
    private String activity;

    public Event(EventId id, OffsetDateTime timestamp, String protocol, String activity) {
        this.id = id;
        this.timestamp = timestamp;
        this.protocol = protocol;
        this.activity = activity;
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
        return Objects.equals(id, event.id) && Objects.equals(timestamp, event.timestamp) && Objects.equals(protocol, event.protocol) && Objects.equals(activity, event.activity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timestamp, protocol, activity);
    }
}
