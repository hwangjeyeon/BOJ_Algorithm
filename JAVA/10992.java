import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 규칙성:
 * 1. n번만큼 줄 수가 출력되고, 각 줄 수는 맨 위에는 n줄로 시작해서 한 칸씩 늘어난다
 * 2. 맨앞 빈칸은 n-1부터 시작해서 0까지 출력한다.
 * 3. 맨앞 빈칸 출력 후, 무조건 별 하나 출력
 * 4. 만약 첫번째 줄이 아닌 경우 3번 실행 후, 빈칸 출력
 * 5. 빈칸 출력은 현재 + 2만큼 늘어나고 이후 별 하나 찍기
 * 6. n을 파라미터로 받아 앞 빈칸의 출력 개수가 0일때, 즉 마지막 출력문에서는 인수로 넘긴 2*n-1만큼 별을 찍고 나머지는 위 로직을 따른다.
 * - 종료 조건:
 * 1. 빈칸이 0보다 작아질 때
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */



public class Main {
    static StringBuilder sb = new StringBuilder();
    static void star1(int count, int blank, int n){
        if(count < 0){
            return;
        }
        if(count == 0){
            for (int i = 0; i < n; i++) {
                sb.append("*");
            }
        }else{
            for (int i = 0; i < count; i++) {
                sb.append(" ");
            }

            sb.append("*");

            if(blank > 0){
                for (int i = 0; i < blank; i++) {
                    sb.append(" ");
                }
                sb.append("*");
            }
        }



        sb.append("\n");
        star1(count-1, blank+2,n);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        star1(n-1, -1, 2*n-1);


        bw.write(sb.toString()+"");

        br.close();
        bw.close();
    }

}

