CREATE TABLE ROLE(
  id INT PRIMARY KEY,
  role VARCHAR(100)
);

INSERT INTO ROLE (id, role)
VALUES (1, 'USER'), (2, 'LIBRARIAN'), (3, 'ADMIN');

CREATE TABLE USER_WITH_ROLE(
    id INT PRIMARY KEY AUTO_INCREMENT,
    u_id INT,
    r_id INT,
    CONSTRAINT FK_UserId FOREIGN KEY (u_id) REFERENCES USERS(id),
    CONSTRAINT FK_RoleId FOREIGN KEY (r_id) REFERENCES ROLE(id)
);