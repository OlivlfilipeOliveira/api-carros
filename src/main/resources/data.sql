insert into role(id,name) values (1, 'ROLE_USER');
insert into role(id,name) values (2, 'ROLE_ADMIN');

insert into user(id,name,email,login,password) values (1,'Ricardo Lecheta','rlecheta@gmail.com','rlecheta','$2a$10$HKveMsPlst41Ie2LQgpijO691lUtZ8cLfcliAO1DD9TtZxEpaEoJe');
insert into user(id,name,email,login,password) values (2,'Admin','admin@gmail.com','admin','$2a$10$HKveMsPlst41Ie2LQgpijO691lUtZ8cLfcliAO1DD9TtZxEpaEoJe');
insert into user(id,name,email,login,password) values (3,'User','user@gmail.com','user','$2a$10$HKveMsPlst41Ie2LQgpijO691lUtZ8cLfcliAO1DD9TtZxEpaEoJe');

insert into user_roles(user_id,role_id) values(1, 1);
insert into user_roles(user_id,role_id) values(2, 2);
insert into user_roles(user_id,role_id) values(3, 1);