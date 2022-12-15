package com.ttasjwi.domain.vo;

import java.util.Objects;

public class IP {

    private final String address;
    private final Protocol protocol;

    public IP(String address, String protocol) {
        if (address == null) throw new IllegalArgumentException("Null IP address");
        if (address.length() <= 15) {
            this.protocol = Protocol.IPV4;
        } else {
            this.protocol = Protocol.IPV6;
        }
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IP)) return false;
        IP ip = (IP) o;
        return Objects.equals(address, ip.address) && protocol == ip.protocol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, protocol);
    }

    @Override
    public String toString() {
        return "IP{" + "address='" + address + '\'' + ", protocol=" + protocol + '}';
    }
}
