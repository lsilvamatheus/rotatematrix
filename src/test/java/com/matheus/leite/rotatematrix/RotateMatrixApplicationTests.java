package com.matheus.leite.rotatematrix;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.matheus.leite.rotatematrix.domain.Response;
import com.matheus.leite.rotatematrix.domain.ResponseStatus;
import com.matheus.leite.rotatematrix.error.message.ErrorMessage;
import com.matheus.leite.rotatematrix.resources.MatrixResource;
import com.matheus.leite.rotatematrix.serializer.ResponseSerializer;
import com.matheus.leite.rotatematrix.service.MatrixService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = MatrixResource.class)
@Import(MatrixResource.class)
class RotateMatrixApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MatrixService matrixService;


    private ResponseSerializer responseSerializer;
    private List<Integer> inputList;
    private List<Integer> responseList;

    @BeforeEach
    void init() {
        this.responseSerializer = new ResponseSerializer();
        inputList = new ArrayList<>();
        responseList = new ArrayList<>();
    }

    @Test
    void whenJustOneElementInList_thenReturnItSelfAndValidStatus() throws Exception {
        inputList.add(1);
        Response mockResponse = responseSerializer.serializer(ResponseStatus.VALID, inputList);

        when(matrixService.rotateMatrix(any(List.class))).thenReturn(mockResponse);

        ObjectWriter objectMapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String inputListJson = objectMapper.writeValueAsString(inputList);

        ObjectWriter objectMapperResponse = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String mockResponseJson = objectMapperResponse.writeValueAsString(mockResponse);

        mockMvc.perform(post("/matrix/rotate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(inputListJson))
                .andExpect(status().isOk())
                .andExpect(content().json(mockResponseJson));
    }

    @Test
    void whenListRepresentsOneOrderMatrix_thenReturnRotatedListAndValidStatus() throws Exception {
        inputList.addAll(Arrays.asList(1, 2));
        responseList.addAll(Arrays.asList(2, 1));
        Response mockResponse = responseSerializer.serializer(ResponseStatus.VALID, responseList);

        when(matrixService.rotateMatrix(any(List.class))).thenReturn(mockResponse);

        ObjectWriter objectMapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String inputListJson = objectMapper.writeValueAsString(inputList);

        ObjectWriter objectMapperResponse = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String mockResponseJson = objectMapperResponse.writeValueAsString(mockResponse);

        mockMvc.perform(post("/matrix/rotate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(inputListJson))
                .andExpect(status().isOk())
                .andExpect(content().json(mockResponseJson));
    }

    @Test
    void whenListRepresentsTwoOrderMatrix_thenReturnRotatedListAndValidStatus() throws Exception {
        inputList.addAll(Arrays.asList(1, 2, 3, 4));
        responseList.addAll(Arrays.asList(3, 1, 4, 2));
        Response mockResponse = responseSerializer.serializer(ResponseStatus.VALID, responseList);

        when(matrixService.rotateMatrix(any(List.class))).thenReturn(mockResponse);

        ObjectWriter objectMapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String inputListJson = objectMapper.writeValueAsString(inputList);

        ObjectWriter objectMapperResponse = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String mockResponseJson = objectMapperResponse.writeValueAsString(mockResponse);

        mockMvc.perform(post("/matrix/rotate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(inputListJson))
                .andExpect(status().isOk())
                .andExpect(content().json(mockResponseJson));
    }

    @Test
    void whenListRepresentsThreeOrderMatrix_thenReturnRotatedListAndValidStatus() throws Exception {
        inputList.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        responseList.addAll(Arrays.asList(4, 1, 2, 7, 5, 3, 8, 9, 6));
        Response mockResponse = responseSerializer.serializer(ResponseStatus.VALID, responseList);

        when(matrixService.rotateMatrix(any(List.class))).thenReturn(mockResponse);

        ObjectWriter objectMapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String inputListJson = objectMapper.writeValueAsString(inputList);

        ObjectWriter objectMapperResponse = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String mockResponseJson = objectMapperResponse.writeValueAsString(mockResponse);

        mockMvc.perform(post("/matrix/rotate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(inputListJson))
                .andExpect(status().isOk())
                .andExpect(content().json(mockResponseJson));
    }

    @Test
    void whenListRepresentsFiveOrderMatrix_thenReturnRotatedListAndValidStatus() throws Exception {
        inputList.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
                23, 24, 25));
        responseList.addAll(Arrays.asList(6, 1, 2, 3, 4, 11, 12, 7, 8, 5, 16, 17, 13, 9, 10, 21, 18, 19, 14, 15, 22, 23,
                24, 25, 20));

        Response mockResponse = responseSerializer.serializer(ResponseStatus.VALID, responseList);

        when(matrixService.rotateMatrix(any(List.class))).thenReturn(mockResponse);

        ObjectWriter objectMapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String inputListJson = objectMapper.writeValueAsString(inputList);

        ObjectWriter objectMapperResponse = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String mockResponseJson = objectMapperResponse.writeValueAsString(mockResponse);

        mockMvc.perform(post("/matrix/rotate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(inputListJson))
                .andExpect(status().isOk())
                .andExpect(content().json(mockResponseJson));
    }

    @Test
    void whenListIsEmpty_thenReturnInputListAndInvalidStatus() throws Exception {
        Response mockResponse = responseSerializer.serializer(ResponseStatus.INVALID, inputList);

        when(matrixService.rotateMatrix(any(List.class))).thenReturn(mockResponse);

        ObjectWriter objectMapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String inputListJson = objectMapper.writeValueAsString(inputList);

        ObjectWriter objectMapperResponse = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String mockResponseJson = objectMapperResponse.writeValueAsString(mockResponse);

        mockMvc.perform(post("/matrix/rotate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(inputListJson))
                .andExpect(status().isNotAcceptable())
                .andExpect(content().json(mockResponseJson));
    }

    @Test
    void whenThreeElementsInListAndIsNotASquareMatrix_thenReturnInputListAndInvalidStatus() throws Exception {
        inputList.addAll(Arrays.asList(3, -5, -2));
        Response mockResponse = responseSerializer.serializer(ResponseStatus.INVALID, inputList);

        when(matrixService.rotateMatrix(any(List.class))).thenReturn(mockResponse);

        ObjectWriter objectMapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String inputListJson = objectMapper.writeValueAsString(inputList);

        ObjectWriter objectMapperResponse = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String mockResponseJson = objectMapperResponse.writeValueAsString(mockResponse);

        mockMvc.perform(post("/matrix/rotate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(inputListJson))
                .andExpect(status().isNotAcceptable())
                .andExpect(content().json(mockResponseJson));
    }

    @Test
    void whenFiveElementsInListAndIsNotASquareMatrix_thenReturnInputListAndInvalidStatus() throws Exception {
        inputList.addAll(Arrays.asList(1, 1, 1, 1, 1));
        Response mockResponse = responseSerializer.serializer(ResponseStatus.INVALID, inputList);

        when(matrixService.rotateMatrix(any(List.class))).thenReturn(mockResponse);

        ObjectWriter objectMapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String inputListJson = objectMapper.writeValueAsString(inputList);

        ObjectWriter objectMapperResponse = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String mockResponseJson = objectMapperResponse.writeValueAsString(mockResponse);

        mockMvc.perform(post("/matrix/rotate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(inputListJson))
                .andExpect(status().isNotAcceptable())
                .andExpect(content().json(mockResponseJson));
    }


    @Test
    void whenWrongTypeInput_thenReturnRelatedMessageAndBadRequestStatus() throws Exception {
        Integer wrongInput = 1;

        ObjectWriter objectMapperInput = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String wrongInputJson = objectMapperInput.writeValueAsString(wrongInput);

        mockMvc.perform(post("/matrix/rotate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(wrongInputJson))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString(ErrorMessage.JSON_PARSE_ERROR)));
    }
}
