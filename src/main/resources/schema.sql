CREATE TABLE IF NOT EXISTS contacts (
  id BIGINT (11) NOT NULL AUTO_INCREMENT,
  firstName VARCHAR(30) NOT NULL,
  lastName VARCHAR(50) NOT NULL ,
  phoneNumber VARCHAR(13),
  emailAddress VARCHAR(30)
  PRIMARY KEY (id)
) ENGINE = INNODB AUTO_INCREMENT=17621402 DEFAULT CHARSET = utf8;