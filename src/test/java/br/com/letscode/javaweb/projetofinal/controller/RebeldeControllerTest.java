package br.com.letscode.javaweb.projetofinal.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RebeldeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void cadastraRebeldeComSucesso() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/rebelde")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\n" +
                                        "    \"nome\": \"Jeferson\",\n" +
                                        "    \"idade\": 34,\n" +
                                        "    \"genero\" : \"M\",\n" +
                                        "    \"localizacao\": {\n" +
                                        "        \"latitude\": 100,\n" +
                                        "        \"longitude\": 200,\n" +
                                        "        \"nomeGalaxia\": \"Via Lactea\"\n" +
                                        "    },\n" +
                                        "    \"inventario\": {\n" +
                                        "        \"numeroArma\": 0,\n" +
                                        "        \"numeroMunicao\": 100,\n" +
                                        "        \"numeroAgua\": 10,\n" +
                                        "        \"numeroComida\": 10\n" +
                                        "    }\n" +
                                        "}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.genero").value("M"));
    }
}
