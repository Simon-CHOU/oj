#include <stdlib.h>
#include <stdio.h>
#include <string.h>
 
void init_buffer(void)
{
    char filename[128] = {""}; // 这样初始为0，如果是{"1"}，则只有第1个字节为1，其它为0 --不知其它编译器会怎样
    
    printf("test of buffer\n");
 
    dump(filename, 128);
    
    char unused_buffer[7*1024*1024] = {0};   // 没有使用的缓冲区，超过栈最大值，有coredump。
    char unused_buffer1[1*1024*1024] = {0};
    
    strcpy(unused_buffer1, "hello");
}
 
// 数组范围越界
void out_of_array(void)
{
    int foo[2]; // 范围不够
    int aaa = 250;
    
    foo[0] = 1;
    foo[1] = 2;
    // 下面这些是不行的
    foo[2] = 3;
    foo[3] = 4;
    foo[4] = 5;
    foo[5] = 6;
    
    printf("%d %d \n", foo[0], foo[1]);
}
 
#include <sys/types.h>
#include <dirent.h>
// 打开未关闭
void open_not_close()
{
    // 内存泄漏
    char* p = new char[100];
    strcpy(p, "hello");
    printf("p:%s\n", p);
    
 
    FILE* fp = NULL;
    fp = fopen("aaa", "a");
    
    if (fp)
    {
        // 注：这里返回时没有关闭文件
        return;
    }
    
    fclose(fp);
    
 
    DIR *dir = NULL;
    dir = opendir("./");
    
}
 
int main(void)
{
    int ret = 0;
 
    foo();
 
    init_buffer();
    out_of_array();
    open_not_close()
    return 0;

}