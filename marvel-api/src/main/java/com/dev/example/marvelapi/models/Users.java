package com.dev.example.marvelapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;


/**
 * Entidad que almacena informacion de usuarios.
 *
 * @author Mauricio González
 */
@Entity()
@Getter @Setter @NoArgsConstructor
@Table(name="users")
@JsonIgnoreProperties({"id", "password"})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // will be set when persisting
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String password;
    @Column(name = "created_at")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createdAt;
}
