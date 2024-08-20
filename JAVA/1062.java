import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 해당 문제는 백트래킹으로 풀 수 있는 문제다. 여기에 문자열이 조금 첨가된 문제다
 * 2. 먼저 suffix와 prefix에 대해 문자열 체크를 한다는 것은 알고 있을 것이다 총 5개의 단어를 뽑을 수 있다
 * 3. 처음에는 Set으로 해결하려 했는데, 그러기에는 구현의 한계가 너무 많았다
 * 4. 결국 선택한 방법은 모든 알파뱃에 대한 백트래킹으로 최대로 읽을 수 있는 단어의 개수를 찾는 것이었다
 *
 * - 문제 해결:
 * 1. 각 알파뱃 방문 배열에 대해 true 표시를 하며, 접두사와 접미사를 제외한 중간 단어에 대해서만 배열에 저장한다
 * 2. 이후 백트래킹을 하는데, 알파벳 단어들 중 방문 하지 않는 단어를 추가로 선택하면서 진행한다
 * 3. 접두사 접미사의 개수인 5개에 지금까지 선택한 단어의 개수를 합한 것이 k와 같아졌을 때, 전체 몇개의 단어를 읽을 수 있는지 체크한다
 * 4. 이중포문을 도는데 n개의 문자열을 각각 그 길이만큼 탐색한다. 방문배열로 확인하여 만약 문자열의 그 단어를 읽을 수 없는 경우 read를 false로 체크하고 탈출한다
 * 5. 만약 read가 true라면 count를 증가시킨다
 * 6. 이렇게 완성한 count와 max를 비교하여 더 큰값을 넣어준다. 이렇게 하다보면 어떤 단어를 선택했을 때, 최대치가 나올 것이고, 그 max를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(26Ck * n * |S|)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    static boolean[] visited = new boolean[26];
    static String[] arr;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        visited[0] = true;
        arr = new String[n];
        visited['n'-'a'] = true;
        visited['t'-'a'] = true;
        visited['i'-'a'] = true;
        visited['c'-'a'] = true;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            arr[i] = s.substring(4, s.length()-4);
        }

        backtracking(n,k, 0, 0);

        bw.write(max+"");

        br.close();
        bw.close();
    }

    private static void backtracking(int n, int k, int depth, int sum) {
        if(sum+5 == k){
            int count = 0;
            for (int i = 0; i < n; i++) {
                boolean chk = true;
                for (int j = 0; j < arr[i].length(); j++) {
                    if(!visited[arr[i].charAt(j) - 'a']){
                        chk = false;
                        break;
                    }
                }
                if(chk){
                    count++;
                }
            }
            max = Math.max(max, count);
        }

        for (int i = depth; i < 26; i++) {
            if(!visited[i]){
                visited[i] = true;
                backtracking(n,k,i, sum + 1);
                visited[i] = false;
            }
        }

    }

}

