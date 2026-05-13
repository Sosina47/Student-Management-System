# Distribution Guide

This project can be distributed in two practical ways:

1. Runnable jar (recommended for class/demo)
2. Native Windows executable installer (optional)

## Option 1: Runnable jar

Build and prepare a shareable folder:

- Run: scripts\build-dist.bat

This creates:

- dist\student-management.jar
- dist\run-app.bat

Share the entire dist folder with other people.

How recipients run it:

- Double-click dist\run-app.bat
- Open browser at http://localhost:8080

Requirement for recipients:

- Java 25 installed and available in PATH

## Option 2: Native .exe installer (no Java install on recipient machine)

Use jpackage from a full JDK that includes jpackage.

Steps:

1. Build jar first:
   - mvnw.cmd -Dmaven.test.skip=true clean package

2. Run jpackage from a JDK that has jpackage:
   - jpackage --type exe --name StudentManagement --input target --main-jar student-management-1.0-SNAPSHOT.jar --main-class org.springframework.boot.loader.launch.JarLauncher --win-menu --win-shortcut

Result:

- A Windows installer/exe under the generated output folder.

Notes:

- If jpackage is not found, install/use a full JDK (not only a runtime shim).
- For production sharing outside class, code-signing the installer is recommended.

## Quick recommendation for your class

Use Option 1 (dist folder). It is faster and reliable for demo machines that already have Java.
