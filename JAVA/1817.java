import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. n이 0일때는 추가 입력 없이 그냥 0을 출력한다
 * 2. 0이 아니면 배열에다가 각 책의 무게를 넣어주고 now와 count 변수를 이용해서 탐색을 통해 개수를 세고 출력한다
 *
 *
 * 해결방법:
 * 1. 탑처럼 쌓여있어서 차례대로 박스에 넣어야한다고 했기 때문에 정렬을 하면 안된다!
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if(n > 0){
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int count = 1;
            int now = 0;
            for (int i = 0; i < n; i++) {
                if(now + arr[i] > m){
                    now = arr[i];
                    count++;
                }else{
                    now += arr[i];
                }
            }
            bw.write(count+"");
        }else{


            bw.write("0");
        }





        br.close();
        bw.close();
    }
}

