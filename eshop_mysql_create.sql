CREATE TABLE `user` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`first_name` varchar(55) NOT NULL,
	`last_name` varchar(55) NOT NULL,
	`role` varchar(10) NOT NULL,
	`email` varchar(255) NOT NULL UNIQUE,
	`password` varchar(255) NOT NULL,
	`contact_number` varchar(55),
	PRIMARY KEY (`id`)
);

CREATE TABLE `category` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(55) NOT NULL,
	`description` varchar(55) NOT NULL,
	`is_active` BOOLEAN NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `sub_category` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(55) NOT NULL,
	`description` varchar(55) NOT NULL,
	`is_active` BOOLEAN NOT NULL,
	`category_id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `order` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`total` DECIMAL NOT NULL,
	`order_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`status` varchar(55) NOT NULL DEFAULT 'IN CART',
	`user_id` INT NOT NULL,
	`address_id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `order_item` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`quantity` INT NOT NULL,
	`price` DECIMAL NOT NULL,
	`order_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`total` DECIMAL NOT NULL,
	`order_id` INT NOT NULL,
	`product_id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `product` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(55) NOT NULL,
	`description` varchar(55) NOT NULL,
	`likes` INT NOT NULL,
	`dislikes` INT NOT NULL,
	`category_id` INT NOT NULL,
	`sub_category_id` INT NOT NULL,
	`supplier_id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `images` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`url` varchar(555) NOT NULL,
	`product_id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `product_info` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`size` varchar(10) NOT NULL,
	`quantity` INT NOT NULL,
	`unit_price` DECIMAL NOT NULL,
	`product_id` DECIMAL NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `address` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`street` varchar(155) NOT NULL,
	`city` varchar(155) NOT NULL,
	`country` varchar(155) NOT NULL,
	`postal_code` varchar(55) NOT NULL,
	`first_name` varchar(155) NOT NULL,
	`last_name` varchar(155) NOT NULL,
	`order_id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tags` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(55) NOT NULL,
	`product_id` varchar(55) NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `sub_category` ADD CONSTRAINT `sub_category_fk0` FOREIGN KEY (`category_id`) REFERENCES `category`(`id`);

ALTER TABLE `order` ADD CONSTRAINT `order_fk0` FOREIGN KEY (`user_id`) REFERENCES `user`(`id`);

ALTER TABLE `order` ADD CONSTRAINT `order_fk1` FOREIGN KEY (`address_id`) REFERENCES `address`(`id`);

ALTER TABLE `order_item` ADD CONSTRAINT `order_item_fk0` FOREIGN KEY (`order_id`) REFERENCES `order`(`id`);

ALTER TABLE `order_item` ADD CONSTRAINT `order_item_fk1` FOREIGN KEY (`product_id`) REFERENCES `product`(`id`);

ALTER TABLE `product` ADD CONSTRAINT `product_fk0` FOREIGN KEY (`category_id`) REFERENCES `category`(`id`);

ALTER TABLE `product` ADD CONSTRAINT `product_fk1` FOREIGN KEY (`sub_category_id`) REFERENCES `sub_category`(`id`);

ALTER TABLE `product` ADD CONSTRAINT `product_fk2` FOREIGN KEY (`supplier_id`) REFERENCES `user`(`id`);

ALTER TABLE `images` ADD CONSTRAINT `images_fk0` FOREIGN KEY (`product_id`) REFERENCES `product`(`id`);

ALTER TABLE `product_info` ADD CONSTRAINT `product_info_fk0` FOREIGN KEY (`product_id`) REFERENCES `product`(`id`);

ALTER TABLE `address` ADD CONSTRAINT `address_fk0` FOREIGN KEY (`order_id`) REFERENCES `order`(`id`);

ALTER TABLE `tags` ADD CONSTRAINT `tags_fk0` FOREIGN KEY (`product_id`) REFERENCES `product`(`id`);

