import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 규칙성:
 * 1. 반복횟수(depth)가 홀수면 2*n-1번 짝수면 2*n번 순회하여 각각 짝수냐 홀수냐에 따라 빈칸과 별을 찍어준다.
 * 2. 재귀함수로는 고정 최대 길이인 n과 depth+1을 통해서 작동시킨다.
 *
 * - 종료 조건:
 * 1. 반복 횟수(depth)가 n보다 커질 떄 종료한다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */



public class Main {
    static StringBuilder sb = new StringBuilder();
    static void star1(int n, int depth){
        if(n < depth){
            return;
        }

        if(depth%2 == 1){
            for (int i = 0; i < 2*n - 1; i++) {
                if(i%2==0){
                    sb.append("*");
                }else{
                    sb.append(" ");
                }
            }
        }else{
            for (int i = 0; i < 2 * n; i++) {
                if(i%2 == 0){
                    sb.append(" ");
                }else{
                    sb.append("*");
                }
            }
        }



        sb.append("\n");
        star1(n, depth+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if(n==1){
            sb.append("*");
        }else{
            star1(n, 1);
        }


        bw.write(sb.toString()+"");

        br.close();
        bw.close();
    }

}

