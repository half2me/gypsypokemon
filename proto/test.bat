@echo off
setlocal enabledelayedexpansion
for %%i in (tests\input*.txt) do (
    set in=%%i
    set out=!in:input=output!
    java -cp classes iitema.gypsypokemon.Game < !in! > !out!

    set num=!in:~11,-4!
    
    fc /L !out! !in:input=expected! > nul
    if errorlevel 1 (
        echo test!num!: Failed
    ) else (
        echo test!num!: OK
    )
)
endlocal