import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 자바 재귀 코드가 주어저서 그것을 활용하면 첫번째 출력 문제는 해결이 된다
 * - 두번째 재귀 호출 회수는 static을 활용하여 함수가 호출될 때마다 count값을 증가시킨 뒤 출력하면 된다.
 * - 재귀 코드를 해석하면 다음과 같다
 * - 처음과 끝의 문자를 비교해서 같지 않으면 펠린드롬이 아니라는 의미의 0을 리턴
 * - 위 방식으로 재귀를 통해서 비교하는 위치가 왼쪽이 오른쪽보다 크거나 작아질때까지 반복하며, 만일 크거나 작아질때까지 다른 수가 나오지 않으면 펠린드롬이라는 의미의 1을 리턴한다
 * - 두 조건을 모두 만족하지 않으면 왼쪽은 1증가 오른쪽은 1감소하는 recursion(s, l+1, r-1)을 통해 재귀 함수를 실행한다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */



public class Main {
    static int count = 0;
    public static int recursion(String s, int l, int r){
        count++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            String s = br.readLine();
            bw.write(isPalindrome(s) + " " + count + "\n");
            count = 0;
        }

        br.close();
        bw.close();
    }
}
