package med.voll.API.REST.domain.patient;

import med.voll.API.REST.domain.address.Address;

public record DataDetailsPatient(Long id, String name, String email, String phone, String document, Boolean active, Address address) {

    public  DataDetailsPatient(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getDocument(), patient.getPhone(), patient.isActive(), patient.getAddress());
    }

}
