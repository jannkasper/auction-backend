
CREATE TABLE active.customers
(
    customer_id             integer NOT NULL,
    email                   character varying(50) COLLATE pg_catalog."default"  NOT NULL,
    pwd                     character varying(200) COLLATE pg_catalog."default" NOT NULL,
    role                    character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_customers PRIMARY KEY (customer_id)
);

INSERT INTO active.customers (customer_id, email, pwd, role)
VALUES (1, 'jan', '12345', 'admin');

INSERT INTO active.customers (customer_id, email, pwd, role)
VALUES (2, 'jan2', '$2y$12$oRRbkNfwuR8ug4MlzH5FOeui.//1mkd.RsOAJMbykTSupVy.x/vb2', 'admin');
