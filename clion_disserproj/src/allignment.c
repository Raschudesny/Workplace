//
// Created by raschudesny on 29.03.18.
//

#include "../headers/allignment.h"


void makeMultAllignGeneticAlgo(char ** sequences, int seq_num , int seq_length)
{
    int iterLimit = 1000, iterMade = 0;
    Organism * = initializePopulation(sequences, seq_num, seq_length);
    modificatePopulation(sequences);
    calculateFitness();
    while(iterLimit >  iterMade)
    {

        iterMade++;
    }
}

