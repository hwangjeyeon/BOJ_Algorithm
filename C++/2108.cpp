#include <iostream>
#include <algorithm>
#include <cmath>


/* 풀이방법:
 * - 이 문제의 티어를 실버3으로 만든 부분은 최빈값 -> 나머지는 너무 쉬워서 최빈값 풀이방법은 설명하겠습니다
 * - 산술평균에서 float형으로 평균을 선언해주면 오차 발생으로 정답이 나오지 않는다 -> float형은 소수점 5자리까지 정확하게 표현 가능하나 double형은 소수점 16자리까지 정확하게 표현 가능하다 -> 따라서 double형으로 선언해주자
 * - 문제의 힌트인 정수의 절대값은 4000을 넘지 않는다와 히스토그램 방식을 중심으로 문제를 풀었습니다
 * 
 * 1. 히스토그램 배열을 8001 크기로 선언해준다
 * 2. 히스토그램 배열을 0으로 초기화 해주고 입력받은 배열의 값 + 4000의 히스토그램 위치에 N만큼 순회해서 값을 1씩 증가시킨다
 * 3. 가장 큰 값을 찾기 위해 히스토그램 배열을 전부 순회해준다
 * 4. 가장 큰 값과 같은 값이 나오면 그 값을 최빈값으로 한다. 2개 이상일 수도 있기 때문에 flag를 이용하여 제한한다
 * 5. 4번 방법대로 하면 최빈값이 여러개일 때 2번째로 작은 값을 찾을 수 있는데 이는 가장 작은 수부터 가장 큰 수까지 순회하기 때문이다. -> 첫번째로 작은 최빈값을 발견하면 mod에 넣고 flag를 true로 선언한다. -> 두번째 최빈값이 발견되면 mod에 넣고 break로 빠져나온다
 * 
 * - 문제의 절댓값 4000을 넘지 않는다는 조건의 힌트와 히스토그램 방식이라는 힌트를 찾지 못했으면 시간이 더 걸렸을듯..
 */

using namespace std;




int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N;
    cin >> N;
    int req[N];

    for(int i=0; i<N; i++){
        cin >> req[i];
    }

    sort(req,req+N);
    // 평균
    double avg =0;
    for(int i=0; i<N; i++){
        avg += req[i];
    }
    avg /= N;
    avg = round(avg);
    if(avg == -0){
        avg = 0;
    }

    // 중앙값
    int mid = req[N/2];


    // 최빈값
    int Mod;
    int histogram[8001];
    int most = 0;
    for(int i=0; i<8001; i++){
        histogram[i] = 0;
    }
    for(int i=0; i<N; i++){

        histogram[req[i]+4000]+=1;
    }
    bool flag = false;
    for(int i=0; i<8001; i++){
        if(histogram[i] > histogram[most]){
            most = i;
            Mod = most-4000;
        }
    }

    for(int i=0; i<8001; i++){
        if(histogram[i] == histogram[most]){
            Mod = i - 4000;
            if(flag == true){
                break;
            }

            flag = true;
        }
    }





    // 범위
    int range = req[N-1] - req[0];

    //cout << Mod;
    cout << avg << "\n" << mid << "\n" << Mod << "\n" << range;

}
