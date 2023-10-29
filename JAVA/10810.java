import java.io.*;
import java.util.StringTokenizer;


/**
 * 풀이 과정:
 * - 우테코 미션, 학술제, 졸업작품때문에 공부할 시간이 안 생기는 중... 학술제라도 끝나면, 스프링 공부 후 남은 시간에 DP부터 공부할 예정..ㅠㅠㅠ 공부하고싶은 알고리즘들 많은데 자꾸 늦어져서 슬픔 ㅠㅠ
 * - 그냥 범위 입력 받고 그 범위 만큼 다시 반복문 사용해서 해당하는 값 채워넣는 쉬운 문제
 *
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n  = Integer.parseInt(st.nextToken());
        int m  = Integer.parseInt(st.nextToken());
        int[] basket = new int[n+1];

        for(int i=1; i<basket.length; i++){
            basket[i] = 0;
        }


        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            for(int j=start; j<=end; j++){
                basket[j] = number;
            }

        }

        for(int i=1; i<basket.length; i++){
            if(i == basket.length-1){
                bw.write(basket[i] + "");
            }else{
                bw.write(basket[i] + " ");
            }

        }


        br.close();
        bw.close();
    }

}
