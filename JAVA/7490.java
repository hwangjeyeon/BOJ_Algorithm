import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 백트래킹으로 모든 경우의 수를 구한다음 base condition에서 합산식을 구현해서 0인 경우만 리스트에 넣는다.
 * 2. 리스트에 넣는 이유는 정렬해서 출력해야하기 때문이다.
 * 3. 백트래킹 종료 후, 오름차순 정렬한 다음 모든 값을 출력한다. 그러면 정답이 된다.
 * 4. 구현이 조금 어려웠다. 문제를 해결하려면 정규표현식을 써서 +와 -인 경우를 모두 split하도록 한다
 * 5. 그리고 처음값을 sum에다가 초기화한다음 이동 포인터 pos를 1로 초기화한다
 * 6. 그리고 원본 문자열을 순회하며 +나 -인 경우 split한 배열의 pos위치의 값을 합산하거나 감산한다. 이때 pos를 후위연산자로 증가시킨다
 *
 * 해결방법:
 *
 * 시간복잡도: O(9*3^9*s.length() -> 문자열 최대길이는 9다.)
 * 공간복잡도: O(3^9)
 *
 */

public class Main {
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            backtracking(n, "1", 1);
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                bw.write(list.get(i) + "\n");
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }

    private static void backtracking(int n, String s, int depth) {
        if(n == depth){
            String tmp = s.replaceAll(" ", "");


            String[] a = tmp.split("-|\\+");
            int sum = Integer.parseInt(a[0]);
            int pos = 1;
            for (int i = 1; i < s.length(); i++) {
                if(s.charAt(i) == '+'){
                    sum += Integer.parseInt(a[pos++]);
                }else if(s.charAt(i) == '-'){
                    sum -= Integer.parseInt(a[pos++]);
                }
            }
            if(sum == 0){
                list.add(s);
            }

            return;
        }

        backtracking(n, s + "+" + (depth+1), depth + 1);
        backtracking(n, s + "-" + (depth+1), depth + 1);
        backtracking(n, s + " " + (depth+1), depth + 1);
    }


}
