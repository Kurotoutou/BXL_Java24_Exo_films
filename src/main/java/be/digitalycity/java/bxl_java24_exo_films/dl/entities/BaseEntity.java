package be.digitalycity.java.bxl_java24_exo_films.dl.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Getter
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(of = {"id"}) @ToString
public abstract class BaseEntity {

    @Id
    @Setter
    private UUID id;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public BaseEntity(UUID id) {
        this.id = id;
    }
}
