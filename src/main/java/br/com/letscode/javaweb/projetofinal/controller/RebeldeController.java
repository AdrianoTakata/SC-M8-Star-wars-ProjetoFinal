package br.com.letscode.javaweb.projetofinal.controller;

import br.com.letscode.javaweb.projetofinal.dto.RequestRebelde;
import br.com.letscode.javaweb.projetofinal.dto.ResponseRebelde;
import br.com.letscode.javaweb.projetofinal.model.Rebelde;
import br.com.letscode.javaweb.projetofinal.service.RebeldeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/rebelde")
public class RebeldeController {

    @Autowired
    RebeldeService rebeldeService;

    @PostMapping
    public ResponseEntity<ResponseRebelde> cadastro(@RequestBody @Valid RequestRebelde requestRebelde, UriComponentsBuilder uriComponentsBuilder) { // o metodo POST recebera o objeto criado e após ser aplicada a lógica necessária, enviará a resposta para outro html
        Rebelde rebelde = rebeldeService.cadastraRebelde(requestRebelde);
        URI uri = uriComponentsBuilder.path("/cliente/{id}").buildAndExpand(rebelde.getId()).toUri();
        return ResponseEntity.created(uri).body(new ResponseRebelde(rebelde));
    }

    @GetMapping
    public List<ResponseRebelde> mostrarListaRebeldes() {
        return ResponseRebelde.toResponse(rebeldeService.buscaTodosRebeldes());
    }


}
