package br.com.letscode.javaweb.projetofinal.dto;

import br.com.letscode.javaweb.projetofinal.model.Inventario;
import br.com.letscode.javaweb.projetofinal.model.Localizacao;
import br.com.letscode.javaweb.projetofinal.utils.Genero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Getter
@Setter
@AllArgsConstructor
public class RequestRebelde {

    @NotBlank @Length(min = 2)
    private String nome;
    @NotNull @Positive
    private Integer idade;
    @Genero
    private Character genero;
    private Localizacao localizacao;
    private Inventario inventario;

}
