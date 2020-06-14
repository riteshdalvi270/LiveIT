package com.liveit.repository.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Venue")
@Setter
@Getter
public class Venue implements Serializable {

    private static final long serialVersionUID = 1L;

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
