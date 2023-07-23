#include <iostream>
/* 풀이방법: 브루트포스 알고리즘으로 풀었습니다
 * 1. int형 i를 666으로 초기화한다.
 * 2. 입력받은 N만큼 반복해서 연속하는 666이 나오는 경우를 찾는다
 * 3. 이때 i를 s에 string 형으로 바꿔주고 연속하는 666이 나올때까지 문자열에서 찾으며, 나오면 count값을 증가시켜준다
 * 4. i-1을 출력하면 그 값이 답이된다.
 */

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;
    int i=666;
    int count=0;

    while(count < N){
        string s = to_string(i);

        for(int j=0; j<s.length()-2; j++){
            if(s.at(j) == '6'){
                if(s.at(j+1) == '6'){
                    if(s.at(j+2) == '6'){
                        count++;
                        break;

                    }
                }
            }
        }


        i++;
    }

    cout << i-1;


}
