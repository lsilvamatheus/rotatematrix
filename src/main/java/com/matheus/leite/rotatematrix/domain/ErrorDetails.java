package com.matheus.leite.rotatematrix.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErrorDetails {
    private String message;
    private Integer status;
    private Long timestamp;
}
