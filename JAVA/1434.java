import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 주어진 조건에 맞게 if문으로 분기해서 구하면 된다
 * 2. 모든 책을 박스에 넣을 수 있는 경우만 입력으로 주어져서 추가적인 처리 필요없이 현재 박스의 크기가 책의 크기보다 크거나 같으면 넣는다
 * 3. 만약 아니면 다음 박스에 현재 책의 크기를 넣어준다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] box = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }
        int[] book = new int[m+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < m+1; i++) {
            book[i] = Integer.parseInt(st.nextToken());
        }
        int pos = 1;
        for (int i = 1; i < m+1; i++) {
            if(box[pos] >= book[i]){
                box[pos] -= book[i];
            }else{
                pos++;
                i--;
            }
        }

        int ans = 0;
        for (int i = 1; i < n+1; i++) {
            ans += box[i];
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }

}

