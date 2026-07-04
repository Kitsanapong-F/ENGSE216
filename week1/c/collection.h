// collection.h
#ifndef COLLECTION_H
#define COLLECTION_H

#include <stdbool.h>

// นิยาม struct
typedef struct {
    int data[5];
    int count;
} Collection;

// ประกาศฟังก์ชัน (Prototypes)
void initCollection(Collection *c);
bool isFull(Collection *c);
bool isEmpty(Collection *c);
int size(Collection *c);
void add(Collection *c, int value);
int removeAt(Collection *c, int index);
void showAll(Collection *c);

#endif