

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 *
 * - 문제 해결:
 * 1. 문제 이해에 시간을 많이 쏟았던 문제이다.
 * 2. 공항이 폐쇄된다는 것은 앞으로의 입력이 더 있더라도 현재 입력된 비행기가 들어가려는 게이트나 차선책 게이트에 들어갈 수 없다면 종료된다
 * 3. 차선책 게이트는 현재 게이트 - 1으로 하며, 0이 되면 종료된다.
 * 4. 일단 그리디하게 입력이 들어온 비행기는 그 숫자에 해당하는 게이트로 간다. 
 * 5. 자신의 숫자에 해당하는 게이트에 먼저 넣어주는 것을 시작으로 만약 넣을 수 없다면, 차선책 게이트를 살펴본다
 * 6. 차선책 게이트에 넣을 수 있다면, 넣어주고, 차선책 게이트의 차선책 게이트로 다음 차선책 게이트를 지정한다
 * 7. 해당 관점으로 봤을 때, 이 문제는 유니온 파인드를 떠올릴 수 있다.
 * 8. 예를 들어 3번을 지정했을 때, 3번이 차서 2번을 지정한다면, 유니온 파인드로 묶었을 때, 다음 3번이 들어올 경우 자동으로 2번으로 가지게 된다
 * 9. 해당 논리를 통해 풀면 문제를 쉽게 풀 수 있다
 * 10. 반복문을 통해 먼저 prepare에 find한 arr[i]를 넣어준다
 * 11. 만약 prepare이 0이라면 종료되어야 하므로 break하고 아닌 경우 count++해준다
 * 12. 이어서 union(prepare, prepare-1)을 진행해준다
 * 13. 이렇게 완성한 ans를 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */

public class Main {

    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        int[] arr = new int[p];
        for (int i = 0; i < p; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        parent = new int[g+1];
        for (int i = 1; i < g+1; i++) {
            parent[i] = i;
        }

        int ans = 0;
        for (int i = 0; i < p; i++) {
            int prepare = find(arr[i]);
            if(prepare == 0){
                break;
            }

            ans++;
            union(prepare, prepare-1);
        }

        bw.write(ans+"");
        
        br.close();
        bw.close();
    }

    private static int find(int x){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x!= y){
            parent[x] = y;
        }
    }

}

