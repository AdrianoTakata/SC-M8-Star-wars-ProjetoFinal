package br.com.letscode.javaweb.projetofinal.service;

import br.com.letscode.javaweb.projetofinal.ProjetoFinalApplication;
import br.com.letscode.javaweb.projetofinal.dto.RequestRebelde;
import br.com.letscode.javaweb.projetofinal.model.BDRebeldes;
import br.com.letscode.javaweb.projetofinal.model.Rebelde;
import org.springframework.stereotype.Service;

import java.util.List;;

@Service
public class RebeldeService {

    BDRebeldes bdRebeldes = ProjetoFinalApplication.bdRebeldes;

    public Rebelde cadastraRebelde(RequestRebelde requestRebelde){
        Rebelde rebelde = new Rebelde(requestRebelde);
        bdRebeldes.adiciona(rebelde);
        return rebelde;
    }

    public List<Rebelde> buscaTodosRebeldes() {
        return bdRebeldes.buscaRebeldes();
    }

}
