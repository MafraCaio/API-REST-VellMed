package med.voll.API.REST.domain.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.API.REST.domain.address.AddressData;

public record UpdateDoctor(
        @NotNull
        Long id,
        String name,
        String phone,
        AddressData address) {
}
