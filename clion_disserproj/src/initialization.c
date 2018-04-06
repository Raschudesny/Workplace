// Created by raschudesny on 29.03.18.
//

#include "../headers/main.h"
#include "../headers/initialization.h"

void my_swap(char* a, char * b)
{
    if(*a == *b )
        return;
    char t = *b;
    *b = *a;
    *a = t;
}

int ** freqMatrix(char ** s, int s_num, int s_len)
{
    for(int i = 0 ; i < s_num; i++)
        for(int j = 0 ; j < s_len; j++)
        {

        }

}


//could work better if not S = seq then seq = S

Organism *  initializePopulation(char ** seq, int seq_num, int seq_length)
{
    Organism * population = (Organism *)malloc(sizeof(Organism) * 500);

    int lengthS = seq_length * seq_num;
    char * S = (char *)malloc(sizeof(char) * lengthS);
    for(int i = 0 ; i < seq_num; i++)
        for(int j = 0 ; j < seq_length; j++)
            S[i * seq_length + j] = seq[i][j];

    //shuffle
    srand(time(NULL));
    for(int i = 0; i < lengthS; i++ ) {
        int ran = rand() % lengthS;
        my_swap(&S[i], &S[ran]);
    }

    for(int i = 0 ; i < seq_num; i++)
        for(int j = 0 ; j < seq_length; j++)
            seq[i][j] = S[i * seq_length + j];

    //for(int i = 0 ; )

}
