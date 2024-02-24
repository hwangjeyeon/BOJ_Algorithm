import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 각 라운드의 경기 순번을 차례대로 내려가다보면 n이 짝수일 경우 n/2 홀수일 경우 n/2+1이 된다
 * - 이를 수학적인 공식으로 나타내면 n/2 + n%2가 된다
 * - 또한 만나지 않는 경우는 절대 없다. 결국 라운드를 거듭하다보면 , 그리고 무조건 이긴다면 결국 만나게 된다. 따라서 -1은 나올 수가 없다.
 * 
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken());
        int im = Integer.parseInt(st.nextToken());
        int round = 0;
        while(kim != im){
            round++;
            kim = kim/2 + kim%2;
            im = im/2 + im%2;
        }
        bw.write(round+"");

        br.close();
        bw.close();
    }

}

