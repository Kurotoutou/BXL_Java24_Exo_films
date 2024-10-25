package be.digitalycity.java.bxl_java24_exo_films.dl.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
public class Film extends BaseEntity{

    @Column(nullable = false, length = 123)
    private String title;

    @Column(nullable = false)
    private LocalTime duration;

    @Column(nullable = false, length = 300)
    private String pitch;

    @Column(nullable = false)
    private LocalDate release;

    private String picture;

    @ManyToOne(fetch = FetchType.EAGER)
    private Director director;

    public Film(UUID id, String title, LocalTime duration) {
        super(id);
        this.title = title;
        this.duration = duration;
    }

    public Film(UUID id, String title, LocalTime duration, String pitch, LocalDate release, Director director) {
        super(id);
        this.title = title;
        this.duration = duration;
        this.pitch = pitch;
        this.release = release;
        this.director = director;
    }

    public Film(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, String title, LocalTime duration, String pitch, LocalDate release, Director director) {
        super(id);
        this.title = title;
        this.duration = duration;
        this.pitch = pitch;
        this.release = release;
        this.director = director;
    }
}
