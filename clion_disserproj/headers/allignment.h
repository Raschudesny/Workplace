//
// Created by raschudesny on 29.03.18.
//

#ifndef CLION_DISSERPROJ_ALLIGNMENT_H
#define CLION_DISSERPROJ_ALLIGNMENT_H

#include "initialization.h"
#include "modification.h"
#include "fitnessCalculation.h"
#include "main.h"

void makeMultAllignGeneticAlgo(char ** sequences, int seq_num, int seq_length);




typedef struct OrganismMatrix
{
    int ** matrix;
    int size1, size2;
} Organism;



#endif //CLION_DISSERPROJ_ALLIGNMENT_H
