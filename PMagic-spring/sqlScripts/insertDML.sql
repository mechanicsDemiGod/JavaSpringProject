-- create the SuperBo$$. he has no correspondent in employees table!
insert into users_tab (empId, mail, pass, isSuperCEO)
value (0, 'SuperMegaCEO@theBusyGuy.com', 'salutSefu', 1);

-- napoleone
insert into users_tab (empId, mail, pass, isSuperCEO)
value (1, 'napoleon@napoli.com', 'salutSefu', 0);

-- manager 1
insert into users_tab (empId, mail, pass, isSuperCEO)
value (2, 'manager1@manages.com', 'salutSefu', 0);

-- employee 1
insert into users_tab (empId, mail, pass, isSuperCEO)
value (3, 'justAResource@depressed.com', 'life sNotPretty', 0);


-- worker 1.
insert into employee_tbl (empId, firstName, lastName, hourRate, hiredWhen)
value (1, 'Napoleon', 'Buonaparte', 18.21, 17991111);


-- de facto inventor of Fourier series
insert into employee_tbl (empId, firstName, lastName, hourRate, hiredWhen)
value (2, 'Daniel', 'Bernoulli', 17.82, 17250915);

-- another high class worker.
insert into Employee_tbl (empId, firstName, lastName, hourRate, hiredWhen)
value (3, 'Albert', 'Einstein', 19.55, 19050630);