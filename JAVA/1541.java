import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. "-"를 기준으로 split해준다. 왜냐하면 그 다음 "-"를 만나기 전까지의 "-" 뒤에 있는 모든 수를 더한 뒤에 빼준 값이 최소가 되기 떄문이다
 * 2. "+"가 있는 경우 해당 값들을 다 더해준 다음에 원래 배열에 넣어준다
 * 3. 또한 문자열이 0으로 시작하는 경우, 해당 0을 제거하는 반복문을 통해 0으로 시작하지 않을 때까지 반복해준다.
 * 4. 이렇게 1,2,3의 모든 과정을 통해 배열에 저장된 값을 모두 빼주는데 첫번째 값은 ans에 넣어주고 그 이후에 있는 값들을 모두 빼준다.
 * 5. 이렇게 한 ans를 출력한다.
 *
 * 시간복잡도: O(n^n)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int ans;
        String[] minus = s.split("-");

        for(int i=0; i<minus.length; i++){
            while(minus[i].startsWith("0")){
                minus[i] = minus[i].substring(1);
            }
            if(minus[i].contains("+")){
                String[] tmp = minus[i].split("\\+");
                int plus = 0;
                for(int j=0; j<tmp.length; j++){
                    plus += Integer.parseInt(tmp[j]);
                }
                minus[i] = String.valueOf(plus);
            }
        }

        ans = Integer.parseInt(minus[0]);
        for(int i=1; i < minus.length; i++){
            ans -= Integer.parseInt(minus[i]);
        }


        bw.write(ans + "");
        br.close();
        bw.close();
    }

}
