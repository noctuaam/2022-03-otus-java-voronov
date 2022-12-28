alter table phone add column client_id bigint
CONSTRAINT fk_client_id REFERENCES client(id);