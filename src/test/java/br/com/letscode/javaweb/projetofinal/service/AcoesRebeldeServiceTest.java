package br.com.letscode.javaweb.projetofinal.service;

import br.com.letscode.javaweb.projetofinal.dto.RequestRebelde;
import br.com.letscode.javaweb.projetofinal.model.Inventario;
import br.com.letscode.javaweb.projetofinal.model.Localizacao;
import br.com.letscode.javaweb.projetofinal.model.Rebelde;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AcoesRebeldeServiceTest {

    @Test
    public void atualizaLocalizacaoRebelde() throws Exception {
        RebeldeService rebeldeService = new RebeldeService();
        AcoesRebeldeService acoesRebeldeService = new AcoesRebeldeService();
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
        RebeldeService rebeldeService = new RebeldeService();
        AcoesRebeldeService acoesRebeldeService = new AcoesRebeldeService();
        RequestRebelde requestRebelde = new RequestRebelde(
                "Jeferson", 34, 'M',
                new Localizacao(100.0, 200.0, "Via Lactea"),
                new Inventario(1, 100, 10,10));

        Rebelde rebelde = rebeldeService.cadastraRebelde(requestRebelde);

        acoesRebeldeService.reportaTraidor(rebelde.getId());
        assertEquals(1, rebelde.getContadorReportes());
    }

    @Test
    public void tornarTraidor() {
        RebeldeService rebeldeService = new RebeldeService();
        AcoesRebeldeService acoesRebeldeService = new AcoesRebeldeService();
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

}
