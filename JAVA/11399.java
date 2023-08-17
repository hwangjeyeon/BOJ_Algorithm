import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 풀이 방법: 그리디 알고리즘으로 풀었습니다
 * 접근 방법: 인출하는데 걸리는 시간이 적은 사람을 먼저 인출하게 하면 된다. -> 이는 오름차순 정렬과 그리디 알고리즘의 방식을 이용하면 쉽게 풀 수 있다
 * 변수 선언: 
 * int[] people = 각 사람마다 걸리는 시간을 담은 배열
 * wait = 현재 사람이 이전 사람이 인출하는데 걸리는 시간 만큼 대기한 시간
 * count = 총 걸리는 시간
 * 풀이 과정:
 * 1. people에 값을 입력받고 오름차순 정렬을 한다
 * 2. count에는 현재 people의 걸리는 시간과 지금까지 걸린 대기시간 wait를 더해준다
 * 3. wait에 현재 people이 걸리는 시간을 더해준다
 * 4. 2~3과정을 people의 크기만큼 반복하고 최종적으로 count를 출력한다
 */


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] people = new int[N];
        int count = 0;
        int wait =0;
        for(int i=0; i<N; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        Arrays.sort(people);
        for(int i=0; i<N; i++){
            count += people[i] + wait;
            wait += people[i];
        }

        bw.write(count+"");
        bw.close();


    }
}
