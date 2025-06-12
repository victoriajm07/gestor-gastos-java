--
-- PostgreSQL database dump
--

-- Dumped from database version 17.4
-- Dumped by pg_dump version 17.4

-- Started on 2025-06-12 18:48:37

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 228 (class 1259 OID 24881)
-- Name: distribuciongasto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.distribuciongasto (
    id_distribucion integer NOT NULL,
    id_gasto_grupo integer NOT NULL,
    id_usuario integer NOT NULL,
    monto_a_pagar numeric(10,2) NOT NULL
);


ALTER TABLE public.distribuciongasto OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 24880)
-- Name: distribuciongasto_id_distribucion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.distribuciongasto_id_distribucion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.distribuciongasto_id_distribucion_seq OWNER TO postgres;

--
-- TOC entry 4909 (class 0 OID 0)
-- Dependencies: 227
-- Name: distribuciongasto_id_distribucion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.distribuciongasto_id_distribucion_seq OWNED BY public.distribuciongasto.id_distribucion;


--
-- TOC entry 220 (class 1259 OID 24830)
-- Name: gasto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.gasto (
    id_gasto integer NOT NULL,
    monto numeric(10,2) NOT NULL,
    fecha date NOT NULL,
    "categoría" character varying(50) NOT NULL,
    tipo character varying(20) NOT NULL,
    id_usuario integer NOT NULL,
    CONSTRAINT gasto_tipo_check CHECK (((tipo)::text = ANY ((ARRAY['personal'::character varying, 'grupal'::character varying])::text[])))
);


ALTER TABLE public.gasto OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 24829)
-- Name: gasto_id_gasto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.gasto_id_gasto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.gasto_id_gasto_seq OWNER TO postgres;

--
-- TOC entry 4910 (class 0 OID 0)
-- Dependencies: 219
-- Name: gasto_id_gasto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.gasto_id_gasto_seq OWNED BY public.gasto.id_gasto;


--
-- TOC entry 226 (class 1259 OID 24869)
-- Name: gastogrupo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.gastogrupo (
    id_gasto_grupo integer NOT NULL,
    id_grupo integer NOT NULL,
    monto numeric(10,2) NOT NULL,
    fecha date NOT NULL,
    "categoría" character varying(50) NOT NULL
);


ALTER TABLE public.gastogrupo OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 24868)
-- Name: gastogrupo_id_gasto_grupo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.gastogrupo_id_gasto_grupo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.gastogrupo_id_gasto_grupo_seq OWNER TO postgres;

--
-- TOC entry 4911 (class 0 OID 0)
-- Dependencies: 225
-- Name: gastogrupo_id_gasto_grupo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.gastogrupo_id_gasto_grupo_seq OWNED BY public.gastogrupo.id_gasto_grupo;


--
-- TOC entry 222 (class 1259 OID 24843)
-- Name: grupo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.grupo (
    id_grupo integer NOT NULL,
    nombre_grupo character varying(100) NOT NULL,
    descripcion text
);


ALTER TABLE public.grupo OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 24842)
-- Name: grupo_id_grupo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.grupo_id_grupo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.grupo_id_grupo_seq OWNER TO postgres;

--
-- TOC entry 4912 (class 0 OID 0)
-- Dependencies: 221
-- Name: grupo_id_grupo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.grupo_id_grupo_seq OWNED BY public.grupo.id_grupo;


--
-- TOC entry 224 (class 1259 OID 24852)
-- Name: miembrogrupo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.miembrogrupo (
    id_miembro integer NOT NULL,
    id_usuario integer NOT NULL,
    id_grupo integer NOT NULL
);


ALTER TABLE public.miembrogrupo OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 24851)
-- Name: miembrogrupo_id_miembro_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.miembrogrupo_id_miembro_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.miembrogrupo_id_miembro_seq OWNER TO postgres;

--
-- TOC entry 4913 (class 0 OID 0)
-- Dependencies: 223
-- Name: miembrogrupo_id_miembro_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.miembrogrupo_id_miembro_seq OWNED BY public.miembrogrupo.id_miembro;


