# COMP-370-Group-Activity-4 

[![CI](https://github.com/sawstepj/COMP-370-Group-Activity-4/actions/workflows/main.yml/badge.svg)](https://github.com/sawstepj/COMP-370-Group-Activity-4/actions/workflows/main.yml)
[![codecov](https://codecov.io/gh/sawstepj/COMP-370-Group-Activity-4/branch/main/graph/badge.svg?token=D1GGP9IJJ3)](https://codecov.io/gh/sawstepj/COMP-370-Group-Activity-4)
[![CodeFactor](https://www.codefactor.io/repository/github/sawstepj/comp-370-group-activity-4/badge)](https://www.codefactor.io/repository/github/sawstepj/comp-370-group-activity-4)
![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/sawstepj/COMP-370-Group-Activity-4)
![GitHub commit activity](https://img.shields.io/github/commit-activity/w/sawstepj/COMP-370-Group-Activity-4)
![GitHub issues](https://img.shields.io/github/issues/sawstepj/COMP-370-Group-Activity-4)


A simple countdown timer written in Java.

## How to Run

1. Make sure you have Java JDK 8+ and gradle 7+ installed 
2. `gradle clean test` to run unit tests

### Debugs for Windows vs Linux OS
Tests may need \r or \r\n after String input per the following examples:

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

