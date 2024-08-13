CREATE TABLE `airport` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255),
  `city` varchar(255),
  `country` varchar(255),
  `code` varchar(10) UNIQUE
);

CREATE TABLE `airline` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255),
  `code` varchar(10) UNIQUE
);

CREATE TABLE `seats` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `seat_number` varchar(10),
  `class` varchar(50),
  `flight_id` int
);

CREATE TABLE `flight` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `flight_number` varchar(10) UNIQUE,
  `departure_time` datetime,
  `arrival_time` datetime,
  `departure_airport_id` int,
  `arrival_airport_id` int,
  `airline_id` int
);

CREATE TABLE `payment` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `booking_id` int,
  `payment_method` varchar(50),
  `transaction_id` varchar(100) UNIQUE,
  `payment_status` varchar(50),
  `amount` decimal(10,2),
  `payment_date` datetime,
  `response_code` varchar(50),
  `response_message` varchar(255),
  `created_at` datetime,
  `updated_at` datetime
);

CREATE TABLE `booking` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `booking_code` varchar(20) UNIQUE,
  `booking_date` datetime,
  `passenger_id` int,
  `total_amount` decimal(10,2),
  `status` varchar(50),
  `payment_id` int
);

CREATE TABLE `booking_detail` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `booking_id` int,
  `flight_id` int,
  `seat_id` int,
  `price` decimal(10,2),
  `discount_id` int
);

CREATE TABLE `discount` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `code` varchar(20) UNIQUE,
  `description` varchar(255),
  `discount_percent` int,
  `valid_from` datetime,
  `valid_to` datetime
);

CREATE TABLE `notification` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `booking_id` int,
  `message` varchar(255),
  `sent_at` datetime,
  `status` varchar(50)
);

CREATE TABLE `users` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `username` varchar(50) UNIQUE,
  `email` varchar(255) UNIQUE,
  `password` varchar(255),
  `role_id` int,
  `passenger_id` int,
  `created_at` datetime,
  `updated_at` datetime
);

CREATE TABLE `passenger` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `first_name` varchar(255),
  `last_name` varchar(255),
  `email` varchar(255) UNIQUE,
  `phone_number` varchar(20)
);

CREATE TABLE `role` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `role_name` varchar(50) UNIQUE,
  `description` varchar(255)
);

ALTER TABLE `seats` ADD FOREIGN KEY (`flight_id`) REFERENCES `flight` (`id`);

ALTER TABLE `flight` ADD FOREIGN KEY (`departure_airport_id`) REFERENCES `airport` (`id`);

ALTER TABLE `flight` ADD FOREIGN KEY (`arrival_airport_id`) REFERENCES `airport` (`id`);

ALTER TABLE `flight` ADD FOREIGN KEY (`airline_id`) REFERENCES `airline` (`id`);

ALTER TABLE `payment` ADD FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`);

ALTER TABLE `booking` ADD FOREIGN KEY (`passenger_id`) REFERENCES `passenger` (`id`);

ALTER TABLE `booking` ADD FOREIGN KEY (`payment_id`) REFERENCES `payment` (`id`);

ALTER TABLE `booking_detail` ADD FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`);

ALTER TABLE `booking_detail` ADD FOREIGN KEY (`flight_id`) REFERENCES `flight` (`id`);

ALTER TABLE `booking_detail` ADD FOREIGN KEY (`seat_id`) REFERENCES `seats` (`id`);

ALTER TABLE `booking_detail` ADD FOREIGN KEY (`discount_id`) REFERENCES `discount` (`id`);

ALTER TABLE `notification` ADD FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`);

ALTER TABLE `users` ADD FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

ALTER TABLE `users` ADD FOREIGN KEY (`passenger_id`) REFERENCES `passenger` (`id`);
