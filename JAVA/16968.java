import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 기본 조합문제이다. 
 * - 첫번째 값은 알파벳인 경우와 숫자인 경우를 분리해서 각각의 최대수를 더해준다
 * - 두번째 값부터는 두번 연속으로 나오지 말아야한다는 조건을 만족시키도록 이전 값의 타입을 체크해준다
 * - 이전 값의 타입이 지금 타입과 같다면 알파벳과 숫자 둘다 전체 개수에서 하나 빼준 값만큼을 곱해준다
 * - 이렇게 타입 배열의 길이만큼 순회해서 완성한 count 값을 출력하면 정답이 된다.
 * 
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] type = br.readLine().toCharArray();
        int count = 0;
        for (int i = 0; i < type.length; i++) {
            if(i == 0){
                if(type[i] == 'c'){
                    count += 26;
                }else{
                    count += 10;
                }
            }else{
                if(type[i] == 'c'){
                    if(type[i-1] == 'c'){
                        count *= 25;
                    }else{
                        count *= 26;
                    }
                }else{
                    if(type[i-1] == 'd'){
                        count *= 9;
                    }else{
                        count *= 10;
                    }
                }
            }

        }

        bw.write(String.valueOf(count));
        

        br.close();
        bw.close();
    }
}

