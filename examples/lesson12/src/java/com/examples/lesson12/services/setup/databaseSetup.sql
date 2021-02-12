# Quiz Application Database
# Create as QuizDB
# User name: oracle
# Password: welcome1
#

# Drop existing tables and Constraints

DROP TABLE QuizResult;
DROP TABLE QuestionResult;
DROP TABLE QuizCheck;

# QuestionResult is a result for each question.
# QuizResult is the result header

CREATE TABLE QuestionResult (
                QuestionResultID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
                QuestionID INTEGER NOT NULL,
                Correct BOOLEAN NOT NULL,
                QuizResultID INTEGER NOT NULL,
                PRIMARY KEY (QuestionResultID)
);

CREATE TABLE QuizResult (
                QuizResultID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
                QuizId INTEGER NOT NULL,
                Title VARCHAR(60),
                UserName VARCHAR(60),
                PRIMARY KEY (QuizResultID)
);

CREATE TABLE QuizCheck(
                CheckValue INTEGER NOT NULL
);

INSERT INTO QuizCheck VALUES(1);

