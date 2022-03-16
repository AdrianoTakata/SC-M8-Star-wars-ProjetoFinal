package br.com.letscode.javaweb.projetofinal.service;

import br.com.letscode.javaweb.projetofinal.ProjetoFinalApplication;
import br.com.letscode.javaweb.projetofinal.exception.ExcecaoNaoEncontrada;
import br.com.letscode.javaweb.projetofinal.model.BDRebeldes;
import br.com.letscode.javaweb.projetofinal.model.Localizacao;
import br.com.letscode.javaweb.projetofinal.model.Rebelde;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class AcoesRebeldeService {

    BDRebeldes bdRebeldes = ProjetoFinalApplication.bdRebeldes;

    public Rebelde atualizaLocalizacao (UUID id, Localizacao localizacao) throws ExcecaoNaoEncontrada {
          Optional<Rebelde> resultRebelde = bdRebeldes.atualizaLocalizacao(id, localizacao);
          if (resultRebelde.isPresent()) {
              return resultRebelde.get();
          } else {
              throw new ExcecaoNaoEncontrada("Usuário não encontrado");
          }
    }

    public void reportaTraidor (UUID id) {
        bdRebeldes.reportaTraidor(id);
    }

}
