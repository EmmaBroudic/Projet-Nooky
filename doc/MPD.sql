CREATE TABLE addresses(
   road VARCHAR(150),
   Zip_code CHAR(5),
   city VARCHAR(50),
   PRIMARY KEY(road, Zip_code, city)
);

CREATE TABLE status(
   exchange_code VARCHAR(10),
   exchange_description VARCHAR(200) NOT NULL,
   PRIMARY KEY(exchange_code)
);

CREATE TABLE categories(
   category_reference VARCHAR(10),
   category_label VARCHAR(50) NOT NULL,
   PRIMARY KEY(category_reference)
);

CREATE TABLE types(
   type_reference VARCHAR(10),
   type_label VARCHAR(50) NOT NULL,
   PRIMARY KEY(type_reference)
);

CREATE TABLE sizes(
   size_reference VARCHAR(10),
   size_label VARCHAR(50) NOT NULL,
   PRIMARY KEY(size_reference)
);

CREATE TABLE users(
   email VARCHAR(254),
   password VARCHAR(100) NOT NULL,
   username VARCHAR(50) NOT NULL,
   firstname VARCHAR(50) NOT NULL,
   lastname VARCHAR(50) NOT NULL,
   User_description VARCHAR(400),
   picture VARCHAR(1000),
   created_at TIMESTAMP,
   road VARCHAR(150) NOT NULL,
   Zip_code CHAR(5) NOT NULL,
   city VARCHAR(50) NOT NULL,
   PRIMARY KEY(email),
   FOREIGN KEY(road, Zip_code, city) REFERENCES addresses(road, Zip_code, city)
);

CREATE TABLE products(
   prod_reference VARCHAR(20),
   product_name VARCHAR(50) NOT NULL,
   product_description VARCHAR(400),
   product_picture VARCHAR(1000),
   added_at TIMESTAMP,
   wishlist VARCHAR(200),
   size_reference VARCHAR(10) NOT NULL,
   type_reference VARCHAR(10) NOT NULL,
   category_reference VARCHAR(10) NOT NULL,
   email VARCHAR(254) NOT NULL,
   PRIMARY KEY(prod_reference),
   FOREIGN KEY(size_reference) REFERENCES sizes(size_reference),
   FOREIGN KEY(type_reference) REFERENCES types(type_reference),
   FOREIGN KEY(category_reference) REFERENCES categories(category_reference),
   FOREIGN KEY(email) REFERENCES users(email)
);

CREATE TABLE exchanges(
   prod_reference_prod_exchanged VARCHAR(20),
   prod_reference_prod_offered VARCHAR(20),
   email_owner VARCHAR(254),
   email_exchanger VARCHAR(254),
   exchange_code_prod_offered VARCHAR(10),
   exchange_code_prod_exchanged VARCHAR(10) NOT NULL,
   PRIMARY KEY(prod_reference_prod_exchanged, prod_reference_prod_offered, email_owner, email_exchanger),
   FOREIGN KEY(prod_reference_prod_exchanged) REFERENCES products(prod_reference),
   FOREIGN KEY(prod_reference_prod_offered) REFERENCES products(prod_reference),
   FOREIGN KEY(email_owner) REFERENCES users(email),
   FOREIGN KEY(email_exchanger) REFERENCES users(email),
   FOREIGN KEY(exchange_code_prod_offered) REFERENCES status(exchange_code),
   FOREIGN KEY(exchange_code_prod_exchanged) REFERENCES status(exchange_code)
);
