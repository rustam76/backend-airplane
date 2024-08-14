CREATE TABLE `airport` (
  `id` BIGINT PRIMARY KEY,
  `name` varchar(255),
  `city` varchar(255),
  `country` varchar(255),
  `code` varchar(10) UNIQUE
);

CREATE TABLE `airline` (
  `id` BIGINT PRIMARY KEY,
  `name` varchar(255),
  `code` varchar(10) UNIQUE
);

CREATE TABLE `seats` (
  `id` BIGINT PRIMARY KEY,
  `seat_number` varchar(10),
  `class` varchar(50),
  `flight_id` BIGINT
);

CREATE TABLE `flight` (
  `id` BIGINT PRIMARY KEY,
  `flight_number` varchar(10) UNIQUE,
  `departure_time` datetime,
  `arrival_time` datetime,
  `departure_airport_id` BIGINT,
  `arrival_airport_id` BIGINT,
  `airline_id` BIGINT
);

CREATE TABLE `payment` (
  `id` BIGINT PRIMARY KEY,
  `booking_id` BIGINT,
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
  `id` BIGINT PRIMARY KEY,
  `booking_code` varchar(20) UNIQUE,
  `booking_date` datetime,
  `passenger_id` BIGINT,
  `total_amount` decimal(10,2),
  `status` varchar(50),
  `payment_id` BIGINT
);

CREATE TABLE `booking_detail` (
  `id` BIGINT PRIMARY KEY,
  `booking_id` BIGINT,
  `flight_id` BIGINT,
  `seat_id` BIGINT,
  `price` decimal(10,2),
  `discount_id` BIGINT
);

CREATE TABLE `discount` (
  `id` BIGINT PRIMARY KEY,
  `code` varchar(20) UNIQUE,
  `description` varchar(255),
  `discount_percent` int,
  `valid_from` datetime,
  `valid_to` datetime
);

CREATE TABLE `notification` (
  `id` BIGINT PRIMARY KEY,
  `booking_id` BIGINT,
  `message` varchar(255),
  `sent_at` datetime,
  `status` varchar(50)
);

CREATE TABLE `users` (
  `id` BIGINT PRIMARY KEY,
  `username` varchar(50) UNIQUE,
  `email` varchar(255) UNIQUE,
  `password` varchar(255),
  `role_id` BIGINT,
  `passenger_id` BIGINT,
  `created_at` datetime,
  `updated_at` datetime
);

CREATE TABLE `passenger` (
  `id` BIGINT PRIMARY KEY,
  `first_name` varchar(255),
  `last_name` varchar(255),
  `email` varchar(255) UNIQUE,
  `phone_number` varchar(20)
);

CREATE TABLE `role` (
  `id` BIGINT PRIMARY KEY,
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