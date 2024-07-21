import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 기본적인 유니온 파인드를 이용하는 문제다
 * 2. 처음 find 값은 기준값에 놓고 continue 한다
 * 3. 이후 pivot과 find 값을 비교하여 다르다면 pivot에 find 값을 갱신해주고 count를 증가시킨다
 * 4. 순회 종료 후에 count를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(Alpha(n))
 * 공간복잡도: O(n)
 *
 */

public class Main {

    private static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y){
            return;
        }

        if(x <= y){
            parent[y] = x;
        }else{
            parent[x] = y;
        }

    }

    private static int find(int x){
        if(x == parent[x]){
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }


    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }

        st = new StringTokenizer(br.readLine());
        int count = 0;
        int pivot = 0;
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(i == 0){
                pivot = find(tmp);
                continue;
            }

            if(pivot != find(tmp)){
                count++;
                pivot = find(tmp);
            }
        }
        bw.write(count+"");

        br.close();
        bw.close();
    }

}

