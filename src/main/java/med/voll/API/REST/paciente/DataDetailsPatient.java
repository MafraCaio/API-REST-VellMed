package med.voll.API.REST.paciente;

import med.voll.API.REST.endereco.Address;
import med.voll.API.REST.medico.Specialty;

public record DataDetailsPatient(Long id, String name, String email, String phone, String document, Boolean active, Address address) {

    public  DataDetailsPatient(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getDocument(), patient.getPhone(), patient.isActive(), patient.getAddress());
    }

}
