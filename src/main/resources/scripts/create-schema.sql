
    drop table if exists MAIL_TEMPLATE;

    create table MAIL_TEMPLATE (
        ID integer not null auto_increment,
        NAME varchar(255),
        TEMPLATE TEXT,
        primary key (ID)
    );
