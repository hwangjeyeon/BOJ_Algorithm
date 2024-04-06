import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 1. 완전탐색으로 가볍게 해결하였다
 * 2. StringBuilder에 각 수를 넣어준다.
 * 3. 두번째 수는 reverse된 수를 넣어준다. 이때 아예 새로운 StringBuilder를 만들어주고 먼저 만든 StringBuilder의 string값을 append한 뒤에 reverse를 해주어야한다 아니면 해당 StringBuilder를 참고하는 꼴이 되어버려서 영향을 주게 된다
 * 4. 만약 두 StringBuilder사이에 같지 않은 수가 있는경우 break 한뒤 isOk를 false로 한다.
 * 5. isOk가 true면 list에 해당 문자열을 넣어준다
 * 6. list가 비어있으면 0을 출력하고 아니면 list의 맨 처음 값을 출력해주면 정답이 된다.
 * 
 *
 * 문제 해결:
 *
 *
 * 시간복잡도: O(T*l^2*문자열길이)
 * 공간복잡도: O(l)
 *
 *
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int l = Integer.parseInt(br.readLine());
            String[] arr = new String[l];
            List<String> list = new ArrayList<>();
            for (int j = 0; j < l; j++) {
                String input = br.readLine();
                arr[j] = input;
            }
            for (int j = 0; j < l; j++) {
                for (int k = 0; k < l; k++) {
                    StringBuilder sb = new StringBuilder(arr[j]);
                    if(j==k){
                        continue;
                    }
                    sb.append(arr[k]);
                    StringBuilder tmp = new StringBuilder();
                    tmp.append(sb.toString());
                    tmp.reverse();
                    boolean isOk = true;
                    for (int a = 0; a < sb.length(); a++) {
                        if(tmp.toString().charAt(a) != sb.toString().charAt(a)){
                            isOk = false;
                            break;
                        }
                    }
                    if(isOk){
                        list.add(sb.toString());
                    }
                }
            }
            if(list.isEmpty()){
                bw.write("0\n");
            }else{
                bw.write(list.get(0) + "\n");
            }
        }

        br.close();
        bw.close();
    }

}
