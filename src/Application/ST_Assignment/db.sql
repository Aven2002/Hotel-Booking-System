/*Establsih Database*/
DROP DATABASE IF EXISTS hotel_system;
CREATE DATABASE hotel_system;
/*Use the database*/
USE hotel_system;
/*User Account Table*/
CREATE TABLE IF NOT EXISTS user_account (
    userID INT NOT NULL AUTO_INCREMENT,
    fullName VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL UNIQUE,
    contactNum VARCHAR(15) NOT NULL,
    username VARCHAR(45) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    memberLevel VARCHAR(50) NOT NULL,
    exclusiveReward BOOLEAN NOT NULL DEFAULT FALSE, 
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (userID)
);
/*Wating List Table*/
CREATE TABLE IF NOT EXISTS waiting_list (
    waitListID INT NOT NULL AUTO_INCREMENT,
    userID INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (waitListID),
    FOREIGN KEY (userID) REFERENCES user_account(userID)
);
/* Room Table */
CREATE TABLE IF NOT EXISTS room (
    roomID INT NOT NULL AUTO_INCREMENT,
    roomType VARCHAR(20) NOT NULL,
    roomPrice DECIMAL(10, 2) NOT NULL,
    roomStatus VARCHAR(20) NOT NULL,
    PRIMARY KEY (roomID)
);
/* Booking Table */
CREATE TABLE IF NOT EXISTS booking (
    bookingID INT NOT NULL AUTO_INCREMENT,
    userID INT NOT NULL,
    roomID INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (bookingID),
    FOREIGN KEY (userID) REFERENCES user_account(userID),
    FOREIGN KEY (roomID) REFERENCES room(roomID)
);
/* Booking Room Table */
CREATE TABLE IF NOT EXISTS bookingRoom (
    bookingRoomID INT NOT NULL AUTO_INCREMENT,
    bookingID INT NOT NULL,
    roomID INT NOT NULL,
    roomQuantity INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (bookingRoomID),
    FOREIGN KEY (bookingID) REFERENCES booking(bookingID),
    FOREIGN KEY (roomID) REFERENCES room(roomID)
);

/*Pre- defined Room*/
INSERT INTO room (roomType, roomPrice, roomStatus) VALUES
('VIP', 800.00, 'Available'),
('VIP', 800.00, 'Available'),
('VIP', 800.00, 'Available'),
('VIP', 800.00, 'Available'),
('VIP', 800.00, 'Available'),
('Deluxe', 500.00, 'Available'),
('Deluxe', 500.00, 'Available'),
('Deluxe', 500.00, 'Available'),
('Deluxe', 500.00, 'Available'),
('Deluxe', 500.00, 'Available'),
('Standard', 300.00, 'Available'),
('Standard', 300.00, 'Available'),
('Standard', 300.00, 'Available'),
('Standard', 300.00, 'Available'),
('Standard', 300.00, 'Available')





