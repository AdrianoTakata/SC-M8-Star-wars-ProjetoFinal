package br.com.letscode.javaweb.projetofinal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter
@AllArgsConstructor
public class Localizacao {
    @NotNull
    private Double latitude;
    @NotNull
    private Double longitude;
    @NotBlank
    private String nomeGalaxia;

    public Localizacao (Localizacao localizacao) {
        latitude = localizacao.getLatitude();
        longitude = localizacao.getLongitude();
        nomeGalaxia = localizacao.getNomeGalaxia();
    }
}
