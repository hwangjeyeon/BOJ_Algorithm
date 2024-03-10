import java.io.*;
import java.math.BigInteger;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민 및 풀이:
 * 1. 우선순위 큐를 사용해서 정렬할 것이다
 * 2. 문자열을 입력 받고 해당 문자열을 길이만큼 순회하는데 만약 순회하는 문자가 숫자면 숫자가 아닐때까지 tmp 문자열에 넣는다.
 * 3. 2번을 진행할 때 이중 포문으로 진행한다 입력 길이가 짧아서 충분히 가능하다
 * 4. while문을 돌때 현재 문자가 숫자면 j++를 해주는데 이때, j+1이 문자 길이보다 작고, 숫자가 일 경우만 j++를 해준다
 * 5. tmp 문자열의 길이가 1이 아니고, 0으로 시작한다면 0이 아닐때까지 맨 앞 문자를 제거해서 저장한다.
 * 6. 이후 Integer 형으로 파싱해서 pq에 넣어주고 순회 종료후 다시 우선순위 큐를 순회해서 출력한다.
 *
 * - 문제 해결:
 * 1. 제출후, numberFormat 에러가 발생하였다. 무엇이 문제인가 했더니 최대 입력되는 문자 길이가 100인데 이게 모두 숫자라면 충분히 int나 long형의 범위를 벗어나게 된다
 * 2. 따라서 BigInteger를 사용하였고 우선순위 큐 대신 리스트로 받아서 넣은 뒤, 정렬 후 출력하였다
 * 3. 해당 문제 정리할 때, BigInteger에 대한 공부와 정리도 같이 진행할 예정이다.
 *
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<BigInteger> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            String tmp;
            for (int j = 0; j < input.length(); j++) {
                tmp = "";
                while(input.charAt(j) - '0' >= 0 && input.charAt(j) - '0' <= 9){
                    tmp += (char)input.charAt(j);

                    if(j+1 < input.length() && input.charAt(j) - '0' >= 0 && input.charAt(j) - '0' <= 9){
                        j++;
                    }else{
                        break;
                    }
                }
                int now = 0;
                while(tmp.length() > 1 && tmp.startsWith("0")){
                    tmp = tmp.substring(now+1);
                }

                if(!tmp.isEmpty()){
                    list.add(new BigInteger(tmp));
                }
            }

        }

        Collections.sort(list);

        for (BigInteger bigInteger : list) {
            bw.write(bigInteger+"\n");
        }

        br.close();
        bw.close();
    }

}

