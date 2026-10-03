@echo off
title Menu Git
color 72

mode 80, 25
:menu
cls
echo ============================
echo    MENU DE GIT - MATRIX
echo ============================
echo 1. Subir todos los cambios a GitHub
echo 2. Ver Cambios Git
echo 3. Bajar cambios de GitHub
echo 4. Abrir Terminal (Colores ANSI)
echo 5. Salir
echo ============================
set /p opcion=Elige una opcion: 

if "%opcion%"=="1" goto subir
if "%opcion%"=="2" goto ver
if "%opcion%"=="3" goto bajar
if "%opcion%"=="4" goto AbrirTerminal
if "%opcion%"=="6" exit

echo Opcion no valida.
pause
goto menu

:subir
cls
echo [ PROCESO ] Revisando cambios en el repositorio...
git pull

if %errorlevel% neq 0 (
   echo ==================================================
   echo [ ALERTA ] Hay conflicts, resolver antes de subir.
   echo ==================================================
   pause
   goto menu
) 
echo.
echo [ PROCESO ] Subiendo cambios al repositorio...
echo.

REM Crear mensaje automatico con nombre + fecha
set "USERNAME_DEFAULT=java-intranet-oracle"
for /f "tokens=1-3 delims=/ " %%a in ("%date%") do set fecha=%%a-%%b-%%c
for /f "tokens=1-2 delims=: " %%a in ("%time%") do set hora=%%a-%%b

REM === CONSTRUIR MENSAJE ===
set mensaje= %USERNAME% - %USERNAME_DEFAULT% - %fecha%_%hora%

git add .
git commit -m "%mensaje%"
git push

if %errorlevel% neq 0 (
   echo.
   echo ================================================
   echo [ ERROR ] No se pudieron subir los cambios.
   echo ================================================
   pause
   goto menu
)

color 72
echo.
echo [ EXITO ] Cambios subidos correctamente.
pause
goto menu

:bajar
cls
echo [ PROCESO ] Bajando cambios ......

git pull

echo.
echo [ FINALIZADO ] Cambios bajados correctamente.
pause
goto menu

:ver
cls
echo [ PROCESO ] Revisando Cambios ......

git status -s

echo.
echo [ FINALIZADO ]  !! Cambios revisados !!.
pause
goto menu

:AbrirTerminal
cls
color 8F
echo =========================================================================
echo  -- PALETA DE COLORES ANSI (Copiar el comando) --
echo =========================================================================
echo  Azul: prompt $e[4;5;31m[*]$e[0m $e[36m$p$g$e[0m
echo  Verde 1: prompt $e[4;5;31m[*]$e[0m $e[1;92m$p$g$e[0m
echo  Verde 2: prompt $e[4;5;31m[*]$e[0m $e[4;32m$p$g$e[0m
echo  Amarillo: prompt $e[4;5;31m[*]$e[0m $e[93m$p$g$e[0m
echo  Naranja:  prompt $e[4;5;31m[*]$e[0m $e[33m$p$g$e[0m
echo  Celeste:  prompt $e[4;5;31m[*]$e[0m $e[96m$p$g$e[0m
echo =========================================================================
echo.

REM Validamos si existe Windows Terminal en el sistema
where wt >nul 2>nul
if %errorlevel% equ 0 (
    echo [OK] Abriendo perfiles en Windows Terminal...
    wt -w 0 -p "Docker" -d . ; new-tab -p "BACK: Spring Boot" -d .
) else (
    echo [Plan B] Windows Terminal no detectado. Abriendo consolas clasicas...
    start ".:.docker.:." cmd /k color 0b
    start ".:. java .:." cmd /k color 0a
)

echo.
echo Presiona una tecla para regresar al Menu Principal.
pause >nul
color 72
goto menu
