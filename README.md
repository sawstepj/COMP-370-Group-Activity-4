# COMP-370-Group-Activity-4 

[![CI](https://github.com/dustinn1/COMP-370-Group-Activity-4/actions/workflows/main.yml/badge.svg)](https://github.com/dustinn1/COMP-370-Group-Activity-4/actions/workflows/main.yml)
[![codecov](https://codecov.io/gh/dustinn1/COMP-370-Group-Activity-4/branch/main/graph/badge.svg?token=D1GGP9IJJ3)](https://codecov.io/gh/dustinn1/COMP-370-Group-Activity-4)
[![CodeFactor](https://www.codefactor.io/repository/github/dustinn1/comp-370-group-activity-4/badge)](https://www.codefactor.io/repository/github/dustinn1/comp-370-group-activity-4)
![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/dustinn1/COMP-370-Group-Activity-4)
![GitHub commit activity](https://img.shields.io/github/commit-activity/w/dustinn1/COMP-370-Group-Activity-4)
![GitHub issues](https://img.shields.io/github/issues/dustinn1/COMP-370-Group-Activity-4)


A simple countdown timer written in Java.

Running the Application in IntelliJ
1. Download project to IntelliJ
2. In IntelliJ: Run > Run Main

Unit tests
Right click on test and chose Run 'Tests in 'COMP_370_Group_Activity_4.test''

Debugs for Windows vs Linux OS
Tests may need \r or \r\n for example per the following examples:

String expectedOutput = "0\r\nTime's up!\r\n";

String expectedOutput = """
                5\r
                4\r
                3\r
                2\r
                1\r
                0\r
                Time's up!\r
                """;

