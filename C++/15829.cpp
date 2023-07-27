#include <iostream>
#include <map>

/* 풀이방법:
 * - 두가지 개념을 가지고 가야지 100점을 맞을 수 있다
 * - 1. 오버플로우 대비해서 long long형으로 갈 것
 * - 2. 어떤 수의 제곱의 나머지를 구하려고 할때, 순차적으로 어떤 수를 곱하고 그 수의 나머지를 구한다음 다시 그 수로 곱해서 제곱의 수까지 곱한다면 그 값은 같다
 * -> 5^3 %7과 5%7*5%7*5%7은 같다
 * 1. map을 이용하여 알파뱃을 key로 그 아스키 코드에서 -96을 한 값을 value로 갖는다 서로소인 M은 미리 define해둔다
 * 2. pow를 쓰면 오버플로우가 발생한다. 따라서 이중 for문을 돌려서 31을 곱하고 그 값을 M으로 나눠서 나머지 값을 넣는 과정을 반복한다
 * 3. 아스키 코드와 2번 과정에서 나온 값을 곱한다
 * 4. 3번 과정의 결과가 정답이다.
 */

using namespace std;
#define M 1234567891



int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    map<char, int> hash;
    int L;
    for(int i=97; i<123; i++){
        hash.insert({i,i-96});

    }

    cin >> L;
    string str;
    cin >> str;
    long long sum=1;
    long long answer = 0;
    for(int i=0; i<L; i++){


        for(int j=0; j<i; j++){
            sum *= 31;
            sum %= M;
        }
        answer += hash.at(str.at(i))* sum;
        answer %= M;

        sum=1;
    }


    cout << answer;


}
