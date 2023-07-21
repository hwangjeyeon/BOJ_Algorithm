#include <iostream>
#include <stack>

/* 풀이방법:
 * 1-1. 문제 풀이를 위한 스택과 입력을 위한 int형, string 형 변수를 각각 선언한다
 * 1-2. 력을 위한 정답 변수를 선언한다
 * 2-1. 입력받은 값이 "0"이면 스택 top의 수를 answer에서 빼주고 pop을 한다
 * 2-2. 입력받은 값이 "0"이 아니면 스택에 수를 push하고 해당 값을 answer에 더해준다
 * 3. 스택이 비어있으면 0 출력, 비어있지 않으면 answer을 출력한다
 */

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int K;
    string req;
    stack<int> zero;
    int answer = 0;
    cin >> K;
    for(int i=0; i<K; i++){
        cin >> req;
        if(req == "0"){
            answer-= zero.top();
            zero.pop();
        }else{
            zero.push(stoi(req));
            answer+=zero.top();

        }
    }

    if(zero.empty()){
        cout << 0;
    }else{
        cout << answer;
    }


}
