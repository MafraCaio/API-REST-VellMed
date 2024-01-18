package med.voll.API.REST.domain.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Entity JPA

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String road;
    private String neighborhood;
    private String zip_code;
    private String house_number;
    private String complement;
    private String city;
    private String country;

    public Address(AddressData data) {
        this.road = data.road();
        this.neighborhood = data.neighborhood();
        this.zip_code = data.zip_code();
        this.country = data.country();
        this.city = data.city();
        this.house_number = data.house_number();
        this.complement = data.complement();
    }

    public void update(AddressData data) {
        if(data.road() != null) {
            this.road = data.road();
        }
        if(data.neighborhood() != null) {
            this.neighborhood = data.neighborhood();
        }
        if(data.zip_code() != null) {
            this.zip_code = data.zip_code();
        }
        if(data.country() != null) {
            this.country = data.country();
        }
        if(data.city() != null) {
            this.city = data.city();
        }
        if(data.house_number() != null) {
            this.house_number = data.house_number();
        }
        if(data.complement() != null) {
            this.complement = data.complement();
        }
    }
}
