package med.voll.API.REST.domain.patient;

import jakarta.validation.constraints.NotNull;
import med.voll.API.REST.domain.address.AddressData;

public record UpdatePatient(
        @NotNull
        Long id,
        String name,
        String phone,
        AddressData address) {
}
