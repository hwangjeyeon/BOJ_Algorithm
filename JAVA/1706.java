import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. String형으로 배열 좌표를 받는다. 이 문제는 String형 좌표를 사용하는 것이 더 편하다
 * 2. 정답은 리스트로 받는다. 정해지지 않은 크기이고, 정렬을 하기 위해서 리스트를 선택했다
 * 3. 먼저 가로 방향으로 쭉 탐색하는 순회와, 세로 방향으로 쭉 탐색하는 순회를 한다
 * 4. 순회할때, #이 발견되면 append된 StringBuilder를 확인한다. 만약 2보다 작으면 리스트에 넣지 않고 스킵한다
 * 5. 가로방향 혹은 세로 방향으로 탐색 한번이 끝나면 현재 StringBuilder의 길이를 확인해서 1보다 크면 리스트에 넣어준다.
 * 6. 이후 리스트가 완성되면 정렬한 뒤, 맨 앞 값을 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(r*c)
 * 공간복잡도: O(r*c)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        String[][] map = new String[r][c];
        for (int i = 0; i < r; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                map[i][j] = input[j];
            }
        }
        List<String> ans = getStrings(r, c, map);

        Collections.sort(ans);
        bw.write(ans.get(0));

        br.close();
        bw.close();
    }

    private static List<String> getStrings(int r, int c, String[][] map) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < c; j++) {
                if(map[i][j].equals("#")){
                    if(sb.length() > 1){
                        ans.add(sb.toString());
                    }
                    sb = new StringBuilder();
                    continue;
                }
                sb.append(map[i][j]);
            }

            if(sb.length() > 1){
                ans.add(sb.toString());
            }
        }

        for (int i = 0; i < c; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < r; j++) {
                if(map[j][i].equals("#")){
                    if(sb.length() > 1){
                        ans.add(sb.toString());
                    }
                    sb = new StringBuilder();
                    continue;
                }
                sb.append(map[j][i]);
            }
            if(sb.length() > 1){
                ans.add(sb.toString());
            }
        }

        return ans;
    }

}

