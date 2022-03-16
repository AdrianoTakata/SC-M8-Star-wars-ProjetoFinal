package br.com.letscode.javaweb.projetofinal.service;

import br.com.letscode.javaweb.projetofinal.dto.RequestRebelde;
import br.com.letscode.javaweb.projetofinal.model.Inventario;
import br.com.letscode.javaweb.projetofinal.model.Localizacao;
import br.com.letscode.javaweb.projetofinal.model.Rebelde;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RebeldeServiceTest {

    RebeldeService rebeldeService = new RebeldeService();

    @Test
    public void cadastraRebelde(){
        RequestRebelde requestRebelde = new RequestRebelde(
                "Jeferson", 34, 'M',
                new Localizacao(100.0, 200.0, "Via Lactea"),
                new Inventario(1, 100, 10,10));

        Rebelde rebelde = rebeldeService.cadastraRebelde(requestRebelde);

        assertEquals(requestRebelde.getNome(), rebelde.getNome());
        assertNotNull(rebelde.getId());
    }


}
