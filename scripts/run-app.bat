@echo off
setlocal

if not exist student-management.jar (
  echo student-management.jar was not found in this folder.
  echo Put this script next to the jar and run again.
  exit /b 1
)

java -jar student-management.jar

endlocal
