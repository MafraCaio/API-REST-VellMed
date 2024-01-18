package med.voll.API.REST.controller;

import jakarta.validation.Valid;
import med.voll.API.REST.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientsController {

    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid RegisterPatient data) {
        repository.save(new Patient(data));
    }

    @GetMapping
    public Page<DataListPatients> getList(@PageableDefault(size = 10, sort = "name") Pageable page) {
        return repository.findAllByActiveTrue(page).map(DataListPatients::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid UpdatePatient data) {
        var patient = repository.getReferenceById(data.id());
        patient.update(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        var patient = repository.getReferenceById(id);
        patient.delete();
    }
}
