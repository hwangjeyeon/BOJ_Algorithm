import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 문자열을 변경해야하기 때문에 StringBuilder를 사용하였다.
 * - 이번에는 좌표가 아니라 문자열에서의 분할정복 문제이지만 비슷하게 풀면 된다.
 * - 종료 조건은 문자열의 크기가 1일때로 잡는다.
 * - 파라미터로는 문자열의 크기, 그리고 시작 위치만 넘겨주면 된다
 * - 문자열의 크기를 3등분하여서 newSize로 만들어준다
 * - start + newSize부터 start+newSize+newSize까지는 문자열을 공백으로 해준다.
 * -> 이때 StringBuilder의 setCharAt으로 공백으로 해준다
 * - start와 start+newSize+newSize로 시작하는 부분은 재귀함수를 실행한다.
 * - 이렇게 해서 완성된 최종 StringBuilder kantoa 값을 출력한다.
 * - 이 문제는 명확한 입력 중지조건이 없기 때문에 while((s=br.readLine())!=null)으로 입력 중지조건을 걸어준다.
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(1)
 *
 */



public class Main {
    static StringBuilder kantoa;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        while((s = br.readLine()) != null){
            int n = Integer.parseInt(s);
            kantoa = new StringBuilder();
            for(int i=0; i<(int)Math.pow(3,n); i++){
                kantoa.append("-");
            }

            kantoaCheck((int) Math.pow(3,n), 0);

            bw.write(kantoa+"\n");
        }

        br.close();
        bw.close();
    }

    public static void kantoaCheck(int n, int start){
        if(n == 1){
            return;
        }
        int newSize = n/3;
        blankKantoa(start+newSize+newSize, start + newSize);

        kantoaCheck(newSize, start);
        kantoaCheck(newSize, start + newSize + newSize);
    }

    public static void blankKantoa(int n, int start){
        for(int i=start; i<n; i++){
            kantoa.setCharAt(i, ' ');
        }
    }

}
