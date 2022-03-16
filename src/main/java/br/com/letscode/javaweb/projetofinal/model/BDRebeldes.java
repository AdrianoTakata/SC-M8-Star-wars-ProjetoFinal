package br.com.letscode.javaweb.projetofinal.model;

import br.com.letscode.javaweb.projetofinal.exception.ExcecaoNaoEncontrada;

import java.util.*;

public class BDRebeldes {
    private static List<Rebelde> rebeldeList = new ArrayList<>();

    public void adiciona(Rebelde rebelde){
        BDRebeldes.rebeldeList.add(rebelde);
    }

    public List<Rebelde> buscaRebeldes() {
        return BDRebeldes.rebeldeList;
    }

    public Optional<Rebelde> detalhesRebelde(UUID id) {
        return BDRebeldes.rebeldeList.stream().filter(rebelde -> Objects.equals(rebelde.getId(), id)).findAny();
    }

    public Optional<Rebelde> atualizaLocalizacao(UUID id, Localizacao localizacao) {
         BDRebeldes.rebeldeList.stream().filter(rebelde -> Objects.equals(rebelde.getId(), id))
                .forEach(rebelde -> {
                            rebelde.setLocalizacao(localizacao);
                        }
                );
        return detalhesRebelde(id);
    }

    public void reportaTraidor(UUID id) {
        BDRebeldes.rebeldeList.stream().filter(rebelde -> Objects.equals(rebelde.getId(), id))
                .forEach(rebelde -> {
                    if (!rebelde.getTraidor()) {
                        rebelde.setContadorReportes(rebelde.getContadorReportes() + 1);
                        if (rebelde.getContadorReportes() == 3) {
                            rebelde.setTraidor(true);
                        }
                    }
                });

    }
}
