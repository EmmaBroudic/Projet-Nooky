CREATE TABLE "categories" (
    id SERIAL PRIMARY KEY,
    category_reference VARCHAR(100),
    category VARCHAR(100),
    description VARCHAR(400)
);

CREATE TABLE "sizes" (
    id SERIAL PRIMARY KEY,
    size_reference VARCHAR(100),
    size VARCHAR(6)
);

CREATE TABLE "types" (
    id SERIAL PRIMARY KEY,
    type_reference VARCHAR(100),
    type VARCHAR(100)
);

CREATE TABLE "addresses" (
    id SERIAL,
    road VARCHAR(100),
    zip_code INT,
    city VARCHAR(100),
    PRIMARY KEY (road, zip_code, city)
);

CREATE TABLE "users" (
    id SERIAL PRIMARY KEY,
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100),
    username VARCHAR(100) UNIQUE,
    firstname VARCHAR(100),
    lastname VARCHAR(100),
    picture VARCHAR(250),
    created_at CURRENT_TIMESTAMP,
    FOREIGN KEY (road, zip_code, city) REFERENCES addresses
);


CREATE TABLE "products" (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    description VARCHAR(400),
    picture VARCHAR(250),
    added_at CURRENT_TIMESTAMP,
    available BOOLEAN,
    FOREIGN KEY (id) REFERENCES categories,
    FOREIGN KEY (id) REFERENCES sizes,
    FOREIGN KEY (id) REFERENCES types,
    FOREIGN KEY (id) REFERENCES user
);

CREATE TABLE "wished_product" (
    email VARCHAR(100),
    wished_product VARCHAR(100),
    proposed_product VARCHAR(100),
    FOREIGN KEY (email) REFERENCES users,
    FOREIGN KEY(wished_product) REFERENCES products(id),
    FOREIGN KEY(proposed_product) REFERENCES products(id),
    PRIMARY KEY (email, wished_product, proposed_product)
);
