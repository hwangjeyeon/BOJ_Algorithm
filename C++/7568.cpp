#include <iostream>
#include <vector>


/* 풀이방법: 입력값 개수 보고 적으면 브루트포스로 풀자!
 * 1. 몸무게, 키는 vector<pair<int,int>>로 값을 받는다
 * 2. 이중for문으로 비교하고자 하는 값과 다른 모든 값을 비교한다
 * 3. 이때 pair의 first값이 비교하는 다른 값보다 작으면 second값을 비교해보고 second 값도 작으면 count의 값을 증가시킨다
 * 4. 모든 값과 비교해본 뒤 count를 rank배열에 넣어준다
 * 5. 최종적으로 rank배열을 출력한다.
 */

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N;
    cin >> N;
    vector<pair<int, int>> status(N);

    for(int i=0; i<N; i++){
        cin >> status[i].first >> status[i].second;
    }

    int count=1;
    int rank[N];
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            if(status[i].first < status[j].first){
                if(status[i].second < status[j].second){
                    count++;
                }

            }
        }
        rank[i] = count;
        count=1;
    }

    for(int i=0; i<N; i++){
        cout << rank[i] << " ";
    }
}
