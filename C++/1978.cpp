#include <iostream>
#include <cmath>

using namespace std;

/*
 * 소수 판정 sqrt루트 제곱근 활용
 * 소수 == (1과 자기 자신을 제외한 약수를 가지지 않음)
 * 합성수 == (1과 자기자신 이외에 약수를 가짐)
 * 합성수가 p*q로 표현될 때, 한쪽은 무조건 sqrt(합성수) 이하 반대는 이상이라는 것을 이용한다
 * 알고리즘 구현 방식은 다음과 같다:
 * 1. 숫자 1은 무조건 소수가 아니므로 제외
 * 2. 숫자 2는 무조건 소수이며, 2를 제외한 양수 중, 짝수는 무조건 소수가 아니다
 * 3. 숫자 num을 입력받았을 때 3부터 num의 제곱근의 정수 (int)sqrt(num)까지의 숫자가 num과 나누었을 때 나머지가 0이되면
 *    해당숫자는 소수가 아니다
 * 4. 이런식으로 코드를 구현하였으며, 소수면 flag = true, 아니면 flag = false
 *
 * - 해당 문제는 소수판정 정수론 공부 후 풀었습니다. - 추후 소수판정 문제가 나올 시, 해당 개념 활용해서 자체적으로 알고리즘 짜기
 */

int main() {
    int N, count=0;
    cin >> N;

    for(int i=0; i<N; i++){
        int num;
        cin >> num;
        bool flag = true;

        if(num <= 1){
            continue;
        }else if(num%2 == 0 && num != 2){
            continue;
        }

        int tmp1 = (int)sqrt(num);
        for(int j=3; j<=tmp1; j+=2){
            if(num%j == 0) {
                flag = false;
                break;
            }else
                flag = true;

        }
        if(flag == true)
            count++;
    }
    cout << count;
}
