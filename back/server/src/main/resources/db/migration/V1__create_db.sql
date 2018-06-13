CREATE TABLE users (
  id           BIGSERIAL NOT NULL PRIMARY KEY,
  username     TEXT      NOT NULL,
  password     TEXT      NOT NULL,
  email        TEXT      NOT NULL,
  active       BOOLEAN   NOT NULL,
  created      TIMESTAMP NOT NULL DEFAULT NOW(),
  last_session TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE roles (
  id   BIGSERIAL NOT NULL PRIMARY KEY,
  name TEXT      NOT NULL
);

CREATE TABLE user_roles (
  id      BIGSERIAL NOT NULL PRIMARY KEY,
  user_id BIGINT    NOT NULL REFERENCES users (id),
  role_id BIGINT    NOT NULL REFERENCES roles (id)
);

CREATE TABLE resources (
  id     BIGSERIAL NOT NULL PRIMARY KEY,
  name   TEXT      NOT NULL,
  active BOOLEAN   NOT NULL
);

CREATE TABLE user_resources (
  id          BIGSERIAL NOT NULL PRIMARY KEY,
  user_id     BIGINT    NOT NULL REFERENCES users (id),
  resource_id BIGINT    NOT NULL REFERENCES resources (id),
  active      BOOLEAN   NOT NULL
);

CREATE TABLE channel_types (
  id   BIGSERIAL NOT NULL PRIMARY KEY,
  name TEXT      NOT NULL
);

CREATE TABLE channels (
  id          BIGSERIAL NOT NULL PRIMARY KEY,
  resource_id BIGINT    NOT NULL REFERENCES resources (id),
  type_id     BIGINT    NOT NULL REFERENCES channel_types (id),
  identifier  TEXT      NOT NULL
);

CREATE TABLE user_channels (
  id           BIGSERIAL NOT NULL PRIMARY KEY,
  user_id      BIGINT    NOT NULL REFERENCES users (id),
  channel_id   BIGINT    NOT NULL REFERENCES channels (id),
  notification BOOLEAN   NOT NULL,
  active       BOOLEAN   NOT NULL
);

INSERT INTO users (username, password, email, active) VALUES
  ('admin', 'admin', 'admin@mail.ru', TRUE),
  ('guest', 'guest', 'guest@mail.ru', TRUE);

INSERT INTO roles (name) VALUES
  ('ROLE_USER'),
  ('ROLE_ADMIN');

INSERT INTO user_roles (user_id, role_id) VALUES
  (1, 1),
  (2, 2);

INSERT INTO resources (name, active) VALUES
  ('vk', TRUE),
  ('facebook', FALSE),
  ('twitter', FALSE),
  ('instagram', TRUE),
  ('ok', FALSE);

INSERT INTO user_resources (user_id, resource_id, active) VALUES
  (1, 1, TRUE),
  (2, 1, TRUE);

INSERT INTO channel_types (name) VALUES
  ('CHANNEL'),
  ('PERSONAL');

INSERT INTO channels (resource_id, type_id, identifier) VALUES
  (1, 1, '-48413872'),
  (1, 1, '-41150947'),
  (4, 2, 'news'),
  (4, 2, 'mujjostore'),
  (4, 2, 'fashionforall'),
  (4, 2, 'teddybearabroad');

INSERT INTO user_channels (user_id, channel_id, notification, active) VALUES
  (1, 2, FALSE, TRUE),
  (2, 1, FALSE, TRUE),
  (2, 2, FALSE, TRUE);



