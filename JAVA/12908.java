import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 이게 왜 플로이드와샬일까? 시간복잡도부터 문제가 되는데? 라는 의문을 가졌다
 * 2. bfs, dfs로도 시간초과가 발생하기에 풀 수가 없다. 그렇다면 어떻게 해야 풀 수 있을까?
 * 3. 바로 플로이드 와샬 방법을 이용하는데 시작 지점과 끝 지점 그리고 텔레포트 지점만을 이용하는 방법이다
 * 4. 이동과 시간은 어떻게 잴 것인가? 의문이 들었는데, 어차피 상하좌우는 1씩만 증가하기 때문에 Hamming Distance를 이용하여, 계산하여 주면된다
 * 5. 텔레포트는 Hamming Distance와 10을 비교하여 더 작은 값을 선택해주면 된다
 * 6. 두 지점간의 최소 이동 거리를 담아줄 arr 2차원 배열과 각 노드들을 담아줄 nodes 1차원 배열을 하나 만들어준다
 * 7. x,y좌표는 간편하게 Position 클래스를 만들어서 관리하였다
 * 8. 상하좌우 이동은 Hamming Distance로 계산해주면 된다. Hamming Distance는 두 x좌표 차의 절댓값 + 두 y좌표 차의 절댓값이다
 * 9. 시작지점과 끝 지점에 해당하는 배열의 위치 0,7 / 7,0에 해당 값들을 넣어준다. 양방향으로 갈 수 있기 때문이다
 * 10. 이어서 텔레포트 시작지점과 끝 지점을 각각 받아주고 nodes 배열에 저장해준다. 이때 순회를 조금 특이하게 돌아야하는데 i를 1부터 시작해서 7보다 작을 떄까지 2씩 증가하도록 순회를 돌면 된다
 * 11. i지점에 시작지점을 넣고 i+1 지점에 끝 지점을 넣어준다
 * 12. arr배열에 넣을 때는 텔레포트 시간인 10과 Hamming Distance 값을 비교하여 더 작은 값을 넣어준다
 * 13. 이제 각 지점마다 최소한의 걸리는 값을 구하기 위해 이중포문을 돌며 현재 지점의 값과 두 지점간의 Hamming Distance 값을 비교하여 더 작은 값을 넣어준다
 * 14. 이제 각 지점의 최소한의 거리를 가지고 플로이드 워셜을 이용하여 경유지를 공유했을 때의 최솟값까지 확인하고 더 작은 값을 넣어준뒤 시작지점에서 도착지점으로 가는 arr[0][7]을 출력해주면 정답이 된다.
 *
 *
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */

class Position{

    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}



public class Main {

    static long[][] arr = new long[8][8];
    static Position[] nodes = new Position[8];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int xs = Integer.parseInt(st.nextToken());
        int ys = Integer.parseInt(st.nextToken());
        nodes[0] = new Position(xs, ys);
        st = new StringTokenizer(br.readLine());
        int xe = Integer.parseInt(st.nextToken());
        int ye = Integer.parseInt(st.nextToken());
        nodes[7] = new Position(xe, ye);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                arr[i][j] = Long.MAX_VALUE;
            }
        }

        arr[0][7] = Math.abs(nodes[0].x - nodes[7].x) + Math.abs(nodes[0].y - nodes[7].y);
        arr[7][0] = Math.abs(nodes[0].x - nodes[7].x) + Math.abs(nodes[0].y - nodes[7].y);

        for (int i = 1; i < 7; i+=2) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[i] = new Position(a, b);
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            nodes[i+1] = new Position(c,d);
            arr[i][i+1] = Math.min(Math.abs(nodes[i].x - nodes[i+1].x) + Math.abs(nodes[i].y - nodes[i+1].y), 10);
            arr[i+1][i] = Math.min(Math.abs(nodes[i].x - nodes[i+1].x) + Math.abs(nodes[i].y - nodes[i+1].y), 10);
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                arr[i][j] = Math.min(arr[i][j], Math.abs(nodes[i].x - nodes[j].x) + Math.abs(nodes[i].y - nodes[j].y));
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                }
            }
        }

        bw.write(arr[0][7] + "");

        br.close();
        bw.close();
    }

}

