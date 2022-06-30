
create table category(
	id int primary key auto_increment,
    name nvarchar(50),
    code varchar(20),
    status int,
    description nvarchar(100)
);

create table product(
	id int primary key auto_increment,
    name nvarchar(50),
    price int,
    sku varchar(50),
    status int,
    description nvarchar(100),
    category_id int,
    FOREIGN KEY (category_id) REFERENCES category(id)
);


create table province(
	id int primary key auto_increment,
    code varchar(50),
    name nvarchar(50)
);

create table warehouse_product(
	id int primary key auto_increment,
    product_id int,
    warehouse_id int,
    inventory int,
    total_import int,
    total_export int,
    start_date datetime,
    expire_date datetime
);

create table district(
	id int primary key auto_increment,
    code varchar(50),
    name nvarchar(100)
);

create table warehouse(
	id int primary key auto_increment,
    name nvarchar(50),
    address nvarchar(100),
    province_id int,
    status int,
    district_id int,
    foreign key (province_id) references province(id),
    foreign key (district_id) references district(id)
);





INSERT INTO `category` (`id`,`name`,`code`,`status`,`description`) VALUES (1,'Áo khoác','strinhtrhrtgz',1,'okerht4ytrz');
INSERT INTO `category` (`id`,`name`,`code`,`status`,`description`) VALUES (2,'Áo khoác gió','strinhtrhrtgz',1,'okerht4ytrz');
INSERT INTO `category` (`id`,`name`,`code`,`status`,`description`) VALUES (3,'Áo khoác gió','strinhtrhrtgz',1,'okerht4ytrz');
INSERT INTO `category` (`id`,`name`,`code`,`status`,`description`) VALUES (4,'Quần','abcrtgz',2,'okerht4ytrz');
INSERT INTO `category` (`id`,`name`,`code`,`status`,`description`) VALUES (5,'Giầy','abcrtgz',2,'okerht4ytrz');
INSERT INTO `category` (`id`,`name`,`code`,`status`,`description`) VALUES (6,'dép','abcrtgz',2,'okerht4ytrz');
INSERT INTO `category` (`id`,`name`,`code`,`status`,`description`) VALUES (7,'áo khoác gió',NULL,1,'dfghdfsghkjfdkjh');

INSERT INTO `district` (`id`,`code`,`name`) VALUES (1,'q1','quan1');
INSERT INTO `district` (`id`,`code`,`name`) VALUES (2,'q2','quan2');
INSERT INTO `district` (`id`,`code`,`name`) VALUES (3,'q3','quan3');
INSERT INTO `district` (`id`,`code`,`name`) VALUES (4,'q4','quan4');
INSERT INTO `district` (`id`,`code`,`name`) VALUES (5,'q5','quan5');
INSERT INTO `district` (`id`,`code`,`name`) VALUES (6,'q6','quan6');
INSERT INTO `district` (`id`,`code`,`name`) VALUES (7,'q7','quan7');
INSERT INTO `district` (`id`,`code`,`name`) VALUES (8,'q8','quan8');
INSERT INTO `district` (`id`,`code`,`name`) VALUES (9,'q9','quan9');
INSERT INTO `district` (`id`,`code`,`name`) VALUES (10,'q10','quan10');

INSERT INTO `province` (`id`,`code`,`name`) VALUES (1,'hn','ha noi');
INSERT INTO `province` (`id`,`code`,`name`) VALUES (2,'hp','hai phong');
INSERT INTO `province` (`id`,`code`,`name`) VALUES (3,'qn','quang ninh');
INSERT INTO `province` (`id`,`code`,`name`) VALUES (4,'hg','ha giang');
INSERT INTO `province` (`id`,`code`,`name`) VALUES (5,'bn','bac ninh');
INSERT INTO `province` (`id`,`code`,`name`) VALUES (6,'mc','moc chau');
INSERT INTO `province` (`id`,`code`,`name`) VALUES (7,'tb','thai binh');
INSERT INTO `province` (`id`,`code`,`name`) VALUES (8,'hcm','ho chi minh');
INSERT INTO `province` (`id`,`code`,`name`) VALUES (9,'ls','lang son');
INSERT INTO `province` (`id`,`code`,`name`) VALUES (10,'qb','quang binh');

INSERT INTO `warehouse` (`id`,`name`,`address`,`province_id`,`status`,`district_id`) VALUES (1,'kho 1','so 1',1,0,1);
INSERT INTO `warehouse` (`id`,`name`,`address`,`province_id`,`status`,`district_id`) VALUES (2,'kho 2','so 10',1,0,1);







