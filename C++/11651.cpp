
#include <iostream>
#include <vector>
#include <algorithm>

/* 풀이방법: 오름차순 정렬 STL 사용
 * 1. 입력받을 횟수 N을 선언하고 입력받는다
 * 2. x와 y 좌표를 받은 vector 배열과 그 안의 pair<int,int>를 N의 크기만큼 선언한다
 * 3. 해당 값을 반대로 입력받고 반대로 출력한다 -> y좌표를 기준으로 오름차순 정렬하기 때문
 */


using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    vector<pair<int, int>> xy(N);
    for(int i=0; i<N; i++){
        cin >> xy[i].second >> xy[i].first;
    }

    sort(xy.begin(),xy.end());

    for(int i=0; i<N; i++){
        cout << xy[i].second << " " << xy[i].first << "\n";
    }

}

