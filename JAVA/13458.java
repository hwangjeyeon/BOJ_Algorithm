import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 최대 입력수를 보았을 때, 정답은 long 타입을 사용해야한다
 * - 리스트별로 순회하면서 b만큼 빼주고 ans의 값은 증가시킨다
 * - 이후 현재 남은 학생 수가 0보다 작거나 같으면 continue해주고 아니면 c로 나눈 몫만큼을 ans에 더해준다
 * - 이후 c만큼 나눈 나머지를 현재 남은 학생수에 넣어주고, 0이 아니면 ans의 값을 1증가시킨다
 * - 이렇게 완성된 ans를 출력한다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */





public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> people = new ArrayList<>();
        while(st.hasMoreTokens()){
            people.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long ans = 0;
        for(int i=0; i< n; i++){
            int currentPerson = people.get(i);
            ans += 1;
            currentPerson -= b;
            if(currentPerson <= 0){
                continue;
            }
            ans += currentPerson / c;
            currentPerson %= c;
            if(currentPerson != 0){
                ans += 1;
            }
        }

        bw.write(ans + "");

        br.close();
        bw.close();
    }

}
