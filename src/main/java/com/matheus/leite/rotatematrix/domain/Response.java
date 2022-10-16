package com.matheus.leite.rotatematrix.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Response {

    private ResponseStatus status;
    private List<Integer> list;
}
