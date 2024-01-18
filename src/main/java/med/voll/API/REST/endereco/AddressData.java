package med.voll.API.REST.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressData(
        @NotBlank
        String road,
        @NotBlank
        String neighborhood,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String zip_code,
        @NotBlank
        String city,
        @NotBlank
        String country,
        String house_number,
        String complement)
{
}
