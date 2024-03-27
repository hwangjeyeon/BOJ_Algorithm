import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. String 형 배열에다가 입력값들을 넣고 List에 String형 배열을 넣어서 관리하였다
 * 2. 값을 비교해줄 min과 i와 j를 담을 a와 b를 변수로 선언한다
 * 3. 이어서 n*(n-1)번 순회하면서 추가로 5*7번 순회를 진행한다. 각각을 비교하면서 같지 않은 문자가 있을 경우 count를 증가시킨다.
 * 4. count가 min보다 작으면 해당 min을 count로 바꾸고 a와 b도 i+1과 j+1로 채워준다.
 *
 * - 문제 해결:
 *
 *
 *
 * 시간복잡도: O(n*n*5*7)
 * 공간복잡도: O(n*5*7)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<String[][]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[][] arr = new String[5][7];
            for (int j = 0; j < 5; j++) {
                String[] input = br.readLine().split("");
                for (int k = 0; k < 7; k++) {
                    arr[j][k] = input[k];
                }
            }
            list.add(arr);
        }
        int min = Integer.MAX_VALUE;
        int a= 0;
        int b =0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int count = 0;
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 7; l++) {
                        if(!list.get(i)[k][l].equals(list.get(j)[k][l])){
                            count++;
                        }
                    }
                }
                if(count < min){
                    min = count;
                    a = i+1;
                    b = j+1;
                }
            }
        }

        bw.write(a + " " + b);

        br.close();
        bw.close();
    }

}

