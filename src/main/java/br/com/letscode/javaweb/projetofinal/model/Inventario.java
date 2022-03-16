package br.com.letscode.javaweb.projetofinal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Getter @Setter
@AllArgsConstructor
public class Inventario {
    @PositiveOrZero
    private Integer numeroArma;
    @PositiveOrZero
    private Integer numeroMunicao;
    @PositiveOrZero
    private Integer numeroAgua;
    @PositiveOrZero
    private Integer numeroComida;
}
