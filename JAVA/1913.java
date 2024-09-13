import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 처음에는 중간에서 부터 시작해서 증가하는 방향으로 했는데, 구현하기 쉽지 않아 0,0부터 시작해서 줄어드는 방향으로 진행하였다
 * 2. 맨 처음 아래방향으로 가는 경우는 n만큼, 오른쪽과 위는 n-1, 왼쪽은 n-2만큼이라고 생각하면 된다
 * 3. 이때 n은 한사이클을 다 돌고나면 2만큼 줄어든다
 * 4. count가 0보다 작으면 탈출하고 그 이전까지는 while(true)로 반복한다
 * 5. 이어서 n*n만큼 순회하며 출력하고 만약 m이 있다면 정답 y축과 x축을 변수로 담아 순회 끝난뒤 출력하면 정답이 된다
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int counts = n;

        int nowY = -1;
        int nowX = 0;

        int ansY = 0;
        int ansX = 0;
        int count = n*n;

        while(true){
            if(count <= 0){
                break;
            }

            for (int i = 0; i < counts; i++) {
                nowY++;
                arr[nowY][nowX] = count--;
            }

            for (int i = 0; i < counts-1; i++) {
                nowX++;
                arr[nowY][nowX] = count--;
            }

            for (int i = counts-2; i >= 0; i--) {
                nowY--;
                arr[nowY][nowX] = count--;
            }

            for (int i = counts-3; i >= 0; i--) {
                nowX--;
                arr[nowY][nowX] = count--;
            }
            counts -= 2;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(arr[i][j]+" ");
                if(arr[i][j] == m){
                    ansY = i+1;
                    ansX = j+1;
                }
            }
            bw.write("\n");
        }
        bw.write(ansY + " " + ansX);

        br.close();
        bw.close();
    }
}

