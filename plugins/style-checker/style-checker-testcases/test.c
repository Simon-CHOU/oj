#include<iostream>

#define _KK 1 <== Violation
#define _TT "sds" <== Violation
int main() {
	test(1,1);
	return 0;
}

void test(int a, int b) {
	std::cout << a + b << endl;
}