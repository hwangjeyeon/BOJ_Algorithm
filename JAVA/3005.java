import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 가로로만 세로만큼 탐색하는 순회와 세로로만 가로만큼 탐색하는 순회를 진행한다
 * 2. 각 순회마다 StringBuilder 인스턴스를 만들어준다
 * 3. 순회 도중 #을 만나면 현재 StringBuild의 크기를 확인한다 1보다 크면 List에 넣어주고 새 StringBuilder 인스턴스를 만든 뒤 continue한다
 * 4. 그리고 안쪽 순회가 끝난 뒤에 다시 StringBuilder의 크기를 확인해서 1보다 크면 리스트에 넣어준다 -> #이 그 줄에 없는 경우 발생하는 문제 해결
 * 5. 완성한 리스트를 오름차순 정렬한 뒤 첫번째 값을 출력한다.
 *
 * - 문제 해결:
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
        String[][] field = new String[r][c];
        for (int i = 0; i < r; i++) {
            String[] input = br.readLine().split("");
            System.arraycopy(input, 0, field[i], 0, c);
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < c; j++) {
                if(field[i][j].equals("#")){
                    if(sb.length() > 1){
                        ans.add(sb.toString());
                    }
                    sb = new StringBuilder();
                    continue;
                }
                sb.append(field[i][j]);
            }
            if(sb.length() > 1){
                ans.add(sb.toString());
            }
        }

        for (int i = 0; i < c; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < r; j++) {
                if(field[j][i].equals("#")){
                    if(sb.length() > 1){
                        ans.add(sb.toString());
                    }
                    sb = new StringBuilder();
                    continue;
                }
                sb.append(field[j][i]);
            }
            if(sb.length() > 1){
                ans.add(sb.toString());
            }
        }

        Collections.sort(ans);

        bw.write(ans.get(0));



        br.close();
        bw.close();
    }

}

