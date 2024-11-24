CREATE TABLE list_item
(
    id               INT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    supplier_list_id INT                                  NOT NULL,
    product_id       INT                                  NOT NULL,
    quantity         INT                                  NOT NULL,
    comment          CLOB,
    updated_at       TIMESTAMP                            NOT NULL,
    CONSTRAINT pk_listitem PRIMARY KEY (id)
);

CREATE TABLE measure_unit
(
    id            INT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    singular_name VARCHAR(255)                         NOT NULL,
    plural_name   VARCHAR(255),
    CONSTRAINT pk_measureunit PRIMARY KEY (id)
);

CREATE TABLE product
(
    id              INT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    sku             INT                                  NOT NULL,
    name            VARCHAR(255)                         NOT NULL,
    supplier_id     INT                                  NOT NULL,
    measure_unit_id INT                                  NOT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE supplier
(
    id   INT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name VARCHAR(255)                         NOT NULL,
    CONSTRAINT pk_supplier PRIMARY KEY (id)
);

CREATE TABLE supplier_list
(
    id            INT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name          VARCHAR(255)                         NOT NULL,
    creation_date TIMESTAMP                            NOT NULL,
    CONSTRAINT pk_supplierlist PRIMARY KEY (id)
);

CREATE INDEX name ON product (name);

CREATE UNIQUE INDEX sku ON product (sku);

ALTER TABLE list_item
    ADD CONSTRAINT FK_LISTITEM_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE list_item
    ADD CONSTRAINT FK_LISTITEM_ON_SUPPLIER_LIST FOREIGN KEY (supplier_list_id) REFERENCES supplier_list (id) ON DELETE CASCADE;

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_MEASURE_UNIT FOREIGN KEY (measure_unit_id) REFERENCES measure_unit (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_SUPPLIER FOREIGN KEY (supplier_id) REFERENCES supplier (id);