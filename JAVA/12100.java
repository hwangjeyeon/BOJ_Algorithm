import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * 재귀(백트래킹)
 * 1. 함수식 game(field, depth);
 * 2. base condition  depth == 5
 * 3. 재귀식 game(field, depth+1);
 *
 * 1. 입력값이 작기 때문에 재귀식으로 가능하다. 그러면서 총 4가지 방향으로 모두 탐색하면서 가지치기를 해야한다
 * 2. 따라서 백트래킹방법을 사용하였고, 블록 이동 수는 5번이라 했으니 종료조건을 5로 잡았다. 5가 되면 배열을 모두 순회해서 가장 큰 값을 count에 넣는다
 * 3. 한가지 주의할점은 백트래킹에서 배열은 그 값이 유지되기 때문에, 미리 원본을 복사해두어야 한다. 따라서 tmp배열에다가 clone해서 저장해두고, 하나의 백트래킹 종료후에 이전 원본 배열로 돌려놓는다
 *
 * - 문제 해결:
 * 1. 머리속으로는 구상이 되었으나 코드로 쉽게 구현이 되지 않았다.
 * 2. 이 문제 쉽게 풀려면 일단 이 부분을 메소드로 쪼개어서 풀도록 하자
 * 3. 여기서는 play로 빼내었다
 * 4. 상하좌우를 각각 0,1,2,3으로 방향을 잡았다
 * 5. 내가 가는 방향쪽의 위가 0이면 그대로 덮어씌운다. 만약 같은값이면 곱해지고 원래자리는 0이 된다. 다른 값이면 움직이지 않는다
 * 6. 이런 5번의 여러 조건을 해결하기 위해서는 큐를 사용해야 했다. 주어진 방향마다 하나의 방향으로만 탐색을 n번해서 숫자가 있는 경우 빼와서 큐에 넣고 원래자리를 0으로 한다
 * 7. 그리고 큐가 빌때까지 큐의 값을 poll해서 now에 넣고, pos이라는 변수를 통해 배열에 값을 넣어준다
 * 8. 만약 현재 배열의 값이 0이면 그냥 현재 배열에 now를 넣는다
 * 9. pos는 그대로이고 now는 갱신된다.
 * 10. 이제 다시 비교하는데 현재 pos의 값이 0이 아니므로 다시 값을 비교한다. 만약 now랑 같아면 현재 배열의 값에 2를 곱해서 넣어주고 pos를 방향에 따라 감소시키거나 늘려준다
 * 11. 만약 아니라면 같은 숫자가 아니므로, pos--나 pos++를 통해서 위치를 갱신한 뒤, 갱신된 배열의 위치에 그 값을 넣어준다. 
 * 12. 이렇게 하면 로직이 완성된다
 *
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 *
 */



public class Main {

    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] field = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        game(field, 0,n);

        bw.write(count+"");


        br.close();
        bw.close();
    }

    private static void game(int[][] field, int depth, int n){
        if(depth == 5){
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field.length; j++) {
                    count = Math.max(field[i][j],count);
                }
            }
            return;
        }

        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++) {
            tmp[i] = field[i].clone();
        }

        // 상(0), 하(1), 좌(2), 우(3)
        for (int i = 0; i < 4; i++) {
            play(field, i, n);
            game(field, depth+1, n);
            for (int j = 0; j < n; j++) {
                field[j] = tmp[j].clone();
            }
        }
    }

    private static void play(int[][] field, int direction, int n) {
        Queue<Integer> q = new LinkedList<>();
        if(direction==0){
            for (int i = 0; i < n; i++) {
                for (int j = n-1; j >= 0; j--) {
                    if(field[j][i] != 0){
                        q.add(field[j][i]);
                    }
                    field[j][i] = 0;
                }

                int pos = n-1;
                while(!q.isEmpty()){
                    int now = q.poll();
                    if(field[pos][i] == 0){
                        field[pos][i] = now;
                    }else if(field[pos][i] == now){
                        field[pos][i] *= 2;
                        pos--;
                    }else{
                        pos--;
                        field[pos][i] = now;
                    }
                }

            }

        }else if(direction==1){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(field[j][i] != 0){
                        q.add(field[j][i]);
                    }
                    field[j][i] = 0;
                }

                int pos = 0;
                while(!q.isEmpty()){
                    int now = q.poll();
                    if(field[pos][i] == 0){
                        field[pos][i] = now;
                    }else if(field[pos][i] == now){
                        field[pos][i] *= 2;
                        pos++;
                    }else{
                        pos++;
                        field[pos][i] = now;
                    }
                }

            }
        }else if(direction==2){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(field[i][j] != 0){
                        q.add(field[i][j]);
                    }
                    field[i][j] = 0;
                }

                int pos = 0;
                while (!q.isEmpty()){
                    int now = q.poll();

                    if(field[i][pos] == 0){
                        field[i][pos] = now;
                    }else if(field[i][pos] == now){
                        field[i][pos]*= 2;
                        pos++;
                    }else{
                        pos++;
                        field[i][pos] = now;
                    }
                }
            }

        }else if(direction==3){
            for (int i = 0; i < n; i++) {
                for (int j = n-1; j >= 0; j--) {
                    if(field[i][j] != 0){
                        q.add(field[i][j]);
                    }
                    field[i][j] = 0;
                }
                int pos = n-1;
                while (!q.isEmpty()){
                    int now = q.poll();

                    if(field[i][pos] == 0){
                        field[i][pos] = now;
                    }else if(field[i][pos] == now){
                        field[i][pos] *= 2;
                        pos--;
                    }else{
                        pos--;
                        field[i][pos] = now;
                    }
                }
            }
        }

    }

}

