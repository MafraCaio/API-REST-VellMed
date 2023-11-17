package med.voll.API.REST.controller;

import med.voll.API.REST.medico.DadosCadastroMedido; // DTO
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicosController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedido dados) {
        System.out.println(dados.nome());
    }

}
