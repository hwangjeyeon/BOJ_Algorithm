import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 입력값들을 받아서 파싱해서 저장해준다
 * 2. 이어서 이중포문으로 arr[i] * 2 == arr[j] 인 경우 count++하고 break한다
 * 3. 각 입력줄마다 count를 출력하면 된다.
 *
 *
 * - 문제 해결:
 *
 *
 *
 * 시간복잡도: O(arr[i].length)
 * 공간복잡도: O(arr[i].length)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = "";
        while(!(input = br.readLine()).equals("-1")){
            String[] tmp = input.split(" ");
            int[] arr = new int[tmp.length-1];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(tmp[i]);
            }
            Arrays.sort(arr);
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i+1; j < arr.length; j++) {
                    if(arr[i]*2 == arr[j]){
                        count++;
                        break;
                    }
                }
            }
            bw.write(count+"\n");
        }

        br.close();
        bw.close();
    }

}

