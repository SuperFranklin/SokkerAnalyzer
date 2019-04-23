create table if not exists sokker.`sessions` (
	`login` varchar(64) not null,
    `password` varchar(64) not null,
    `ip` varchar(32) not null,
    `time_to` timestamp not null,
    primary key(`login`));
