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

CREATE TABLE "status" (
    id SERIAL PRIMARY KEY,
    code VARCHAR(10),
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
    firstname VARCHAR(50),
    lastname VARCHAR(50),
    picture VARCHAR(1000),
    created_at TIMESTAMP,
    address_id INT NOT NULL,
    FOREIGN KEY (address_id) REFERENCES addresses(id)
);

CREATE TABLE "products" (
    id SERIAL PRIMARY KEY,
    reference VARCHAR(20) UNIQUE NOT NULL,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(400),
    picture VARCHAR(1000),
    added_at TIMESTAMP,
    wishlist VARCHAR(200),
    category_id INT,
    size_id INT,
    type_id INT,
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
    from_a_user_id INT NOT NULL,
    to_another_user_id INT NOT NULL,
    status_id INT NOT NULL,
    CONSTRAINT exchanges_ukey UNIQUE (product_offered_id, product_exchanged_id, from_a_user_id, to_another_user_id),
    FOREIGN KEY(product_offered_id) REFERENCES products(id),
    FOREIGN KEY(product_exchanged_id) REFERENCES products(id),
    FOREIGN KEY(from_a_user_id) REFERENCES users(id),
    FOREIGN KEY(to_another_user_id) REFERENCES users(id),
    FOREIGN KEY(status_id) REFERENCES status(id)
);

INSERT INTO categories (reference, label) VALUES
('CAT001', 'Kids'),
('CAT002', 'Women'),
('CAT003', 'Men');

INSERT INTO sizes (reference, label) VALUES
('SIZ001', 'XS'),
('SIZ002', 'S'),
('SIZ003', 'M'),
('SIZ004', 'L'),
('SIZ005', 'XL'),
('SIZ006', '39'),
('SIZ007', '40'),
('SIZ008', '41'),
('SIZ009', '42'),
('SIZ010', '43'),
('SIZ011', '44');

INSERT INTO types (reference, label) VALUES
('TYP001', 'T-Shirt'),
('TYP002', 'Pantalon'),
('TYP003', 'Escarpins'),
('TYP004', 'Montre'),
('TYP005', 'Sac à dos');

INSERT INTO status (code, description) VALUES
('COD1', 'Livrer le produit à !'),
('COD2', 'Proposition échange de'),
('COD3', 'Refus échange de');

INSERT INTO addresses (road, zip_code, city) VALUES
('1 Rue de la Mode', '75001', 'Paris'),
('5 Avenue du Style', '69001', 'Lyon'),
('10 Rue de la Chaussure', '33000', 'Bordeaux');

INSERT INTO users (email, password, username, firstname, lastname, picture, created_at, address_id) VALUES
('user1@example.com', '$2a$12$WKxz27iChcbPj8uJUeFXpeh7alLYMrXMRUErQkgHlwZEb3rEQC5Xa', 'utilisateur1', 'Jean', 'Dupont', 'https://example.com/user1.jpg', CURRENT_TIMESTAMP,
    (SELECT id FROM addresses WHERE road = '10 Rue de la Chaussure' AND zip_code = '33000' AND city = 'Bordeaux')),
('user2@example.com', '$2a$12$gUxCdCHIrmierqlXqqZJGucaG67w7cCMsBRG64G83z38sCx9kOsya', 'utilisateur2', 'Marie', 'Dubois', 'https://example.com/user2.jpg', CURRENT_TIMESTAMP,
    (SELECT id FROM addresses WHERE road = '5 Avenue du Style' AND zip_code = '69001' AND city = 'Lyon')),
('user3@example.com', '$2a$12$PjCkYMnJwewts1F3pC365ODrmjRQcJtEUCEQWUPJIOqZJJGqdiUJe', 'utilisateur3', 'Pierre', 'Durand', 'https://example.com/user3.jpg', CURRENT_TIMESTAMP,
    (SELECT id FROM addresses WHERE road = '10 Rue de la Chaussure' AND zip_code = '33000' AND city = 'Bordeaux')),
