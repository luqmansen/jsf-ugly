CREATE DATABASE IF NOT EXISTS students;
USE students;

CREATE TABLE student_record (
f_name VARCHAR(100),
l_name VARCHAR(100),
street_address VARCHAR(100),
city_address VARCHAR(100),
state_address VARCHAR(100),
postal_code INT(100),
phone INT(100),
email VARCHAR(100),
survey_date VARCHAR(100),
LIKE_ABOUT VARCHAR(100),
INTEREST VARCHAR(100),
IS_RECOMEND VARCHAR(100),
ADD_COMMENT VARCHAR(100));

INSERT INTO student_record
VALUES ('John',
        'Doe',
        '21 Street',
        'G. Avenue',
        'LA',
        324,
        632123,
        'jhon@doe.com',
        '21-9-2020',
        'NO',
        'NO',
        'FALSE',
        'NO');

INSERT INTO student_record
VALUES ('Foo',
        'Bar',
        '22 Jump Street',
        'G. Avenue',
        'LA',
        324,
        632123,
        'foo@bar.com',
        '21-9-2020',
        'NO',
        'NO',
        'FALSE',
        'NO');
