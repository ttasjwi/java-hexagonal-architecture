package com.ttasjwi.framework.adapters.output.file;

import com.ttasjwi.application.ports.output.RouterViewOutputPort;
import com.ttasjwi.domain.Router;
import com.ttasjwi.domain.RouterId;
import com.ttasjwi.domain.RouterType;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RouterViewFileAdapter implements RouterViewOutputPort {

    private static final String ROUTERS_FILE_PATH = "routers.txt";
    private static final String DELIMITER = ";";

    private static RouterViewFileAdapter instance;

    private RouterViewFileAdapter() {
    }

    public static RouterViewFileAdapter getInstance() {
        if (instance == null) {
            instance = new RouterViewFileAdapter();
        }
        return instance;
    }

    @Override
    public List<Router> fetchRouters() {
        List<Router> routers = readFileAsString();
        return routers;
    }

    private static List<Router> readFileAsString() {
        List<Router> routers = new ArrayList<>();

        try (Stream<String> stream = new BufferedReader(
                new InputStreamReader(
                        RouterViewFileAdapter.class.getClassLoader().
                                getResourceAsStream(ROUTERS_FILE_PATH))).lines()) {
            stream.forEach(line ->{
                String[] routerEntry = line.split(DELIMITER);
                var id = routerEntry[0];
                var type = routerEntry[1];
                Router router = new Router(RouterType.valueOf(type),RouterId.of(id));
                routers.add(router);
            });
        } catch (Exception e){
            e.printStackTrace();
        }
        return routers;
    }

}