('user4@example.com', '$2a$12$kt/QTiRrqo1uSPBQ0.F4Be2w2QuBC180JTAW/cZEThJK1x9HJfCTa', 'utilisateur4', 'Nathalie', 'Durand', 'https://example.com/user4.jpg', CURRENT_TIMESTAMP,
    (SELECT id FROM addresses WHERE road = '10 Rue de la Chaussure' AND zip_code = '33000' AND city = 'Bordeaux'));

INSERT INTO products (reference, name, description, picture, added_at, wishlist, category_id, size_id, type_id, user_id) VALUES
('PROD001', 'T-Shirt Noir', 'T-Shirt noir basique', 'https://example.com/tshirt_noir.jpg', CURRENT_TIMESTAMP, 'Ma liste de souhaits est la suivante : jean bleu en taille 36 ou vêtements enfants à partir de 6 ans',
    (SELECT id FROM categories WHERE reference = 'CAT001'),
    (SELECT id FROM sizes WHERE reference = 'SIZ001'),
    (SELECT id FROM types WHERE reference = 'TYP001'),
    (SELECT id FROM users WHERE email = 'user1@example.com')),
('PROD002', 'Chemise à carreaux', 'Chemise à carreaux rouge et bleue', 'https://example.com/chemise_carreaux.jpg', CURRENT_TIMESTAMP, 'Ma liste de souhaits est la suivante : veste noire en taille 40, pantalon noir en taille 40 ou chemises hommes en taille L',
    (SELECT id FROM categories WHERE reference = 'CAT001'),
    (SELECT id FROM sizes WHERE reference = 'SIZ001'),
    (SELECT id FROM types WHERE reference = 'TYP001'),
    (SELECT id FROM users WHERE email = 'user2@example.com')),
('PROD003', 'Baskets Blanches', 'Baskets blanches à lacets', 'https://example.com/baskets_blanches.jpg', CURRENT_TIMESTAMP, 'Ma liste de souhaits est la suivante : chapeaux de tous types',
    (SELECT id FROM categories WHERE reference = 'CAT003'),
    (SELECT id FROM sizes WHERE reference = 'SIZ001'),
    (SELECT id FROM types WHERE reference = 'TYP001'),
    (SELECT id FROM users WHERE email = 'user3@example.com')),
('PROD004', 'Montre en cuir', 'Montre-bracelet en cuir marron', 'https://example.com/montre_cuir.jpg', CURRENT_TIMESTAMP, 'Ma liste de souhaits est la suivante : chaussures en taille 38',
    (SELECT id FROM categories WHERE reference = 'CAT002'),
    (SELECT id FROM sizes WHERE reference = 'SIZ001'),
    (SELECT id FROM types WHERE reference = 'TYP005'),
    (SELECT id FROM users WHERE email = 'user4@example.com'));

INSERT INTO exchanges (product_offered_id, product_exchanged_id, from_a_user_id, to_another_user_id, status_id) VALUES
    ((SELECT id FROM products WHERE reference = 'PROD001'), (SELECT id FROM products WHERE reference = 'PROD002'), (SELECT id FROM users WHERE email = 'user1@example.com'), (SELECT id FROM users WHERE email = 'user2@example.com'), (SELECT id FROM status WHERE code = 'COD1')),
    ((SELECT id FROM products WHERE reference = 'PROD001'), (SELECT id FROM products WHERE reference = 'PROD004'), (SELECT id FROM users WHERE email = 'user1@example.com'), (SELECT id FROM users WHERE email = 'user3@example.com'), (SELECT id FROM status WHERE code = 'COD3')),
    ((SELECT id FROM products WHERE reference = 'PROD003'), (SELECT id FROM products WHERE reference = 'PROD004'), (SELECT id FROM users WHERE email = 'user2@example.com'), (SELECT id FROM users WHERE email = 'user3@example.com'), (SELECT id FROM status WHERE code = 'COD2'));