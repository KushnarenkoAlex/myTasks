drop database `st4`;
create database `st4`;
use `st4`;

create table if not exists `user` (
	`id` serial,
	`email` varchar(60) not null unique,
	`password` varchar(100) not null,
	`f_name` varchar(40),
	`l_name` varchar(40),
	`document_tag` varchar(20),
	`role_id` tinyint unsigned not null,
	
	primary key (`id`)
) charset=utf8;

INSERT INTO `user` (`id`, `email`, `password`, `f_name`, `l_name`, `document_tag`, `role_id`) VALUES (3, 'daria@gmail.com', '39032b363c5c4990ff5a399d470d2b10b7269263', NULL, NULL, NULL, 1);



create table if not exists `train_type` (
	`id` tinyint unsigned auto_increment not null unique,
	`name` varchar(40) not null unique,
	
	primary key (`id`)
) charset=utf8;

-- price is specified per station
create table if not exists `train`(
	`id` serial,
	`tag` varchar(10) not null unique,
	`price` decimal(5,2) unsigned not null,
	`type_id` tinyint unsigned,
	
	primary key (`id`),
	constraint `fk_train_train_type` foreign key (`type_id`) references `train_type`(`id`) on update cascade
) charset=utf8;

INSERT INTO `train` (`id`, `tag`, `price`, `type_id`) VALUES (1, '725 O', 30.00, NULL);
INSERT INTO `train` (`id`, `tag`, `price`, `type_id`) VALUES (2, '115 O', 20.00, NULL);
INSERT INTO `train` (`id`, `tag`, `price`, `type_id`) VALUES (3, '082 П', 15.00, NULL);
INSERT INTO `train` (`id`, `tag`, `price`, `type_id`) VALUES (4, '726 О', 30.00, NULL);


-- --------------------------------------------------------

create table if not exists `station` (
	`id` smallint unsigned auto_increment not null unique,
	`name` varchar(30) not null unique,
	
	primary key (`id`)
) charset=utf8;

insert into station values(1, 'Харьков-Пасс');
insert into station values(2, 'Киев-Пасс');
insert into station values(3, 'Полтава');
insert into station values(4, 'Миргород');
insert into station values(5, 'Запорожье');
insert into station values(6, 'Львов-Пасс');
insert into station values(7, 'Винница');
insert into station values(8, 'Одесса-Главная');
insert into station values(9, 'Херсон');
insert into station values(10, 'Бердянск');
insert into station values(11, 'Мелитополь');
insert into station values(15, 'Дарница');
insert into station values(12, 'Коростень');
insert into station values(13, 'Славута 1');
insert into station values(14, 'Здолбунов');
insert into station values(16, 'Броды');
insert into station values(17, 'Львов');
insert into station values(18, 'Ивано-Франковск');
insert into station values(19, 'Лозовая');
insert into station values(20, 'Павлоград');
insert into station values(21, 'Новоалексеевка');
insert into station values(22, 'Лихачево');
-- finish here
create table if not exists `route`(
	`id` smallint unsigned auto_increment not null unique,
	`date` date not null,
	`train_id` bigint unsigned not null,
	
	primary key (`id`),
	unique key `date_train` (`date`, `train_id`),
	constraint `fk_route_train` foreign key (`train_id`) references `train`(`id`) on delete cascade on update cascade
) charset=utf8;

INSERT INTO `route` (`id`, `date`, `train_id`) VALUES (4, '2016-03-05', 1);
INSERT INTO `route` (`id`, `date`, `train_id`) VALUES (13, '2016-03-05', 2);
INSERT INTO `route` (`id`, `date`, `train_id`) VALUES (3, '2016-03-06', 1);
INSERT INTO `route` (`id`, `date`, `train_id`) VALUES (12, '2016-03-06', 2);
INSERT INTO `route` (`id`, `date`, `train_id`) VALUES (2, '2016-03-07', 1);
INSERT INTO `route` (`id`, `date`, `train_id`) VALUES (10, '2016-03-07', 2);
INSERT INTO `route` (`id`, `date`, `train_id`) VALUES (1, '2016-03-08', 1);
INSERT INTO `route` (`id`, `date`, `train_id`) VALUES (14, '2016-03-08', 2);
INSERT INTO `route` (`id`, `date`, `train_id`) VALUES (15, '2016-03-09', 2);
INSERT INTO `route` (`id`, `date`, `train_id`) VALUES (11, '2016-03-10', 2);

