import java.io.*;
import java.util.Arrays;

import static java.lang.Math.round;

/**
 * - 2023.07.28.부로 자바로 코딩테스트 연습 바꿨습니다
 * 풀이 방법: 
 * 1. 값을 long배열에 모두 입력 받습니다 
 * 2. 30% 절사평균계산하여 trm에 넣습니다
 * 3. opn을 오름차순 정렬합니다
 * 4. N이 0이면 0을 출력하면 아니면 양 끝에 해당하는 값을 제외한 부분부터 계산해서 반올림합니다
 * 5. 해당 값을 ans에 int형으로 담아 출력합니다
 * 
 * 기타: 
 * - c++로 하다가 자바로 해보니깐 입출력 방식과 형 지정, 배열 선언 등 다른부분이 많아 시간이 더 걸렸던 것 같습니다
 * - 백엔드 개발자가 되고 스프링으로 개발하다보면 자바를 쓸일이 더 많을 것 같아서 코딩테스트 언어를 바꾸게 되었는데, 첫 코딩테스트를 풀어보면서 바꾸길 잘한 것 같다는 생각이 들었습니다
 * - c++에서 써먹었던 STL을 자바 언어로 잘 바꿔서 쓰고, 자바의 라이브러리도 익히면서 코딩테스트 실력도 키워나갈 계획입니다
 * - 근데 속도나 메모리 비교했을 때, c++이 확실히 더 빠르고 덜 잡아먹어서 좋네요 ㅋㅋ
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long[] opn; //opn == opinion
        opn = new long[N];
        for(int i=0; i<N; i++){
            opn[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        long trm = round(0.15*N);

        Arrays.sort(opn);
        double sum=0;

        if(N == 0){
            bw.write(String.valueOf(N));
            bw.close();
        }else{
            for(long i=trm; i<N-trm; i++){
                sum += opn[(int)i];
            }
            sum = round(sum/(N-2*trm));
            int ans = (int)sum;
            bw.write(String.valueOf(ans));
            bw.close();
        }
    }
}
