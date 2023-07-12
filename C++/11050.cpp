#include <iostream>

using namespace std;

int main() {
    int N, K;
    cin >> N >> K;
    int temp = N-K;
    int answer1=1;
    int answer2=1;
    for(int i=N; i>temp; i--){
        answer1*=i;
    }
    for(int i=2; i<=K; i++){
        answer2*=i;
    }

    cout << answer1/answer2;

}