INSERT INTO `route` (`id`, `date`, `train_id`) VALUES (41, '2016-03-05', 3);
INSERT INTO `route` (`id`, `date`, `train_id`) VALUES (17, '2016-03-05', 4);
INSERT INTO `route` (`id`, `date`, `train_id`) VALUES (30, '2016-03-06', 3);
INSERT INTO `route` (`id`, `date`, `train_id`) VALUES (19, '2016-03-06', 4);
INSERT INTO `route` (`id`, `date`, `train_id`) VALUES (20, '2016-03-07', 3);
INSERT INTO `route` (`id`, `date`, `train_id`) VALUES (21, '2016-03-07', 4);
INSERT INTO `route` (`id`, `date`, `train_id`) VALUES (18, '2016-03-08', 3);
INSERT INTO `route` (`id`, `date`, `train_id`) VALUES (23, '2016-03-08', 4);
INSERT INTO `route` (`id`, `date`, `train_id`) VALUES (35, '2016-03-09', 3);
INSERT INTO `route` (`id`, `date`, `train_id`) VALUES (22, '2016-03-10', 4);


-- what if someone deletes a station?
create table if not exists `route_item`(
	`id` serial,
	`arr_time` time,
	`dep_time` time,
	`ordinal` tinyint not null,
	`train_id` bigint unsigned not null,
	`station_id` smallint unsigned not null,
	
	primary key (`id`),
	unique key `ordinal_train_station` (`ordinal`, `train_id`, `station_id`),
	constraint `fk_route_item_train` foreign key (`train_id`) references `train`(`id`) on delete cascade on update cascade,
	constraint `fk_route_item_station` foreign key (`station_id`) references `station`(`id`) on update cascade
) charset=utf8;

INSERT INTO `route_item` (`id`, `arr_time`, `dep_time`, `ordinal`, `train_id`, `station_id`) VALUES (1, NULL, '07:23:00', 0, 1, 1);
INSERT INTO `route_item` (`id`, `arr_time`, `dep_time`, `ordinal`, `train_id`, `station_id`) VALUES (2, '08:58:00', '09:00:00', 1, 1, 3);
INSERT INTO `route_item` (`id`, `arr_time`, `dep_time`, `ordinal`, `train_id`, `station_id`) VALUES (3, '09:50:00', '09:52:00', 2, 1, 4);
INSERT INTO `route_item` (`id`, `arr_time`, `dep_time`, `ordinal`, `train_id`, `station_id`) VALUES (4, '11:46:00', '11:48:00', 3, 1, 15);
INSERT INTO `route_item` (`id`, `arr_time`, `dep_time`, `ordinal`, `train_id`, `station_id`) VALUES (5, '12:02:00', NULL, 4, 1, 2);
INSERT INTO `route_item` (`id`, `arr_time`, `dep_time`, `ordinal`, `train_id`, `station_id`) VALUES (6, NULL, '18:48:00', 0, 2, 1);
INSERT INTO `route_item` (`id`, `arr_time`, `dep_time`, `ordinal`, `train_id`, `station_id`) VALUES (7, '21:04:00', '21:06:00', 1, 2, 3);
INSERT INTO `route_item` (`id`, `arr_time`, `dep_time`, `ordinal`, `train_id`, `station_id`) VALUES (8, '00:47:00', '01:07:00', 2, 2, 2);
INSERT INTO `route_item` (`id`, `arr_time`, `dep_time`, `ordinal`, `train_id`, `station_id`) VALUES (9, '02:54:00', '02:56:00', 3, 2, 12);
INSERT INTO `route_item` (`id`, `arr_time`, `dep_time`, `ordinal`, `train_id`, `station_id`) VALUES (10, '04:54:00', '04:56:00', 4, 2, 13);
INSERT INTO `route_item` (`id`, `arr_time`, `dep_time`, `ordinal`, `train_id`, `station_id`) VALUES (11, '05:44:00', '06:04:00', 5, 2, 14);
INSERT INTO `route_item` (`id`, `arr_time`, `dep_time`, `ordinal`, `train_id`, `station_id`) VALUES (12, '07:15:00', '07:17:00', 6, 2, 16);
INSERT INTO `route_item` (`id`, `arr_time`, `dep_time`, `ordinal`, `train_id`, `station_id`) VALUES (13, '08:25:00', '08:48:00', 7, 2, 6);
INSERT INTO `route_item` (`id`, `arr_time`, `dep_time`, `ordinal`, `train_id`, `station_id`) VALUES (14, '10:58:00', NULL, 8, 2, 18);

