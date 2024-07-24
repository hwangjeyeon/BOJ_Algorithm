import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 원에 관련된 문제이다.
 * 2. 경우의 수는 다음 4가지가 나올 수 있다. 아예 원이 닿지 않아 0인 경우, 한점이 만나는 경우, 두점이 만나는 경우, 겹쳐서 무한대로 만나는 경우이다.
 * 3. 먼저 무한대로 만나는 경우는 매우 간단하다. 두 좌표와 거리가 같아서 원이 겹치게 그려지면 된다. 이 경우 -1을 출력한다
 * 4. 이어서 한점이 만나는 경우는 한 원에 다른 원이 들어가 내접하거나, 두 점이 외접하는 경우이다
 * 5. 내접하는 경우는 두 좌표의 거리와 두 거리를 뺀 차가 같은 경우이며 외접하는 경우는 두 좌표의 거리와 두 거리를 합한 경우이다
 * 6. 나머지 경우는 모두 두점이 만나는 경우로 생각하면 된다
 * 7. 이때 거리는 Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2))로 구할 수 있다. 하지만 이 경우는 double 타입이 나온다
 * 8. double 타입의 경우 오차 범위가 존재할 수 있다. 제출했을 때도, double 타입으로 거리를 구하면 틀렸다고 하는 것으로 보아, 다르게 생각해주어야한다
 * 9. 그 방법으로 Math.sqrt를 제외하고 거리는 그 안의 두 제곱의 합인 int 타입으로만 생각하고 비교하는 대상에 제곱을 해준다
 * 10. 주어진 조건에 해당하는 값을 출력하면 정답이 된다.
 *
 * 시간복잡도: O(T)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int dist = (int)(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
            if(x1 == x2 && y1 == y2 && r1 == r2) {
                bw.write("-1\n");
            }else if(dist > Math.pow(r1+r2,2) || dist < Math.pow(r1-r2,2)) {
                bw.write("0\n");
            }else if(dist == Math.pow(r1-r2,2) || dist == Math.pow(r1+r2,2)){
                bw.write("1\n");
            }else{
                bw.write("2\n");
            }
        }
        br.close();
        bw.close();
    }
}

