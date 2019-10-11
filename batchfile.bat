set projectLocation=C:\Users\hparupalli\Workspace\TestingWorkSpace\Projects\repo\Testing_Discovery
cd %projectLocation%
set classpath=%projectLocation%\target\classes\*; %projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\src\main\java\testng.xml
pause

