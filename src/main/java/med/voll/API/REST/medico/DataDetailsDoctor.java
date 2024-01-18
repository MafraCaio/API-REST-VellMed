package med.voll.API.REST.medico;

import med.voll.API.REST.endereco.Address;

public record DataDetailsDoctor(Long id, String name, String email, String phone, String crm, Specialty specialty, Boolean active, Address address) {
    public  DataDetailsDoctor(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getPhone(), doctor.getCrm(), doctor.getSpecialty(), doctor.isActive(), doctor.getAddress());
    }
}
