package com.liveit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonIgnoreProperties(value= {"id","version_start_date","version_end_date"},allowGetters=true)
@Data
public class MovieVo {

    @JsonProperty("id")
    private long movieID;

    @JsonProperty("movie_name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("released_date")
    private LocalDate releasedDate;

    @JsonProperty("watch_date")
    private LocalDate watchDate;

    @JsonProperty("venue")
    private String venue;

    @JsonProperty("amount_payed")
    private BigDecimal amountPayed;

    @JsonProperty("screen_mode")
    private String screenMode;

    @JsonProperty("our_rating")
    private short ourRating;

    @JsonProperty("genre_id")
    private String genre;

    @JsonProperty("imdb_url")
    private String imdbURL;

    @JsonProperty("rotten_tomatoes_url")
    private String rottenTomatoesURL;

    @JsonProperty("version_start_date")
    private LocalDateTime versionStartDate;

    @JsonProperty("version_end_date")
    private LocalDateTime versionEndDate;
}
