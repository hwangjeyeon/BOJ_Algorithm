import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 키보드에 있는거 다 map다 넣어야한다. 이건 그냥 복사해서 가져왔다
 * 2. 다음은 map을 활용하면 쉽게 해결할 수 있다. 문자를 key로 하고, 좌표를 값으로 하며, left와 right에 대해서 각각의 map을 만든다
 * 3. 데이터 저장 후, 입력값을 받아 현재 손가락의 위치 문자열 정보를 받는다
 * 4. 이제 문자열을 순회하면서 각 문자열이 어느 map에 들어있는지 보고, 만약 현재 위치와 같지 않다면 이동거리만큼 ans에 넣고 현재 위치도 바꿔준다
 * 5. 이동시간뿐만아니라 누르는 시간 1도 발생하므로 조건 상관없이 ans를 증가시킨다
 * 6. 완성한 ans를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(|s|)
 * 공간복잡도: O(1)
 *
 */

class Pair{
    int y;
    int x;

    public Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Pair> left = new HashMap<>();
        Map<String, Pair> right = new HashMap<>();

        left.put("q", new Pair(0, 0));
        left.put("w", new Pair(0, 1));
        left.put("e", new Pair(0, 2));
        left.put("r", new Pair(0, 3));
        left.put("t", new Pair(0, 4));
        right.put("y", new Pair(0, 5));
        right.put("u", new Pair(0, 6));
        right.put("i", new Pair(0, 7));
        right.put("o", new Pair(0, 8));
        right.put("p", new Pair(0, 9));

        left.put("a", new Pair(1, 0));
        left.put("s", new Pair(1, 1));
        left.put("d", new Pair(1, 2));
        left.put("f", new Pair(1, 3));
        left.put("g", new Pair(1, 4));
        right.put("h", new Pair(1, 5));
        right.put("j", new Pair(1, 6));
        right.put("k", new Pair(1, 7));
        right.put("l", new Pair(1, 8));

        left.put("z", new Pair(2, 0));
        left.put("x", new Pair(2, 1));
        left.put("c", new Pair(2, 2));
        left.put("v", new Pair(2, 3));
        right.put("b", new Pair(2, 4));
        right.put("n", new Pair(2, 5));
        right.put("m", new Pair(2, 6));


        StringTokenizer st = new StringTokenizer(br.readLine());
        String leftNow = st.nextToken();
        String rightNow = st.nextToken();

        String s = br.readLine();
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if(left.containsKey(String.valueOf(s.charAt(i)))){
                if(!leftNow.equals(String.valueOf(s.charAt(i)))){
                    Pair start = left.get(String.valueOf(s.charAt(i)));
                    Pair end = left.get(leftNow);
                    ans += Math.abs(start.x - end.x) + Math.abs(start.y - end.y);
                    leftNow = String.valueOf(s.charAt(i));
                }
                ans++;

            }else if(right.containsKey(String.valueOf(s.charAt(i)))){
                if(!rightNow.equals(String.valueOf(s.charAt(i)))){
                    Pair start = right.get(String.valueOf(s.charAt(i)));
                    Pair end = right.get(rightNow);
                    ans += Math.abs(start.x - end.x) + Math.abs(start.y - end.y);
                    rightNow = String.valueOf(s.charAt(i));
                }
                ans++;
            }
        }


        bw.write(ans+"");

        br.close();
        bw.close();
    }
}