INSERT INTO `route_item` (`id`, `arr_time`, `dep_time`, `ordinal`, `train_id`, `station_id`) VALUES (15, NULL, '21:37:00', 0, 3, 21);
INSERT INTO `route_item` (`id`, `arr_time`, `dep_time`, `ordinal`, `train_id`, `station_id`) VALUES (16, '23:09:00', '23:31:00', 1, 3, 11);
INSERT INTO `route_item` (`id`, `arr_time`, `dep_time`, `ordinal`, `train_id`, `station_id`) VALUES (17, '01:07:00', '01:12:00', 2, 3, 5);
INSERT INTO `route_item` (`id`, `arr_time`, `dep_time`, `ordinal`, `train_id`, `station_id`) VALUES (18, '02:47:00', '02:49:00', 3, 3, 20);
INSERT INTO `route_item` (`id`, `arr_time`, `dep_time`, `ordinal`, `train_id`, `station_id`) VALUES (19, '03:48:00', '03:58:00', 4, 3, 19);
INSERT INTO `route_item` (`id`, `arr_time`, `dep_time`, `ordinal`, `train_id`, `station_id`) VALUES (20, '04:47:00', '04:52:00', 5, 3, 22);
INSERT INTO `route_item` (`id`, `arr_time`, `dep_time`, `ordinal`, `train_id`, `station_id`) VALUES (21, '06:01:00', NULL, 6, 3, 1);
INSERT INTO `route_item` (`id`, `arr_time`, `dep_time`, `ordinal`, `train_id`, `station_id`) VALUES (22, NULL, '18:03:00', 0, 4, 2);
INSERT INTO `route_item` (`id`, `arr_time`, `dep_time`, `ordinal`, `train_id`, `station_id`) VALUES (23, '18:17:00', '18:19:00', 1, 4, 15);
INSERT INTO `route_item` (`id`, `arr_time`, `dep_time`, `ordinal`, `train_id`, `station_id`) VALUES (24, '20:11:00', '20:13:00', 2, 4, 4);
INSERT INTO `route_item` (`id`, `arr_time`, `dep_time`, `ordinal`, `train_id`, `station_id`) VALUES (25, '21:04:00', '21:06:00', 3, 4, 3);
INSERT INTO `route_item` (`id`, `arr_time`, `dep_time`, `ordinal`, `train_id`, `station_id`) VALUES (26, '22:40:00', NULL, 4, 4, 1);



-- -------------------------------------------------------------

create table if not exists `carriage_type` (
	`id` tinyint unsigned auto_increment not null unique,
	`name` varchar(15) not null unique,
	`seat_num` tinyint unsigned not null,
	
	primary key (`id`)
) charset=utf8;

insert into `carriage_type` values(1, 'db.couchette3', 54);
insert into `carriage_type` values(2, 'db.corridor2', 36);
insert into `carriage_type` values(3, 'db.suite1', 24);
insert into `carriage_type` values(4, 'db.sitting2', 80);
insert into `carriage_type` values(5, 'db.sitting1', 56);

create table if not exists `carriage` (
	`id` serial,
	`tag` varchar(10) not null,
	`price` decimal (5,2) not null,
	`type_id` tinyint unsigned not null,
	`train_id` bigint unsigned not null,
	
	primary key (`id`),
	unique key `tag_train` (`tag`, `train_id`),
	constraint `fk_carriage_car_type` foreign key (`type_id`) references `carriage_type`(`id`) on update cascade,
	constraint `fk_carriage_train` foreign key (`train_id`) references `train`(`id`) on delete cascade on update cascade
) charset=utf8;

