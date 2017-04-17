--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: adminlogin; Type: TABLE; Schema: public; Owner: gunnarmarhardarson
--

CREATE TABLE adminlogin (
    username character varying(20),
    password character varying(20)
);


ALTER TABLE adminlogin OWNER TO gunnarmarhardarson;

--
-- Name: bookings; Type: TABLE; Schema: public; Owner: gunnarmarhardarson
--

CREATE TABLE bookings (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    kennitala integer NOT NULL,
    email character varying(100) NOT NULL,
    phonenumber integer,
    seatsreserved integer NOT NULL,
    flightnumber integer
);


ALTER TABLE bookings OWNER TO gunnarmarhardarson;

--
-- Name: flightdata; Type: TABLE; Schema: public; Owner: gunnarmarhardarson
--

CREATE TABLE flightdata (
    flightnumber integer NOT NULL,
    departure character varying(50) NOT NULL,
    arrival character varying(50) NOT NULL,
    departuredate character(10),
    departuretime character(5),
    arrivaldate character(10),
    arrivaltime character(5),
    seats integer NOT NULL,
    price integer NOT NULL
);


ALTER TABLE flightdata OWNER TO gunnarmarhardarson;

--
-- Data for Name: adminlogin; Type: TABLE DATA; Schema: public; Owner: gunnarmarhardarson
--

COPY adminlogin (username, password) FROM stdin;
admin	1234
\.


--
-- Data for Name: bookings; Type: TABLE DATA; Schema: public; Owner: gunnarmarhardarson
--

COPY bookings (id, name, kennitala, email, phonenumber, seatsreserved, flightnumber) FROM stdin;
1	Jón Jónsson	1202832629	john@email.com	5934346	3	26
2	Helgi Sigurjónsson	1704693829	helgi@email.com	5636806	2	12
3	Jóna Atladóttir	803927419	jona@email.com	8453673	1	2
\.


--
-- Data for Name: flightdata; Type: TABLE DATA; Schema: public; Owner: gunnarmarhardarson
--

COPY flightdata (flightnumber, departure, arrival, departuredate, departuretime, arrivaldate, arrivaltime, seats, price) FROM stdin;
29	Keflavik	Belfast	13.03.2017	10:00	13.03.2017	12:00	125	15848
13	Gautaborg	Keflavik	02.04.2017	11:00	02.04.2017	13:30	140	32899
30	Belfast	Keflavik	25.03.2017	09:00	25.03.2017	11:00	135	16949
14	Keflavik	London	04.04.2017	11:00	04.04.2017	14:00	160	41900
31	Keflavik	Boston	21.03.2017	08:00	21.03.2017	12:00	110	69373
15	London	Keflavik	14.04.2017	19:30	14.04.2017	21:30	160	34999
32	Boston	Keflavik	04.04.2017	09:00	04.04.2017	13:00	120	65839
16	Amsterdam	Keflavik	18.04.2017	15:10	18.04.2017	19:00	165	28384
33	Keflavik	Gautaborg	18.03.2017	10:00	18.03.2017	12:30	100	29256
17	Reykjavik	Akureyri	19.02.2017	08:10	19.02.2017	09:00	50	17849
18	Akureyri	Reykjavik	28.02.2017	12:10	28.02.2017	13:00	50	18383
34	Gautaborg	Keflavik	03.04.2017	16:00	03.04.2017	18:30	100	27948
19	Keflavik	Florida	29.02.2017	12:00	29.02.2017	18:00	250	69270
35	Keflavik	London	05.04.2017	17:00	05.04.2017	19:30	112	36237
1	Keflavik	Rome	10.03.2017	17:30	10.03.2017	21:30	200	43986
20	Florida	Keflavik	14.03.2017	22:00	15.02.2017	04:00	250	62845
2	Rome	Keflavik	18.03.2017	06:20	18.03.2017	09:30	200	35748
36	London	Keflavik	16.04.2017	20:00	16.04.2017	22:30	130	45748
37	Reykjavik	Akureyri	17.02.2017	11:00	17.02.2017	12:00	45	15848
3	Keflavik	Oslo	15.03.2017	14:00	15.03.2017	16:00	150	14462
22	Rome	Keflavik	16.03.2017	12:30	16.03.2017	16:30	175	40684
38	Akureyri	Reykjavik	29.02.2017	20:00	29.02.2017	21:00	45	14948
4	Oslo	Keflavik	23.03.2017	11:20	23.03.2017	13:00	110	18463
23	Keflavik	Oslo	16.03.2017	14:30	16.03.2017	16:30	160	15063
5	Keflavik	Barcelona	12.03.2017	18:00	12.03.2017	22:00	100	63832
6	Barcelona	Keflavik	26.03.2017	04:10	26.03.2017	08:00	136	49842
24	Oslo	Keflavik	25.03.2017	11:00	25.03.2017	13:00	165	17485
7	Keflavik	Amsterdam	30.02.2017	15:10	30.02.2017	19:00	165	28384
39	Keflavik	Florida	26.02.2017	06:00	26.02.2017	12:00	160	64748
8	Keflavik	Belfast	11.03.2017	23:45	12.03.2017	01:45	120	18999
25	Keflavik	Barcelona	11.03.2017	10:30	11.03.2017	14:30	140	57368
9	Belfast	Keflavik	23.03.2017	10:00	23.03.2017	12:00	140	14999
10	Keflavik	Boston	22.03.2017	11:40	22.03.2017	17:00	210	73848
26	Barcelona	Keflavik	24.03.2017	09:30	24.03.2017	13:30	150	51647
11	Boston	Keflavik	02.04.2017	12:00	02.04.2017	17:30	210	62566
40	Florida	Keflavik	16.03.2017	20:00	17.03.2017	02:00	170	72838
12	Keflavik	Gautaborg	16.03.2017	20:30	16.03.2017	23:00	150	32899
27	Keflavik	Amsterdam	28.03.2017	09:30	28.03.2017	13:30	145	32568
28	Amsterdam	Keflavik	16.04.2017	10:00	16.03.2017	14:00	120	35627
41	Keflavik	Tokyo	03.04.2017	16:30	04.04.2017	04:30	123	84890
21	Keflavik	Rome	15.03.2017	17:30	15.03.2017	21:30	251	52525
\.


--
-- Name: bookings bookings_email_key; Type: CONSTRAINT; Schema: public; Owner: gunnarmarhardarson
--

ALTER TABLE ONLY bookings
    ADD CONSTRAINT bookings_email_key UNIQUE (email);


--
-- Name: bookings bookings_pkey; Type: CONSTRAINT; Schema: public; Owner: gunnarmarhardarson
--

ALTER TABLE ONLY bookings
    ADD CONSTRAINT bookings_pkey PRIMARY KEY (id);


--
-- Name: flightdata flightdata_pkey; Type: CONSTRAINT; Schema: public; Owner: gunnarmarhardarson
--

ALTER TABLE ONLY flightdata
    ADD CONSTRAINT flightdata_pkey PRIMARY KEY (flightnumber);


--
-- Name: bookings bookings_flightnumber_fkey; Type: FK CONSTRAINT; Schema: public; Owner: gunnarmarhardarson
--

ALTER TABLE ONLY bookings
    ADD CONSTRAINT bookings_flightnumber_fkey FOREIGN KEY (flightnumber) REFERENCES flightdata(flightnumber);


--
-- PostgreSQL database dump complete
--

