CREATE TABLE `jdbcdemo`.`t_user`  (
`id` int(0) NOT NULL AUTO_INCREMENT,
`name` varchar(255) NULL,
PRIMARY KEY (`id`)
);

INSERT INTO `jdbcdemo`.`t_user`(`id`, `name`) VALUES (1, 'uuuu');
INSERT INTO `jdbcdemo`.`t_user`(`id`, `name`) VALUES (2, 'dddd');