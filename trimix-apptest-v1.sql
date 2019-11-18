--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.22
-- Dumped by pg_dump version 9.4.22
-- Started on 2019-11-18 07:29:46 -03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;

--
-- TOC entry 8 (class 2615 OID 41854)
-- Name: trimix; Type: SCHEMA; Schema: -; Owner: -
--

CREATE SCHEMA trimix;


--
-- TOC entry 1 (class 3079 OID 11897)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2043 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 175 (class 1259 OID 41863)
-- Name: id_persona_seq; Type: SEQUENCE; Schema: trimix; Owner: -
--

CREATE SEQUENCE trimix.id_persona_seq
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 174 (class 1259 OID 41855)
-- Name: persona; Type: TABLE; Schema: trimix; Owner: -; Tablespace: 
--

CREATE TABLE trimix.persona (
    id_persona bigint DEFAULT nextval('trimix.id_persona_seq'::regclass) NOT NULL,
    nombre character varying,
    apellido character varying,
    tipo_documento character varying,
    nro_documento bigint,
    fec_nac date
);


--
-- TOC entry 1925 (class 2606 OID 41862)
-- Name: id_persona_pk; Type: CONSTRAINT; Schema: trimix; Owner: -; Tablespace: 
--

ALTER TABLE ONLY trimix.persona
    ADD CONSTRAINT id_persona_pk PRIMARY KEY (id_persona);


--
-- TOC entry 2042 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: -
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2019-11-18 07:29:46 -03

--
-- PostgreSQL database dump complete
--

