package med.voll.API.REST.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.API.REST.endereco.Address;

// Entity JPA

@Table(name = "doctors")
@Entity(name = "Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    private boolean active;

    @Embedded
    private Address address;

    public Doctor(RegisterDoctor data) {
        this.name =  data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.crm = data.crm();
        this.specialty =  data.specialty();
        this.address = new Address(data.address());
        this.active = true;
    }

    public void update(UpdateDoctor data) {
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
