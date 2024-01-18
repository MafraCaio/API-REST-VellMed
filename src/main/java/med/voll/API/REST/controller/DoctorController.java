package med.voll.API.REST.controller;

import jakarta.validation.Valid;
import med.voll.API.REST.domain.doctor.*;
import med.voll.API.REST.domain.doctor.DataListDoctor;
import med.voll.API.REST.domain.doctor.Doctor;
import med.voll.API.REST.domain.doctor.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DataDetailsDoctor> register(@RequestBody @Valid RegisterDoctor data, UriComponentsBuilder uriBuilder) {
        var doctor = new Doctor(data);
        repository.save(doctor);

        var uri = uriBuilder.path("doctors/{id}").buildAndExpand(doctor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DataDetailsDoctor(doctor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataDetailsDoctor> getDoctor(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DataDetailsDoctor(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<DataListDoctor>> getList(@PageableDefault(size = 10, sort = "name") Pageable page) {
        var doctors = repository.findAllByActiveTrue(page).map(DataListDoctor::new);

        return ResponseEntity.ok(doctors);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DataDetailsDoctor> update(@RequestBody @Valid UpdateDoctor data) {
        var doctor = repository.getReferenceById(data.id());
        doctor.update(data);

        return ResponseEntity.ok(new DataDetailsDoctor(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);
        doctor.delete();

        return ResponseEntity.noContent().build();
    }
}
