call runcrud.bat

if "%ERRORLEVEL%" == "0" goto runchrome
echo.
echo RUNCRUD has errors - breaking work
goto fail

:runchrome
start "Chrome" "C:\Program Files (x86)\Google\Chrome\Application\Chrome.exe"
@rem start chrome.exe
if "%ERRORLEVEL%" == "0" goto runtasks
echo.
echo RUNCHROME has errors - breaking work
goto fail

:runtasks
start http://localhost:8080/crud/v1/task/getTasks
goto end

:fail
echo.
echo There were errors!

:end
echo.
echo Work is finished!
