package med.voll.API.REST.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.API.REST.endereco.DadosEndereco;

public record DadosAtualizaMedido(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
