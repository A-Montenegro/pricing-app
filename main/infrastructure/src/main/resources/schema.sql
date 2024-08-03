DROP TABLE IF EXISTS price;
DROP TABLE IF EXISTS brand;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS price_rate;

CREATE TABLE brand (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE product (
  id INT NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE price_rate (
  id INT NOT NULL AUTO_INCREMENT,
  description varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE price (
  id INT NOT NULL AUTO_INCREMENT,
  brand_id INT NOT NULL,
  start_date TIMESTAMP NOT NULL,
  end_date TIMESTAMP NOT NULL,
  price_rate_id INT NOT NULL,
  product_id INT NOT NULL,
  priority INT NOT NULL,
  price_value FLOAT,
  currency VARCHAR(50),
  PRIMARY KEY (id),
  FOREIGN KEY (brand_id) REFERENCES brand(id),
  FOREIGN KEY (price_rate_id) REFERENCES price_rate(id),
  FOREIGN KEY (product_id) REFERENCES product(id)
);
