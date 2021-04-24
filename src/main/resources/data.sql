
insert into brands(id, name) values (1, 'Hp');
insert into brands(id, name) values (2, 'Acer');

insert into manufacturer(id, name) values(1, 'Intel');
insert into manufacturer(id, name) values(2, 'AMD');

insert into processors(id, name, manufacturer_id, speed_ghz) VALUES(1, 'corei7',1, 2.0);
insert into processors(id, name, manufacturer_id, speed_ghz) VALUES(2, 'corei5',1, 1.9);
insert into processors(id, name, manufacturer_id, speed_ghz) VALUES(3, 'corei3',1, 1.6);
insert into processors(id, name, manufacturer_id, speed_ghz) VALUES(4, 'ryzen5',2, 2.3);


insert into computer_ram(id, ram_size_gb, ram_type) values(1, 4, 'DDR3');
insert into computer_ram(id, ram_size_gb, ram_type) values(2, 8, 'DDR3');
insert into computer_ram(id, ram_size_gb, ram_type) values(3, 4, 'DDR4');
insert into computer_ram(id, ram_size_gb, ram_type) values(4, 8, 'DDR4');
insert into computer_ram(id, ram_size_gb, ram_type) values(5, 16, 'DDR4');


insert into laptops(id, name, description,display_size, price,brand_id,processor_id, ram_id)
VALUES (1, 'Hp Omen', 'cool', 14.0, 30000, 1,3,1);

insert into laptops(id, name, description,display_size, price,brand_id,processor_id, ram_id)
VALUES (2, 'Hp Pavilion', 'cool shitty laptop', 15.0, 60000, 1, 2, 2);

insert into laptops(id, name, description,display_size, price,brand_id,processor_id, ram_id)
VALUES (3, 'Hp Elite Book', 'cool shitty laptop', 13.0, 45000, 1, 1, 3);

insert into laptops(id, name, description,display_size, price,brand_id,processor_id, ram_id)
VALUES (4, 'Hp Think Pad', 'cool shitty laptop', 15.0, 60000, 1, 2, 5);

insert into laptops(id, name, description,display_size, price,brand_id,processor_id, ram_id)
VALUES (5, 'Acer 15', 'cool shitty laptop', 15.0, 70000, 2, 2, 4);



insert into computer_storage(id, storage_size_gb, storage_type, laptop_id) values (1, 512, 'HDD', 1);
insert into computer_storage(id, storage_size_gb, storage_type, laptop_id) values (2, 128, 'SDD', 1);
insert into computer_storage(id, storage_size_gb, storage_type, laptop_id) values (3, 512, 'HDD', 2);
insert into computer_storage(id, storage_size_gb, storage_type, laptop_id) values (4, 512, 'SDD', 3);
insert into computer_storage(id, storage_size_gb, storage_type, laptop_id) values (5, 256, 'SDD', 4);
insert into computer_storage(id, storage_size_gb, storage_type, laptop_id) values (6, 256, 'SDD', 5);

