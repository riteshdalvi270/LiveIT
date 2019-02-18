CREATE TABLE Restaurants (
id INT AUTO_INCREMENT,
name VARCHAR(200) NOT NULL,
address VARCHAR(250) NOT NULL,
visitedDate DATETIME,
webURL VARCHAR(500),
yelpURL VARCHAR(500),
cuisineId INT NOT NULL,
ourRating INT NOT NULL,
expense  VARCHAR(4),
amtPaid DECIMAL(5,2) NOT NULL,
isClosed BOOLEAN NOT NULL,
versionStartDate TIMESTAMP DEFAULT now(),
versionEndDate TIMESTAMP,
venueId INT NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY(cuisineId) REFERENCES cuisine(id),
FOREIGN KEY(venueId) REFERENCES venue(id)
)ENGINE=INNODB;