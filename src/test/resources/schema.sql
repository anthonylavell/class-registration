CREATE SEQUENCE IF NOT EXISTS student_seq;

CREATE TABLE IF NOT EXISTS student (

student_id BIGINT NOT NULL DEFAULT nextval('student_seq') PRIMARY KEY,
age BIGINT NOT NULL,
classification VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL,
first_name VARCHAR(100) NOT NULL,
last_name VARCHAR(100) NOT NULL

);

CREATE SEQUENCE IF NOT EXISTS course_seq;

CREATE TABLE IF NOT EXISTS course (

course_id BIGINT NOT NULL DEFAULT nextval('course_seq') PRIMARY KEY,
course_credit BIGINT NOT NULL,
course_name VARCHAR(100) NOT NULL,
stage VARCHAR(100) NOT NULL,
description VARCHAR(500) NOT NULL

);


CREATE TABLE IF NOT EXISTS course_student (

course_id BIGINT REFERENCES course,
student_id BIGINT REFERENCES student

);