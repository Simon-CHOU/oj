#include<stdio.h>
int main()
{
	int array[6] = {5,2,4,6,3,1};// n = 6
	int i,j,temp;
	for(i = 1;i < 6;i++)//����n - 1������
	{
		temp = array[i];//temp��ʱ���array[i]
		j = i;
		while(j > 0 && temp < array[j - 1])//ֻҪtempС��ǰһ��Ԫ��array[j - 1]��j����0�����array[j - 1]������һλ��array[j]
		{
            array[j] = array[j - 1];//��array[j - 1]������һλ��array[j]
			j--;//�±�ǰ�ƣ�������������ǰ�����򲿷ֱ���
		}
		array[j] = temp;//��temp�����Ӧ��λ��j
	}
    for(i = 0;i < 6;i++)
	{
		printf("%d ",array[i]);
	}
	printf("\n");
	return 0;
}