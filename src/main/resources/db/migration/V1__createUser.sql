CREATE TABLE USERS(
  id INT PRIMARY KEY AUTO_INCREMENT,
  Inss VARCHAR(15) UNIQUE NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  first_name VARCHAR(100),
  password varchar(100) not null,
  street VARCHAR(100),
  house_number VARCHAR(15),
  postal_code VARCHAR(15),
  city VARCHAR(100) NOT NULL
)