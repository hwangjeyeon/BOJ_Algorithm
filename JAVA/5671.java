import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 *
 * 문제 해결:
 * 1. n부터 m까지 완전탐색하면 된다
 * 2. 이때 중복되는 숫자가 없게 하기 위해서는 각 숫자를 담고 있는 10의 크기의 배열을 선언하고 현재 i가 0이 아닌동안에 계속 순회하면서 10으로 나눠준 몫이 2인 경우는 그냥 break해주고 아닌 경우 몫을 저장해서 탐색한다
 * 3. 만약 결과가 0이면 중복되는 경우가 없는 것이므로 count를 증가한다.
 *
 *
 * 시간복잡도: O(m-n)
 * 공간복잡도: O(1)
 *
 *
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = "";

        while((input = br.readLine()) != null){
            int count = 0;
            String[] s = input.split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);

            for (int i = n; i <= m; i++) {
                int[] arr = new int[10];
                int tmp = i;
                while(tmp != 0){
                    arr[tmp%10]++;
                    if(arr[tmp%10] == 2){
                        break;
                    }
                    tmp /= 10;
                }
                if(tmp == 0){
                    count++;
                }
            }
            bw.write(count+"\n");
        }

        br.close();
        bw.close();
    }

}