INSERT INTO `carriage` (`id`, `tag`, `price`, `type_id`, `train_id`) VALUES (1, '1', 25.00, 5, 1);
INSERT INTO `carriage` (`id`, `tag`, `price`,  `type_id`, `train_id`) VALUES (2, '2',25.00, 5, 1);
INSERT INTO `carriage` (`id`, `tag`,  `price`, `type_id`, `train_id`) VALUES (3, '3',25.00, 5, 1);
INSERT INTO `carriage` (`id`, `tag`, `price`,  `type_id`, `train_id`) VALUES (4, '4a', 15.00, 4, 1);
INSERT INTO `carriage` (`id`, `tag`, `price`,  `type_id`, `train_id`) VALUES (5, '4', 15.00, 4, 1);
INSERT INTO `carriage` (`id`, `tag`, `price`,  `type_id`, `train_id`) VALUES (6, '5', 15.00, 4, 1);
INSERT INTO `carriage` (`id`, `tag`, `price`,  `type_id`, `train_id`) VALUES (7, '1', 15.00, 1, 2);
INSERT INTO `carriage` (`id`, `tag`, `price`,  `type_id`, `train_id`) VALUES (8, '2', 16.00, 1, 2);
INSERT INTO `carriage` (`id`, `tag`, `price`,  `type_id`, `train_id`) VALUES (9, '12', 20.00, 2, 2);
INSERT INTO `carriage` (`id`, `tag`, `price`,  `type_id`, `train_id`) VALUES (10, '4', 16.00, 1, 2);
INSERT INTO `carriage` (`id`, `tag`, `price`,  `type_id`, `train_id`) VALUES (11, '10', 20.00, 2, 2);
INSERT INTO `carriage` (`id`, `tag`, `price`, `type_id`, `train_id`) VALUES (12, '3', 15.00, 1, 2);
INSERT INTO `carriage` (`id`, `tag`,  `price`, `type_id`, `train_id`) VALUES (14, '2', 13.00, 1, 3);
INSERT INTO `carriage` (`id`, `tag`, `price`,  `type_id`, `train_id`) VALUES (15, '3', 13.00, 1, 3);
INSERT INTO `carriage` (`id`, `tag`, `price`,  `type_id`, `train_id`) VALUES (16, '7', 13.00, 1, 3);
INSERT INTO `carriage` (`id`, `tag`, `price`,  `type_id`, `train_id`) VALUES (17, '4', 25.00, 2, 3);
INSERT INTO `carriage` (`id`, `tag`, `price`,  `type_id`, `train_id`) VALUES (18, '5', 25.00, 2, 3);
INSERT INTO `carriage` (`id`, `tag`,  `price`, `type_id`, `train_id`) VALUES (19, '6', 30.00, 3, 3);
INSERT INTO `carriage` (`id`, `tag`,  `price`, `type_id`, `train_id`) VALUES (21, '3', 23.00, 5, 4);
INSERT INTO `carriage` (`id`, `tag`, `price`,  `type_id`, `train_id`) VALUES (22, '5', 23.00, 5, 4);
INSERT INTO `carriage` (`id`, `tag`, `price`,  `type_id`, `train_id`) VALUES (23, '6', 23.00, 5, 4);
INSERT INTO `carriage` (`id`, `tag`, `price`,  `type_id`, `train_id`) VALUES (24, '1a', 16.00, 4, 4);
INSERT INTO `carriage` (`id`, `tag`,  `price`, `type_id`, `train_id`) VALUES (25, '1', 16.00, 4, 4);
INSERT INTO `carriage` (`id`, `tag`, `price`,  `type_id`, `train_id`) VALUES (26, '2', 16.00, 4, 4);


-- -----------------------------------------------------------------------

create table if not exists `seat_type` (
	`id` tinyint unsigned auto_increment not null unique,
	`name` varchar(10) not null unique,
	
	primary key (`id`)
) charset=utf8;

insert into `seat_type` values(1, 'db.upper');
insert into `seat_type` values(2, 'db.lower');
insert into `seat_type` values(3, 'db.sitting');

-- --------------------------------------------------------
create table if not exists `discount_type` (
	`id` tinyint unsigned auto_increment not null unique,
	`name` varchar(15) not null unique,
	`perc` tinyint unsigned not null default 0,
	
	primary key (`id`)
) charset=utf8;

insert into `discount_type` values(0, 'db.student', 50);
insert into `discount_type` values(0, 'db.child', 50);

create table if not exists `status` (
	`id` tinyint unsigned auto_increment not null unique,
	`name` varchar(15) not null unique,
	
	primary key(`id`)
) charset=utf8;

-- hmmm integrity
create table if not exists `ticket` (
	`id` serial,
	`f_name` varchar(40) not null,
	`l_name` varchar(40) not null,
	`seat_num` tinyint not null,
	`price` decimal(5,2) not null,
	
	`user_id` bigint unsigned not null,
	`discount_type_id` tinyint unsigned,
	`status_id` tinyint unsigned references `status`(`id`),
	`carriage_id` bigint unsigned not null,
	`route_id` smallint unsigned not null,
	`route_item_dep_id` bigint unsigned not null,
	`route_item_arr_id` bigint unsigned not null,
	
	primary key(`id`),
	
	unique key `ticket_uniq` (`seat_num`, `carriage_id`, `route_id`, `route_item_dep_id`, `route_item_arr_id`),
	
	constraint `fk_ticket_user` foreign key(`user_id`) references `user`(`id`) on update cascade on delete cascade,
	constraint `fk_ticket_discount` foreign key(`discount_type_id`) references `discount_type`(`id`) on update cascade on delete cascade,
	constraint `fk_ticket_carriage` foreign key(`carriage_id`) references `carriage`(`id`) on update cascade on delete cascade,
	constraint `fk_ticket_route` foreign key(`route_id`) references `route`(`id`) on update cascade,
	constraint `fk_ticket_dep_station` foreign key(`route_item_dep_id`) references `route_item`(`id`) on update cascade,
	constraint `fk_ticket_arr_station` foreign key(`route_item_arr_id`) references `route_item`(`id`) on update cascade
) charset=utf8;

