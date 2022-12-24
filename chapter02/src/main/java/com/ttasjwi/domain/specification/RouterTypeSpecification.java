package com.ttasjwi.domain.specification;

import com.ttasjwi.domain.entity.Router;
import com.ttasjwi.domain.specification.shared.AbstractSpecification;
import com.ttasjwi.domain.vo.RouterType;

public class RouterTypeSpecification extends AbstractSpecification<Router> {

    @Override
    public boolean isSatisfiedBy(Router router) {
        RouterType type = router.getRouterType();

        return type == RouterType.CORE || type == RouterType.EDGE;
    }
}
