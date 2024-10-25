package be.digitalycity.java.bxl_java24_exo_films.dl.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jdk.jfr.Enabled;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
public class Director extends BaseEntity {

    @Column(nullable = false, length = 123)
    private String firstName;

    @Column(nullable = false, length = 80)
    private String lastName;

    @Column(nullable = false)
    private LocalDate birthDate;



    public Director(UUID id, String firstName, String lastName, LocalDate birthDate) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
}
