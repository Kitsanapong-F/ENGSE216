// collection.c
#include <stdio.h>
#include "collection.h" // ต้อง include header ของตัวเองเข้ามาด้วย

// ฟังก์ชันสำหรับกำหนดค่าเริ่มต้น (เหมือน Constructor ใน Java)
void initCollection(Collection *c) {
    c->count = 0;
}

bool isFull(Collection *c) {
    return c->count == 5;
}

bool isEmpty(Collection *c) {
    return c->count == 0;
}

int size(Collection *c) {
    return c->count;
}

void add(Collection *c, int value) {
    if (!isFull(c)) {
        c->data[c->count] = value;
        c->count++;
    } else {
        printf("isFull.\n");
    }
}

int removeAt(Collection *c, int index) {
    int temp = -1;
    if (!isEmpty(c) && index >= 0 && index < c->count) {
        temp = c->data[index];
        c->data[index] = c->data[c->count - 1];
        c->count--;
    }
    return temp;
}

void showAll(Collection *c) {
    for (int i = 0; i < c->count; i++) {
        printf("%d\n", c->data[i]);
    }
}