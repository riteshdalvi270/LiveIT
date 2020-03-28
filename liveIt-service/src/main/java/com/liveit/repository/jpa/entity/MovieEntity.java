package com.liveit.repository.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

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
	private Date releasedDate;

	@Column(name = "watchDate")
	private Date watchDate;

	@OneToOne
	@JoinColumn(name = "venueId", referencedColumnName = "venueId")
	private Venue venue;

	@Column(name = "amountPayed")
	private BigDecimal amountPayed;

	@Column(name = "screenMode")
	private String screenMode;

	@Column(name = "ourRating")
	private short ourRating;

	@OneToOne
	@JoinColumn(name = "genreId", referencedColumnName = "genreId")
	private Genre genre;

	@Column(name = "imdbURL")
	private String imdbURL;

	@Column(name = "rottenTomatoesURL")
	private String rottenTomatoesURL;

	@Column(name = "versionStartDate")
	private Date versionStartDate;

	@Column(name = "versionEndDate")
	private Date versionEndDate;
}
