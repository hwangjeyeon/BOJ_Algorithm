import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 투포인터 알고리즘을 이용하여 해결하였습니다
 * - 두 포인터의 가리키는 처음값은 1로 한다.
 * - right가 check보다 작을 때까지 반복한다 (check에 g*g를 해가지고 자꾸 시간초과가 발생했었다..) 
 * - now는 right*right - left*left이며 g보다 작으면 right 값을 늘리고 크면 left값을 증가시킨다
 * - 같으면 right 값을 출력하고 right와 count변수의 값을 증가시킨다
 * - 이후 count 값이 0이면 가능한 현재 몸무게가 없으므로 -1을 출력한다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int g = Integer.parseInt(br.readLine());
        int left = 1;
        int right = 1;
        int count = 0;
        int check = 100000;
        while(right < check){
            int now = right*right - left*left;
            if(now < g){
                right++;
            }else if(now > g){
                left++;
            }else{
                bw.write(right + "\n");
                right++;
                count++;
            }
        }

        if(count == 0){
            bw.write("-1");
        }


        br.close();
        bw.close();
    }
}
