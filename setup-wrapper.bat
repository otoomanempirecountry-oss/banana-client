@echo off
REM Banana Client - Gradle Wrapper Bootstrap Script (Windows)
REM This script initializes the Gradle wrapper JAR file

setlocal enabledelayedexpansion

echo 🍌 Banana Client - Gradle Wrapper Bootstrap
echo ==========================================
echo.

REM Check if Java is installed
java -version >nul 2>&1
if errorlevel 1 (
    echo ❌ Error: Java is not installed or not in PATH
    echo Please install Java 17 or higher
    pause
    exit /b 1
)

for /f "tokens=*" %%i in ('java -version 2^>^&1') do (
    echo ✅ Java found: %%i
    goto :java_found
)

:java_found
echo.

REM Create gradle wrapper directory
if not exist gradle\wrapper mkdir gradle\wrapper

echo 📥 Downloading Gradle 8.3 wrapper JAR...
echo.

cd gradle\wrapper

REM Download using PowerShell if available
powershell -Command "if ($PSVersionTable.PSVersion.Major -ge 3) { $ProgressPreference = 'SilentlyContinue'; Invoke-WebRequest -Uri 'https://services.gradle.org/distributions/gradle-8.3-bin.zip' -OutFile 'gradle-8.3-bin.zip' }" 2>nul

if not exist gradle-8.3-bin.zip (
    echo ❌ Download failed. Trying alternative method...
    echo Please download manually from:
    echo https://services.gradle.org/distributions/gradle-8.3-bin.zip
    echo.
    echo Extract it and copy gradle-8.3\lib\plugins\gradle-wrapper-8.3.jar to gradle\wrapper\gradle-wrapper.jar
    pause
    exit /b 1
)

echo.
echo 📦 Extracting wrapper JAR...

REM Extract using Windows built-in tar (Windows 10+) or fallback
tar -xf gradle-8.3-bin.zip 2>nul

if errorlevel 1 (
    echo Note: Using alternative extraction method
    REM If tar fails, try PowerShell
    powershell -Command "Expand-Archive -Path 'gradle-8.3-bin.zip' -DestinationPath '.' -Force" 2>nul
)

if exist gradle-8.3\lib\plugins\gradle-wrapper-8.3.jar (
    copy /Y gradle-8.3\lib\plugins\gradle-wrapper-8.3.jar gradle-wrapper.jar
    rmdir /S /Q gradle-8.3
    del gradle-8.3-bin.zip
) else (
    echo ❌ Error: Could not find gradle-wrapper-8.3.jar in downloaded file
    pause
    exit /b 1
)

cd ...\..

echo.
echo ✅ Gradle wrapper JAR successfully created!
echo.
echo 🚀 You can now run:
echo    gradlew.bat build
echo    gradlew.bat runClient
echo    gradlew.bat test
echo.
echo 🍌 Happy hacking!
echo.
pause