--
-- TOC entry 218 (class 1259 OID 24821)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    id_usuario integer NOT NULL,
    nombre character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    "contraseña" character varying(255) NOT NULL
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 24820)
-- Name: usuario_id_usuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_id_usuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.usuario_id_usuario_seq OWNER TO postgres;

--
-- TOC entry 4914 (class 0 OID 0)
-- Dependencies: 217
-- Name: usuario_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuario_id_usuario_seq OWNED BY public.usuario.id_usuario;


--
-- TOC entry 4725 (class 2604 OID 24884)
-- Name: distribuciongasto id_distribucion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.distribuciongasto ALTER COLUMN id_distribucion SET DEFAULT nextval('public.distribuciongasto_id_distribucion_seq'::regclass);


--
-- TOC entry 4721 (class 2604 OID 24833)
-- Name: gasto id_gasto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gasto ALTER COLUMN id_gasto SET DEFAULT nextval('public.gasto_id_gasto_seq'::regclass);


--
-- TOC entry 4724 (class 2604 OID 24872)
-- Name: gastogrupo id_gasto_grupo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gastogrupo ALTER COLUMN id_gasto_grupo SET DEFAULT nextval('public.gastogrupo_id_gasto_grupo_seq'::regclass);


--
-- TOC entry 4722 (class 2604 OID 24846)
-- Name: grupo id_grupo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.grupo ALTER COLUMN id_grupo SET DEFAULT nextval('public.grupo_id_grupo_seq'::regclass);


--
-- TOC entry 4723 (class 2604 OID 24855)
-- Name: miembrogrupo id_miembro; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.miembrogrupo ALTER COLUMN id_miembro SET DEFAULT nextval('public.miembrogrupo_id_miembro_seq'::regclass);


--
-- TOC entry 4720 (class 2604 OID 24824)
-- Name: usuario id_usuario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario ALTER COLUMN id_usuario SET DEFAULT nextval('public.usuario_id_usuario_seq'::regclass);


--
-- TOC entry 4903 (class 0 OID 24881)
-- Dependencies: 228
-- Data for Name: distribuciongasto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.distribuciongasto (id_distribucion, id_gasto_grupo, id_usuario, monto_a_pagar) FROM stdin;
1	1	1	50.00
2	1	2	50.00
3	1	3	50.00
4	2	2	50.00
5	2	4	50.00
\.


--
-- TOC entry 4895 (class 0 OID 24830)
-- Dependencies: 220
-- Data for Name: gasto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.gasto (id_gasto, monto, fecha, "categoría", tipo, id_usuario) FROM stdin;
1	50.00	2025-04-01	Comida	personal	1
2	30.00	2025-04-02	Transporte	personal	2
3	20.00	2025-04-03	Entretenimiento	personal	3
\.


--
-- TOC entry 4901 (class 0 OID 24869)
-- Dependencies: 226
-- Data for Name: gastogrupo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.gastogrupo (id_gasto_grupo, id_grupo, monto, fecha, "categoría") FROM stdin;
1	1	150.00	2025-04-05	Alojamiento
2	2	100.00	2025-04-06	Cena
\.


--
-- TOC entry 4897 (class 0 OID 24843)
-- Dependencies: 222
-- Data for Name: grupo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.grupo (id_grupo, nombre_grupo, descripcion) FROM stdin;
1	Viaje a la Playa	Gastos compartidos para el viaje a la playa.
2	Cena de Amigos	Gastos compartidos para una cena grupal.
\.


--
-- TOC entry 4899 (class 0 OID 24852)
-- Dependencies: 224
-- Data for Name: miembrogrupo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.miembrogrupo (id_miembro, id_usuario, id_grupo) FROM stdin;
1	1	1
2	2	1
3	3	1
4	2	2
5	4	2
\.


--
-- TOC entry 4893 (class 0 OID 24821)
-- Dependencies: 218
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (id_usuario, nombre, email, "contraseña") FROM stdin;
1	Juan Pérez	juan.perez@example.com	password123
2	Ana Gómez	ana.gomez@example.com	password456
3	Carlos López	carlos.lopez@example.com	password789
4	María Fernández	maria.fernandez@example.com	password321
\.


