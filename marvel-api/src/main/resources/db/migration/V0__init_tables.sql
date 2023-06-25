CREATE TABLE users (
  id IDENTITY PRIMARY KEY,
  name VARCHAR(255),
  last_name VARCHAR(255),
  email VARCHAR(255),
  password VARCHAR(255),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP()
);

INSERT INTO users (name, last_name, email, password)
  VALUES ('Jhon', 'Doe', 'admin@company.com', '202cb962ac59075b964b07152d234b70');

CREATE TABLE events (
    id IDENTITY PRIMARY KEY,
    type VARCHAR(255) NOT NULL,
    user_registered VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP()
);