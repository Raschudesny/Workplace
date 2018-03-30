//
// Created by raschudesny on 29.03.18.
//

#include "../headers/allignment.h"

void makeMultAllignGeneticAlgo(char ** sequences)
{
    int iterLimit = 1000, iterMade = 0;
    initializePopulation(sequences);
    modificatePopulation(sequences);
    calculateFitness();
    while(iterLimit >  iterMade)
    {

        iterMade++;
    }
}

