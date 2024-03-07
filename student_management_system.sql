CREATE DATABASE IF NOT EXISTS student_management_system;
USE student_management_system;

-- Create the 'student' table
CREATE TABLE IF NOT EXISTS student (
    st_ID INT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    postal_code VARCHAR(10),
    district VARCHAR(255),
    division VARCHAR(255),
    DOB DATE,
    password VARCHAR(255),
    dept_ID INT,
    hostel_ID INT,
    FOREIGN KEY (dept_ID) REFERENCES department(dept_ID),
    FOREIGN KEY (hostel_ID) REFERENCES hostel(hostel_ID)
);

-- Create the 'student_mobile' table
CREATE TABLE IF NOT EXISTS student_mobile (
    st_ID INT,
    mobile_no VARCHAR(15),
    FOREIGN KEY (st_ID) REFERENCES student(st_ID)
);

-- Create the 'student_email' table
CREATE TABLE IF NOT EXISTS student_email (
    st_ID INT,
    email VARCHAR(255),
    FOREIGN KEY (st_ID) REFERENCES student(st_ID)
);

-- Create the 'faculty' table
CREATE TABLE IF NOT EXISTS faculty (
    f_ID INT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    department VARCHAR(255),
    salary DECIMAL(10, 2),
    password VARCHAR(255)
);

-- Create the 'faculty_mobile' table
CREATE TABLE IF NOT EXISTS faculty_mobile (
    f_ID INT,
    mobile_no VARCHAR(15),
    FOREIGN KEY (f_ID) REFERENCES faculty(f_ID)
);

-- Create the 'faculty_email' table
CREATE TABLE IF NOT EXISTS faculty_email (
    f_ID INT,
    email VARCHAR(255),
    FOREIGN KEY (f_ID) REFERENCES faculty(f_ID)
);

-- Create the 'department' table
CREATE TABLE IF NOT EXISTS department (
    dept_ID INT PRIMARY KEY,
    dept_name VARCHAR(255),
    f_ID INT,
    FOREIGN KEY (f_ID) REFERENCES faculty(f_ID)
);

-- Create the 'course' table
CREATE TABLE IF NOT EXISTS course (
    dept_ID INT,
    course_ID INT,
    course_name VARCHAR(255),
    course_credit INT,
    PRIMARY KEY (dept_ID, course_ID),
    FOREIGN KEY (dept_ID) REFERENCES department(dept_ID)
);

-- Create the 'exams' table
CREATE TABLE IF NOT EXISTS exams (
    dept_ID INT,
    exam_ID INT,
    room VARCHAR(255),
    date DATE,
    time TIME,
    PRIMARY KEY (dept_ID, exam_ID),
    FOREIGN KEY (dept_ID) REFERENCES department(dept_ID)
);

-- Create the 'hostel' table
CREATE TABLE IF NOT EXISTS hostel (
    hostel_ID INT PRIMARY KEY,
    hostel_name VARCHAR(255),
    no_of_seats INT
);

select * from student, student_mobile;