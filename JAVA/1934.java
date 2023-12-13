import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 유클리드 호제법을 이용하여 최대공약수를 구하고 이후, 최대공배수를 구하면 된다
 * - 최대 공약수 GCD를 구하는 방법은 다음과 같다
 * - a와 b 두 자연수가 주어졌을 때, a가 b보다 크고 a를 b로 나눈 나머지 즉 a%b를 r이라고 한다
 * - 위 과정을 r이 0이 될때까지 반복하고 0이될 때의 b를 최대공약수라고 한다
 * - r이 0이 아닐때는 a에 b를 넣고, r에 b를 대입한다
 * - 이렇게 구한 최대공약수 GCD를 이용해서 최대공약수를 구할 수 있다
 * - 원래 입력받은 A와 B를 곱한 값에 최대공약수를 나누면, 그 몫이 최소공배수가 된다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int tmpA = a;
            int tmpB = b;
            int gcd = 0;
            if(a>b){
                while(b != 0){
                    int r = a%b;
                    a = b;
                    b = r;
                }
                gcd = a;
            }else{
                while(a != 0){
                    int r = b%a;
                    b = a;
                    a = r;
                }
                gcd = b;
            }

            int lcm = tmpA * tmpB / gcd;
            bw.write(lcm + "\n");
        }


        br.close();
        bw.close();
    }

}
