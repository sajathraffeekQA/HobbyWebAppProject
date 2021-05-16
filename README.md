# HobbyWebAppProject

# HobbyWebAppProject (MOVE TO DEV BRANCH!)
Hobby Web Application project work for week 9 submission

*****MUST READ!*******
Due to problems with github, the master/main branch in this project is considered to be the DEV branch!
Please move to the 'dev' branch to assess the final project.


Hobby Web Application Project
A fully Hobbt Web Application was created, using front end and back end software and incorporating them together to create a functional website. From project management aspects all the way to testing, a lot of methodologies were applied to form a functional application. Link to Jira Board: https://team-1616578761183.atlassian.net/jira/software/projects/HWA/boards/4/roadmap

Getting Started
In order to run this project, you need to make sure Java is already installed in the computer. Open up the command line and type; java -jar (and then the name of the file with the dependencies on it).

Prerequisites
Java is required to run this program. Assuming you're on Windows, to download Java, you could click on the following link https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html . By double clicking "jdk-14.0.1_window-x64_bin.exe"/"jdk-8u221-windows-x64.exe" a window should appear. Keep clicking 'next' until the 'close' button appears and Java should be installed.

Environmental variables are also required. To do so, click the windows button and type 'path' and then select the 'Edit the system environment variables' control panel. After clicking the 'Environmental Variables...' button and change the 'System variables' to affect all users. Click on 'New...' and create a new 'JAVA_HOME variable and give the folder adress of the jdk file and press 'OK'. On 'System variables' select the new 'JAVA_HOME' option. Select the 'Path' variable and click 'Edit...' and reference the JAVA_HOME variable by using '%JAVA_HOME%\bin'.

Finally, to test the success of the prerequisites, open 'command prompt' on your search bar and type 'java' and it should execute successfully.

Installing
From the steps above, it is clear Java was required.

Eclipse was also required, to do this go on https://eclipse.org/downloads and download the installer. Start running the executable and select the relevant packages. Select in which folder you want to install it and then finally launch if required.

Maven was also required for testing. Go to https://maven.apache.org/download.cgi and download the relevant zip file and then unzip it. Add MAVEN_HOME in the 'system variables' just like in the java installations above but add '%MAVEN_HOME%\bin' instead. Go to the command line and type 'mvn –version' to see if it's successful.

Git Bash was required for version control. Go to https://git-scm.com/ and download the relevant file. Run and click next, selecting the relevant options and chosing where you want to install the file into.

Visual Studio code was used to design the front end. Go to https://code.visualstudio.com/ and download the relevant file. Selecting the relevant options and user agreements, the application will be ready.

Sonarqube helps us inspect code with static analysis of code to detect bugs, code smells, and security vulnerabilities . Go to https://docs.sonarqube.org/7.4/setup/get-started-2-minutes/ and download the relevant file. Unzip the file in C:\sonarqube and run C:\sonarqube\bin\windows-x86-xx\StartSonar.bat on windows. Log in to http://localhost:9000 with the credentials admin/admin.

Spring Tools 4 is a framework and an inversion of control container that let's us access its services. It was donwloaded through the Eclipse marketplace.

Selenium was used for front end testing. Go to https://chromedriver.storage.googleapis.com/index.html and download the relevant zip file, extract it and place it in either src/test/resources or if that folder isn't present, into src/main/resources.

MySQL workbench could be used for the databases. Go to https://dev.mysql.com/downloads/workbench/ and download the relevant file. Run and install when the window pops up. Choose the complete installation option to access all the features of MySQL workbench.



## Running the tests

Before running the tests, we must make sure Maven has been installed and the relevant dependencies added into the pom.xml file.
We also must ensure that mockito has already been installed from https://site.mockito.org/ along with selenium (as specified in the previous section).
We also must make sure that the file is already opened as a maven file instead of a java one.

### Unit Tests 

Unit tests involve in testing each 'unit' in the code so that we can be sure each block of code works independently of each other properly.
These tests are all automated so that it reduces the manual and human aspect of it.
We can do this through JUnit, by include assertions like @BeforeAll, @BeforeEach, etc.
This is all done in src/main/test where classes are made and the tests are conducted.
After the test code has been written, a right-click and running the test should display whether it has passed or if failures/errors occurred.
We could also check coverage to see how much of the code has been checked.
Built With
Maven - Dependency Management
Java - https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html - programming language
SQL - https://dev.mysql.com/downloads/workbench/ - Database Management System
Eclipse - https://eclipse.org/downloads - IDE
Git - https://git-scm.com/ - Version Control
Versioning
We use SemVer for versioning.

Authors
Mohamed Sajath Raffeek * - Carried out the project as a whole.
License
This project is licensed under the MIT license - see the LICENSE.md file for details

For help in Choosing a license
