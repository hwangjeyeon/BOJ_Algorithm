import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 풀이 과정:
 * - 이번에는 배열 대신 List를 활용해보았다.
 * - 똑같은 백트래킹 문제이다.
 * - 리스트에서는 배열과 다르게 단순히 input리스트의 값을 추가해주면 된다
 * - 대신 리스트는 해당 인덱스의 값을 재귀함수 종료후에 remove해줘야 한다
 * - 이 문제를 풀기 위해서는 depth 파라미터 외에 start 파라미터를 추가해줘야 한다.
 * - start를 순회의 초기화 값으로 지정해주고, 재귀함수에서 인수로 넘길 때는 start가 아닌 i를 넘겨서 자기 자신도 출력할 수 있게 해준다.
 * - 문제 풀때 자꾸 스택오버플로우와 인덱스 초과가 떠서 고생했었다..
 * - 원인은 종료조건에서 return;을 빼먹어서 발생했던 문제 ㅠㅠ
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */




public class Main {

    static StringBuilder sb;
    static List<Integer> ans;
    static List<Integer> input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        input = new ArrayList<>();
        ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            input.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(input);
        sb = new StringBuilder();
        backTracking(n,m,0,0);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static void backTracking(int n, int m, int start, int depth) {
        if(depth == m){
            for(int i=0; i<m; i++){
                sb.append(ans.get(i))
                        .append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<n; i++){
            ans.add(input.get(i));
            backTracking(n,m, i,depth+1);
            ans.remove(input.get(i));
        }
    }


}
