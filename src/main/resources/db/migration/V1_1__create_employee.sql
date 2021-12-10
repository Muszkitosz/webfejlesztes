create table hr.employee(
    dolgozo_id          bigint identity(1,1) primary key,
    vezeteknev          nvarchar(255) not null,
    keresztnev          nvarchar(255) not null,
    szuletesi_datum     nvarchar(12)  not null,
    lakcim              nvarchar(255) not null,
    anyja_neve          nvarchar(255) not null
);