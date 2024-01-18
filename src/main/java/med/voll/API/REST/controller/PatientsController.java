package med.voll.API.REST.controller;

import jakarta.validation.Valid;
import med.voll.API.REST.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/patients")
public class PatientsController {

    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DataDetailsPatient> register(@RequestBody @Valid RegisterPatient data, UriComponentsBuilder uriBuilder) {
        var patient = new Patient(data);
        repository.save(patient);

        var uri = uriBuilder.path("doctors/{id}").buildAndExpand(patient.getId()).toUri();

        return ResponseEntity.created(uri).body(new DataDetailsPatient(patient));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataDetailsPatient> getPatient(@PathVariable Long id) {
        var patient = repository.getReferenceById(id);

        return ResponseEntity.ok(new DataDetailsPatient(patient));
    }

    @GetMapping
    public ResponseEntity<Page<DataListPatients>> getList(@PageableDefault(size = 10, sort = "name") Pageable page) {
        var patients = repository.findAllByActiveTrue(page).map(DataListPatients::new);
        return  ResponseEntity.ok(patients);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DataDetailsPatient> update(@RequestBody @Valid UpdatePatient data) {
        var patient = repository.getReferenceById(data.id());
        patient.update(data);
        return ResponseEntity.ok(new DataDetailsPatient(patient));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var patient = repository.getReferenceById(id);
        patient.delete();

        return ResponseEntity.noContent().build();
    }
}
