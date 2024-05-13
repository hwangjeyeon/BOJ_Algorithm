

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 왼쪽부터 차례대로 확인했을 때, 배수는 자신부터 그 이후로에만 영향이 미치므로 이전 값 반전에 대해 고민할 필요가 없다
 * 2. 따라서 1부터 차례대로 2중 포문을 통해 배수에 해당되는 수들을 모두 반전 시켜준다
 * 3. 이때 현재 수가 "Y"인 경우만 반전을 시켜줌으로써 효율성을 높여주고 count를 세어준다
 * 4. 또한 문자열은 불변이기 때문에 배열로 받아주고 위 과정을 진행하며, 종료 후에는 Y체크를 위해 다시 Arrays.toString을 통해 문자열로 바꿔준다
 * 5. contains를 통해 "Y"가 있는지 체크하고 있으면 -1, 없으면 count를 출력하면 정답이 된다.
 *
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(s.length^2)
 * 공간복잡도: O(s.length)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split("");
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if(s[i].equals("Y")){
                for (int j = 0; j < s.length; j++) {
                    if((j+1) % (i+1) == 0){
                        if(s[j].equals("Y")){
                            s[j] = "N";
                        }else{
                            s[j] = "Y";
                        }
                    }
                }
                count++;
            }
        }
        String tmp = Arrays.toString(s);
        if(tmp.contains("Y")){
            bw.write("-1");
        }else{
            bw.write(count+"");
        }

        br.close();
        bw.close();
    }
}

