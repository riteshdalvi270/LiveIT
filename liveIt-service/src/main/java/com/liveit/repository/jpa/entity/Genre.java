package com.liveit.repository.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Genre")
@Setter
@Getter
public class Genre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genreId")
    private short genreId;

    @Column(name = "type")
    private String type;

    @OneToOne(mappedBy = "genre", fetch = FetchType.LAZY)
    @JsonIgnore
    private MovieEntity movieEntity;
}
