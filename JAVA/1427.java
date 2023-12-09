import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 입력받은 숫자를 문자열로 받아서 split해서 각각 단어의 문자열배열로 저장한다.
 * - 이후 Arrays.sort(arr, Collections.reverseOrder());를 사용하여 내림차순해준다. 이것을 사용하면 시간복잡도가 O(nlog(n))이기 때문에 시간초과 문제가 없다
 * - 이후 해당 값들을 출력해준다.
 *
 * 시간복잡도: O(nlog(n))
 * 공간복잡도: O(n)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String[] arr = s.split("");

        Arrays.sort(arr, Collections.reverseOrder());
        for(int i=0; i<arr.length; i++){
            bw.write(arr[i]+"");
        }


        br.close();
        bw.close();
    }

}
