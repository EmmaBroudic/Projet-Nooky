-- Seeds pour la table "categories"
INSERT INTO categories (reference, description) VALUES
('CAT001', 'Kids'),
('CAT002', 'Women'),
('CAT003', 'Men');

-- Seeds pour la table "sizes" (considérant uniquement des tailles de vêtements et de chaussures)
INSERT INTO sizes (reference, description) VALUES
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

-- Seeds pour la table "types"
INSERT INTO types (reference, description) VALUES
('TYP001', 'T-Shirt'),
('TYP002', 'Pantalon'),
('TYP003', 'Escarpins'),
('TYP004', 'Montre'),
('TYP005', 'Sac à dos');

-- Seeds pour la table "addresses" (adresses fictives en France)
INSERT INTO addresses (road, zip_code, city) VALUES
('1 Rue de la Mode', '75001', 'Paris'),
('5 Avenue du Style', '69001', 'Lyon'),
('10 Rue de la Chaussure', '33000', 'Bordeaux');

-- Seeds pour la table "users" (noms français et adresses en France)
INSERT INTO users (email, password, username, firstname, lastname, picture, created_at, address_id) VALUES
('user1@example.com', 'password123', 'utilisateur1', 'Jean', 'Dupont', 'https://example.com/user1.jpg', CURRENT_TIMESTAMP, 1),
('user2@example.com', 'password456', 'utilisateur2', 'Marie', 'Dubois', 'https://example.com/user2.jpg', CURRENT_TIMESTAMP, 2),
('user3@example.com', 'password789', 'utilisateur3', 'Pierre', 'Durand', 'https://example.com/user3.jpg', CURRENT_TIMESTAMP, 3);

-- Seeds pour la table "products" (exemples de produits variés)
INSERT INTO products (reference, name, description, picture, added_at, available, category_id, size_id, type_id, user_id) VALUES
('PROD001', 'T-Shirt Noir', 'T-Shirt noir basique', 'https://example.com/tshirt_noir.jpg', CURRENT_TIMESTAMP, true, 1, 3, 1, 1),
('PROD002', 'Chemise à carreaux', 'Chemise à carreaux rouge et bleue', 'https://example.com/chemise_carreaux.jpg', CURRENT_TIMESTAMP, true, 1, 3, 1, 2),
('PROD003', 'Baskets Blanches', 'Baskets blanches à lacets', 'https://example.com/baskets_blanches.jpg', CURRENT_TIMESTAMP, true, 2, 6, 3, 3),
('PROD004', 'Montre en cuir', 'Montre-bracelet en cuir marron', 'https://example.com/montre_cuir.jpg', CURRENT_TIMESTAMP, true, 3, NULL, 4, 1);

-- Seeds pour la table "wished_products" (exemple de produits souhaités)
INSERT INTO wished_products (user_id, wished_product_id, proposed_product_id) VALUES
(1, 1, 3),
(2, 2, 4),
(3, 3, 1);