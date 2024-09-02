import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 브루트포스로 풀 수 있는 최대 입력값으로 완전탐색을 선택해서 풀었다
 * 2. 단순 포문으로 풀 수 있을까 생각했는데, 단순 포문으로 푸는 것이 아닌 백트래킹을 이용해서 푸는 문제였다
 * 3. 책에 대한 정보는 클래스로 만들어 묶어서 관리하며, 리스트로 담아 관리하였다
 * 4. 입력한 문자열을 변수로 받아 순회하면서 알파벳 배열에 그 개수를 세어주었다
 * 5. 백트래킹을 돌리는데, 현재 문자열에서의 단어를 개수로 선택하는 경우와 선택하지 않는 경우로 나눠서 그 개수를 추가로 만든 선택된 알파벳 개수 배열에 저장한다
 * 6. 백트래킹 파라미터로 인덱스와 비용 합산을 관리해준다
 * 7. 선택된 경우는 리스트의 현재 인덱스에 해당하는 비용을 인수로 더해주고 아닌 경우는 그냥 넘겨준다
 * 8. base condition은 인덱스가 n이 된 경우다. 이때는 chk 메소드를 통과하는지 테스트해서 통과하는 경우 ans에 더 작은 값을 넣어준다
 * 9. chk 메소드는 알파벳 배열의 길이만큼 순회하면서 만약 알파벳 문자열 배열의 현재 위치의 값이 선택 알파벳 문자열 개수보다 큰경우 false를 리턴하고 모두 통과하면 true를 리턴한다
 * 10. 이렇게 완성된 ans를 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(2^n*Wi*26)
 * 공간복잡도: O(n)
 *
 */
class Pair{
    int cost;
    String name;

    public Pair(int cost, String name) {
        this.cost = cost;
        this.name = name;
    }
}


public class Main {

    static String word;
    static List<Pair> list;
    static int[] alpha = new int[26];
    static int[] counts = new int[26];
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        word = br.readLine();
        for (int i = 0; i < word.length(); i++) {
            alpha[word.charAt(i) - 'A']++;
        }
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String b = st.nextToken();
            list.add(new Pair(a, b));
        }
        backtracking(0,0, n);
        if(ans == Integer.MAX_VALUE){
            bw.write("-1");
        }else{
            bw.write(ans+"");
        }


        br.close();
        bw.close();
    }

    private static void backtracking(int idx, int sum, int n) {
        if(idx == n){
            if (chk()) {
                ans = Math.min(ans, sum);
            }
            return;
        }
        for (int i = 0; i < list.get(idx).name.length(); i++) {
            counts[list.get(idx).name.charAt(i) - 'A']++;
        }
        backtracking(idx+1, sum + list.get(idx).cost, n);
        for (int i = 0; i < list.get(idx).name.length(); i++) {
            counts[list.get(idx).name.charAt(i) - 'A']--;
        }
        backtracking(idx+1, sum, n);
    }

    private static boolean chk() {
        for (int i = 0; i < 26; i++) {
            if(alpha[i] > counts[i]){
                return false;
            }
        }

        return true;
    }
}

