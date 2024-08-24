import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 백트래킹이자 순열 문제인데, 문제는 n!이 20!이 될 수 있어서 해당 방법으로 못 풀 것처럼 보인다
 * 2. 다행히도 n!이긴 하나 제한을 10만으로 두어서 상관없이 백트래킹으로 해당 문제를 풀 수 있따
 * 3. 중복 제거와 정렬을 위해 TreeSet을 하나 선언하여 값들을 관리한다
 * 4. 백트래킹으로 처음에는 문자열을 이어나가는 방법을 선택했으나 메모리 초과가 발생하였다
 * 5. 메모리 초과의 원인은 입력 문자열 만큼 방문 체크 배열을 선언했기 떄문이다
 * 6. 재귀함수가 실행되면서 배열의 길이만큼 커지다보니 메모리초과가 발생했던 것이었다
 * 5. 따라서 다음 방법으로 입력받은 문자열을 26개의 알파벳 배열로 만들어서 개수를 세어주는 방식으로 바꿨다
 * 6. 탐색하는 현재의 인덱스 위치에 -'a'을 하여서 문자열을 붙여나가는 식으로 바꿨고 set에 있는 값들을 출력하니 정답이 되었다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n*20!)
 * 공간복잡도: O(n!)
 *
 */



public class Main {
    static int[] alpha;
    static Set<String> set;
    static char[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            arr = br.readLine().toCharArray();
            alpha = new int[26];
            for (int j = 0; j < arr.length; j++) {
                alpha[arr[j] - 'a']++;
            }

            set = new TreeSet<>();
            backtracking(arr.length, 0, "");
            for (String s : set) {
                bw.write(s+"\n");
            }
        }


        br.close();
        bw.close();
    }

    private static void backtracking(int length, int depth, String s) {
        if(depth == length){
            set.add(s);
            return;
        }


        for (int i = 0; i < 26; i++) {
            if(alpha[i] > 0){
                alpha[i]--;
                backtracking(length, depth+1, s+((char)(i+'a')));
                alpha[i]++;
            }
        }
    }
}

