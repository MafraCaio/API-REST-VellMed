package med.voll.API.REST.medico;

import med.voll.API.REST.endereco.DadosEndereco;

public record DadosCadastroMedido(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        DadosEndereco endereco
) {
}