--
-- TOC entry 4915 (class 0 OID 0)
-- Dependencies: 227
-- Name: distribuciongasto_id_distribucion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.distribuciongasto_id_distribucion_seq', 5, true);


--
-- TOC entry 4916 (class 0 OID 0)
-- Dependencies: 219
-- Name: gasto_id_gasto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.gasto_id_gasto_seq', 3, true);


--
-- TOC entry 4917 (class 0 OID 0)
-- Dependencies: 225
-- Name: gastogrupo_id_gasto_grupo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.gastogrupo_id_gasto_grupo_seq', 2, true);


--
-- TOC entry 4918 (class 0 OID 0)
-- Dependencies: 221
-- Name: grupo_id_grupo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.grupo_id_grupo_seq', 2, true);


--
-- TOC entry 4919 (class 0 OID 0)
-- Dependencies: 223
-- Name: miembrogrupo_id_miembro_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.miembrogrupo_id_miembro_seq', 5, true);


--
-- TOC entry 4920 (class 0 OID 0)
-- Dependencies: 217
-- Name: usuario_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_id_usuario_seq', 7, true);


--
-- TOC entry 4740 (class 2606 OID 24886)
-- Name: distribuciongasto distribuciongasto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.distribuciongasto
    ADD CONSTRAINT distribuciongasto_pkey PRIMARY KEY (id_distribucion);


--
-- TOC entry 4732 (class 2606 OID 24836)
-- Name: gasto gasto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gasto
    ADD CONSTRAINT gasto_pkey PRIMARY KEY (id_gasto);


--
-- TOC entry 4738 (class 2606 OID 24874)
-- Name: gastogrupo gastogrupo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gastogrupo
    ADD CONSTRAINT gastogrupo_pkey PRIMARY KEY (id_gasto_grupo);


--
-- TOC entry 4734 (class 2606 OID 24850)
-- Name: grupo grupo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.grupo
    ADD CONSTRAINT grupo_pkey PRIMARY KEY (id_grupo);


--
-- TOC entry 4736 (class 2606 OID 24857)
-- Name: miembrogrupo miembrogrupo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.miembrogrupo
    ADD CONSTRAINT miembrogrupo_pkey PRIMARY KEY (id_miembro);


--
-- TOC entry 4728 (class 2606 OID 24828)
-- Name: usuario usuario_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_email_key UNIQUE (email);


--
-- TOC entry 4730 (class 2606 OID 24826)
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario);


--
-- TOC entry 4745 (class 2606 OID 24887)
-- Name: distribuciongasto distribuciongasto_id_gasto_grupo_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.distribuciongasto
    ADD CONSTRAINT distribuciongasto_id_gasto_grupo_fkey FOREIGN KEY (id_gasto_grupo) REFERENCES public.gastogrupo(id_gasto_grupo);


--
-- TOC entry 4746 (class 2606 OID 24892)
-- Name: distribuciongasto distribuciongasto_id_usuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.distribuciongasto
    ADD CONSTRAINT distribuciongasto_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario);


--
-- TOC entry 4741 (class 2606 OID 24837)
-- Name: gasto gasto_id_usuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gasto
    ADD CONSTRAINT gasto_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario);


--
-- TOC entry 4744 (class 2606 OID 24875)
-- Name: gastogrupo gastogrupo_id_grupo_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gastogrupo
    ADD CONSTRAINT gastogrupo_id_grupo_fkey FOREIGN KEY (id_grupo) REFERENCES public.grupo(id_grupo);


--
-- TOC entry 4742 (class 2606 OID 24863)
-- Name: miembrogrupo miembrogrupo_id_grupo_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.miembrogrupo
    ADD CONSTRAINT miembrogrupo_id_grupo_fkey FOREIGN KEY (id_grupo) REFERENCES public.grupo(id_grupo);


--
-- TOC entry 4743 (class 2606 OID 24858)
-- Name: miembrogrupo miembrogrupo_id_usuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.miembrogrupo
    ADD CONSTRAINT miembrogrupo_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario);


-- Completed on 2025-06-12 18:48:37

--
-- PostgreSQL database dump complete
--

