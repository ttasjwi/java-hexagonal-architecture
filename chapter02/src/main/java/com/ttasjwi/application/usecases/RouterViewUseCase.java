package com.ttasjwi.application.usecases;

import com.ttasjwi.domain.entity.Router;

import java.util.List;
import java.util.function.Predicate;

public interface RouterViewUseCase {

    /**
     * 지정 조건을 만족하는 Router의 리스트 반환
     */
    List<Router> getRouters(Predicate<Router> filter);
}
