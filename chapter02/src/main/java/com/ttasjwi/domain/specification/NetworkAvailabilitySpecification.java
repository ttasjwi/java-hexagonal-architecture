package com.ttasjwi.domain.specification;

import com.ttasjwi.domain.entity.Router;
import com.ttasjwi.domain.specification.shared.AbstractSpecification;
import com.ttasjwi.domain.vo.IP;
import com.ttasjwi.domain.vo.Network;

public class NetworkAvailabilitySpecification extends AbstractSpecification<Router> {

    private IP address;
    private String name;
    private int cidr;

    public NetworkAvailabilitySpecification(IP address, String name, int cidr) {
        this.address = address;
        this.name = name;
        this.cidr = cidr;
    }

    @Override
    public boolean isSatisfiedBy(Router router) {
        return router!= null && isNetworkAvailable(router);
    }

    private boolean isNetworkAvailable(Router router) {
        var availability = true;
        for (Network network : router.retrieveNetworks()) {
            if (network.getAddress().equals(address) && network.getCidr() == cidr) {
                availability = false;
                break;
            }
        }
        return availability;
    }
}
