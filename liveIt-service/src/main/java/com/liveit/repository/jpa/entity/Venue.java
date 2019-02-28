package com.liveit.repository.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Venue")
@Data
public class Venue implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "venueId")
    private short venueId;

    @Column(name = "type")
    private String type;

    @OneToOne(mappedBy = "venue",fetch = FetchType.LAZY)
    @JsonIgnore
    private MovieEntity movieEntity;
}
