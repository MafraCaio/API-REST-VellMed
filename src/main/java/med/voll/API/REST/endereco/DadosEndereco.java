package med.voll.API.REST.endereco;

public record DadosEndereco(
        String logradouro,
        String bairro,
        String cep,
        String cidade,
        String uf,
        String numero)
{
}