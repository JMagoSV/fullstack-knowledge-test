package com.dev.example.marvelapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;


/**
 * Entidad que almacena informacion de los eventos.
 *
 * @author Mauricio González
 */
@Entity()
@Getter @Setter @NoArgsConstructor
@Table(name="events")
public class Events implements Serializable {

    private static final long serialVersionUID = 10L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // will be set when persisting
    private String type;
    @Column(name = "user_registered")
    private String userRegistered;
    @Column(name = "created_at")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createdAt;
}
