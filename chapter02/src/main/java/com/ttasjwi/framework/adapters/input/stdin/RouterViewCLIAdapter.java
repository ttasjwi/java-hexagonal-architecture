package com.ttasjwi.framework.adapters.input.stdin;

import com.ttasjwi.application.ports.input.RouterViewInputPort;
import com.ttasjwi.application.usecases.RouterViewUseCase;
import com.ttasjwi.domain.entity.Router;
import com.ttasjwi.domain.vo.RouterType;
import com.ttasjwi.framework.adapters.output.file.RouterViewFileAdapter;

import java.util.List;

public class RouterViewCLIAdapter {

    private RouterViewUseCase routerViewUseCase;

    public RouterViewCLIAdapter(){
        initAdapters();
    }

    private void initAdapters(){
        this.routerViewUseCase = new RouterViewInputPort(RouterViewFileAdapter.getInstance());
    }

    public List<Router> obtainRelatedRouters(String type) {
        return routerViewUseCase.getRouters(
                Router.filterRouterByType(RouterType.valueOf(type)));
    }

}
