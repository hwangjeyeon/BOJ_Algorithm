import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. LCA(최소 공통 조상)을 이용하는 문제이다
 * 2. 해당 알고리즘에 대한 정리와 구현은 이후 재풀이를 통해 진행할 계획이다
 * 3. 먼저 입력받은 A와 B를 부모 변수에 각각 넣어준다
 * 4. 두 부모의 수가 같이 않을 동안 두 수를 비교하여 더 큰 쪽의 부모값을 넣어준다
 * 5. 트리에서 해당 노드의 부모 노드 수는 2로 나눈 몫이다.
 *
 * 시간복잡도: O(logn)
 * 공간복잡도: O(1)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int parentA = a;
            int parentB = b;
            while(parentA != parentB){
                if(parentA > parentB){
                    parentA /= 2;
                }else{
                    parentB /= 2;
                }

            }
            bw.write(parentA * 10 + "\n");
        }


        br.close();
        bw.close();
    }

}

