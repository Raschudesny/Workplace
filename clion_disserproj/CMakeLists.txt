cmake_minimum_required(VERSION 3.9)
project(clion_disserproj C)

set(CMAKE_C_STANDARD 99)

add_executable(clion_disserproj src/main.c src/allignment.c headers/allignment.h headers/main.h src/initialization.c headers/initialization.h src/modification.c headers/modification.h src/fitnessCalculation.c headers/fitnessCalculation.h)