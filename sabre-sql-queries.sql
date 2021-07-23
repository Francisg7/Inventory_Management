create database sabredb;

select * from sabredb.group_tbl;
select * from sabredb.permission_tbl;
select * from sabredb.group_permission_tbl;
select * from sabredb.login_tbl;
select * from sabredb.order_tbl;
select * from sabredb.order_products_tbl;
select * from sabredb.product_tbl;

/* insert settings */
insert into sabredb.settings_tbl (`company_name`, `phone_number`, `email`, `address`, `country`, `vat_charge`) values ('myCompany', '0123456789', 'myComapny@sabre.com', 'some address', 'Spain', 9);

/* insert permissions */
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_CREATE_EMPLOYEES');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_UPDATE_EMPLOYEES');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_VIEW_EMPLOYEES');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_DELETE_EMPLOYEES');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_CREATE_PRODUCTS');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_UPDATE_PRODUCTS');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_VIEW_PRODUCTS');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_DELETE_PRODUCTS');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_CREATE_CATEGORIES');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_UPDATE_CATEGORIES');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_VIEW_CATEGORIES');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_DELETE_CATEGORIES');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_CREATE_STORES');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_UPDATE_STORES');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_VIEW_STORES');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_DELETE_STORES');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_CREATE_GROUPS');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_UPDATE_GROUPS');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_VIEW_GROUPS');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_DELETE_GROUPS');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_CREATE_ORDERS');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_UPDATE_ORDERS');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_VIEW_ORDERS');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_DELETE_ORDERS');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_CREATE_SUPPLIERS');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_UPDATE_SUPPLIERS');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_VIEW_SUPPLIERS');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_DELETE_SUPPLIERS');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_CREATE_LOGINS');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_UPDATE_LOGINS');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_VIEW_LOGINS');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_DELETE_LOGINS');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_UPDATE_SETTINGS');
insert into sabredb.permission_tbl (`name`) values ('PERMISSION_VIEW_SETTINGS');
