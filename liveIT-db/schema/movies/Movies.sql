create table Movies(
movieId int not null,
name varchar(50) not null,
type varchar(50) not null,
releasedDate date not null,
watchDate date default now(),
venueId smallint not null,
amountPayed decimal(13,2) not null,
screenMode varchar(10) not null default '2D',
ourRating smallint,
genreId smallint,
imdbLink varchar(500),
rottenTomatoesLink varchar(500),
versionStartDate date not null default now(),
Primary Key (movieId),
FOREIGN Key (venueId) REFERENCES VENUE(venueId),
FOREIGN Key (genreId) REFERENCES VENUE(genreId)
);