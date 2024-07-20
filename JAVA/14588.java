import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 케빈 베이컨 문제랑 비슷하게 풀 수 있는 플로이드 워셜 문제다
 * 2. Node로 시작과 끝을 관리해주며, arr을 만들어서 두 지점의 연결을 관리한다
 * 3. 최대 나올 수 있는 친구의 수 + 1은 301이므로 arr은 301로 모두 초기화한다
 * 4. 이어서 먼저 친구 관계를 파악해준다. 이중포문으로 확인하며, i의 start보다 크고 i의 end보다 작은 j의 start와 end일 경우 친구가 된다. 따라서 둘을 양방향 연결로 이어준다
 * 5. 이어서 플로이드 워셜을 통해 한 친구가 다른 모든 친구와 맺을 수 있는 친구관계를 구한다. 낮을 수록 좋은 것이므로 최단거리를 구하는 플로이드 워셜이 최적의 방법이 된다
 * 6. 이제 주어진 쿼리대로 출력하는데 만약 301이라면 둘은 이어질 수 없는 관계이므로 -1을 출력하며, 아닌 경우 그대로 arr에서 두 연결관계에 해당하는 배열의 값을 출력하면 정답이 된다.
 * 
 * 
 * 해결방법:
 *
 * 시간복잡도: O(n^3)
 * 공간복잡도: O(n^2)
 *
 */

class Node{
    int start;
    int end;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }
}


public class Main {

    static int[][] arr;
    static Node[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        nodes = new Node[n+1];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[i+1] = new Node(a, b);
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                arr[i][j] = 301;
            }
        }


        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(i == j){
                    continue;
                }

                if((nodes[i].start <= nodes[j].start && nodes[i].end >= nodes[j].start)
                        || (nodes[i].start <= nodes[j].end && nodes[i].end >= nodes[j].end)){
                    arr[i][j] = 1;
                    arr[j][i] = 1;
                }
            }
        }

        floydWarshall(n);


        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(arr[a][b] == 301){
                bw.write("-1\n");
            }else{
                bw.write(arr[a][b]+ "\n");
            }
        }

        br.close();
        bw.close();
    }

    private static void floydWarshall(int n) {

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                }
            }
        }


    }

}

