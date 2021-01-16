create table if not exists user
(
    id uuid default random_uuid() primary key,
    user_id varchar(255),
    name varchar(255),
    pwd varchar (255)
    );

create table if not exists bank_transactions
(
    id uuid default random_uuid() primary key,
    t_userid varchar(255),
    amount int,
    reference varchar (255)
    );