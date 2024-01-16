package med.voll.API.REST.controller;

import jakarta.validation.constraints.NotNull;
import med.voll.API.REST.endereco.DadosEndereco;

public record DadosAtualizaPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
