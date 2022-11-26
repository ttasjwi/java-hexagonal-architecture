package com.ttasjwi.domain;


import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Router {

    private final RouterType routerType;
    private final RouterId routerId;

    public Router(RouterType routerType, RouterId routerId) {
        this.routerType = routerType;
        this.routerId = routerId;
    }

    /**
     * Router가 지정타입의 라우터인지 확인하는 함수를 반환
     */
    public static Predicate<Router> filterRouterByType(RouterType routerType){
        return routerType.equals(RouterType.CORE)
                ? isCore() :
                isEdge();
    }

    private static Predicate<Router> isCore(){
        return p -> p.getRouterType() == RouterType.CORE;
    }

    private static Predicate<Router> isEdge(){
        return p -> p.getRouterType() == RouterType.EDGE;
    }

    /**
     * 필터 조건에 맞는 라우터들만 걸러서, List로 반환
     */
    public static List<Router> retrieveRouter(List<Router> routers, Predicate<Router> predicate){
        return routers.stream()
                .filter(predicate)
                .collect(Collectors.<Router>toList());
    }

    public RouterType getRouterType(){
        return routerType;
    }

    @Override
    public String toString() {
        return "Router{" +
                "routerType=" + routerType +
                ", routerId=" + routerId +
                '}';
    }
}
