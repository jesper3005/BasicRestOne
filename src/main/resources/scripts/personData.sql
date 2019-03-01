/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Jesper
 * Created: 01-03-2019
 */
INSERT INTO PERSON (FIRSTNAME, LASTNAME, PHONE) VALUES ('Jesper', 'Christensen', '22813634');
SET @person1 = LAST_INSERT_ID();
INSERT INTO PERSON (FIRSTNAME, LASTNAME, PHONE) VALUES ('Jens', 'Christensen', '22813322');
SET @person2 = LAST_INSERT_ID();
INSERT INTO PERSON (FIRSTNAME, LASTNAME, PHONE) VALUES ('Per', 'Larsen', '12425467');
SET @person3 = LAST_INSERT_ID();
INSERT INTO PERSON (FIRSTNAME, LASTNAME, PHONE) VALUES ('Lars', 'Jensen', '84231254');
SET @person4 = LAST_INSERT_ID();
INSERT INTO PERSON (FIRSTNAME, LASTNAME, PHONE) VALUES ('Søren', 'Bjergsen', '54127642');
SET @person5 = LAST_INSERT_ID();
INSERT INTO PERSON (FIRSTNAME, LASTNAME, PHONE) VALUES ('Martin', 'Larsson', '22423321');
SET @person6 = LAST_INSERT_ID();
