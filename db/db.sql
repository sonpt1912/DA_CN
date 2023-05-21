CREATE SCHEMA `dacn` ;

CREATE TABLE `dacn`.`customer` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `phone_number` INT NULL,
  `email` VARCHAR(45) NULL,
  `password` VARCHAR(45) NOT NULL,
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
  `status` INT NOT NULL,
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
  `description` VARCHAR(100) NULL,
    `quantity` INT NOT NULL,
  `sell_price` DECIMAL(10,0) NOT NULL,
  `origin_price` DECIMAL NOT NULL,
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
  `code` INT NOT NULL,
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
  `code` INT NOT NULL,
  `create_date` DATE NOT NULL,
  `payment_date` DATE NULL,
  `delivery_date` DATE NULL,
  `received_date` DATE NULL,
  `name_customer` VARCHAR(45) NOT NULL,
  `address` VARCHAR(300) NOT NULL,
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
INSERT INTO `dacn`.`category` (`name`, `status`) VALUES ('Hoodie', '0');
INSERT INTO `dacn`.`category` (`name`, `status`) VALUES ('Trousers', '0');



--
INSERT INTO `dacn`.`color` (`name`, `status`) VALUES ('Black', '0');
INSERT INTO `dacn`.`color` (`name`, `status`) VALUES ('Red', '0');
INSERT INTO `dacn`.`color` (`name`, `status`) VALUES ('Blue ', '0');
INSERT INTO `dacn`.`color` (`name`, `status`) VALUES ('Green', '0');
INSERT INTO `dacn`.`color` (`name`, `status`) VALUES ('White', '0');


--
INSERT INTO `dacn`.`product` (`name`, `image`, `status`) VALUES ('INDIGO HERZ FEAT T-shirt', 'rr', '0');
INSERT INTO `dacn`.`product` (`name`, `image`, `status`) VALUES ('GRAPHIC TRAE PLAYOFF T-shirt', 'rr', '0');


--
INSERT INTO `dacn`.`size` (`name`, `status`) VALUES ('S', '0');
INSERT INTO `dacn`.`size` (`name`, `status`) VALUES ('L', '0');
INSERT INTO `dacn`.`size` (`name`, `status`) VALUES ('XL', '0');
INSERT INTO `dacn`.`size` (`name`, `status`) VALUES ('XXL', '0');


--
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `description`, `quantity`, `sell_price`, `origin_price`, `status`) VALUES ('2', '1', '1', '5', '1', 'Áo adidas', '1002', '200000', '150000', '0');
INSERT INTO `dacn`.`detail_product` (`id_category`, `id_product`, `id_size`, `id_color`, `id_brand`, `description`, `quantity`, `sell_price`, `origin_price`, `status`) VALUES ('2', '2', '1', '5', '1', 'Áo Adidas', '2003', '250000', '150000', '0');

 -- customer
 INSERT INTO `dacn`.`customer` (`username`, `last_name`, `first_name`, `phone_number`, `email`, `password`) VALUES ('sonpt', 'Phạm ', 'Sơn', '0389412203', 'sonptph25875@ftp.edu.vn', '12123');
