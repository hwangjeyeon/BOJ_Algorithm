import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 슬라이딩 윈도우 알고리즘을 이용하여 풀었다.
 * - 주어진 문자열을 정해진 윈도우 크기(p)만큼 자르고 검사한 뒤, 한칸씩 옆으로 이동하는 과정에서 발생하는 변화만 잘 반영해주면 풀 수 있는 문제다
 * - 0~p까지 문자열에서 ACTG의 개수를 각각 배열에 저장해준다
 * - 이어서 검사하는데 슬라이딩 윈도우의 가능 횟수만큼 순회한다 0~s-p까지
 * - 이제 각 문자열의 개수가 입력받은 최소 문자열의 개수보다 작으면 ans 값을 증가시키지 않고 모두 같거나 클경우 ans를 증가시킨다
 * - 이어서 슬라이딩 윈도우를 한칸 옆으로 밀어야하니 부분 문자열 맨 앞에 있는 문자의 개수를 줄이고, 이어서 나올 문자의 개수를 증가시킨다
 * - 이것을 반복한뒤 ans를 출력하면 정답이 된다.
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
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        char[] dna = br.readLine().toCharArray();
        int[] dnaNumber = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            dnaNumber[i] = Integer.parseInt(st.nextToken());
        }

        int[] dnaCount = new int[4];
        int ans = 0;
        for (int i = 0; i < p; i++) {
            switch (dna[i]){
                case 'A': dnaCount[0]++;
                    break;
                case 'C': dnaCount[1]++;
                    break;
                case 'G': dnaCount[2]++;
                    break;
                case 'T': dnaCount[3]++;
            }
        }

        for (int i = 0; i <= s - p; i++) {
            for (int j = 0; j < 4; j++) {
                if (dnaCount[j] < dnaNumber[j]){
                    break;
                }
                if (j == 3) {
                    ans++;
                }
            }
            if(s-p == i){
                break;
            }
            switch (dna[i]){
                case 'A': dnaCount[0]--;
                    break;
                case 'C': dnaCount[1]--;
                    break;
                case 'G': dnaCount[2]--;
                    break;
                case 'T': dnaCount[3]--;
            }

            switch (dna[i+p]){
                case 'A': dnaCount[0]++;
                    break;
                case 'C': dnaCount[1]++;
                    break;
                case 'G': dnaCount[2]++;
                    break;
                case 'T': dnaCount[3]++;
            }
        }

        bw.write(String.valueOf(ans));

        br.close();
        bw.close();
    }
}
