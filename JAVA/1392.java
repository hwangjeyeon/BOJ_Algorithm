import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 이중포문 돌면서 i+1을 입력받은 악보의 크기만큼 리스트에 넣어준다
 * 2. 질문으로 들어오는 위치의 리스트 값을 출력하면 정답이 된다
 * 
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(n*lyric)
 * 공간복잡도: O(n*lyric)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int lyric = Integer.parseInt(br.readLine());
            for (int j = 0; j < lyric; j++) {
                list.add((i+1));
            }
        }

        for (int i = 0; i < m; i++) {
            int q = Integer.parseInt(br.readLine());
            bw.write(list.get(q)+"\n");
        }

        br.close();
        bw.close();
    }
}

