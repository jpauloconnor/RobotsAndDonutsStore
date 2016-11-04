CREATE SCHEMA IF NOT EXISTS robotsanddonuts;
USE robotsanddonuts;

CREATE TABLE IF NOT EXISTS robotsanddonuts.products (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  upc VARCHAR(16) NOT NULL,
  product_name VARCHAR(16) NOT NULL,
  product_manufacturer VARCHAR(45) NOT NULL,
  product_price DECIMAL NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS robotsanddonuts.customers (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(16) NOT NULL,
  last_name VARCHAR(16) NOT NULL,
  email VARCHAR(30) NOT NULL,
  phone_number VARCHAR(15) NOT NULL,
  PRIMARY KEY (id));
  
CREATE TABLE IF NOT EXISTS robotsanddonuts.transactions (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  customer_id VARCHAR(16) NOT NULL,
  product_id VARCHAR(16) NOT NULL,
  transaction_date VARCHAR(40) NOT NULL,
  PRIMARY KEY (id));
  
  

