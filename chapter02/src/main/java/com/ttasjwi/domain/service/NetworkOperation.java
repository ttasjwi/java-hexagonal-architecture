package com.ttasjwi.domain.service;

import com.ttasjwi.domain.entity.Router;
import com.ttasjwi.domain.vo.IP;
import com.ttasjwi.domain.vo.Network;

public class NetworkOperation {

    private final int MINIMUM_ALLOWED_CIDR = 8;

    public void createNewNetwork(Router router, IP address, String name, int cidr) {
        // 사전 조건
        if (cidr < MINIMUM_ALLOWED_CIDR)
            throw new IllegalArgumentException("CIDR is below "+MINIMUM_ALLOWED_CIDR);
        if (isNetworkAvailable(router, address, cidr))
            throw new IllegalArgumentException("Address already exist");

        // 사후 조건 : 네트워크 생성, 네트워크를 Router에 추가
        Network network = Router.createNetwork(address, name, cidr);
        router.addNetworkToSwitch(network);
    }

    private boolean isNetworkAvailable(Router router, IP address, int cidr) {
        // 네트워크 주소가 전체 네트워크에서 사용되고 있는 지 확인하여, 중복되는 주소가 있는 지 여부를 반환
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
