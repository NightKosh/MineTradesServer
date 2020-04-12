CREATE TABLE shops (
  owner text NOT NULL,
  price double precision NOT NULL,
  itemConfig text NOT NULL,
  x integer NOT NULL,
  y integer NOT NULL,
  z integer NOT NULL,
  world varchar(32) NOT NULL,
  unlimited SMALLINT DEFAULT NULL,
  type SMALLINT DEFAULT NULL,
  PRIMARY KEY (x, y, z, world)
);