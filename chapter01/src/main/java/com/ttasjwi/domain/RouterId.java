package com.ttasjwi.domain;

/**
 * Router의 식별자
 */
public class RouterId {

    private String id;

    private RouterId(String id){
        this.id = id;
    }

    /**
     * 정적 팩토리 메서드
     */
    public static RouterId of(String id){
        return new RouterId(id);
    }

    @Override
    public String toString() {
        return "RouterId{" +
                "id='" + id + '\'' +
                '}';
    }
}
