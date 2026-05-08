@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  Gradle startup script for Windows
@rem
@rem  Optional ENV vars
@rem  JAVA_HOME - location of a JDK home dir
@rem  GRADLE_OPTS - parameters to pass to the Java VM, e.g. -Xmx1024m
@rem  GRADLE_SKIP_VALIDATION - Skip gradle wrapper validation
@rem
@rem ##########################################################################

@setlocal

for /f "tokens=4-5" %%i in ('tasklist /v /fo list ^| find /i "java.exe"') do set JAVA_HOME=%%i

if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >nul 2>&1
if "%ERRORLEVEL%"=="0" goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\gradle\wrapper\gradle-wrapper.jar

@rem Execute Gradle
"%JAVA_EXE%" -server -XX:MaxMetaspaceSize=512m -XX:+UseG1GC %GRADLE_OPTS% "-Dorg.gradle.appname=%APP_BASE_NAME%" -classpath "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %CMD_LINE_ARGS%

:end
@endlocal & set ERROR_CODE=%ERRORLEVEL%

if "%ERROR_CODE%"=="0" goto mainEnd

if not "%GRADLE_EXIT_CONSOLE%"=="" (
    echo.
    echo Please press a key to continue . . .
    pause >nul
)

exit /b %ERROR_CODE%

:mainEnd
if "%OS%"=="Windows_NT" endlocal

goto end

:fail
rem Set variable GRADLE_EXIT_CONSOLE to 1 to always exit with exit code 100
if "%GRADLE_EXIT_CONSOLE%"=="" set GRADLE_EXIT_CONSOLE=1

echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

exit /b 1

:end
