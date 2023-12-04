@echo off
setlocal

set "pdfFile=SCRUM ARTIFACTS\Report Second Sprint group 19.pdf"
set "folderPath=."

set "fullPath=%folderPath%\%pdfFile%"

if exist "%fullPath%" (
    start "" "%fullPath%"
) else (
    echo Il file PDF non esiste: "%fullPath%"
)

endlocal