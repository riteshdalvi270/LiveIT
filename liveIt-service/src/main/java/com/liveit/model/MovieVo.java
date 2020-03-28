package com.liveit.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class MovieVo {

    private int movieID;

    private String name;

    private String type;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate releasedDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate watchDate;

    private String venue;

    private BigDecimal amountPayed;

    private String screenMode;

    private short ourRating;

    private String genre;

    private String imdbURL;

    private String rottenTomatoesURL;

    @JsonIgnore
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime versionStartDate;

    @JsonIgnore
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime versionEndDate;
}
