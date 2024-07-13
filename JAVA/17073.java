import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. dfs로 리프노드 개수 알아내가지고 w에다가 나눠주면 될듯.
 * 2. dfs 생각할 필요도 없이 그냥 리스트 배열 순회해서 크기가 1인 경우 리프노드로 판단하고 count를 세어주면 된다
 * 3. 이후 double 타입의 ans 변수에다가 w / count결과를 초기화하고 출력하면 정답이 된다.
 *
 * 해결방법:
 * 1. 한가지 주의할 점이 루트 노드의 값은 제외하고 생각해야한다. 따라서 count를 세어줄때, 루트노드인 1번을 제외하고 2번부터 탐색을 시작하여야 한다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */




public class Main {

    private static boolean[] visited;
    private static int count = 0;
    private static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        list = new ArrayList[n+1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }


        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 2; i < n+1; i++) {
            if(list[i].size() == 1){
                count++;
            }
        }


        double ans = (double) w / count;
        bw.write(ans+"");
        
        br.close();
        bw.close();
    }


}

