CREATE TABLE "categories" (
    id SERIAL PRIMARY KEY,
    reference VARCHAR(10) UNIQUE NOT NULL,
    label VARCHAR(50) NOT NULL
);

CREATE TABLE "sizes" (
    id SERIAL PRIMARY KEY,
    reference VARCHAR(10) UNIQUE NOT NULL,
    label VARCHAR(50) NOT NULL
);

CREATE TABLE "types" (
    id SERIAL PRIMARY KEY,
    reference VARCHAR(10) UNIQUE NOT NULL,
    label VARCHAR(50) NOT NULL
);

CREATE TABLE "status" (
    id SERIAL PRIMARY KEY,
    code VARCHAR(10) UNIQUE NOT NULL,
    description VARCHAR(200) NOT NULL
);

CREATE TABLE "addresses" (
    id SERIAL PRIMARY KEY,
    road VARCHAR(150) NOT NULL,
    zip_code CHAR(5) NOT NULL,
    city VARCHAR(50) NOT NULL,
    CONSTRAINT addresses_ukey UNIQUE (road, zip_code, city)
);

CREATE TABLE "users" (
    id SERIAL PRIMARY KEY,
    email VARCHAR(254) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    username VARCHAR(50) UNIQUE NOT NULL,
    description VARCHAR(400),
    picture VARCHAR(1000),
    firstname VARCHAR(50),
    lastname VARCHAR(50),
    created_at TIMESTAMP,
    address_id INT NOT NULL,
    FOREIGN KEY (address_id) REFERENCES addresses(id)
);

CREATE TABLE "products" (
    id SERIAL PRIMARY KEY,
    reference VARCHAR(1000) UNIQUE NOT NULL,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(400),
    picture VARCHAR(1000),
    added_at TIMESTAMP,
    wishlist VARCHAR(200),
    category_id INT NOT NULL,
    size_id INT NOT NULL,
    type_id INT NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES categories(id),
    FOREIGN KEY (size_id) REFERENCES sizes(id),
    FOREIGN KEY (type_id) REFERENCES types(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE "exchanges" (
    id SERIAL PRIMARY KEY,
    product_offered_id INT NOT NULL,
    product_exchanged_id INT NOT NULL,
    owner_id INT NOT NULL,
    exchanger_id INT NOT NULL,
    status_id INT NOT NULL,
    CONSTRAINT exchanges_ukey UNIQUE (product_offered_id, product_exchanged_id, owner_id, exchanger_id),
    FOREIGN KEY(product_offered_id) REFERENCES products(id),
    FOREIGN KEY(product_exchanged_id) REFERENCES products(id),
    FOREIGN KEY(owner_id) REFERENCES users(id),
    FOREIGN KEY(exchanger_id) REFERENCES users(id),
    FOREIGN KEY(status_id) REFERENCES status(id)
);



