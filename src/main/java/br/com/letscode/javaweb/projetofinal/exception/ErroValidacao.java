package br.com.letscode.javaweb.projetofinal.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErroValidacao {

    private String campo;
    private String messagem;

}
