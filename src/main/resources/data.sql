INSERT INTO district (title) VALUES ('East') ON CONFLICT DO NOTHING;
INSERT INTO district (title) VALUES ('West') ON CONFLICT DO NOTHING;
INSERT INTO district (title) VALUES ('North') ON CONFLICT DO NOTHING;
INSERT INTO district (title) VALUES ('South') ON CONFLICT DO NOTHING;

INSERT INTO specialization (name) VALUES ('Landscaping') ON CONFLICT DO NOTHING;
INSERT INTO specialization (name) VALUES ('Construction') ON CONFLICT DO NOTHING;