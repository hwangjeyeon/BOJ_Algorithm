import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 순회를 통해 주어진 조건에 맞는 경우 출력하고 프로세스를 종료한다.
 * 
 * - 처음에는 방정식을 이용한 풀이를 했는데, 코딩을 이용할거면 앞으로 순회를 이용하면 된다는 사실을 기억하자...
 * 
 * 
 * 시간복잡도: O(m^2)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int seed = Integer.parseInt(st.nextToken());
        int x1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());

        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                if(x1 == (i * seed + j) % m && x2 == (i * x1 + j) % m){
                    bw.write(i + " " + j);
                    br.close();
                    bw.close();
                    return;
                }
            }
        }


    }

}

