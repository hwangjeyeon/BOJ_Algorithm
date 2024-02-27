import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 종료조건: n이 0이 될때 종료한다
 * - 함수 실행마다 StringBuilder에 n의 크기만큼 별을 넣어준다
 * - 재귀함수는 n-1로 호출해서 0에 도달할 수 있게 해주고, 문제에서 요구하는 줄어드는 별 모양을 만든다
 * - 이번에는 위 재귀함수에 한가지 조건을 추가하기 위해 count라는 파라미터를 하나 더해줬다.
 *  - 문제에서 친절하게 알려주었다. 앞에서 했던 문제에서 n과 count의 상황만 바꾸고, 인수를 count는 0으로 주고 n은 2*n-1로 주면 된다.
 *  
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */



public class Main {
    static StringBuilder sb = new StringBuilder();
    static void star(int n, int count){
        if(n < 0){
            return;
        }

        for (int i = 0; i < count; i++) {
            sb.append(" ");
        }

        for (int i = 0; i < n; i++) {
            sb.append("*");
        }
        sb.append("\n");
        star(n-2, count+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        star(2*n-1,0);

        bw.write(sb.toString()+"");

        br.close();
        bw.close();
    }

}

