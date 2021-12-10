create table hr.employee_job(
    dolgozo_beosztas_id bigint identity(1,1) primary key,
    dolgozo_id          bigint not null FOREIGN KEY REFERENCES hr.employee(dolgozo_id),
    beosztas_id         bigint not null FOREIGN KEY REFERENCES hr.job(beosztas_id),
    felvetel_datum      date   not null
);