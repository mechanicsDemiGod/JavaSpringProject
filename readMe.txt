configure JRE to Java 7
set your MySQL password to 1234
run the sqlScripts "CreateDbDDL" and "insertDML" (these are needed for the users, which can't be manipulated for the moment)
!!!! update empId of SuperMegaCEO@theBusyGuy -> set it to 0 (yeah, it's ugly...)
run as Maven (goals -> jetty:run-exploded)
entry hyperlink of app: http://localhost:8080/web/user/loginPage
use the credentials defined in users_tab, for the superCEO: 
	mail - SuperMegaCEO@theBusyGuy.com
	pass - salutSefu

enjoy!