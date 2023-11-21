package med.voll.API.REST.controller;

import jakarta.validation.Valid;
import med.voll.API.REST.medico.DadosCadastroMedido; // DTO
import med.voll.API.REST.medico.Medico;
import med.voll.API.REST.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicosController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedido dados) {
        repository.save(new Medico(dados));
    }

}
