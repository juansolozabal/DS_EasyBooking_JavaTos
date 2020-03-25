/* DELETE 'productsDB' database*/
DROP SCHEMA productsDB;

/* DELETE USER 'products_user' AT LOCAL SERVER*/
DROP USER 'vQLVHjSzCJ'@'%';

/* CREATE ''productsDB' DATABASE */
CREATE SCHEMA productsDB;

/* CREATE THE USER 'products_user' AT LOCAL SERVER WITH PASSWORD 'password' */

CREATE USER 'vQLVHjSzCJ'@'%' IDENTIFIED BY 'lwb6EqCayw';

/* GRANT FULL ACCESS TO THE DATABASE FOR THE USER 'products_user' AT LOCAL SERVER*/
GRANT ALL ON productsDB.* TO 'vQLVHjSzCJ'@'%';
