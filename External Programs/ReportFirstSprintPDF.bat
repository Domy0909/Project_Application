@echo off
setlocal

rem Imposta il percorso del file PDF e della cartella
set "pdfFile=SCRUM ARTIFACTS\Report First Sprint group 19.pdf"
set "folderPath=."

rem Costruisci il percorso completo del file PDF
set "fullPath=%folderPath%\%pdfFile%"

rem Verifica se il file PDF esiste
if exist "%fullPath%" (
    rem Apre il file PDF con l'applicazione predefinita
    start "" "%fullPath%"
) else (
    echo Il file PDF non esiste: "%fullPath%"
)

endlocal