import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 단절선은 모두 YES
 * 2. 단절점은 루트 노드와 리프 노드를 제외하고 모두 yes
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(nlogn)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if(t == 1){
                if(list.get(k).size() == 1){
                    bw.write("no\n");
                }else{
                    bw.write("yes\n");
                }
            }else{
                bw.write("yes\n");
            }
        }



        br.close();
        bw.close();
    }

}

