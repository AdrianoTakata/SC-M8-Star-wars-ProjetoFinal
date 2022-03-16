package br.com.letscode.javaweb.projetofinal.service;

import br.com.letscode.javaweb.projetofinal.dto.RequestRebelde;
import br.com.letscode.javaweb.projetofinal.exception.ExcecaoNaoEncontrada;
import br.com.letscode.javaweb.projetofinal.model.Inventario;
import br.com.letscode.javaweb.projetofinal.model.Localizacao;
import br.com.letscode.javaweb.projetofinal.model.Rebelde;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class AcoesRebeldeServiceTest {

    RebeldeService rebeldeService = new RebeldeService();
    AcoesRebeldeService acoesRebeldeService = new AcoesRebeldeService();

    @Test
    public void atualizaLocalizacaoRebelde() throws Exception {
        RequestRebelde requestRebelde = new RequestRebelde(
                "Jeferson", 34, 'M',
                new Localizacao(100.0, 200.0, "Via Lactea"),
                new Inventario(1, 100, 10,10));

        Rebelde rebelde  = rebeldeService.cadastraRebelde(requestRebelde);
        Localizacao localizacaoRebeldeAtualizado = new Localizacao(150.0, 250.0, "Andromeda");

        acoesRebeldeService.atualizaLocalizacao(rebelde.getId(), localizacaoRebeldeAtualizado);

        assertEquals(150, rebelde.getLocalizacao().getLatitude());

    }

    @Test
    public void reportaTraidor() {
        RequestRebelde requestRebelde = new RequestRebelde(
                "Jeferson", 34, 'M',
                new Localizacao(100.0, 200.0, "Via Lactea"),
                new Inventario(1, 100, 10,10));

        Rebelde rebelde = rebeldeService.cadastraRebelde(requestRebelde);

        acoesRebeldeService.reportaTraidor(rebelde.getId());
        assertEquals(1, rebelde.getContadorReportes());
        assertEquals(false, rebelde.getTraidor());
    }

    @Test
    public void tornarTraidor() {
        RequestRebelde requestRebelde = new RequestRebelde(
                "Jeferson", 34, 'M',
                new Localizacao(100.0, 200.0, "Via Lactea"),
                new Inventario(1, 100, 10,10));

        Rebelde rebelde = rebeldeService.cadastraRebelde(requestRebelde);

        acoesRebeldeService.reportaTraidor(rebelde.getId());
        acoesRebeldeService.reportaTraidor(rebelde.getId());
        acoesRebeldeService.reportaTraidor(rebelde.getId());

        assertEquals(true, rebelde.getTraidor());
        System.out.println("teste");
    }

    @Test
    public void atualizaLocaizacaoExcecao() throws ExcecaoNaoEncontrada {
        UUID id = UUID.randomUUID();
        try{
            RequestRebelde requestRebelde = new RequestRebelde(
                    "Jeferson", 34, 'M',
                    new Localizacao(100.0, 200.0, "Via Lactea"),
                    new Inventario(1, 100, 10,10));

            rebeldeService.cadastraRebelde(requestRebelde);
            Localizacao localizacaoRebeldeAtualizado = new Localizacao(150.0, 250.0, "Andromeda");
            acoesRebeldeService.atualizaLocalizacao(id, localizacaoRebeldeAtualizado);
            fail("Nao lancou a excecao");
        } catch (Exception e){ }

    }


}
