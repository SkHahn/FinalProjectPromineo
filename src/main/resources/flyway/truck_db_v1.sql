DROP TABLE IF EXISTS food_truck_location;
DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS menu;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS food_truck;

CREATE TABLE food_truck(
food_truck_id INT NOT NULL AUTO_INCREMENT,
truck_name VARCHAR(45) NOT NULL,
owner VARCHAR(50) NOT NULL,
home_base_address VARCHAR(50) NOT NULL,
PRIMARY KEY(food_truck_id),
);
Create table employee(
employee_id INT NOT NULL AUTO_INCREMENT,
food_truck_id INT,
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL,
phone_contact VARCHAR(20),
PRIMARY KEY(employee_id),
FOREIGN KEY(food_truck_id) REFERENCES food_truck(food_truck_id)
);
CREATE TABLE menu(
menu_id INT NOT NULL AUTO_INCREMENT,
food_truck_id INT,
food_type VARCHAR(45),
food_price DECIMAL(4),
PRIMARY KEY(menu_id)
FOREIGN KEY(food_truck_id) REFERENCES food_truck(food_truck_id)
);

CREATE TABLE location(
location_id INT NOT NULL AUTO_INCREMENT,
location_name VARCHAR(45),
address VARCHAR(20),
serves_alcohol VARCHAR(5),
PRIMARY KEY (location_id)
);

CREATE TABLE food_truck_location(
food_truck_id INT NOT NULL,
location_id INT NOT NULL,
PRIMARY KEY (food_truck_id, location_id),
FOREIGN KEY(food_truck_id) references food_truck(food_truck_id),
FOREIGN KEY(location_id) REFERENCES location(location_id)
);
