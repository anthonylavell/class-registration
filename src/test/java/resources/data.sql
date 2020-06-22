-- INSERT STUDENT --
insert into student (student_id, first_name, last_name,age, email, classification) values (nextval('student_seq'), 'John', 'Warton',26,'warton@gmail.com','Sophomore');
insert into student (student_id, first_name, last_name,age, email, classification) values (nextval('student_seq'), 'Mike', 'Lanister',21,'lanister@gmail.com','Freshman');
insert into student (student_id, first_name, last_name,age, email, classification) values (nextval('student_seq'), 'Steve', 'Reeves',33, 'Reeves@gmail.com','Junior');
insert into student (student_id, first_name, last_name,age, email, classification) values (nextval('student_seq'), 'Ronald', 'Connor',28,'connor@gmail.com','Junior');
insert into student (student_id, first_name, last_name,age, email, classification) values (nextval('student_seq'), 'Jim', 'Salvator',44,'Sal@gmail.com','Freshman');
insert into student (student_id, first_name, last_name,age, email, classification) values (nextval('student_seq'), 'Peter', 'Henley',37,'henley@gmail.com','Sophomore');
insert into student (student_id, first_name, last_name,age, email, classification) values (nextval('student_seq'), 'Richard', 'Carson',40,'carson@gmail.com','Sophomore');
insert into student (student_id, first_name, last_name,age, email, classification) values (nextval('student_seq'), 'Honor', 'Miles',23,'miles@gmail.com','Freshman');
insert into student (student_id, first_name, last_name,age, email, classification) values (nextval('student_seq'), 'Tony', 'Roggers',42,'roggers@gmail.com','Senior');
insert into student (student_id, first_name, last_name,age, email, classification) values (nextval('student_seq'), 'Anthony', 'Ward',36,'ward@gmail.com','Senior');

-- INSERT COURSE --
insert into course (course_id, course_name,course_credit, stage, description) values (nextval('course_seq'), 'Pre-Algebra',4, 'EMPTY', 'This is Prerequisite to Algebra');
insert into course (course_id, course_name,course_credit, stage, description) values (nextval('course_seq'), 'Algebra',3, 'ALMOST FULL', 'This is a Require course');
insert into course (course_id, course_name,course_credit, stage, description) values (nextval('course_seq'), 'CPTR 1100',4, 'FULL', 'This is Prerequisite to CPTR 1200');
insert into course (course_id, course_name,course_credit, stage, description) values (nextval('course_seq'), 'CPTR 1200',3, 'EMPTY', 'This is a Require course for Computer science majors');

-- INSERT COURSE_STUDENT_RELATION --
insert into course_student(course_id, student_id) (select s.student_id, c.course_id from student s, course c where s.last_name ='Warton' AND c.course_name = 'Pre-Algebra');
insert into course_student(course_id, student_id) (select s.student_id, c.course_id from student s, course c where s.last_name ='Ward' AND c.course_name = 'CPTR 1200');
insert into course_student(course_id, student_id) (select s.student_id, c.course_id from student s, course c where s.last_name ='Warton' AND c.course_name = 'CPTR 1100');
insert into course_student(course_id, student_id) (select s.student_id, c.course_id from student s, course c where s.last_name ='Reeves' AND c.course_name = 'CPTR 1100');
insert into course_student(course_id, student_id) (select s.student_id, c.course_id from student s, course c where s.last_name ='Ward' AND c.course_name = 'Algebra');
insert into course_student(course_id, student_id) (select s.student_id, c.course_id from student s, course c where s.last_name ='Reeves' AND c.course_name = 'CPTR 1200');
insert into course_student(course_id, student_id) (select s.student_id, c.course_id from student s, course c where s.last_name ='Henley' AND c.course_name = 'Algebra');
insert into course_student(course_id, student_id) (select s.student_id, c.course_id from student s, course c where s.last_name ='Henley' AND c.course_name = 'CPTR 1100');