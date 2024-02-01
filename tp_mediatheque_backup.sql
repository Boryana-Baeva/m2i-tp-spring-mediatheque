create table adherents (date_expiration_abonnement date, date_start_abonnement date, id serial not null, nom varchar(255), numero_adherant varchar(255) unique, prenom varchar(255), primary key (id));
create table documents (id serial not null, is_available boolean not null, titre varchar(255) unique, type varchar(255) check (type in ('BOOK','ARTICLE','FILM','IMAGE')), primary key (id));
create table emprunts (adherent_id integer, date_start date not null, document_id integer, id serial not null, primary key (id));
alter table if exists emprunts add constraint FK5gdu5mujebshemuwwi4sla7bx foreign key (adherent_id) references adherents;
alter table if exists emprunts add constraint FKgdj36wd8qqcsrxohdf9yc4tr4 foreign key (document_id) references documents;
