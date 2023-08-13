import java.io.*;
import java.util.*;

/**
 * 풀이 방법: map을 사용해서 풀었습니다
 * 접근 방법: 문제 입력 유형이 map을 사용하면 쉽게 풀리도록 되어있어서 해당 방법을 통해 풀었습니다.
 * 변수 선언:
 * - Map<Integer, String> dogam1
 * - Map<String, Integer> dogam2
 * - String tmp1 = 입력 값을 담아두고 어떤 형인지 확인하기 위한 변수 
 * 풀이 과정:
 * - 처음에는 하나의 map을 가지고 key값으로 value를 찾고 value로 map을 모두 순회해서 key값을 찾으려 했으나 시간 초과가 발생하였습니다.
 * - 다음 방법으로 key과 value를 바꾼 map을 하나 더 생성해서 map 두개를 활용해서 푸는 방식을 생각해서 풀었습니다
 * 1. try-catch를 이용해서 Integer로 바뀌면 그대로 Integer가 key인 map의 value를 출력합니다
 * 2. 바뀌지 않으면 String이 key인 map의 value를 출력합니다.
 */


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<Integer, String> dogam1 = new HashMap<>();
        Map<String, Integer> dogam2 = new HashMap<>();

        for(int i=0; i<N; i++){
            String tmp = br.readLine();
            dogam1.put(i+1,tmp);
            dogam2.put(tmp,i+1);
        }

        String tmp1;
        for(int i=0; i<M; i++){
            tmp1 = br.readLine();
            try{
                Integer.parseInt(tmp1);
                bw.write(dogam1.get(Integer.parseInt(tmp1))+"\n");
            }catch (NumberFormatException ex){
                bw.write(dogam2.get(tmp1)+"\n");
            }
        }
        br.close();
        bw.close();
    }
}
