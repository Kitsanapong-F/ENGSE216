// main.c
#include <stdio.h>
#include "collection.h" // ดึงฟังก์ชันของ collection มาใช้งาน

int main() {
    Collection c;
    initCollection(&c); // เรียกฟังก์ชันเซ็ตค่าเริ่มต้นให้ count = 0

    add(&c, 15);
    add(&c, 7);
    add(&c, 12);
    add(&c, 16);
    add(&c, 10);

    removeAt(&c, 0);

    printf("%d\n", size(&c));
    showAll(&c);

    return 0;
}