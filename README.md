# CRM-for-Sales
mini project
# Sales CRM System (Java + MySQL + Swing)

## Features
- Login Authentication
- Customer Management (CRUD)
- Deal Management
- Dashboard with stats
- JTable GUI

## Setup

1. Create DB:
CREATE DATABASE crm_db;

2. Tables:
CREATE TABLE customers (id INT PRIMARY KEY, name VARCHAR(100), email VARCHAR(100));
CREATE TABLE deals (deal_id INT PRIMARY KEY, customer_id INT, status VARCHAR(50));
CREATE TABLE users (username VARCHAR(50), password VARCHAR(50));
INSERT INTO users VALUES ('admin','admin123');

3. Add MySQL connector in lib/

4. Run:
javac -cp ".;lib/mysql-connector-j.jar" src/**/*.java
java -cp ".;lib/mysql-connector-j.jar;src" ui.LoginUI
