package com.ttasjwi.domain.service;

import com.ttasjwi.domain.entity.Event;
import com.ttasjwi.domain.vo.ParsePolicyType;

import java.util.List;
import java.util.stream.Collectors;

public class EventSearch {

    public List<Event> retrieveEvents(List<String> unparsedEvents, ParsePolicyType policyType) {
        return unparsedEvents.stream()
                .map(event -> Event.parsedEvent(event, policyType))
                .collect(Collectors.toList());
    }
}
