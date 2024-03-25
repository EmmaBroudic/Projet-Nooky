CREATE TABLE "categories" (
    id SERIAL PRIMARY KEY,
    category_reference VARCHAR(100) NOT NULL,
    category VARCHAR(100) NOT NULL,
    description VARCHAR(400)
);

CREATE TABLE "sizes" (
    id SERIAL PRIMARY KEY,
    size_reference VARCHAR(100) NOT NULL,
    size VARCHAR(6) NOT NULL
);

CREATE TABLE "types" (
    id SERIAL PRIMARY KEY,
    type_reference VARCHAR(100) NOT NULL,
    type VARCHAR(100) NOT NULL
);

CREATE TABLE "addresses" (
    id SERIAL,
    road VARCHAR(100) NOT NULL,
    zip_code INT NOT NULL,
    city VARCHAR(100) NOT NULL,
    PRIMARY KEY (road, zip_code, city)
);

CREATE TABLE "users" (
    id SERIAL PRIMARY KEY,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    username VARCHAR(100) UNIQUE,
    firstname VARCHAR(100),
    lastname VARCHAR(100),
    picture VARCHAR(250),
    created_at CURRENT_TIMESTAMP,
    road VARCHAR(100),
    zip_code INT,
    city VARCHAR(100),
    FOREIGN KEY (road, zip_code, city) REFERENCES addresses
);


CREATE TABLE "products" (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(400),
    picture VARCHAR(250),
    added_at CURRENT_TIMESTAMP,
    available BOOLEAN NOT NULL,
    category_id INT,
    size_id INT,
    type_id INT,
    user_id INT,
    FOREIGN KEY (category_id) REFERENCES categories(id),
    FOREIGN KEY (size_id) REFERENCES sizes(id),
    FOREIGN KEY (type_id) REFERENCES types(id),
    FOREIGN KEY (userid) REFERENCES user(id)
);

CREATE TABLE "wished_product" (
    email VARCHAR(100),
    wished_product VARCHAR(100),
    proposed_product VARCHAR(100),
    FOREIGN KEY (email) REFERENCES users(email),
    FOREIGN KEY(wished_product) REFERENCES products(id),
    FOREIGN KEY(proposed_product) REFERENCES products(id),
    PRIMARY KEY (email, wished_product, proposed_product)
);
