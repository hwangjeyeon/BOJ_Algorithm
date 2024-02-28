import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 규칙성:
 * 1. n이 짝수냐 홀수냐에 따라 찍는 방식을 다르게 한다
 * 2. 나머지는 이전 문제와 비슷하게 해주면 된다.
 *
 * - 종료 조건:
 * 1. 반복 횟수(depth)가 2*n보다 커질 떄 종료한다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */



public class Main {
    static StringBuilder sb = new StringBuilder();
    static void star1(int n, int depth){
        if(2*n < depth){
            return;
        }
        if(n%2==0){
            if(depth%2 == 1){
                for (int i = 0; i < n - 1; i++) {
                    if(i%2==0){
                        sb.append("*");
                    }else{
                        sb.append(" ");
                    }
                }
            }else{
                for (int i = 0; i < n; i++) {
                    if(i%2 == 0){
                        sb.append(" ");
                    }else{
                        sb.append("*");
                    }
                }
            }
        }else{
            if(depth%2 == 0){
                for (int i = 0; i < n - 1; i++) {
                    if(i%2==0){
                        sb.append(" ");
                    }else{
                        sb.append("*");
                    }
                }
            }else{
                for (int i = 0; i < n; i++) {
                    if(i%2 == 0){
                        sb.append("*");
                    }else{
                        sb.append(" ");
                    }
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

