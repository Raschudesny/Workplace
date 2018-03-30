#include <stdio.h>
#include <stdlib.h>
#include "../headers/allignment.h"

int main() {

    char ** sequences;
    sequences = (char**)malloc(sizeof(char *) * SEQ_NUM);
    for(int i = 0; i  <  SEQ_NUM; i++)
    {
        sequences[i] = (char *) malloc(sizeof(char) * SEQ_LENGTH);
    }

    makeMultAllignGeneticAlgo(sequences);



    return 0;
}