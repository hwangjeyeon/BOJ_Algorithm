/*유를리드 호제법 사용:
최대공약수:
1. 최대공약수를 구하기 위한 두 수를 나눠준다
2-1. 나눠 떨어지지 않으면 다시 반복해서 나눠준다
2-2. 나눠 떨어지면 그 몫이 최대공약수이다
최소공배수:
1. 최대공배수를 구하기 위한 두 수를 곱한다
2. 곱한 값과 최대 공약수를 나누면 그 몫이 최소공배수가 된다.
*/

#include <iostream>

using namespace std;




int main() {
    int A,B,tmp1, tmp2, answer1, answer2;
    cin >> A >> B;
    tmp2 = A*B;
    while(A%B != 0){
        tmp1 = A;
        A = B;
        B = tmp1 % B;
    }
    answer1 = B;
    answer2 = tmp2/B;

    cout << answer1 << "\n" << answer2;
}
