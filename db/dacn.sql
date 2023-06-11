CREATE SCHEMA `dacn` ;

CREATE TABLE `dacn`.`customer` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `phone_number` INT NULL,
  `email` VARCHAR(45) NULL,
  `password` VARCHAR(45) NOT NULL,
  `status` INT NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC) VISIBLE,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);
  
-- address
CREATE TABLE `dacn`.`address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_customer` INT NOT NULL,
  `description` VARCHAR(200) NULL,
  `ward` VARCHAR(45) NOT NULL,
  `district` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_AD_CU_idx` (`id_customer` ASC) VISIBLE,
  CONSTRAINT `FK_AD_CU`
    FOREIGN KEY (`id_customer`)
    REFERENCES `dacn`.`customer` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



-- admin
CREATE TABLE `dacn`.`admin` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `phone_number` INT NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC) VISIBLE);
 
 
-- color
CREATE TABLE `dacn`.`color` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `status` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);
  
  
  -- brand
  CREATE TABLE `dacn`.`brand` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `status` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);
  
-- size 
CREATE TABLE `dacn`.`size` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `status` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);
  
-- product
CREATE TABLE `dacn`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `image` TEXT NOT NULL,
  `description` VARCHAR(300) NULL,
  `status` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);

-- category
CREATE TABLE `dacn`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `status` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);


-- detail product
CREATE TABLE `dacn`.`detail_product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_category` INT NOT NULL,
  `id_product` INT NOT NULL,
  `id_size` INT NOT NULL,
  `id_color` INT NOT NULL,
  `id_brand` INT NOT NULL,
  `sell_price` DECIMAL(10,0) NOT NULL,
  `status` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `FK_DPR_PR_idx` (`id_product` ASC) VISIBLE,
  INDEX `FK_DPR_CT_idx` (`id_category` ASC) VISIBLE,
  INDEX `FK_DPR_SI_idx` (`id_size` ASC) VISIBLE,
  INDEX `FK_DPR_CL_idx` (`id_color` ASC) VISIBLE,
  INDEX `FK_DPR_BR_idx` (`id_brand` ASC) VISIBLE,
  CONSTRAINT `FK_DPR_PR`
    FOREIGN KEY (`id_product`)
    REFERENCES `dacn`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_DPR_CT`
    FOREIGN KEY (`id_category`)
    REFERENCES `dacn`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_DPR_SI`
    FOREIGN KEY (`id_size`)
    REFERENCES `dacn`.`size` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_DPR_CL`
    FOREIGN KEY (`id_color`)
    REFERENCES `dacn`.`color` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_DPR_BR`
    FOREIGN KEY (`id_brand`)
    REFERENCES `dacn`.`brand` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- voucher
CREATE TABLE `dacn`.`voucher` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  `discount_amount` DECIMAL(10,2) NOT NULL,
  `status` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) VISIBLE
);


-- cart
CREATE TABLE `dacn`.`cart` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_customer` INT NOT NULL,
  `status` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_CART_C_idx` (`id_customer` ASC) VISIBLE,
  CONSTRAINT `FK_CART_C`
    FOREIGN KEY (`id_customer`)
    REFERENCES `dacn`.`customer` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



-- detail cart
CREATE TABLE `dacn`.`detail_cart` (
  `id_cart` INT NOT NULL,
  `id_detail_product` INT NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`id_cart`, `id_detail_product`),
  INDEX `FK_DC_DP_idx` (`id_detail_product` ASC) VISIBLE,
  CONSTRAINT `FK_DC_C`
    FOREIGN KEY (`id_cart`)
    REFERENCES `dacn`.`cart` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_DC_DP`
    FOREIGN KEY (`id_detail_product`)
    REFERENCES `dacn`.`detail_product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- bill
CREATE TABLE `dacn`.`bill` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_customer` INT NULL,
  `code` BIGINT NOT NULL,
  `create_date` DATE NOT NULL,
  `payment_date` DATE NULL,
  `delivery_date` DATE NULL,
  `received_date` DATE NULL,
  `address` VARCHAR(300) NOT NULL,
  `description` VARCHAR(300) NULL,
  `phone_number` INT NOT NULL,
  `status` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_BILL_C_idx` (`id_customer` ASC) VISIBLE,
  CONSTRAINT `FK_BILL_C`
    FOREIGN KEY (`id_customer`)
    REFERENCES `dacn`.`customer` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



-- detail bill
CREATE TABLE `dacn`.`detail_bill` (
  `id_bill` INT NOT NULL AUTO_INCREMENT,
  `id_detail_product` INT NOT NULL,
  `quantity` INT NOT NULL,
  `price` DECIMAL NOT NULL,
  PRIMARY KEY (`id_bill`),
  UNIQUE INDEX `id_bill_UNIQUE` (`id_bill` ASC) VISIBLE,
  INDEX `FK_DB_DP_idx` (`id_detail_product` ASC) VISIBLE,
  CONSTRAINT `FK_DB_B`
    FOREIGN KEY (`id_bill`)
    REFERENCES `dacn`.`bill` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_DB_DP`
    FOREIGN KEY (`id_detail_product`)
    REFERENCES `dacn`.`detail_product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
-- favorite
CREATE TABLE `dacn`.`favorite` (
  `id_customer` INT NOT NULL,
  `id_product` INT NOT NULL,
  PRIMARY KEY (`id_customer`, `id_product`),
  INDEX `FK_F_P_idx` (`id_product` ASC) VISIBLE,
  CONSTRAINT `FK_F_C`
    FOREIGN KEY (`id_customer`)
    REFERENCES `dacn`.`customer` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_F_P`
    FOREIGN KEY (`id_product`)
    REFERENCES `dacn`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- 
