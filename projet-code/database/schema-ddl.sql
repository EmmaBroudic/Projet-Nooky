CREATE TABLE "categories" (
    id SERIAL PRIMARY KEY,
    category_reference VARCHAR(10) UNIQUE NOT NULL,
    category VARCHAR(50) UNIQUE NOT NULL,
    description VARCHAR(400)
);

CREATE TABLE "sizes" (
    id SERIAL PRIMARY KEY,
    size_reference VARCHAR(10) UNIQUE NOT NULL,
    size VARCHAR(6) UNIQUE NOT NULL
);

CREATE TABLE "types" (
    id SERIAL PRIMARY KEY,
    type_reference VARCHAR(10) UNIQUE NOT NULL,
    type VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE "addresses" (
    id SERIAL,
    road VARCHAR(150) NOT NULL,
    zip_code CHAR(5) NOT NULL,
    city VARCHAR(50) NOT NULL,
    PRIMARY KEY (road, zip_code, city)
);

CREATE TABLE "users" (
    id SERIAL PRIMARY KEY,
    email VARCHAR(254) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    username VARCHAR(50) UNIQUE NOT NULL,
    firstname VARCHAR(50),
    lastname VARCHAR(50),
    picture VARCHAR(1000),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    road VARCHAR(150),
    zip_code CHAR(5),
    city VARCHAR(50),
    FOREIGN KEY (road, zip_code, city) REFERENCES addresses
);

CREATE TABLE "products" (
    id SERIAL PRIMARY KEY,
    product_reference VARCHAR(20) UNIQUE NOT NULL,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(400),
    picture VARCHAR(1000),
    added_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    available BOOLEAN NOT NULL,
    category_id INT,
    size_id INT,
    type_id INT,
    user_id INT,
    FOREIGN KEY (category_id) REFERENCES categories(id),
    FOREIGN KEY (size_id) REFERENCES sizes(id),
    FOREIGN KEY (type_id) REFERENCES types(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE "wished_products" (
    email VARCHAR(254),
    wished_product INT,
    proposed_product INT,
    PRIMARY KEY (email, wished_product, proposed_product),
    FOREIGN KEY (email) REFERENCES users(email),
    FOREIGN KEY(wished_product) REFERENCES products(id),
    FOREIGN KEY(proposed_product) REFERENCES products(id)
);
