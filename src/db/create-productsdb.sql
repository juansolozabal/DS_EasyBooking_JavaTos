/* DELETE 'productsDB' database*/
DROP SCHEMA productsDB;

/* DELETE USER 'products_user' AT LOCAL SERVER*/
DROP USER 'db4hFGoBHE'@'%';

/* CREATE ''productsDB' DATABASE */
CREATE SCHEMA productsDB;

/* CREATE THE USER 'products_user' AT LOCAL SERVER WITH PASSWORD 'password' */

CREATE USER 'db4hFGoBHE'@'%' IDENTIFIED BY 'zCt1wUkWlA';

/* GRANT FULL ACCESS TO THE DATABASE FOR THE USER 'products_user' AT LOCAL SERVER*/
GRANT ALL ON productsDB.* TO 'db4hFGoBHE'@'%';