ALTER TABLE `dacn`.`bill` ADD COLUMN `id_voucher` INT NULL AFTER `id_customer`;
ALTER TABLE `dacn`.`bill` ADD CONSTRAINT `FK_BILL_V`
  FOREIGN KEY (`id_voucher`)
  REFERENCES `dacn`.`voucher` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;



INSERT INTO `dacn`.`brand` (`name`, `status`) VALUES ('Adidas', '0');
INSERT INTO `dacn`.`brand` (`name`, `status`) VALUES ('Nike', '0');
INSERT INTO `dacn`.`brand` (`name`, `status`) VALUES ('Hermes', '0');
INSERT INTO `dacn`.`brand` (`name`, `status`) VALUES ('Dior', '0');
INSERT INTO `dacn`.`brand` (`name`, `status`) VALUES ('Balenciage', '0');

-- 
INSERT INTO `dacn`.`category` (`name`, `status`) VALUES ('Shoe', '0');
INSERT INTO `dacn`.`category` (`name`, `status`) VALUES ('T-shirt', '0');
INSERT INTO `dacn`.`category` (`name`, `status`) VALUES ('Accessory', '0');
INSERT INTO `dacn`.`category` (`name`, `status`) VALUES ('Shirt', '0');
INSERT INTO `dacn`.`category` (`name`, `status`) VALUES ('Bag', '0');
INSERT INTO `dacn`.`category` (`name`, `status`) VALUES ('Hoodie', '0');


--
INSERT INTO `dacn`.`color` (`name`, `status`) VALUES ('Black', '0');
INSERT INTO `dacn`.`color` (`name`, `status`) VALUES ('Red', '0');
INSERT INTO `dacn`.`color` (`name`, `status`) VALUES ('Blue ', '0');
INSERT INTO `dacn`.`color` (`name`, `status`) VALUES ('Green', '0');
INSERT INTO `dacn`.`color` (`name`, `status`) VALUES ('White', '0');


--
INSERT INTO `dacn`.`product` (`name`, `image`, `status`) VALUES ('INDIGO HERZ FEAT', '/user/img/product/product-5.jpg', '0');
INSERT INTO `dacn`.`product` (`name`, `image`, `status`) VALUES ('GRAPHIC TRAE PLAYOFF', '/user/img/product/product-8.jpg', '0');
INSERT INTO `dacn`.`product` (`name`, `image`, `status`) VALUES ('RIFTA METRO AAC', '/user/img/product/product-9.jpg', '0');
INSERT INTO `dacn`.`product` (`name`, `image`, `status`) VALUES ('ALPHA BOUNCE', '/user/img/product/product-1.jpg', '0');
INSERT INTO `dacn`.`product` (`name`, `image`, `status`) VALUES ('AIR FORCE 1', '/user/img/product/product-3.jpg', '0');

INSERT INTO `dacn`.`product` (`name`, `image`, `status`) VALUES ('OBLIQUE SHORT-SLEEVED', '/user/img/product/product-2.jpg', '0');
INSERT INTO `dacn`.`product` (`name`, `image`, `status`) VALUES ('OBLIQUE OVERSHIRT', '/user/img/product/product-4.jpg', '0');

INSERT INTO `dacn`.`product` (`name`, `image`, `status`) VALUES ('NIKE HERITAFE', '/user/img/product/product-7.jpg', '0');
INSERT INTO `dacn`.`product` (`name`, `image`, `status`) VALUES ('NIKE SPORTSWEAR', '/user/img/product/product-11.jpg', '0');
INSERT INTO `dacn`.`product` (`name`, `image`, `status`) VALUES ('NIKE HARDWAY 2.0', '/user/img/product/product-13.jpg', '0');

