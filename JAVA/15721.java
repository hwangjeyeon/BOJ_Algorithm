import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 주어진대로 구현하면 되는 문제다.
 * 2. 정답을 구할때까지 반복하여, 첫 4번째에 대한 예외와 count만큼의 횟수를 반복하여 뻔과 데기의 경우를 나눠서 세어준다
 * 3. count의 초기값은 2로 한다
 * 4. 첫 4번에서 짝수일경우 뻔, 홀수일경우 데기다. 이때, type과 현재 뻔과 데기의 횟수가 t와 같다면 뻔의 개수와 데기의 개수를 더한 값의 -1 한 값에다가 a를 나눈 나머지가 정답이 된다.
 * 5. 왜냐하면 0번째부터 시작하기 때문에 두 개수를 합한 값에서 1을 빼주어야 하며, 사람의 수만큼 다시 첫사람부터 돌아가며 반복되기 때문에 사람의 수로 모듈러 연산을 해야한다
 * 6. 각 순회마다 반복 횟수를 증가시켜준다
 * 7. 이렇게 완성한 결과인 ans를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(2*t)
 * 공간복잡도: O(1)
 *
 */



public class Main {

    static int count = 2;
    static int bbun = 0;
    static int degy = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        int type = Integer.parseInt(br.readLine());

        int ans = solve(a,t,type);


        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static int solve(int a, int t, int type) {
        while(true){
            for (int i = 0; i < 4; i++) {
                if(i%2 == 0){
                    bbun++;
                }else{
                    degy++;
                }
                if(type == 0 && bbun == t){
                    return (bbun + degy-1)%a;
                }
                if(type == 1 && degy == t){
                    return (bbun + degy-1)%a;
                }
            }
            for (int i = 0; i < count; i++) {
                bbun++;
                if(type == 0 && bbun == t){
                    return (bbun + degy-1)%a;
                }
            }
            for (int i = 0; i < count; i++) {
                degy++;
                if(type == 1 && degy == t){
                    return (bbun + degy-1)%a;
                }
            }
            count++;
        }

    }
}

