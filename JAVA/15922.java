import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 스위핑을 이용해서 쉽게 풀 수 있는 문제다
 * 2. 먼저 각 지점을 Pair이란 클래스로 만들어서 배열로 관리해준다
 * 3. 원래 정렬해야하는데 이 문제에서 알아서 정렬된 값을 준다고 명시되어 있어서 따라 정렬을 하지는 않는다
 * 4. 처음값을 start와 end에 넣고 1부터 시작해서 n-1까지 순회하자
 * 5. 그림을 그려봤을 때, 두가지 경우를 생각해서 구현하면 된다
 * 6. 탐색하는 현재 값의 시작위치가 누적된 끝값보다 작거나 같으면서 현재 값의 끝위치가 누적된 끝값보다 클때, end를 현재 끝값으로 갱신한다
 * 7. 이어서 위 경우가 아닐 경우 현재 시작 위치가 누적된 끝값인 end보다 크거나 같을경우, 새롭게 start와 end를 갱신해야하므로 end-start를 ans에 더해주고 start와 end를 현재 값으로 갱신한다
 * 8. 이 과정이후 마지막 값에 대해 누적된 값의 선분길이가 계산되지 않을 것이므로 end - start를 ans에 더해주고 ans를 출력하면 정답이 된다
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */
class Pair{
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pairs[i] = new Pair(x,y);
        }
        int start = pairs[0].x;
        int end = pairs[0].y;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(pairs[i].x <= end && pairs[i].y > end){
                end = pairs[i].y;
            }else if(pairs[i].x >= end){
                ans += end - start;
                start = pairs[i].x;
                end = pairs[i].y;
            }
        }
        ans += end - start;

        bw.write(ans+"");


        br.close();
        bw.close();
    }
}

