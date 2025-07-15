alter table respuestas add state tinyint;
update respuestas set state=1;

alter table usuarios add state tinyint;
update usuarios set state=1;