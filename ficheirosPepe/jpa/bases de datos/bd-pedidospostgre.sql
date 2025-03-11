--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.2

-- Started on 2024-04-30 00:56:34

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
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
-- TOC entry 218 (class 1259 OID 106497)
-- Name: Cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Cliente" (
    "idCliente" integer NOT NULL,
    dni character varying(12) NOT NULL,
    nombre character varying(128) NOT NULL
);


ALTER TABLE public."Cliente" OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 106496)
-- Name: Cliente_idCliente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Cliente_idCliente_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."Cliente_idCliente_seq" OWNER TO postgres;

--
-- TOC entry 4896 (class 0 OID 0)
-- Dependencies: 217
-- Name: Cliente_idCliente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Cliente_idCliente_seq" OWNED BY public."Cliente"."idCliente";


--
-- TOC entry 219 (class 1259 OID 106503)
-- Name: ComentarioProducto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."ComentarioProducto" (
    "idProducto" integer NOT NULL,
    comentario character varying(255)
);


ALTER TABLE public."ComentarioProducto" OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 106506)
-- Name: EtiquetaLineaPedido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."EtiquetaLineaPedido" (
    "idLineaPedido" integer NOT NULL,
    etiqueta character varying(50)
);


ALTER TABLE public."EtiquetaLineaPedido" OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 106509)
-- Name: FotoProducto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."FotoProducto" (
    "idProducto" integer NOT NULL,
    descripcion character varying(255),
    nombre character varying(255),
    imagen bytea
);


ALTER TABLE public."FotoProducto" OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 106515)
-- Name: LineaPedido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."LineaPedido" (
    cantidad smallint NOT NULL,
    "idLineaPedido" integer NOT NULL,
    "idPedido" integer NOT NULL,
    "idProducto" integer NOT NULL
);


ALTER TABLE public."LineaPedido" OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 82157)
-- Name: LineaPedido_SEQ; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."LineaPedido_SEQ"
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."LineaPedido_SEQ" OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 106514)
-- Name: LineaPedido_idLineaPedido_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."LineaPedido_idLineaPedido_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."LineaPedido_idLineaPedido_seq" OWNER TO postgres;

--
-- TOC entry 4897 (class 0 OID 0)
-- Dependencies: 222
-- Name: LineaPedido_idLineaPedido_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."LineaPedido_idLineaPedido_seq" OWNED BY public."LineaPedido"."idLineaPedido";


--
-- TOC entry 225 (class 1259 OID 106522)
-- Name: Pedido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Pedido" (
    "idCliente" integer,
    "idPedido" integer NOT NULL,
    fecha timestamp(6) without time zone NOT NULL
);


ALTER TABLE public."Pedido" OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 106521)
-- Name: Pedido_idPedido_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Pedido_idPedido_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."Pedido_idPedido_seq" OWNER TO postgres;

--
-- TOC entry 4898 (class 0 OID 0)
-- Dependencies: 224
-- Name: Pedido_idPedido_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Pedido_idPedido_seq" OWNED BY public."Pedido"."idPedido";


--
-- TOC entry 227 (class 1259 OID 106529)
-- Name: Producto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Producto" (
    "idProducto" integer NOT NULL,
    precio numeric(10,2),
    nombre character varying(125) NOT NULL,
    descripcion character varying(255),
    imagen bytea
);


ALTER TABLE public."Producto" OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 106528)
-- Name: Producto_idProducto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Producto_idProducto_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."Producto_idProducto_seq" OWNER TO postgres;

--
-- TOC entry 4899 (class 0 OID 0)
-- Dependencies: 226
-- Name: Producto_idProducto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Producto_idProducto_seq" OWNED BY public."Producto"."idProducto";


--
-- TOC entry 215 (class 1259 OID 81979)
-- Name: lineaPedido_SEQ; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."lineaPedido_SEQ"
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."lineaPedido_SEQ" OWNER TO postgres;

--
-- TOC entry 4717 (class 2604 OID 106500)
-- Name: Cliente idCliente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Cliente" ALTER COLUMN "idCliente" SET DEFAULT nextval('public."Cliente_idCliente_seq"'::regclass);


--
-- TOC entry 4718 (class 2604 OID 106518)
-- Name: LineaPedido idLineaPedido; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."LineaPedido" ALTER COLUMN "idLineaPedido" SET DEFAULT nextval('public."LineaPedido_idLineaPedido_seq"'::regclass);


--
-- TOC entry 4719 (class 2604 OID 106525)
-- Name: Pedido idPedido; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Pedido" ALTER COLUMN "idPedido" SET DEFAULT nextval('public."Pedido_idPedido_seq"'::regclass);


--
-- TOC entry 4720 (class 2604 OID 106532)
-- Name: Producto idProducto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Producto" ALTER COLUMN "idProducto" SET DEFAULT nextval('public."Producto_idProducto_seq"'::regclass);


--
-- TOC entry 4881 (class 0 OID 106497)
-- Dependencies: 218
-- Data for Name: Cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Cliente" ("idCliente", dni, nombre) FROM stdin;
1	11111111A	Daniel
2	22222222B	Lucia
3	33333333C	Beatriz
\.


--
-- TOC entry 4882 (class 0 OID 106503)
-- Dependencies: 219
-- Data for Name: ComentarioProducto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."ComentarioProducto" ("idProducto", comentario) FROM stdin;
\.


--
-- TOC entry 4883 (class 0 OID 106506)
-- Dependencies: 220
-- Data for Name: EtiquetaLineaPedido; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."EtiquetaLineaPedido" ("idLineaPedido", etiqueta) FROM stdin;
\.


