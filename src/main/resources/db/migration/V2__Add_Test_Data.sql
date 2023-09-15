INSERT INTO hynea.users ("username", "password_hash")
VALUES
('testuser1', 'pbkdf2:sha256:150000$kmRJEFJB$'),
('testuser2', 'pbkdf2:sha256:150000$9XuBAGv3$');

INSERT INTO hynea.menu_item ("title", "serve_time", "weight", "price", "image_name")
VALUES
('Burger', 10, 250, 1299, '8b9dd0ad-a14d-4f61-9af8-f6b90b374cab.beef.webp'),
('Fries', 5, 150, 299, '8b9dd0ad-a14d-4f61-9af8-f6b90b374cab.beef.webp'),
('Salad', 5, 100, 799, '8b9dd0ad-a14d-4f61-9af8-f6b90b374cab.beef.webp'),
('Soft Drink', 2, 350, 199, '8b9dd0ad-a14d-4f61-9af8-f6b90b374cab.beef.webp');

INSERT INTO hynea.ingredient ("title", "dosage")
VALUES
('Beef', 100),
('Bun', 1),
('Ketchup', 1),
('Lettuce', 50),
('Tomato', 1),
('Potato', 200),
('Salt', 10);

INSERT INTO hynea.menu_item_ingredient ("menu_item_id", "ingredient_id")
VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(2, 6),
(2, 7),
(3, 4),
(3, 5);

INSERT INTO hynea.salad ("menu_item_id")
VALUES
(3);

INSERT INTO hynea.drink ("menu_item_id")
VALUES
(4);