INSERT INTO `dacn`.`product` (`name`, `image`, `status`) VALUES ('MASK SUNGLASSES', '/user/img/product/product-14.jpg', '0');
INSERT INTO `dacn`.`product` (`name`, `image`, `status`) VALUES ('CHRISTIAN VERNIS NAIL LACQUER', '/user/img/product/product-10.jpg', '0');
INSERT INTO `dacn`.`product` (`name`, `image`, `status`) VALUES ('DESIGNER SILK SCARVES', '/user/img/product/product-6.jpg', '0');
INSERT INTO `dacn`.`product` (`name`, `image`, `status`) VALUES ('SAD BOIZ', '/user/img/product/product-12.jpg', '0');


--
INSERT INTO `dacn`.`size` (`name`, `status`) VALUES ('S', '0');
INSERT INTO `dacn`.`size` (`name`, `status`) VALUES ('L', '0');
INSERT INTO `dacn`.`size` (`name`, `status`) VALUES ('XL', '0');
INSERT INTO `dacn`.`size` (`name`, `status`) VALUES ('XXL', '0');

-- detail product
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('2', '1', '1', '1', '2', '200000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('2', '2', '1', '1', '2', '220000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('2', '3', '1', '1', '2', '190000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('2', '1', '2', '2', '2', '200000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('2', '2', '2', '2', '2', '220000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('2', '3', '2', '2', '2', '190000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('2', '1', '3', '3', '2', '200000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('2', '2', '3', '3', '2', '220000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('2', '3', '3', '3', '2', '190000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('2', '1', '4', '4', '2', '200000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('2', '2', '4', '4', '2', '220000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('2', '3', '4', '4', '2', '190000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('1', '4', '1', '1', '1', '140000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('1', '5', '1', '1', '2', '140000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('1', '4', '2', '2', '1', '140000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('1', '5', '2', '2', '2', '140000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('1', '4', '3', '3', '1', '140000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('1', '5', '3', '3', '2', '140000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('4', '6', '1', '1', '3', '240000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('4', '7', '1', '1', '3', '280000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('4', '6', '2', '2', '3', '240000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('4', '7', '2', '2', '3', '280000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('4', '6', '3', '3', '3', '240000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('4', '7', '3', '3', '3', '280000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('5', '8', '1', '1', '4', '320000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('5', '9', '1', '1', '4', '320000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('5', '10', '1', '1', '4', '320000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('5', '8', '2', '2', '4', '320000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('5', '9', '2', '2', '4', '320000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('5', '10', '2', '2', '4', '320000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('5', '8', '3', '3', '4', '320000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('5', '9', '3', '3', '4', '320000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('5', '10', '3', '3', '4', '320000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('3', '11', '1', '1', '3', '290000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('3', '12', '1', '1', '3', '200000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('3', '13', '1', '1', '3', '300000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('3', '11', '2', '2', '3', '290000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('3', '12', '2', '2', '3', '200000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('3', '13', '2', '2', '3', '300000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('3', '11', '3', '3', '3', '290000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('3', '12', '3', '3', '3', '200000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('3', '13', '3', '3', '3', '300000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('6', '14', '1', '1', '3', '290000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('6', '14', '1', '2', '3', '290000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('6', '14', '1', '3', '3', '290000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('6', '14', '2', '1', '3', '290000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('6', '14', '2', '2', '3', '290000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('6', '14', '2', '3', '3', '290000', '0');



INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('2', '1', '2', '1', '2', '200000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('2', '1', '3', '1', '2', '200000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('2', '1', '4', '1', '2', '200000', '0');

INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('2', '2', '3', '1', '2', '220000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('2', '2', '4', '1', '2', '220000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('2', '2', '3', '2', '2', '220000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('2', '2', '4', '2', '2', '220000', '0');

-- 
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('2', '3', '3', '1', '2', '190000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('2', '3', '4', '1', '2', '190000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('2', '3', '3', '2', '2', '190000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `sell_price`, `status`) VALUES ('2', '3', '4', '2', '2', '190000', '0');




-- customer
INSERT INTO `dacn`.`customer` (`username`, `last_name`, `first_name`, `phone_number`, `email`, `password`, `status`) VALUES ('sonpt', 'phạm', 'sơn', '0389412203', 'sonptph25875@fpt.edu.vn', 'sonpt', '0');


-- address
INSERT INTO `dacn`.`address` (`id_customer`,`city`,`district`,`ward`, `description`) VALUES ('1','Hòa Bình','Cao Phong','Cao Phong','294 Khu 4');

-- voucher
INSERT INTO `dacn`.`voucher` (`code`, `start_date`, `end_date`, `discount_amount`, `status`) VALUES ('PSON', '2023-01-01', '2024-01-01', '100000', '0');

-- cart
INSERT INTO `dacn`.`cart` (`id_customer`, `status`) VALUES ('1','0');

-- admin
INSERT INTO `dacn`.`admin` (`email`,`phone_number`,`password`) VALUES ('phamson191203@gmail.com','0389412203','Son191203');
