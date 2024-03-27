import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 앞전에 풀었던 유레카 이론과 비슷하게 그냥 3중포문을 돌면된다
 * 2. 단 각각의 수에서 어디까지를 범위로할까에 대한 고민이 있는데 n/a 식으로 그 몫까지만 돌아주면 된다.
 * 3. 그리고 0부터 시작해야한다... 해당 방을 안쓸 수도 있기 떄문이다.
 * 
 * - 문제 해결:
 * 
 *
 *
 * 시간복잡도: O(n/a * n/b * n/c)
 * 공간복잡도: O(1)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        boolean isOk = false;
        for (int i = 0; i <= n / a; i++) {
            for (int j = 0; j <= n / b; j++) {
                for (int k = 0; k <= n / c; k++) {
                    if((a*i) + (b*j) + (c*k) == n){
                        isOk = true;
                    }
                }
            }
        }
        if(isOk){
            bw.write("1");
        }else{
            bw.write("0");
        }


        br.close();
        bw.close();
    }

}

