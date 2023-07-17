#include <iostream>
#include <unordered_map>
#include <map>
using namespace std;

/*
 * 풀이방법: map을 활용한 풀이 방식
 * 1. 먼저 입력한 배열의 키가 map에 있는지 확인 하고 있으면 새로 만들어 넣어준다. 이때 값은 1로 한다.
 * 2. 출력할 때는 무식하게 다시 처음부터 순회해서 하지 말고 그냥 map에다가 찾는 키 넣어주면 해당하는 값이 바로 나온다 -> 없으면 0 나옴
 *
 * 추가사항: unorderd_map으로 해시함수 써서 더 빠르게 출력하는 방법도 있음
*/



int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M, req;

    //unordered_map<int,int> m;
    map<int, int> m;
    cin >> N;
    int arr[N];
    for(int i=0; i<N; i++){
        cin >> arr[i];

        if(m.find(arr[i])!=m.end()){
        }else{
            //cout << "not find" << "\n";
            m.insert(make_pair(arr[i],1));
        }

    }
    cin >> M;
    for(int i=0; i<M; i++) {
        cin >> req;
        cout << m[req] << " ";

    }
}
