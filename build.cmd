@echo off

mkdir out\classes
javac -sourcepath src/ -d out/classes src/TicTacToe/Launcher.java
jar cfe out/tic-tac-toe.jar TicTacToe.Launcher -C out/classes .
del /q /f out\classes
rmdir /q /s out\classes