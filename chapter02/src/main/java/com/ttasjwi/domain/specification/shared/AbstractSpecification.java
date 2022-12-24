package com.ttasjwi.domain.specification.shared;

public abstract class AbstractSpecification<T> implements Specification<T> {

    public Specification<T> and(final Specification<T> specification) {
        return new AndSpecification<>(this, specification);
    }
}
