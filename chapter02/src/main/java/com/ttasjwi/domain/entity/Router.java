package com.ttasjwi.domain.entity;

import com.ttasjwi.domain.vo.RouterId;
import com.ttasjwi.domain.vo.RouterType;

import java.util.function.Predicate;

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
