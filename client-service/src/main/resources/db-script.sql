

DROP TABLE IF EXISTS `client`;

CREATE TABLE `client` (
  `username` varchar(100) NOT NULL,
  `firstName` varchar(100) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  `address` varchar(200) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`username`)
);


INSERT INTO `client` VALUES ('anudissa','anula','dissanayaka','anuradhapura','686f2160bc1b0928c46ec5f9b87d65490306e018bdfafbae4fbc03e1e0aa70b5'),('isurath','isuru','rathnayaka','ampara','72a68be888fa2906ea23bfd8167cf2cd9205e5a5f7ace1604db82fa194fd2564'),('nipueee','nipuni','pavithra','talawa','b5fda1d0c402698d48deec5b5caca17ba3b63b6fffba8a17cee59eea37579260'),('nipunipu','nipunija','dissanayaka','talawa','4396aaf7e48af0f665e0fb70382bf800c93b28f889c7e5470d60785177103c29'),('pavijaya','J.Nipuni','Jayathilaka','Andarawewa road, Talawa','da3be815135c2fdf75d28587dea512cf4f205fe414d9d03fe0db66137afd1d3d');
