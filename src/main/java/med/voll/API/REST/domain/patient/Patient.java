package med.voll.API.REST.domain.patient;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.API.REST.domain.address.Address;

@Table(name = "patients")
@Entity(name = "Patient")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String document;

    private boolean active;

    @Embedded
    private Address address;

    public Patient(RegisterPatient data) {
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.document =  data.document();
        this.address = new Address(data.address());
        this.active = true;
    }

    public void update(UpdatePatient data) {
        if(data.name() != null) {
            this.name = data.name();
        }
        if(data.phone() != null) {
            this.phone = data.phone();
        }
        if(data.address() != null) {
            this.address.update(data.address());
        }
    }

    public void delete() {
        this.active = false;
    }
}
