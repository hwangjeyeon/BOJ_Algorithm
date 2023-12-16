import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 일단 분모끼리 곱하고, 분자에도 상대 분모를 곱해서 분모가 같은 두 분수를 만든다
 * - 최대 공약수로 분모와 분자를 각각 나눠주면 기약분수가 된다
 * - 따라서 최대공약수를 유클리드 호제법을 이용하여 구한다
 * - 구한 최대공약수로 분모와 분자를 나눠서 저장하고 분자 분모 순으로 출력한다.
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aChild = Integer.parseInt(st.nextToken());
        int aParent = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int bChild = Integer.parseInt(st.nextToken());
        int bParent = Integer.parseInt(st.nextToken());

        int ansParent = aParent * bParent;
        int ansChild = aChild * bParent + bChild * aParent;

        int a = Math.max(ansParent, ansChild);
        int b = Math.min(ansParent, ansChild);


        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }

        ansParent /= a;
        ansChild /= a;

        bw.write(ansChild + " " + ansParent);

        br.close();
        bw.close();
    }

}
