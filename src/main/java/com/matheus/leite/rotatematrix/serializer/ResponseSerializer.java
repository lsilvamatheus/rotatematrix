package com.matheus.leite.rotatematrix.serializer;

import com.matheus.leite.rotatematrix.domain.Response;
import com.matheus.leite.rotatematrix.domain.ResponseStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResponseSerializer {
    public Response serializer(ResponseStatus responseStatus, List<Integer> responseBody) {
        return new Response(responseStatus, responseBody);
    }
}
