create table hr.job(
    beosztas_id bigint identity(1,1) primary key,
    beosztas_neve nvarchar(255) not null,
    rovid_leiras nvarchar(255) not null
);