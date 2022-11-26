package com.ttasjwi.application.ports.output;

import com.ttasjwi.domain.Router;

import java.util.List;

/**
 * 외부 리소스에서 어떤 종류의 데이터를 가져와야하는 지 명세
 */
public interface RouterViewOutputPort {

    List<Router> fetchRouters();

}
