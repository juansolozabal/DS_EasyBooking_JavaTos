/* DELETE 'productsDB' database*/
DROP SCHEMA productsDB;

/* DELETE USER 'products_user' AT LOCAL SERVER*/
DROP USER 'uixjskf8gv6vwlpc'@'%';

/* CREATE ''productsDB' DATABASE */
CREATE SCHEMA productsDB;

/* CREATE THE USER 'products_user' AT LOCAL SERVER WITH PASSWORD 'password' */

CREATE USER 'uixjskf8gv6vwlpc'@'%' IDENTIFIED BY 'dr9d0imb1vYbYI4rCJlr';

/* GRANT FULL ACCESS TO THE DATABASE FOR THE USER 'products_user' AT LOCAL SERVER*/
GRANT ALL ON productsDB.* TO 'uixjskf8gv6vwlpc'@'%';
