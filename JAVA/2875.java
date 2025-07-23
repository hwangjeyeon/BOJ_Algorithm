import java.io.*;
import java.util.StringTokenizer;

/**
 * 풀이 과정:
 * 1. 2명의 여학생과 1명의 남학생이 팀을 결성해야한다
 * 2. 현재 여학생이 2명 이상이고 남학생이 1명 이상면 한팀 결성할 수 있다
 * 3. 팀을 결성하면 총 인원에게 3명이 빠지고 또한 k명을 또 빼야한다
 * 4. 총 인원에서 k명을 인턴에 보내고 나머지 인원 중 3명으로 팀을 만들 수 있는지 확인한다
 * 5. 완성한 ans를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int ans = 0;
        while(n >= 2 && m >= 1 && (n + m) - k >= 3){
            ans++;
            n-=2;
            m--;
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }
}
