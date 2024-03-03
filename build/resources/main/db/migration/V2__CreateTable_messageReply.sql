create table message_replace(
    id_base_message bigint references messages (id_message) not null, --constraint fk_base_messages_user,
    id_reply_message bigint references messages (id_message) not null --constraint fk_reply_messages_user
)