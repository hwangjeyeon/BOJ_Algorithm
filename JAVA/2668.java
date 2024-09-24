import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 첫번째 줄의 수를 출발점, 그 아래줄의 수를 도착지점 인덱스로 잡는다
 * 2. 만약 사이클이 발생한다면, 첫째줄에서 뽑은 값들과 두번째 줄에서 뽑은 값들이 일치한다
 * 3. 이점을 이용하여 모든 지점을 순회하면서 dfs로 사이클이 발생하는지 확인한ㄷ. 
 * 4. 방문체크와 재귀 종료후 체크해제를 통해 중복을 없애고 종료로 이끌어준다
 * 5. 처음 선택되는 값에 대해서도 방문 체크 및 이후 해제를 진행해야 한다. 그래야지 다음 탐색에 영향을 주지 않는다
 * 6. 이 값들중 target과 일치하는 값이 있을 때, 리스트에 넣어준다
 * 7. 완성한 리스트를 오름차순 정렬한 뒤, 크기와 그 값들을 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    static int[] arr;
    static List<Integer> lists;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        visited = new boolean[n+1];
        lists = new ArrayList<>();
        for (int i = 1; i < n+1; i++) {
            visited[i] = true;
            dfs(arr[i], i);
            visited[i] = false;
        }

        Collections.sort(lists);

        bw.write(lists.size() + "\n");
        for (int i = 0; i < lists.size(); i++) {
            bw.write(lists.get(i)+ "\n");
        }

        br.close();
        bw.close();
    }

    private static void dfs(int start, int target) {
        if(!visited[start]){
            visited[start] = true;
            dfs(arr[start], target);
            visited[start] = false;
        }
        if(start == target){
            lists.add(target);
        }

    }
}

