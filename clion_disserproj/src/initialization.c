//
// Created by raschudesny on 29.03.18.
//

#include "../headers/initialization.h"

void swap(char* a, char * b)
{
    if(*a == *b )
        return;
    char t = *b;
    *b = *a;
    *a = t;
}


//could work better if not S = seq then seq = S

int*** initializePopulation(char ** seq)
{
    int lengthS = SEQ_LENGTH * SEQ_NUM;
    char * S = (char *)malloc(sizeof(char) * lengthS);
    for(int i = 0 ; i < SEQ_NUM; i++)
        for(int j = 0 ; j < SEQ_LENGTH; j++)
            S[i * SEQ_LENGTH + j] = seq[i][j];

    //shuffle
    srand(time(NULL));
    for(int i = 0; i < lengthS; i++ ) {
        int ran = rand() % lengthS;
        swap(S[i], S[ran]);
    }
}
