package med.voll.API.REST.domain.patient;

public record DataListPatients(Long id, String name, String email, String document) {
    public DataListPatients(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getDocument());
    }
}
