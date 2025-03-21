create table if not exists users(
    id int primary key AUTO_INCREMENT,
    name varchar(100),
    password varchar(100)
);

insert into users(name, password)
values('john','qwerty'),('Jane','1234');

select * from users;