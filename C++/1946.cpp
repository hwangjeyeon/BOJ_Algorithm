#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
/*
 * 문제 유형: 그리디 알고리즘을 생각하는 문제
 * 풀이 날짜: 2023.03.01.
 * 1차 코드 리딩 날짜: 2023.07.20.
 * 풀이 방법:
 * 1. 각 사람의 서류 점수와 면접 점수를 pair<int,int>로 감싸서 백터안에 넣는다 -> vector<pair<int, int>> Marks(N);
 * 2. 왼쪽의 서류 점수를 기준으로 오름차순 정렬을 한다 -> 시간 초과 해결을 위해서 오름차순 정렬을 함 -> 오름차순 정렬 안 하고 첫번째 값과 두번째 값을 비교하는 이중 for문 코드를 작성하면 시간초과 발생
 * 3-1. 오름차순 정렬되면 왼쪽 서류 성적을 1등한 사람의 오른쪽 면접 점수 순위를 checker에 넣는다 
 * 3-2. checker의 순위보다 높은 순위를 가진 사람이 있는 경우 그 사람의 순위를 checker에 넣는다 -> 또한 카운트 값도 증가시킨다
 * 3-3. checker의 들어가는 순서는 왼쪽 서류 성적의 순위가 높은 사람부터 차례대로 확인해서 들어가므로, 만약 checker보다 순위가 낮은 사람이 존재할 경우 그 경우는 두 성적 순위가 모두 다른 사람에 비해 떨어진다는 것을 의미한다
 * 4. 해당 과정을 거쳐 count값을 출력한다
 *
 */

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int T, N;
    cin >> T;
    int count = 0;
    for (int i = 0; i < T; i++) {
        cin >> N;
        vector<pair<int, int>> Marks(N);
        int count = 1, checker = 0;

        for (int j = 0; j < N; j++) {
            cin >> Marks[j].first >> Marks[j].second;

        }

        sort(Marks.begin(), Marks.end());

        checker = Marks[0].second;

        for (int j = 1; j < N; j++) {
            if (Marks[j].second < checker) {
                count++;
                checker = Marks[j].second;
            }
        }

        cout << count << "\n";

    }


}
