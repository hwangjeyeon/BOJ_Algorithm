import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 *
 * - 문제 해결:
 * 1. 입력값이 작다는 것에서 눈치를 챘어야 했다. 이문제는 백트래킹을 이용하는 문제다
 * 2. depth가 k와 같아질때까지 반복한다
 * 3. 카드 번호가 담겨있는 배열을 순회하면서 파라미터의 문자열에 해당 숫자를 넣는 방식으로 진행하면 된다
 * 4. 단 중복을 막기 위해 중복 배열을 선언해주고, 백트래킹 종료 후에는 원상복귀시켜둔다
 * 5. set을 추가로 활용해야한다. 중복된 문자가 만들어질 수도 있기 때문이다. 
 * 6. base condition에 도달하면 set에 해당 문자열을 넣는다
 * 7. 완성된 set의 크기를 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    static Set<String> set = new HashSet<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        card(arr,k, 0, "");
        bw.write(set.size()+"");

        br.close();
        bw.close();
    }

    private static void card(int[] arr,int k, int depth, String s) {
        if(k == depth){
            set.add(s);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                card(arr,k,depth+1, s + arr[i]);
                visited[i] = false;
            }
        }


    }
}

