package com.ttasjwi.domain.entity;

import com.ttasjwi.domain.vo.IP;
import com.ttasjwi.domain.vo.Network;
import com.ttasjwi.domain.vo.SwitchId;
import com.ttasjwi.domain.vo.SwitchType;

import java.util.ArrayList;
import java.util.List;

public class Switch {

    private SwitchId switchId;
    private SwitchType switchType;
    private final List<Network> networks;
    private IP address;

    public Switch(SwitchId switchId, SwitchType switchType,
                  List<Network> networks, IP address) {
        this.switchId = switchId;
        this.switchType = switchType;
        this.networks = networks;
        this.address = address;
    }

    public Switch addNetwork(Network network) {
        List<Network> networks = new ArrayList<>(this.networks);
        networks.add(network);
        return new Switch(switchId, switchType, networks, address);
    }

    public List<Network> getNetworks() {
        return networks;
    }
}
