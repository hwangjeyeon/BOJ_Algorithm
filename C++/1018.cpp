#include <iostream>
using namespace std;

/*
 * 브루트포스 알고리즘으로 진짜 말그대로 무식하게 다 일일이 비교해서 풀었습니다.
 * 풀이방법:
 * 1. 비교해야 될 샘플은 두가지이므로, 미리 2개의 샘플 배열을 만들어 놓습니다.
 * 2. 체스판에서 비교해야될 범위를 지정해서 tmp1,tmp2에 넣습니다
 * 3. 범위 만큼 샘플과 일일이 비교해서 바꿔야 할 칸의 수를 카운트하고, 두 샘플 중 더 작은 카운트를 저장합니다
 * 4. 저장한 카운트 중에서 가장 작은 카운트를 찾고 해당 값을 출력합니다.
 */



int main(){
    int N,M,tmp1,tmp2;
    char sample1[8][8] = {
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'}
    };
    char sample2[8][8] = {
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'}
    };
    cin >> N >> M;
    char chess[N][M];
    tmp1 = N-8+1;
    tmp2 = M-8+1;
    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++) {
            cin >> chess[i][j];
        }
    }

    int count1=0;
    int count2=0;
    int count_array[tmp1*tmp2];
    int count3=0;

    for(int i=0; i<tmp1; i++){
        for(int j=0; j<tmp2; j++){
            for(int k=0; k<8; k++){
                for(int l=0; l<8; l++){
                    if(chess[k+i][l+j] != sample1[k][l]){
                        count1++;
                    }
                    if(chess[k+i][l+j] != sample2[k][l]){
                        count2++;
                    }

                }

            }
            //cout << count1 << " " << count2 << "\n";
            count_array[count3] = min(count1,count2);
            //cout << count_array[count3] << "\n";
            //cout << count3 << "\n";
            count1=0;
            count2=0;

            count3++;
        }
    }

    int answer = count_array[0];
    for(int i=0; i< count3; i++){
        //cout << count_array[i] << endl;
        answer = min(answer,count_array[i]);

    }

    cout << answer;

    // 배열 출력 test
    /*cout << "\n";
    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++){
            cout << chess[i][j];
        }
        cout << "\n";
    }*/
}
