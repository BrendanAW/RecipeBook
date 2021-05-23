INSERT INTO recipe (name, IMAGE_LOCATION, PORTION_SIZE, TIME_TO_MAKE)
values ('Broccoli Stew', '/images/1.jpg', 4, '6 hours');

INSERT INTO recipe (name, IMAGE_LOCATION)
values ('Tofu', '/images/2.jpg');

INSERT INTO recipe (name, IMAGE_LOCATION, PORTION_SIZE, TIME_TO_MAKE)
values ('Tofu Stew', '/images/1.jpg', 4, '6 hours');

INSERT INTO recipe (name, IMAGE_LOCATION)
values ('Tofurukey', '/images/2.jpg');

INSERT INTO recipe (name, IMAGE_LOCATION, PORTION_SIZE, TIME_TO_MAKE)
values ('Sssk Stew', '/images/1.jpg', 4, '6 hours');

INSERT INTO recipe (name, IMAGE_LOCATION)
values ('Squimbles', '/images/2.jpg');

INSERT INTO recipe (name, IMAGE_LOCATION, PORTION_SIZE, TIME_TO_MAKE)
values ('Whiplash Stew', '/images/1.jpg', 4, '6 hours');

INSERT INTO recipe (name, IMAGE_LOCATION)
values ('Smark', '/images/2.jpg');

INSERT
INTO ingredient (name, preparation, amount, measurement, recipe_id)
values ('Broccoli', 'Cut into florets', 500, 'GRAM', 1);

INSERT
INTO ingredient (name, preparation, amount, measurement, recipe_id)
values ('Stew', 'stew it', 200, 'MILLILITER', 1);

INSERT INTO category (name)
values ('Dinner');

INSERT INTO recipes_categories (recipe_id, category_id)
values (1, 1);

INSERT INTO shopping_list_item (name, removable)
values ('2 bottles of ketchup', false);

INSERT INTO recipe_instructions (recipe_id, instructions)
values (1, 'rub it against your butt');

INSERT INTO recipe_instructions (recipe_id, instructions)
values (1, 'then you lick it');