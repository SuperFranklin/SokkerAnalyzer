create table if not exists sokker.`players` (
	`id` int unsigned not null,
    `name` varchar(64) not null,
    `surename` varchar(64) not null,
    `country_id` smallint unsigned not null,
    primary key(`id`));