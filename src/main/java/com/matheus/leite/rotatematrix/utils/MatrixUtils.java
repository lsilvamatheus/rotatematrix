package com.matheus.leite.rotatematrix.utils;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixUtils {

    private MatrixUtils() {
    }

    public static int[][] convertToMatrix(List<Integer> list, Integer matrixOrder) {
        return Lists.partition(list, matrixOrder)
                .stream()
                .map(Ints::toArray)
                .map(a -> Arrays.copyOf(a, matrixOrder))
                .toArray(int[][]::new);
    }

    public static Double getMatrixOrder(List<Integer> list) {
        return Math.sqrt(list.size());
    }

    public static Boolean checkSquareMatrix(Double matrixOrder) {
        return matrixOrder - Math.floor(matrixOrder) == 0;
    }

    public static Integer getMatrixOrderToIntValue(Double matrixOrder) {
        return matrixOrder.intValue();
    }

    public static boolean evenSquareMatrix(Integer matrixOrder) {
        return matrixOrder % 2 == 0;
    }

    public static Integer iterationNumber(Integer listSize, Integer matrixOrder) {
        return listSize % 2 == 0 ? (matrixOrder / 2) : getMatrixMiddlePosition(matrixOrder);
    }

    public static Integer getMatrixMiddlePosition(Integer matrixOrder) {
        return (matrixOrder - 1) / 2;
    }

    public static Integer increasingIteratorValue(Integer value) {
        return value + 1;
    }

    public static Integer decreasingIteratorValue(Integer value) {
        return value - 1;
    }

    public static List<Integer> convertToList(int[][] matrix) {
        return Arrays
                .stream(matrix)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.toList());
    }
}
