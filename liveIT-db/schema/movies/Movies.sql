create table Movies(
movieId int not null auto_increment,
name varchar(50) not null,
type varchar(50) not null,
releasedDate date not null,
watchDate timestamp not null default current_timestamp ,
venueId smallint not null,
amountPayed decimal(13,2) not null,
screenMode varchar(10) not null default '2D',
ourRating smallint,
genreId smallint,
imdbURL varchar(500),
rottenTomatoesURL varchar(500),
versionStartDate timestamp not null default current_timestamp ,
Primary Key (movieId),
FOREIGN Key (venueId) REFERENCES VENUE(venueId),
FOREIGN Key (genreId) REFERENCES Genre(genreId)
);