-- Table: public.players

-- DROP TABLE public.players;

CREATE TABLE public.players
(
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    surname character varying(255) COLLATE pg_catalog."default" NOT NULL,
    player_id bigint NOT NULL
)
WITH (
    OIDS = FALSE
)