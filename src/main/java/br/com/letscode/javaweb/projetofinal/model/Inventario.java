package br.com.letscode.javaweb.projetofinal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Getter @Setter
@AllArgsConstructor
public class Inventario {

    private Integer numeroArma;
    private Integer numeroMunicao;
    private Integer numeroAgua;
    private Integer numeroComida;
}
