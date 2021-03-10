DELETE FROM COURSE;

INSERT INTO COURSE(NAME, DURATION) VALUES('Java-1', 10);
INSERT INTO COURSE(NAME, DURATION) VALUES('Java-2', 20);
INSERT INTO COURSE(NAME, DURATION) VALUES('Java-3', 30);
INSERT INTO COURSE(NAME, DURATION) VALUES('Java-4', 40);
INSERT INTO COURSE(NAME, DURATION) VALUES('Java-5', 50);
INSERT INTO COURSE(NAME, DURATION) VALUES('Java-6', 60);
INSERT INTO COURSE(NAME, DURATION) VALUES('Java-7', 70);
INSERT INTO COURSE(NAME, DURATION) VALUES('Java-8', 80);

create table if not exists users(
    username varchar(50) not null primary key,
    password varchar(150) not null,
    enabled boolean not null
);

create table if not exists authorities(
    username varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key(username) references users(username)
);

CREATE UNIQUE index IF NOT EXISTS ix_auth_username on authorities(username, authority);

-- DELETE FROM AUTHORITIES;
-- DELETE FROM users;
-- INSERT INTO users(username, password, enabled) VALUES('admin', '$2a$10$wrqJsQwb77GmKXgirfnp.elL/l0BMTUCgqazKv2kvs.mdpG6regfi', true);
-- INSERT INTO authorities(username, authority) VALUES('admin', 'ROLE_ADMIN');