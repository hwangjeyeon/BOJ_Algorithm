import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 미리 세명의 찍기 방식을 배열에 저장한다
 * 2. 각각의 맞은 개수를 배열로 관리한다. 순회하면서 체크해서 0~2인덱스의 값을 증가시킨다
 * 3. 가장 큰 값을 순회를 통해 구하고 출력한다
 * 4. 다시 순회하면서, 가장 큰값과 같은 개수의 이름을 출력하면 정답이다.
 *
 *
 * - 문제 해결:
 *
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split("");

        String[] sang = {"A","B","C"};
        String[] chang = {"B","A","B","C"};
        String[] hyun = {"C","C","A","A","B","B"};

        int[] count = new int[3];

        for (int i = 0; i < n; i++) {
            if(sang[i%3].equals(input[i])){
                count[0]++;
            }
            if(chang[i%4].equals(input[i])){
                count[1]++;
            }
            if(hyun[i%6].equals(input[i])){
                count[2]++;
            }
        }
        int max = 0;
        for (int i = 0; i < 3; i++) {
            max = Math.max(max, count[i]);
        }
        bw.write(max+"\n");
        for (int i = 0; i < 3; i++) {
            if(count[i] == max){
                if(i == 0){
                    bw.write("Adrian\n");
                }else if(i==1){
                    bw.write("Bruno\n");
                }else{
                    bw.write("Goran\n");
                }
            }
        }

        br.close();
        bw.close();
    }

}

