set projectLocation=C:\Users\Testing\SoftwareTestingWorkSpace\Projects\Discovery
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml
pause