--
-- TOC entry 4884 (class 0 OID 106509)
-- Dependencies: 221
-- Data for Name: FotoProducto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."FotoProducto" ("idProducto", descripcion, nombre, imagen) FROM stdin;
1	cara de asdasdasd a	cara	\N
\.


--
-- TOC entry 4886 (class 0 OID 106515)
-- Dependencies: 223
-- Data for Name: LineaPedido; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."LineaPedido" (cantidad, "idLineaPedido", "idPedido", "idProducto") FROM stdin;
3	1	1	1
6	2	1	2
10	3	2	2
5	4	2	3
5	5	2	4
\.


--
-- TOC entry 4888 (class 0 OID 106522)
-- Dependencies: 225
-- Data for Name: Pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Pedido" ("idCliente", "idPedido", fecha) FROM stdin;
1	1	2020-11-05 12:24:37
2	2	2022-10-20 08:34:11
\.


--
-- TOC entry 4890 (class 0 OID 106529)
-- Dependencies: 227
-- Data for Name: Producto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Producto" ("idProducto", precio, nombre, descripcion, imagen) FROM stdin;
1	15.50	camiseta	Camiseta de manga corta	\N
2	15.50	camiseta	Camiseta de manga corta.	\N
3	30.00	pantalon	Pantalon vaquero	\N
4	47.75	chaqueta	Chaqueta de cuero.	\N
5	100.00	zapatos	Zapatos negros	\N
\.


--
-- TOC entry 4900 (class 0 OID 0)
-- Dependencies: 217
-- Name: Cliente_idCliente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Cliente_idCliente_seq"', 3, true);


--
-- TOC entry 4901 (class 0 OID 0)
-- Dependencies: 216
-- Name: LineaPedido_SEQ; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."LineaPedido_SEQ"', 1, false);


--
-- TOC entry 4902 (class 0 OID 0)
-- Dependencies: 222
-- Name: LineaPedido_idLineaPedido_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."LineaPedido_idLineaPedido_seq"', 5, true);


--
-- TOC entry 4903 (class 0 OID 0)
-- Dependencies: 224
-- Name: Pedido_idPedido_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Pedido_idPedido_seq"', 2, true);


--
-- TOC entry 4904 (class 0 OID 0)
-- Dependencies: 226
-- Name: Producto_idProducto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Producto_idProducto_seq"', 5, true);


--
-- TOC entry 4905 (class 0 OID 0)
-- Dependencies: 215
-- Name: lineaPedido_SEQ; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."lineaPedido_SEQ"', 1, false);


--
-- TOC entry 4722 (class 2606 OID 106502)
-- Name: Cliente Cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Cliente"
    ADD CONSTRAINT "Cliente_pkey" PRIMARY KEY ("idCliente");


--
-- TOC entry 4724 (class 2606 OID 106520)
-- Name: LineaPedido LineaPedido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."LineaPedido"
    ADD CONSTRAINT "LineaPedido_pkey" PRIMARY KEY ("idLineaPedido");


--
-- TOC entry 4726 (class 2606 OID 106527)
-- Name: Pedido Pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Pedido"
    ADD CONSTRAINT "Pedido_pkey" PRIMARY KEY ("idPedido");


--
-- TOC entry 4728 (class 2606 OID 106536)
-- Name: Producto Producto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Producto"
    ADD CONSTRAINT "Producto_pkey" PRIMARY KEY ("idProducto");


--
-- TOC entry 4732 (class 2606 OID 106552)
-- Name: LineaPedido FK16r6q9njvef9fuecshutqo5ro; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."LineaPedido"
    ADD CONSTRAINT "FK16r6q9njvef9fuecshutqo5ro" FOREIGN KEY ("idPedido") REFERENCES public."Pedido"("idPedido");


--
-- TOC entry 4731 (class 2606 OID 106547)
-- Name: FotoProducto FK5pt6qumiubvgt2y7j0ihpi3rx; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."FotoProducto"
    ADD CONSTRAINT "FK5pt6qumiubvgt2y7j0ihpi3rx" FOREIGN KEY ("idProducto") REFERENCES public."Producto"("idProducto");


--
-- TOC entry 4734 (class 2606 OID 106562)
-- Name: Pedido FKb7xr57df8semvktej7l1lo85e; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Pedido"
    ADD CONSTRAINT "FKb7xr57df8semvktej7l1lo85e" FOREIGN KEY ("idCliente") REFERENCES public."Cliente"("idCliente");


--
-- TOC entry 4729 (class 2606 OID 106537)
-- Name: ComentarioProducto FKfx3w7ikqlamq973mvslod19o6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."ComentarioProducto"
    ADD CONSTRAINT "FKfx3w7ikqlamq973mvslod19o6" FOREIGN KEY ("idProducto") REFERENCES public."Producto"("idProducto");


--
-- TOC entry 4733 (class 2606 OID 106557)
-- Name: LineaPedido FKjmo85q6spgveoxjmyjrvwhk1q; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."LineaPedido"
    ADD CONSTRAINT "FKjmo85q6spgveoxjmyjrvwhk1q" FOREIGN KEY ("idProducto") REFERENCES public."Producto"("idProducto");


--
-- TOC entry 4730 (class 2606 OID 106542)
-- Name: EtiquetaLineaPedido FKl089aahlkhu95ier7g3p2e8ak; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."EtiquetaLineaPedido"
    ADD CONSTRAINT "FKl089aahlkhu95ier7g3p2e8ak" FOREIGN KEY ("idLineaPedido") REFERENCES public."LineaPedido"("idLineaPedido");


-- Completed on 2024-04-30 00:56:34

--
-- PostgreSQL database dump complete
--

