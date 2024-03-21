import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 일단 계란의 속성은 클래스로 지정해준다. 그리고 이 계란 클래스들을 배열에 저장해둔다
 * 2. 최대로 깰려면 내구도를 기준으로, 내구도가 같으면 power를 기준으로 오름차순 정렬을 해준다.
 * 3. 재귀
 * 3-1. 함수식: game(n, depth)
 * 3-2. base condition: depth == n
 * 3-3. 재귀식: game(n, depth+1)
 * 4. 재귀식에서 현재 들고 있는 계란을 지정한다. select = eggs[depth];
 * 5. 순회를 통해서 계란치기를 진행한다. while문을 통해서 반복한다. 이때 count가 n이거나, eggs의 내구도가 0보다 작아지면 종료한다
 * 6. 5번 과정에서 계란이 순회마다 각각 서로 친 계란의 내구도를 봐서 꺠졌으면 count를 증가시킨다
 * => 틀린풀이
 *
 * - 문제 해결:
 *  - 3번부터 다시 시작이다
 *  - 재귀
 *  - 함수식: game(n, 현재위치, 깨트린 계란 개수 총합)
 *  - base condition (깨트린 계란 개수 총합이 n-1개거나, 현재위치가 n-1일떄)
 *  -> 이때 ans와 비교해서 더 큰 값을 넣어준다
 *  - 재귀식:
 * 현재 계란의 내구도가 0이하이면
 * game(n,now+1, count+2);
 * 2개 다 꺠졌으면
 * game(n, now+1, count + 2);
 * 1개만 깨졌으면
 * game(n, now+1, count + 1);
 * 둘다 안 깨졌으면
 * game(n, now+1, count);
 *
 * - 처음 풀때는 정렬을 해야하나 생각을 했지만 그렇게 접근하면 안 되는 문제였다
 * - 예제들을 보면 정렬하지 않고 주어진 순서대로 탐색해야 하는데 현재 손에 잡고 있는 계란과 쳐볼 계란은 랜덤이다 (물론 꺠지지 않은 계란이어야한다)
 * - 처음에는 집고 나서 다시 정렬을 해야하나 했는데 이것 역시 원하는 결과를 도출하지 못했다
 * - 방법은 백트래킹과 완전탐색을 이용해서 나온 결과를 계속 비교해서 가장 큰 값을 찾으면 되는 것이었다
 * - 만약 현재 계란의 내구도가 0이면 now+1을 해준다.
 * - 만약 그리고 순회하면서, 내구도가 0보다 크면 서로 쳐서 내구도를 깎아주고, 깨진 개수에 따라 count에 추가로 더해서 재귀함수를 실행한다
 * - 이후 돌아와서는 다시 깎인 내구도를 복구시켜서 완전탐색하도록 한다.
 *
 * - 재귀와 백트래킹 개념은 어느정도 잡히는데 완전탐색이 들어가면 어려워지는 것 같다. 이제 곧 학습할 완전탐색 풀이 후에 다시 풀어보자
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(nlogn)
 *
 */

class Egg{
    int weight;
    int power;

    public Egg(int weight, int power){
        this.weight = weight;
        this.power = power;
    }
}

public class Main {

    static int ans = 0;
    static Egg[] eggs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        eggs = new Egg[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Egg egg = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            eggs[i] = egg;
        }

        game(n, 0, 0 );
        bw.write(ans+"");
        br.close();
        bw.close();
    }

    private static void game(int n, int now, int count) {
        if(count == n-1 || now == n){
            ans = Math.max(ans, count);
            return;
        }

        if(eggs[now].weight <= 0){
            game(n, now+1, count);
        }else{
            for (int i = 0; i < n; i++) {
                if(i == now){
                    continue;
                }
                if(eggs[i].weight > 0 ){
                    eggs[i].weight -= eggs[now].power;
                    eggs[now].weight -= eggs[i].power;
                    if(eggs[now].weight <=0 && eggs[i].weight <= 0){
                        game(n, now+1, count + 2);
                    }else if(eggs[now].weight <=0 || eggs[i].weight<=0){
                        game(n,now+1, count+1);
                    }else{
                        game(n,now+1, count);
                    }
                    eggs[now].weight += eggs[i].power;
                    eggs[i].weight += eggs[now].power;
                }

            }
        }

    }


}

