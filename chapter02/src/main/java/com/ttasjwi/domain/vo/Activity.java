package com.ttasjwi.domain.vo;

import java.util.Objects;

public class Activity {

    private final String srcHost;
    private final String dstHost;

    public Activity(String srcHost, String dstHost) {
        this.srcHost = srcHost;
        this.dstHost = dstHost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Activity)) return false;
        Activity activity = (Activity) o;
        return Objects.equals(srcHost, activity.srcHost) && Objects.equals(dstHost, activity.dstHost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(srcHost, dstHost);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "srcHost='" + srcHost + '\'' +
                ", dstHost='" + dstHost + '\'' +
                '}';
    }

}
