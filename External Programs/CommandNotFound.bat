@echo off

comando_non_trovato


if %errorlevel% equ 127 (
    echo Il comando non è stato trovato.
    exit /b 127
}