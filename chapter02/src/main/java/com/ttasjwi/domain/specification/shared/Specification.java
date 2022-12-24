package com.ttasjwi.domain.specification.shared;

/**
 * - 명세 : 객체의 특성을 보장하는데 사용되는 조건, 프레디케이트
 */
public interface Specification<T> {

    boolean isSatisfiedBy(T t);

    /**
     * 다른 명세와 결합
     */
    Specification<T> and(Specification<T> specification);
}
