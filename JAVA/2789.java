import java.io.*;


/**
 * 풀이 과정:
 * - 문자열 라이브러리를 최대한 활용하여 풀었습니다.
 * - 자바 문자열에 대한 깊이 있는 학습을 해야할 필요가 있다고 느껴, 익숙해지고자 해당 라이브러리를 최대한 찾고 활용하여 풀었습니다.
 * - 앞으로 문자열 문제를 시간이 된다면 추가로 풀 계획이며, 자바 문자열 라이브러리에 대해 익숙해질 때까지 계속 풀 것 같습니다.
 * - 이번에는 contains, substring, replace를 활룡하여 문제를 풀었습니다
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String uni = "CAMBRIDGE";
        for(int i=0; i<uni.length(); i++){
            if(s.contains(uni.substring(i,i+1))){
                s = s.replace(uni.substring(i,i+1),"");
            }
        }
        bw.write(s);
        br.close();
        bw.close();


    }

}
