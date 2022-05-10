insert into clients(created_at, is_deleted, updated_at, first_name, last_name, phone_number)
VALUES ('2022-05-07 11:55:56',false,'2022-06-01 12:00:00','Jon', 'Goodman','123456789');

insert into drivers_riders(created_at, is_deleted, updated_at, first_name, last_name, phone_number)
VALUES ('2022-05-07 11:55:56',false,'2022-06-01 12:00:00','Matt', 'Driver','123456789');

insert into jobs(created_at, is_deleted, updated_at, delivery_date, delivery_time, description, job_reference, location, status, client_id, driver_rider_id) VALUES
('2022-05-07 11:55:56',false,'2022-06-01 12:00:00','2022-06-01 12:00:00','2022-06-01 14:00:00','Fragile Box Cargo', '1A','Liverpool','NEW',1,1)

insert into job_items(created_at, is_deleted, updated_at, description, job_id)
VALUES ('2022-05-07 11:55:56',false,'2022-06-01 12:00:00','10 Monitor box',1),
       ('2022-05-07 11:55:56',false,'2022-06-01 12:00:00','8 Laptop case ',1),
       ('2022-05-07 11:55:56',false,'2022-06-01 12:00:00','5 Desk',1);