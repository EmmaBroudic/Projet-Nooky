CREATE TABLE "categories" (
    id SERIAL PRIMARY KEY,
    reference VARCHAR(10) UNIQUE NOT NULL,
    label VARCHAR(50) NOT NULL
);

CREATE TABLE "sizes" (
    id SERIAL PRIMARY KEY,
    reference VARCHAR(10) UNIQUE NOT NULL,
    label VARCHAR(6) NOT NULL
);

CREATE TABLE "types" (
    id SERIAL PRIMARY KEY,
    reference VARCHAR(10) UNIQUE NOT NULL,
    label VARCHAR(50) NOT NULL
);

CREATE TABLE "notifications" (
    id SERIAL PRIMARY KEY,
    reference VARCHAR(10) UNIQUE NOT NULL,
    content VARCHAR(300)
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
    firstname VARCHAR(50),
    lastname VARCHAR(50),
    picture VARCHAR(1000),
    created_at TIMESTAMP,
    address_id INT,
    FOREIGN KEY (address_id) REFERENCES addresses(id)
);

CREATE TABLE "products" (
    id SERIAL PRIMARY KEY,
    reference VARCHAR(20) UNIQUE NOT NULL,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(400),
    picture VARCHAR(1000),
    added_at TIMESTAMP,
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
    id SERIAL PRIMARY KEY,
    user_id INT,
    wished_product_id INT,
    proposed_product_id INT,
    CONSTRAINT wished_products_ukey UNIQUE (user_id, wished_product_id, proposed_product_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY(wished_product_id) REFERENCES products(id),
    FOREIGN KEY(proposed_product_id) REFERENCES products(id)
);

CREATE TABLE "user_gets_notifs" (
    id SERIAL PRIMARY KEY,
    user_id INT,
    from_another_user_id INT,
    notification_id INT,
    product_id INT,
    CONSTRAINT user_gets_notifs_ukey UNIQUE (from_another_user_id, user_id, notification_id, product_id),
    FOREIGN KEY(user_id) REFERENCES users(id),
    FOREIGN KEY(from_another_user_id) REFERENCES users(id),
    FOREIGN KEY(notification_id) REFERENCES notifications(id),
    FOREIGN KEY(product_id) REFERENCES products(id)
);