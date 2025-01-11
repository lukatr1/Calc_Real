EJB 3 Calculator
================

Description
-----------

This calculator example demonstrates the usage of EJB 3 with a stateless session 
bean and one persistent entity:

  1. The stateless session bean calculator.server.CalculatorImpl implements 
     the remote business interface calculator.server.Calculator.

  2. The entity calculator.server.Variable can be persistently stored in the 
     database. It is used by the stateless session bean in order to assign 
     values to variables.

Building and deploying the example
----------------------------------

To build and run the example on the command line, you need to download and 
extract:
  * A Java Development Kit (JDK) version 17
  * Maven (http://maven.apache.org/)
  * Wildfly Application Server 28.0.1 from http://wildfly.org/downloads/

If you use an integrated development environment (IDE) such as IntelliJ or 
NetBeans, you  should already have a JDK (check the version) and Maven 
support in the IDE.

To build the project from the command line, perform the following steps:

1. Open a console and change to the directory of this README.

2. Open the pom.xml within this directory and let the wildfly.deploy.dir 
   property point to your Wildfly installation

3. Let the environment variable JAVA_HOME point to your JDK 17 directory.
   You can do that from the console:
   * Windows: set JAVA_HOME=
   * *nix: export JAVA_HOME=...

3. Call: maven with "-P deploy install", e.g.  
   C:\Programs\apache-maven-3.9.1\bin\mvn -P deploy install.
   This builds the binary distribution and copies the enterprise application 
   archive into the "WILDFLY_HOME/standalone/deployments" directory (assuming you 
   correctly configured the path in step 2).

Short note on code changes: If you change something in the code, you can run 
Maven again and do not have to restart the Wildfly application server.  However, 
you have to wait with running the client until the re-deployment by Wildfly 
finished -- have a look at the Wildfly console.

Running the example
-------------------

1. Execute the file: WILDFLY_HOME\bin\add-user.bat/sh and add a user "tester" with 
   password "testerpass" in the ApplicationDomain. Otherwise, the client will 
   not be able to contact the server due to security restrictions.

2. Execute the file: WILDFLY_HOME\bin\standalone.bat or 
   WILDFLY_HOME/bin/standalone.sh - depending on your operating system.

3. Open a console and change to the directory of this README.

4. Wait until the Wildfly has started -- you can see something like "WildFly ...  
   started ..." in the console opened in step 1.

5. Execute "run-client" or run-client.sh and watch the output.

If you want to run the client application from within an IDE such as NetBeans or 
Eclipse, for example, open/import the Maven project found in this directory into 
your IDE.
