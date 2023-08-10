import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 풀이 방법: Map을 활용하여 풀었습니다.
 * 접근 방법: pair 형태로 주어진 것을 보고 Map을 사용하여 한쪽을 key로 한쪽을 value로 활용하면 되겠다고 생각했습니다.
 * 변수 선언:
 * int N = 입력 받을 사이트 주소의 수
 * int M = 찾으려는 사이트 주소의 수
 * Map<String, String> pwd = key:사이트, password:비밀번호
 * finder = 찾으려는 사이트 주소
 *
 * 풀이 과정:
 * 1. Map에 key와 value 쌍으로 값을 받습니다
 * 2. finder에 찾으려는 사이트 주소를 받고 해당 주소를 활용하여 키값으로 해당 값을 찾습니다 -> 이때 반드시 이미 저장된 사이트 주소가 입력된다고 문제에 나와있으므로, 따로 없을때를 생각할 필요가 없다
 *
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, String > pwd = new HashMap<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            pwd.put(st.nextToken(), st.nextToken());
        }

        String finder;

        for(int i=0; i<M; i++){
            finder = br.readLine();
            bw.write(pwd.get(finder) + "\n");
        }
        br.close();
        bw.close();


    }
}