INSERT INTO `ticket` (`id`, `f_name`, `l_name`, `seat_num`, `price`, `user_id`, `discount_type_id`, `status_id`, `carriage_id`, `route_id`, `route_item_dep_id`, `route_item_arr_id`) VALUES (1, 'Дарья', 'Сердюк', 10, 112.00, 3, NULL, NULL, 10, 10, 3, 2);
INSERT INTO `ticket` (`id`, `f_name`, `l_name`, `seat_num`, `price`, `user_id`, `discount_type_id`, `status_id`, `carriage_id`, `route_id`, `route_item_dep_id`, `route_item_arr_id`) VALUES (2, 'Дарья', 'Сердюк', 11, 112.00, 3, NULL, NULL, 10, 10, 1, 3);
INSERT INTO `ticket` (`id`, `f_name`, `l_name`, `seat_num`, `price`, `user_id`, `discount_type_id`, `status_id`, `carriage_id`, `route_id`, `route_item_dep_id`, `route_item_arr_id`) VALUES (3, 'Дарья', 'Сердюк', 13, 112.00, 3, NULL, NULL, 10, 10, 3, 2);
INSERT INTO `ticket` (`id`, `f_name`, `l_name`, `seat_num`, `price`, `user_id`, `discount_type_id`, `status_id`, `carriage_id`, `route_id`, `route_item_dep_id`, `route_item_arr_id`) VALUES (4, 'Дарья', 'Сердюк', 1, 112.00, 3, NULL, NULL, 10, 10, 3, 2);
INSERT INTO `ticket` (`id`, `f_name`, `l_name`, `seat_num`, `price`, `user_id`, `discount_type_id`, `status_id`, `carriage_id`, `route_id`, `route_item_dep_id`, `route_item_arr_id`) VALUES (7, 'asdf', 'asf', 5, 110.00, 3, NULL, NULL, 2, 3, 1, 5);
INSERT INTO `ticket` (`id`, `f_name`, `l_name`, `seat_num`, `price`, `user_id`, `discount_type_id`, `status_id`, `carriage_id`, `route_id`, `route_item_dep_id`, `route_item_arr_id`) VALUES (8, 'Дарья', 'Сердюк', 24, 110.00, 3, NULL, NULL, 2, 3, 1, 5);
INSERT INTO `ticket` (`id`, `f_name`, `l_name`, `seat_num`, `price`, `user_id`, `discount_type_id`, `status_id`, `carriage_id`, `route_id`, `route_item_dep_id`, `route_item_arr_id`) VALUES (9, 'Ольга', 'Красникова', 1, 110.00, 3, NULL, NULL, 1, 2, 1, 5);
INSERT INTO `ticket` (`id`, `f_name`, `l_name`, `seat_num`, `price`, `user_id`, `discount_type_id`, `status_id`, `carriage_id`, `route_id`, `route_item_dep_id`, `route_item_arr_id`) VALUES (10, 'Иван', 'Иванов', 3, 110.00, 3, NULL, NULL, 1, 2, 1, 5);
INSERT INTO `ticket` (`id`, `f_name`, `l_name`, `seat_num`, `price`, `user_id`, `discount_type_id`, `status_id`, `carriage_id`, `route_id`, `route_item_dep_id`, `route_item_arr_id`) VALUES (11, 'Андрей', 'Кумпан', 13, 78.00, 3, NULL, NULL, 5, 2, 1, 5);



-- ---------------------------------------------------

create table if not exists `facility_type` (
	`id` tinyint unsigned auto_increment not null unique,
	`name` varchar(15) not null unique,
	`price` decimal(4,2) unsigned not null,
	
	primary key (`id`)
) charset=utf8;

insert into `facility_type` values(1, 'db.bed_linen', 18.00);
insert into `facility_type` values(2, 'db.tea', 5.00);

create table if not exists `facility` (
	`id` serial,
	`type_id` tinyint unsigned not null,
	`ticket_id` bigint unsigned not null,

	primary key (`id`),
	constraint `fk_facility_facility_type` foreign key(`type_id`) references `facility_type`(`id`) on update cascade,
	constraint `fk_facility_ticket` foreign key(`ticket_id`) references `ticket`(`id`) on delete cascade on update cascade
) charset=utf8;

