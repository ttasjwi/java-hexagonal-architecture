package com.ttasjwi;

import com.ttasjwi.domain.Router;
import com.ttasjwi.framework.adapters.input.stdin.RouterViewCLIAdapter;

import java.util.List;

public class App {

    public static void main(String[] args) {

        RouterViewCLIAdapter cli = new RouterViewCLIAdapter();

        String type = "CORE";

        List<Router> routers = cli.obtainRelatedRouters(type);

        System.out.println(routers);
    }
}
