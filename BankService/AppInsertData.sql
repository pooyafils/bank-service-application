insert into allowed_currencies(id,name) values (1,'EUR');
insert into allowed_currencies(id,name) values (1,'USD');
insert into allowed_currencies(id,name) values (1,'GEP');
insert into allowed_currencies(id,name) values (1,'SEK');


INSERT INTO direction_of_transaction(id, direction) values (1,'IN');
INSERT INTO direction_of_transaction(id, direction) values (1,'OUT');

INSERT INTO customer(ID, COUNTRY, CUSTOMER_ID) VALUES (12,'FRANCE','f509c6d6-d5ed-11ec-9d64-0249ac120001');
INSERT INTO currency(id, account_id, balance, customer_id, name, customer_info) VALUES (67,'f502c6d6-d5ed-20ec-9d64-0249ac120001',120,'f509c6d6-d5ed-11ec-9d64-0249ac120001','EUR',12);

CREATE TABLE direction_of_transaction (
    id int NOT NULL ,
    direction varchar(255) DEFAULT NULL,
    PRIMARY KEY (id)
    ) ;

CREATE TABLE allowed_currencies (
    id int NOT NULL ,
    name varchar(255) DEFAULT NULL,
    PRIMARY KEY (id)
    ) ;

