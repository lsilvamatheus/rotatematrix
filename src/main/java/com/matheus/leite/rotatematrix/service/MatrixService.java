package com.matheus.leite.rotatematrix.service;

import com.matheus.leite.rotatematrix.domain.Response;

import java.util.List;

public interface MatrixService {
    Response rotateMatrix(List<Integer> matrix);

    void addCenterPosition(int[][] matrix, Integer matrixOrderIntValue, int[][] matrixResult,
                           int matrixMiddlePosition);

    int[][] rotateMatrixValues(int[][] matrix, Integer matrixOrderIntValue, Integer iterationNumber);

    void rotateFirstLine(int[][] matrix, int[][] result, Integer start, Integer end);

    void rotateFirstColumn(int[][] matrix, int[][] result, Integer start, Integer end);

    void rotateLastLine(int[][] matrix, int[][] result, Integer start, Integer end);

    void rotateLastColumn(int[][] matrix, int[][] result, Integer start, Integer end);
}
