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
 * 6. 5번 조건에서 하나가 추가된다. 홀수일때는 빈칸을 찍고 짝수일 때는 별을 찍는다.
 * - 종료 조건:
 * 1. 빈칸이 0보다 작아질 때
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */



public class Main {
    static StringBuilder sb = new StringBuilder();
    static void star1(int count, int blank){
        if(count < 0){
            return;
        }

        for (int i = 0; i < count; i++) {
            sb.append(" ");
        }

        sb.append("*");

        if(blank > 0){
            for (int i = 0; i < blank; i++) {
                if(i%2==1){
                    sb.append("*");
                }else{
                    sb.append(" ");
                }

            }
            sb.append("*");
        }


        sb.append("\n");
        star1(count-1, blank+2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        star1(n-1, -1);


        bw.write(sb.toString()+"");

        br.close();
        bw.close();
    }

}

