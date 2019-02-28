package com.liveit.repository.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Genre")
@Data
public class Genre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genreId")
    private short genreId;

    @Column(name = "type")
    private String type;

    @OneToOne(mappedBy = "genre", fetch = FetchType.LAZY)
    private MovieEntity movieEntity;
}
