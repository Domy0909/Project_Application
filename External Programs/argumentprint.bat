@echo off
echo Printing Command Line Arguments:

rem Loop through each argument and print it
:loop
if "%1"=="" goto end
echo %1
shift
goto loop

:end
