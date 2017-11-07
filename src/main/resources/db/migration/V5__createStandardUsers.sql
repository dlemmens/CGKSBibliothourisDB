insert users (Inss, last_name, password, city)
values  ('user', 'Standard User', 'user', 'userville'),
        ('librarian', 'Standard Librarian', 'librarian', 'librarianville'),
        ('admin', 'Standard Admin', 'admin', 'adminville');

insert into user_with_role (u_id, r_id)
values  ((select u.id from users u where u.inss = 'user'),
            (select r.id from role r where r.role = 'user')),
        ((select u.id from users u where inss = 'librarian'),
            (select r.id from role r where r.role = 'librarian')),
        ((select u.id from users u where inss = 'librarian'),
            (select r.id from role r where r.role = 'user')),
        ((select u.id from users u where inss = 'admin'),
            (select r.id from role r where r.role = 'admin')),
        ((select u.id from users u where inss = 'admin'),
            (select r.id from role r where r.role = 'librarian')),
        ((select u.id from users u where inss = 'admin'),
            (select r.id from role r where r.role = 'user'));