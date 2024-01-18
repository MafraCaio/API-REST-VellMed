package med.voll.API.REST.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.API.REST.endereco.AddressData;

public record UpdateDoctor(
        @NotNull
        Long id,
        String name,
        String phone,
        AddressData address) {
}
