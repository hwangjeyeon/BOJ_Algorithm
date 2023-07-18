#include <iostream>
using namespace std;

/*
 * 풀이방법: 브론즈 난이도는 그냥 브루트포스로 풀자.
 * 1. 그냥 0부터 입력값 전까지 다 분해합을 구해본다.
*/



int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    string N, tmp2;
    cin >> N;
    int tmp1, dit1, dit2, answer;
    tmp1 = stoi(N);
    dit1 = N.length();

    bool flag = true;
    for (int i = 0; i < tmp1; i++) {
        answer = i;
        int tmp3 = answer;
        //cout << answer << " ";
        for (int j = 0; j < dit1; j++) {
            int digit = tmp3 % 10;
            answer += digit;
            tmp3 /= 10;

        }
        if (answer == tmp1) {
            cout << i;
            flag = false;
            break;
        } else {
            answer = 0;
        }
    }
    if (flag == true) {
        cout << 0;
    }
}
