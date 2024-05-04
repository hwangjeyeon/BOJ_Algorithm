import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 
 * 해결방법:
 * 1. 비트 비교, 위치 변경 등 문제만보면 복잡할 것 같아 고민되지만 예제를 잘 살펴보면 굉장히 쉽게 풀린다
 * 2. 한쪽을 기준으로 반대편과 비교해서 0일때 1인 경우와 1일 때 0인 경우를 세어줘서 더 큰 경우를 출력하면 정답이 된다
 * 
 * - 너무 급하게 힌트를 봐서 아쉽다... 조금만 더 살펴볼 걸 이라는 후회가 되는 아쉬운 문제. 다시 풀때는 힌트 없이 풀자!
 * - 쉬운 난이도 그리디는 수학적 사고력 + 아이디어로 푸는 유형이 많다. 그림을 그리거나 문제 이해에 집중하고 규칙을 잘 찾아내서 푸는 연습을 하자! 
 * 
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String p1 = st.nextToken();
            String p2 = st.nextToken();

            int count0 = 0;
            int count1 = 0;

            for (int j = 0; j < p1.length(); j++) {
                if(p1.charAt(j) == '0' && p2.charAt(j) == '1'){
                    count0++;
                }else if(p1. charAt(j) == '1' && p2.charAt(j) == '0'){
                    count1++;
                }
            }

            int ans = count0;
            ans = Math.max(ans, count1);
            bw.write(ans+"\n");

        }



        br.close();
        bw.close();
    }
}

