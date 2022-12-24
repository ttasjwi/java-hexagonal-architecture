package com.ttasjwi.domain.service;

import com.ttasjwi.domain.entity.Router;
import com.ttasjwi.domain.specification.CIDRSpecification;
import com.ttasjwi.domain.specification.NetworkAmountSpecification;
import com.ttasjwi.domain.specification.NetworkAvailabilitySpecification;
import com.ttasjwi.domain.specification.RouterTypeSpecification;
import com.ttasjwi.domain.specification.shared.Specification;
import com.ttasjwi.domain.vo.IP;
import com.ttasjwi.domain.vo.Network;

public class NetworkOperation {

    private final int MINIMUM_ALLOWED_CIDR = 8;

    public void createNewNetwork(Router router, IP address, String name, int cidr) {
        Specification cidrSpec = new CIDRSpecification();
        Specification availabilitySpec = new NetworkAvailabilitySpecification(address, name, cidr);
        Specification routerTypeSpec = new RouterTypeSpecification();
        Specification amountSpec = new NetworkAmountSpecification();

        if (!cidrSpec.isSatisfiedBy(cidr))
            throw new IllegalArgumentException("CIDR is below " + MINIMUM_ALLOWED_CIDR);

        if (!availabilitySpec.isSatisfiedBy(router))
            throw new IllegalArgumentException("Address already exist");

        if (amountSpec.and(routerTypeSpec).isSatisfiedBy(router)) {
            Network network = Router.createNetwork(address, name, cidr);
            router.addNetworkToSwitch(network);
        }
    }

}
