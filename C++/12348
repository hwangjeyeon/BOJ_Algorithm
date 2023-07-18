#include <iostream>
using namespace std;

/*
 * 풀이방법: 수학적 사고와 브루트포스 알고리즘 활용하여 풀었습니다.
 * 수학적 사고:
 * 1. 각 자리마다 올 수 있는 수는 0 ~ 9, 그렇다면 각 자리수 만큼 9씩 제곱해서 빼주면 굳이 1부터 해당 수까지 구해볼 필요가 없겠다고 생각함
 * 1,ex): 216이면 3자리수니까 9^3 = 729만큼 빼줘서 계산하자 -> 729 이하면 오히려 더 손해
 * 1,ex): 그럼 max(1LL,pow(9,자릿수))면? -> 이것도 결국은 입력 값 숫자가 많아지면 느려짐
 * 2. 제곱이 아니라 자릿수 만큼 곱해준다면?
 * 2,ex): 730일때 1부터 해주는 것이 아닌 730에서 27을 뺀 703부터 구하기 때문에 시간을 효율적으로 사용 가능
 * 3 더 효율적으로 하고 싶으면 함수로 빼서 해보기 -> 큰 차이는 없다고 함
 * 풀이 과정:
 * 1. 값을 입력 받고 string으로 저장합니다
 * 2. 저장한 값의 길이를 자릿수 longlong으로, string을 longlong으로 변환시켜줍니다
 * 3. 9*자릿수를 입력 받은 값에서 빼줘서 그 값을 시작으로 입력 값 까지 분해합이 있는지 확인합니다
 * 4. 있으면 해당 값을 출력하고 break, 없으면 for문 종료 후, 0을 출력합니다
 *
 * 기타사항: 첫 골드5 성공!, 조금만 더 시간 갖고 더 수학적 사고를 했다면 조금이라도 외부의 도움 없이 풀었을 텐데 아쉽다.
 *
 */




int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    string N, tmp2;
    cin >> N;
    long long tmp1, dit1,dit2, answer;
    tmp1 = stoll(N);
    dit1 = N.length();

    bool flag = true;


    dit2 = 9*dit1;

    //cout << dit2;
    for(long long i = tmp1-dit2; i < tmp1; i++){
        answer = i;
        //cout << "1: " << answer << " ";
        long long tmp3 = answer;
        for(long long j=0; j<dit1;j++){
            long long digit = tmp3 %10;
            answer += digit;
            tmp3 /= 10;
        }
        //cout << "2: " << answer << "\n";
        if(answer==tmp1){
            cout << i;
            flag = false;
            break;
        }else{
            answer = 0;
        }
    }

    if(flag == true){
        cout << 0;
    }
    return 0;
}
