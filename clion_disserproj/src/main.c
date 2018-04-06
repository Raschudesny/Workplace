#include <stdio.h>
#include <stdlib.h>
#include "../headers/allignment.h"

int main() {



    const int SEQ_NUM = 10;
    const int SEQ_LENGTH = 100;



    char ** sequences;
    sequences = (char**)malloc(sizeof(char *) * SEQ_NUM);
    for(int i = 0; i  <  SEQ_NUM; i++)
    {
        sequences[i] = (char *) malloc(sizeof(char) * SEQ_LENGTH);
    }

    //makeMultAllignGeneticAlgo(sequences, SEQ_NUM , SEQ_LENGTH);

    initializePopulation(sequences, SEQ_NUM, SEQ_LENGTH);

    for(int i = 0; i < SEQ_NUM; i++)
    {
        free(sequences[i]);
    }
    free(sequences);


    return 0;
}