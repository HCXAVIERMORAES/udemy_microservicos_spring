CREATE TABLE IF NOT EXISTS cambio (
  id serial NOT NULL,
  from_currency CHAR(3) NOT NULL,
  to_currency CHAR(3) NOT NULL,
  conversion_factor decimal(65,2) NOT NULL,
  PRIMARY KEY (id)
);
