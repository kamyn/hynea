CREATE SCHEMA hynea;

create table hynea.breakfast (
    id bigserial not null,
    price integer,
    title varchar(255),
    image_name varchar(255),
    primary key (id)
);

create table hynea.drink (
    id bigserial not null,
    menu_item_id bigint,
    primary key (id)
);

create table hynea.ingredient (
    id bigserial not null,
    dosage integer,
    title varchar(255),
    primary key (id)
);

create table hynea.menu_item (
    id bigserial not null,
    price integer,
    serve_time integer,
    weight integer,
    title varchar(255),
    image_name varchar(255),
    primary key (id)
);

create table hynea.menu_item_breakfast (
    id bigserial not null,
    breakfast_id bigint,
    menu_item_id bigint,
    primary key (id)
);

create table hynea.menu_item_ingredient (
    id bigserial not null,
    ingredient_id bigint,
    menu_item_id bigint,
    primary key (id)
);

create table hynea.salad (
    id bigserial not null,
    menu_item_id bigint,
    primary key (id)
);

create table hynea.users (
    id bigserial not null,
    password_hash varchar(255),
    username varchar(255),
    primary key (id)
);

alter table if exists hynea.drink
    drop constraint if exists menu_item_drink_fk;

alter table if exists hynea.menu_item_breakfast
    drop constraint if exists menu_item_breakfast_fk1;

alter table if exists hynea.menu_item_breakfast
    drop constraint if exists menu_item_breakfast_fk2;

alter table if exists hynea.menu_item_ingredient
    drop constraint if exists menu_item_ingredient_fk1;

alter table if exists hynea.menu_item_ingredient
    drop constraint if exists menu_item_ingredient_fk2;

alter table if exists hynea.salad
    drop constraint if exists menu_item_salad_fk;

alter table if exists hynea.drink
    add constraint menu_item_drink_fk
    foreign key (menu_item_id) references hynea.menu_item on delete cascade;

alter table if exists hynea.menu_item_breakfast
    add constraint menu_item_breakfast_fk1
    foreign key (breakfast_id) references hynea.breakfast on delete cascade;

alter table if exists hynea.menu_item_breakfast
    add constraint menu_item_breakfast_fk2
    foreign key (menu_item_id) references hynea.menu_item on delete cascade;

alter table if exists hynea.menu_item_ingredient
    add constraint menu_item_ingredient_fk1
    foreign key (ingredient_id) references hynea.ingredient on delete cascade;

alter table if exists hynea.menu_item_ingredient
    add constraint menu_item_ingredient_fk2
    foreign key (menu_item_id) references hynea.menu_item on delete cascade;

alter table if exists hynea.salad
    add constraint menu_item_salad_fk
    foreign key (menu_item_id) references hynea.menu_item on delete cascade;