create table users(
    id_user bigserial primary key,
    user_name character varying(60)
);

create table region(
    id_region serial primary key,
    region_name character varying(50)
);

create table country(
    id_country serial primary key,
    country_name character varying(250),
    region_id int references region (id_region) not null constraint fk_country_region
);

create table city(
    id_city bigserial primary key,
    city_name character varying(250),
    country_id int references country(id_country) not null constraint fk_city_country
);

create table topic(
    id_topic serial primary key,
    city_id bigint references city(id_city) constraint fk_topic_city,
    country_id int references country(id_country) constraint fk_topic_country
);

create table messages(
    id_message bigserial primary key,
    text_Message text,
    user_id bigint references users (id_user) not null constraint fk_messages_user,
    topic_id int references topic (id_topic) not null constraint fk_messages_topic,
    created_at date
)