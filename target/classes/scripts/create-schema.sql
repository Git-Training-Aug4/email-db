
    drop table if exists EMAIL;

    create table EMAIL (
        ID integer not null auto_increment,
        NAME varchar(255),
        PATTERN TEXT,
        primary key (ID)
    );
