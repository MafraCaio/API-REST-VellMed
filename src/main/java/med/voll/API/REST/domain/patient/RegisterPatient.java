package med.voll.API.REST.domain.patient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.API.REST.domain.address.AddressData;

public record RegisterPatient(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String phone,
        @NotBlank
        String document,
        @NotNull
        @Valid
        AddressData address
) {
}
