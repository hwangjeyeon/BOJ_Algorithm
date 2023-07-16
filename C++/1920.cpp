#include <iostream>
#include <algorithm>
using namespace std;

/*
 * 풀이방법: 이분탐색 라이브러리를 사용하여 해결하였습니다
 * 1. 먼저 입력 값을 배열에 저장하고 오름차순 정렬을 합니다
 * 2. 이분탐색을 이용하여 찾는 값이 있는 배열과 비교합니다
 * 이분탐색: start, mid, end 설정하고
 * mid = (start+end)/2
 * mid 보다 작으면 end = mid-1
 * mid 보다 크면 start = mid+1
 * 해당 과정을 start <= end 동안 반복한다
 * 해당 과정 진행 중 원하는 값을 찾으면 그대로 종료
 * 추가사항: 이분탐색 알고리즘 구현 코드도 작성하여 풀어봤습니다.
*/



int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    int N,M,req;
    cin >> N;
    int A[N];
    for(int i=0; i<N; i++){
        cin >> A[i];
    }
    cin >> M;

    sort(A, A+N);

    /*  오름차순 정렬 확인 Test
     * for(int i=0; i<N; i++){
        cout << A[i] << endl;
    }*/

    // 이분탐색 직접 구현 코드
    /*for(int i=0; i<M; i++) {
        cin >> req;
        int start = 0, end = N-1, mid = (start+end)/2;
        while (start <= end) {
            if (A[mid] == req) {
                cout << 1 << "\n";
                break;
            } else {
                if (A[mid] < req) {
                    start = mid + 1;
                    mid = (start + end) / 2;

                } else if (A[mid] > req) {
                    end = mid - 1;
                    mid = (start + end) / 2;
                }
            }
        }

        if(start > end){
            cout << 0 << "\n";
        }
    }*/


    //이분탐색 라이브러리 사용 코드
   for(int i=0; i<M; i++){
        cin >> req;
        bool answer = binary_search(A,A+N,req);
        if (answer == true){
            cout << 1 << "\n";
        }else{
            cout << 0 << "\n";
        }

    }

}
