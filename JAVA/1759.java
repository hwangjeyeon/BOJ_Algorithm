import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1-1. 일단 모음과 자음을 분리해서 리스트에 저장하자 -> 그냥 하나에 넣자
 * 1-2. 위 방법 말고 그냥 하나의 리스트에 넣고 오름차순 정렬을 해주자
 *
 * 2. 재귀
 * 2-1. 함수식 security(주어진 문자열 리스트, depth, 만들어진 문자열 + 현재 문자열, 시작할 위치)
 * 2-2. base condition depth == L -> 현재 문자열에 모음이 한개이상 있는지, 자음이 두개이상 있는지 함수를 통해 체크해주자
 * -> 만약 이 조건을 만족하면 StringBuilder에 넣어주고 종료하고, 아니면 그냥 종료한다
 * 2-3. 재귀식 security(depth+1, 만들어진 문자열 + 현재문자열, i+1)
 *
 * 3. 시작할 위치를 옆으로 계속 밀어서 중복을 제거하도록 백트래킹해준다.
 * 4. 위 재귀식을 통해 완성된 StringBuilder를 출력하면 정답이 된다.
 * 
 * - 문제 해결:
 *
 *
 *
 * 시간복잡도: O(ClogL)
 * 공간복잡도: O(ClogL)
 *
 */


public class Main {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<String> code = new ArrayList<>();
        for (int i = 0; i < C; i++) {
            String input = st.nextToken();
            code.add(input);
        }
        Collections.sort(code);
        security(code, L, 0, "", 0);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static void security(List<String> code, int size, int depth, String total, int start) {
        if(depth == size){
            if(moOk(total, size) && zaOk(total, size)){
                sb.append(total).append("\n");
            }
            return;
        }

        for (int i = start; i < code.size(); i++) {
               security(code, size, depth+1, total + code.get(i), i+1);
        }


    }

    private static boolean zaOk(String total, int size) {
        int tmp = 0;
        for (int i = 0; i < size; i++) {
            if(total.charAt(i) != 'a' && total.charAt(i) != 'e' && total.charAt(i) != 'i' && total.charAt(i) != 'o' && total.charAt(i) != 'u'){
                tmp++;
            }
        }

        return tmp >= 2;
    }

    private static boolean moOk(String total, int size) {
        for (int i = 0; i < size; i++) {
            if(total.charAt(i) == 'a' || total.charAt(i) == 'e' || total.charAt(i) == 'i' || total.charAt(i) == 'o' || total.charAt(i) == 'u'){
                return true;
            }
        }

        return false;
    }

}

