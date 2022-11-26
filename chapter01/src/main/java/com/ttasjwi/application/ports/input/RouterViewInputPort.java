package com.ttasjwi.application.ports.input;

import com.ttasjwi.application.ports.output.RouterViewOutputPort;
import com.ttasjwi.application.usecases.RouterViewUseCase;
import com.ttasjwi.domain.Router;

import java.util.List;
import java.util.function.Predicate;

public class RouterViewInputPort implements RouterViewUseCase {

    private final RouterViewOutputPort routerListOutputPort;

    public RouterViewInputPort(RouterViewOutputPort routerListOutputPort) {
        this.routerListOutputPort = routerListOutputPort;
    }

    @Override
    public List<Router> getRouters(Predicate<Router> filter) {
        List<Router> routers = routerListOutputPort.fetchRouters();
        return Router.retrieveRouter(routers, filter);
    }
}
