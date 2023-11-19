import java.io.*;
import java.util.StringTokenizer;


/**
 * 풀이 과정:
 * - 완전수의 약수들을 배열에 저장하고 해당 값들을 나중에 출력한다.
 * - if로 구분해서 완전수인 경우와 아닌 경우의 출력문을 다르게 해준다
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */




public class Main {

//    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == -1){
                break;
            }
            int[] arr = new int[n+1];
            int check = 0;
            int pointer = 0;
            for(int i=1; i<n; i++){
                if(n%i == 0) {
                    arr[pointer++] = i;
                    check += i;
                }
            }
            if(check == n){
                bw.write(n + " = ");
                for(int i=0; i<pointer; i++){
                    if(i != pointer-1){
                        bw.write(arr[i] + " + ");
                    }else{
                        bw.write(arr[i] + "\n");
                    }
                }
            }else{
                bw.write(n + " is NOT perfect.\n");
            }

        }


        br.close();
        bw.close();
    }

}
