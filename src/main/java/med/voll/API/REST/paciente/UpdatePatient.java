package med.voll.API.REST.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.API.REST.endereco.AddressData;

public record UpdatePatient(
        @NotNull
        Long id,
        String name,
        String phone,
        AddressData address) {
}
