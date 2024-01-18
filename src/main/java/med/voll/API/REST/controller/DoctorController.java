package med.voll.API.REST.controller;

import jakarta.validation.Valid;
import med.voll.API.REST.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid RegisterDoctor data) {
        repository.save(new Doctor(data));
    }

    @GetMapping
    public Page<DataListDoctor> getList(@PageableDefault(size = 10, sort = "name") Pageable page) {
        return repository.findAllByActiveTrue(page).map(DataListDoctor::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid UpdateDoctor data) {
        var doctor = repository.getReferenceById(data.id());
        doctor.update(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);
        doctor.delete();

        return ResponseEntity.noContent().build();
    }
}
