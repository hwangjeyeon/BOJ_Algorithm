import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 플로이드 와샬까지는 쉽게 도출해낼 수 있었다
 *
 * 해결방법:
 * 1. 정답을 구하기 위해서는 문제를 잘 이해해야 한다
 * 2. 2개의 건물을 골라서 치킨집에 열려고 한다고 했으며, 그 두 지점 까지 모든 건물에서 각각 왕복하는 시간의 총합이 가장 작은 시간을 구하는 것이라고 하였다
 * 3. 이것을 위해서는 한번더 3중 포문을 돌아서 두 지점을 고르고 두 지점에서 출발해서 자기자신을 제외한 다른 지점으로 가능 거리가 더 짧은 것은 sum에다가 더해줘야한다
 * 4. 이후 min값보다 작다면 값을 갱신해주고 그 두 지점을 정답 지점으로 갱신해준다
 * 5. 이때 sum은 그 지점으로 그냥 가는 시간만 더하는 것이다. 왕복시간은 갔다가 돌아오는 시간도 생각해야하기 때문에 sum * 2로 출력을 해야한다.
 *
 *
 * 시간복잡도: O(n^3)
 * 공간복잡도: O(n^2)
 *
 */



public class Main {

    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(i == j){
                    arr[i][j] = 0;
                }
                arr[i][j] = 10001;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }


        floydWarshall(n);
        int min = 10001;
        int ans1 = 0;
        int ans2 = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(i == j){
                    continue;
                }
                int sum = 0;
                for (int k = 1; k < n+1; k++) {
                    if(k == i || j == k){
                        continue;
                    }
                    sum += Math.min(arr[i][k], arr[j][k]);
                }
                int now = sum;

                if(min > now){
                    min = now;
                    ans1 = i;
                    ans2 = j;
                }
            }
        }

        bw.write(ans1 + " " + ans2 + " " + min*2 + "");


        br.close();
        bw.close();
    }

    private static void floydWarshall(int n) {

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    if(arr[j][k] > arr[j][i] + arr[i][k]){
                        arr[j][k] = arr[j][i] + arr[i][k];
                    }
                }
            }
        }



    }

}

