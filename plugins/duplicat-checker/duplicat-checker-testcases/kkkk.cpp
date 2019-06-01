#include<stdio.h>
int main()
{
	int array[6] = {5,2,4,6,3,1};// n = 6
	int i,j,temp;
	for(i = 1;i < 6;i++)//进行n - 1趟排序
	{
		temp = array[i];//temp临时存放array[i]
		j = i;
		while(j > 0 && temp < array[j - 1])//只要temp小于前一个元素array[j - 1]且j大于0，则把array[j - 1]往后移一位至array[j]
		{
            array[j] = array[j - 1];//把array[j - 1]往后移一位至array[j]
			j--;//下标前移，即继续往数组前面有序部分遍历
		}
		array[j] = temp;//把temp插入对应的位置j
	}
    for(i = 0;i < 6;i++)
	{
		printf("%d ",array[i]);
	}
	printf("\n");
	return 0;
}