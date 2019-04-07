INSERT INTO user(fname,lname,email,password,classstanding,major,phonenumber,resumeurl) VALUES ('Nolan', 'Jimenez', 'nolan1299@gmail.com','password','2','cs','123456789','github.com/nolan1299');
INSERT INTO user(fname,lname,email,password,classstanding,major,phonenumber,resumeurl) VALUES ('Bob', 'Joe', 'bob@gmail.com','nono','2','econ','23478962','github.com/bob');
INSERT INTO project(projectname,userid,projectdetails,applicationdeadline,numapplications) VALUES ('CollabSC', '1', 'fun project', 'tomorrow', '2');
INSERT INTO project(projectname,userid,projectdetails,applicationdeadline,numapplications) VALUES ('Test', '1', 'boring project', 'yesterday', '19');

COMMIT;