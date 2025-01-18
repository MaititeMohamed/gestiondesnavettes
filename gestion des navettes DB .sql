-- create database gestionDesNavettes ;
-- Use the correct database
USE gestionDesNavettes;

-- Table for Companies
CREATE TABLE Company (
    company_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    contact_info VARCHAR(255)
);

-- Table for Shuttles
CREATE TABLE Shuttle (
    shuttle_id INT AUTO_INCREMENT PRIMARY KEY,
    company_id INT NOT NULL,
    departure_city VARCHAR(255) NOT NULL,
    arrival_city VARCHAR(255) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    departure_time TIME NOT NULL,
    arrival_time TIME NOT NULL,
    seats INT NOT NULL,
    description TEXT,
    FOREIGN KEY (company_id) REFERENCES Company(company_id)
);

-- Table for Subscription Offers (Updated)
CREATE TABLE SubscriptionOffer (
    offer_id INT AUTO_INCREMENT PRIMARY KEY,
    shuttle_id INT NOT NULL,
    max_subscribers INT NOT NULL,
    current_subscribers INT DEFAULT 0,
    status ENUM('open', 'closed') DEFAULT 'open',
    departure_city VARCHAR(100) NOT NULL,
    arrival_city VARCHAR(100) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    departure_time TIME NOT NULL,
    arrival_time TIME NOT NULL,
    description TEXT,
    FOREIGN KEY (shuttle_id) REFERENCES Shuttle(shuttle_id)
);

-- Table for Users
CREATE TABLE User (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Table for Subscription Requests
CREATE TABLE SubscriptionRequest (
    request_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    shuttle_id INT NOT NULL,
    request_date DATE NOT NULL,
    status ENUM('pending', 'accepted', 'rejected') DEFAULT 'pending',
    FOREIGN KEY (user_id) REFERENCES User(user_id),
    FOREIGN KEY (shuttle_id) REFERENCES Shuttle(shuttle_id)
);

-- Table for Request Details (Updated)
CREATE TABLE RequestDetail (
    detail_id INT AUTO_INCREMENT PRIMARY KEY,
    request_id INT NOT NULL,
    departure_city VARCHAR(255) NOT NULL,
    arrival_city VARCHAR(255) NOT NULL,
    departure_time TIME NOT NULL,
    arrival_time TIME NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    FOREIGN KEY (request_id) REFERENCES SubscriptionRequest(request_id)
);
-- insert 
INSERT INTO Company (name, contact_info) 
VALUES 
('Navette Express', 'contact@navette.com'),
('Rapid Shuttle', 'support@rapidshuttle.com'),
('City Travel', 'info@citytravel.com');


INSERT INTO Shuttle (company_id, departure_city, arrival_city, start_date, end_date, departure_time, arrival_time, seats, description)
VALUES 
(1, 'Casablanca', 'Rabat', '2025-01-20', '2025-01-20', '08:00:00', '09:30:00', 50, 'Comfortable shuttle for business travel'),
(2, 'Marrakech', 'Casablanca', '2025-01-21', '2025-01-21', '14:00:00', '17:00:00', 60, 'Fast shuttle with comfortable seats'),
(3, 'Tangier', 'Fes', '2025-01-22', '2025-01-22', '10:00:00', '13:30:00', 45, 'Fully booked shuttle, no availability');


INSERT INTO SubscriptionOffer (shuttle_id, max_subscribers, current_subscribers, status, departure_city, arrival_city, start_date, end_date, departure_time, arrival_time, description)
VALUES 
(1, 20, 5, 'open', 'Casablanca', 'Rabat', '2025-01-20', '2025-01-20', '08:00:00', '09:30:00', 'Morning shuttle from Casablanca to Rabat'),
(2, 30, 15, 'open', 'Marrakech', 'Casablanca', '2025-01-21', '2025-01-21', '14:00:00', '17:00:00', 'Afternoon shuttle from Marrakech to Casablanca'),
(3, 25, 25, 'closed', 'Tangier', 'Fes', '2025-01-22', '2025-01-22', '10:00:00', '13:30:00', 'Fully booked shuttle from Tangier to Fes');

