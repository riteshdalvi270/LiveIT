package com.liveit.repository.jpa.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="Movies")
@Data
@Builder
public class MovieEntity {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="movieId")
	private int movieId;

	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;

	@Column(name = "releasedDate")
	private LocalDate releasedDate;

	@Column(name = "watchDate")
	private LocalDate watchDate;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Venue venue;

	@Column(name = "amountPayed")
	private BigDecimal amountPayed;

	@Column(name = "screenMode")
	private String screenMode;

	@Column(name = "ourRating")
	private short ourRating;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Genre genre;

	@Column(name = "imdbURL")
	private String imdbURL;

	@Column(name = "rottenTomatoesURL")
	private String rottenTomatoesURL;

	@Column(name = "versionStartDate")
	private LocalDate versionStartDate;

	@Column(name = "versionEndDate")
	private LocalDate versionEndDate;
}
