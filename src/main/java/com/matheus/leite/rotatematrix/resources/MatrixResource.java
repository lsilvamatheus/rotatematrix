package com.matheus.leite.rotatematrix.resources;

import com.matheus.leite.rotatematrix.domain.Response;
import com.matheus.leite.rotatematrix.domain.ResponseStatus;
import com.matheus.leite.rotatematrix.service.MatrixService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/matrix")
public class MatrixResource {

    private final MatrixService service;

    public MatrixResource(MatrixService service) {
        this.service = service;
    }

    @PostMapping(value = "/rotate")
    public ResponseEntity<Response> rotate(@RequestBody List<Integer> list) {
        Response response = service.rotateMatrix(list);

        return response.getStatus().equals(ResponseStatus.VALID)
                ?  ResponseEntity.status(HttpStatus.OK).body(response)
                : ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }
}
