DELETE FROM users;
DELETE FROM devices;
ALTER SEQUENCE users_id_seq RESTART WITH 10000;

-- user: qwerty
-- user2: admin@123
INSERT INTO users ("id", "username", "password", "registered", "enabled") VALUES
  (10001, 'user', '$2a$10$EKmVCVVli63OcrjewfHbUeSbdKZpKCFau1KDKLwu/IPDgSBRhn/xu', DEFAULT, DEFAULT),
  (10002, 'user2', '$2a$10$hbxecwitQQ.dDT4JOFzQAulNySFwEpaFLw38jda6Td.Y/cOiRzDFu', DEFAULT, DEFAULT);

INSERT INTO devices ("id", "serial_no", "type", "description", "user_id", "created_at") VALUES
  ('de4dd4eb-0eb8-4d8b-9d7b-fdf1f230c336', '1234567890', 'датчик дыма', 'описание датчика дыма', 10001, DEFAULT),
  ('750a029a-d9b4-4fa6-a79e-768ce11086b6', '1234554321', 'датчик влажности', 'описание датчика влажности', 10001, DEFAULT),
  ('d05956a4-1827-4e63-94dd-e891cf6cbbd1', '11111111', 'датчик температуры', 'описание датчика температуры', 10002, DEFAULT),
  ('ad8d0ddd-e4d4-4390-ad73-7dcc28dd341d', '22222222', 'датчик температуры', 'Описание другого датчика температуры ', 10002, DEFAULT),
  ('d6afaf93-8bef-45b8-8c0e-deaea9874ab4', '33333333', 'агрегат', 'Это подробное описание ', 10002, DEFAULT);