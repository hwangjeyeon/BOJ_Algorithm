import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 문제 구현자체는 어렵지 않게 한 문제다. 다만 파이어볼을 합치는 과정에서 3중 포문 + 포문을 사용했는데, 그 부분에서 시간초과가 발생했다
 * 2. 개선해서 2중 포문 + 포문을 했는데도 여전히 시간초과가 발생했다. 문제가 발생하는 지점은 전체 배열의 각 칸에 파이어볼의 개수를 세는 부분과 합치는 부분을 나눴을 때 발생한다
 * 3. 파이어볼의 개수를 아예 세지 않고, 파이어볼 합치는 로직과 4개로 분리하는 로직을 한번에 처리하도록 구현했다
 * 4. 이때, 이전에 사용하지 않았던 2차원 리스트 배열을 사용해서, 아예 배열 칸에 파이어볼을 넣도록 상태를 관리했다
 * 5. 이것을 이용하면 합치는 로직 개선은 쉽게 할 수 있다
 *
 * 해결방법:
 *
 * 시간복잡도: O(k*n^2*4*n^2)
 * 공간복잡도: O(n^2)
 *
 */
class Fireball{
    int r;
    int c;
    int m;
    int s;
    int d;

    public Fireball(int r, int c, int m, int s, int d) {
        this.r = r;
        this.c = c;
        this.m = m;
        this.s = s;
        this.d = d;
    }
}

public class Main {

    static List<Fireball> fireballs;
    static List<Fireball>[][] count;
    static int n;
    static int m;
    static int k;
    static int[] dy = {-1,-1,0,1,1,1,0,-1};
    static int[] dx = {0,1,1,1,0,-1,-1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        fireballs = new ArrayList<>();
        count = new List[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[i][j] = new LinkedList<>();
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int nm = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireballs.add(new Fireball(r-1, c-1, nm, s, d));
        }

        for (int i = 0; i < k; i++) {
            moveBalls();
            unionBalls();
        }

        int ans = 0;
        for (Fireball fireball : fireballs) {
            ans += fireball.m;
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void unionBalls() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(count[i][j].size() < 2) {
                    count[i][j].clear();
                    continue;
                }
                int sumS = 0;
                int sumM = 0;
                int oddCount = 0;
                int evenCount = 0;
                int size = count[i][j].size();
                for (Fireball fireball : count[i][j]) {
                    sumS += fireball.s;
                    sumM += fireball.m;
                    if(fireball.d % 2 == 1){
                        oddCount++;
                    }else{
                        evenCount++;
                    }
                    fireballs.remove(fireball);
                }
                count[i][j].clear();
                sumM /= 5;
                if(sumM == 0){
                    continue;
                }
                sumS /= size;

                if(oddCount == size || evenCount == size){
                    for (int l = 0; l < 4; l++) {
                        fireballs.add(new Fireball(i,j, sumM,
                                sumS, 2*l));
                    }
                }else{
                    for (int l = 0; l < 4; l++) {
                        fireballs.add(new Fireball(i,j, sumM,
                                sumS, 1+2*l));
                    }
                }
            }
        }


    }

    private static void moveBalls() {
        for (Fireball fireball : fireballs) {
            int ny = (fireball.r + n +dy[fireball.d]*(fireball.s%n)) % n;
            int nx = (fireball.c + n +dx[fireball.d]*(fireball.s%n)) % n;
            fireball.r = ny;
            fireball.c = nx;
            count[ny][nx].add(fireball);
        }
    }

}
