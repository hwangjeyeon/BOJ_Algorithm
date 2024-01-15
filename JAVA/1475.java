import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 머리풀기용 깡구현 문제
 * - 각 숫자를 배열에 넣어주고, 입력받은 문자를 순회하여 발견되는 숫자마다 값을 증가 시킨 뒤 마지막에 가장 큰 값을 출력하면 된다
 * - 단 한가지 예외조건이 있으니, 6은 9를 9는 6을 사용할 수 있으므로, 만약 6이 9보다 값이 크다면 9의 값을 증가시키고 continue하며 반대도 똑같이 한다
 * - 이렇게 완성한 max값을 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */





public class Main {

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String n = br.readLine();
        arr = new int[10];

        for(int i=0; i<n.length(); i++){
            String s = String.valueOf(n.charAt(i));
            if(s.equals("6")){
                if(arr[Integer.parseInt(s)] > arr[9]){
                    arr[9]++;
                    continue;
                }
            }
            if(s.equals("9")){
                if(arr[Integer.parseInt(s)] > arr[6]){
                    arr[6]++;
                    continue;
                }
            }
            arr[Integer.parseInt(s)]++;
        }

        int max = arr[0];
        for(int i=1; i<10; i++){
            max = Math.max(arr[i],max);
        }

        bw.write(String.valueOf(max));
        br.close();
        bw.close();
    }

}
