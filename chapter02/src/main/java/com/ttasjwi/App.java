package com.ttasjwi;

import com.ttasjwi.framework.adapters.input.stdin.RouterViewCLIAdapter;

public class App {

    public static void main(String[] args) {
        var cli = new RouterViewCLIAdapter();
        var type = "CORE";

        var routers = cli.obtainRelatedRouters(type);
        System.out.println(routers);
    }
}
