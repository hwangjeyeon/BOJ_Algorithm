import java.io.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 팰린드롬 여부는 쉽게 구할 수 있으나, 최소거리를 찾는데 어려움을 겪었던 문제다
 * 2. 해결방법은 그냥 숫자를 1씩 더하면서 늘려가는 방법이다
 * 3. 문제는 문자열로 되어있을 때, 앞자리가 0으로 시작하는 경우 파싱할때 모두 사라지기 때문에 자릿수에 맞춰서 0을 먼저 추가해줘야한다
 * 4. 따라서 팰린드롬이 될 떄까지 숫자를 증가하며 그 개수를 세어주고, 다시 증가한 문자열의 숫자로 바꾸기 위해 자릿수 - 현재 숫자의 길이만큼 0을 더해준뒤 증가한 숫자를 문자열에 더하낟
 * 5. 처음부터 팰린드롬이면 0, 아닐 경우 그 개수를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(|S/2 * 9|)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            String s = br.readLine();
            if(s.equals("0")){
                break;
            }

            if(isPalindrome(s)){
                bw.write("0\n");
            }else{
                bw.write(adds(s)+"\n");
            }

        }

        br.close();
        bw.close();
    }

    private static int adds(String s) {
        int count = 0;
        int len = s.length();
        while(!isPalindrome(s)){
            int next = Integer.parseInt(s) + 1;
            count++;
            s = Integer.toString(next);

            if(s.length() < len){
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < len - s.length(); i++) {
                    sb.append("0");
                }
                sb.append(s);
                s = sb.toString();
            }

        }
        return count;
    }

    private static boolean isPalindrome(String num) {
        int left = 0;
        int right = num.length() - 1;
        while(left < right){
            if(num.charAt(left) != num.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}

