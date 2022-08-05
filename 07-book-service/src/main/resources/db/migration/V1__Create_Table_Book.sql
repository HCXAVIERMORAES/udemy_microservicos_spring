CREATE TABLE book (
  id SERIAL ,
  author TEXT,
  launch_date timestamp NOT NULL,
  price decimal(65,2) NOT NULL,
  title TEXT,
  PRIMARY KEY (id)
);
