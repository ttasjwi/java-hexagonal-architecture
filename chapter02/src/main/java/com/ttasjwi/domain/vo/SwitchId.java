package com.ttasjwi.domain.vo;

import java.util.Objects;
import java.util.UUID;

public class SwitchId {

    private final UUID id;

    private SwitchId(UUID id) {
        this.id = id;
    }

    public static SwitchId withId(String id) {
        return new SwitchId(UUID.fromString(id));
    }

    public static SwitchId withoutId() {
        return new SwitchId(UUID.randomUUID());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SwitchId)) return false;
        SwitchId switchId = (SwitchId) o;
        return Objects.equals(id, switchId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "SwitchId{" +
                "id='" + id + '\'' +
                '}';
    }
}
