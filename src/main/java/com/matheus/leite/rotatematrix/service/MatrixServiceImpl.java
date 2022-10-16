package com.matheus.leite.rotatematrix.service;

import com.matheus.leite.rotatematrix.domain.Response;
import com.matheus.leite.rotatematrix.domain.ResponseStatus;
import com.matheus.leite.rotatematrix.serializer.ResponseSerializer;
import com.matheus.leite.rotatematrix.utils.MatrixUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class MatrixServiceImpl implements MatrixService {

    private final ResponseSerializer responseSerializer;

    public MatrixServiceImpl(ResponseSerializer responseSerializer) {
        this.responseSerializer = responseSerializer;
    }

    @Override
    public Response rotateMatrix(List<Integer> list) {
        if (list.isEmpty()) {
            return new Response(ResponseStatus.INVALID, list);
        }

        Double matrixOrder = MatrixUtils.getMatrixOrder(list);

        if (Boolean.FALSE.equals(MatrixUtils.checkSquareMatrix(matrixOrder)))
            return new Response(ResponseStatus.INVALID, list);

        Integer matrixOrderIntValue = MatrixUtils.getMatrixOrderToIntValue(matrixOrder);
        int[][] matrix = MatrixUtils.convertToMatrix(list, matrixOrderIntValue);
        Integer iterationNumber = MatrixUtils.iterationNumber(list.size(), matrixOrderIntValue);
        int[][] matrixResult = this.rotateMatrixValues(matrix, matrixOrderIntValue, iterationNumber);

        List<Integer> listResult = MatrixUtils.convertToList(matrixResult);

        return responseSerializer.serializer(ResponseStatus.VALID, listResult);
    }

    @Override
    public void addCenterPosition(int[][] matrix, Integer matrixOrderIntValue, int[][] matrixResult,
                                  int matrixCenterPosition) {
        if (!MatrixUtils.evenSquareMatrix(matrixOrderIntValue)) {
            matrixResult[matrixCenterPosition][matrixCenterPosition] =
                    matrix[matrixCenterPosition][matrixCenterPosition];
        }
    }

    @Override
    public int[][] rotateMatrixValues(int[][] matrix, Integer matrixOrderIntValue, Integer iterationNumber) {
        int[][] matrixResult = new int[matrixOrderIntValue][matrixOrderIntValue];
        int matrixCenterPosition = (MatrixUtils.getMatrixMiddlePosition(matrixOrderIntValue));

        this.addCenterPosition(matrix, matrixOrderIntValue, matrixResult, matrixCenterPosition);

        IntStream.range(0, iterationNumber)
                .forEach(iterator -> {
                    Integer start = iterator;
                    Integer end = matrixOrderIntValue - 1 - iterator;

                    this.rotateFirstLine(matrix, matrixResult, start, end);
                    this.rotateLastColumn(matrix, matrixResult, start, end);
                    this.rotateLastLine(matrix, matrixResult, start, end);
                    this.rotateFirstColumn(matrix, matrixResult, start, end);
                });
        return matrixResult;
    }


    @Override
    public void rotateFirstLine(int[][] matrix, int[][] result, Integer start, Integer end) {
        IntStream.range(start, end)
                .forEach(item ->
                        result[start][MatrixUtils.increasingIteratorValue(item)] = matrix[start][item]
                );
    }

    @Override
    public void rotateFirstColumn(int[][] matrix, int[][] result, Integer start, Integer end) {
        IntStream.range(start, end)
                .map(i -> end - i + start)
                .forEach(item ->
                        result[MatrixUtils.decreasingIteratorValue(item)][start] = matrix[item][start]
                );
    }

    @Override
    public void rotateLastLine(int[][] matrix, int[][] result, Integer start, Integer end) {
        IntStream.range(start, end)
                .map(i -> start - i + end)
                .forEach(item ->
                        result[end][MatrixUtils.decreasingIteratorValue(item)] = matrix[end][item]
                );
    }

    @Override
    public void rotateLastColumn(int[][] matrix, int[][] result, Integer start, Integer end) {
        IntStream.range(start, end)
                .forEach(item ->
                        result[MatrixUtils.increasingIteratorValue(item)][end] = matrix[item][end]
                );
    }
}
