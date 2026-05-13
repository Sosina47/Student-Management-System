@echo off
setlocal

REM Build runnable Spring Boot jar and prepare a dist folder.
cd /d %~dp0\..

call .\mvnw.cmd -Dmaven.test.skip=true clean package
if errorlevel 1 (
  echo Build failed.
  exit /b 1
)

if exist dist rmdir /s /q dist
mkdir dist
copy /y target\student-management-1.0-SNAPSHOT.jar dist\student-management.jar >nul
copy /y scripts\run-app.bat dist\run-app.bat >nul
copy /y README.md dist\README.md >nul 2>nul

echo.
echo Distribution prepared in dist\
echo Send the dist folder to users.
echo.
echo They can start with: run-app.bat

endlocal
