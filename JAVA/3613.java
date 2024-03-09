import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민 및 풀이:
 * 1. C++이려면 각 단어의 첫 문자가 소문자고 _로 이어져야 한다. 그리고 모든 문자가 소문자이어야 한다.
 * 2. Java이려면 전체 단어에 먼저 대문자가 있는지 확인하고 첫 단어의 첫문자는 소문자여야한다. 또한 첫 단어를 제외한 단어의 첫 문자는 대문자여야한다. 그 이외의 모든 단어는 소문자여야한다.
 * 3. 1,2번 조건 모두 만족하지 않으면 Error!를 출력한다.
 *
 * - 문제 해결:
 * 1. 자꾸 틀려서 힌트 참고하니까 여러 분기를 다 고려해야하는 문제였다...
 * 2. 내가 빼먹은 조건은 C++쪽이었다. _로 시작하거나 _로 끝나는 경우, 그리고 __가 두번 이어지는 경우 -> split할때 빈칸이 된다 (isEmpty 이용)
 * 3. 해당 조건을 완성하여 해결하였다
 * 
 * - 문자열 문제는 반드시 먼저 풀이를 주석에 작성하고 풀자... 조건 분기가 많은 문제도 마찬가지다
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringBuilder ans = new StringBuilder();
        if(input.contains("_")){
            boolean isC = true;
            if(input.startsWith("_") || input.endsWith("_")){
                isC = false;
            }
            String[] alpha = input.split("_");
            for (int i = 0; i < alpha.length; i++) {
                if(alpha[i].isEmpty()){
                    isC = false;
                    break;
                }
                for (int j = 0; j < alpha[i].length(); j++) {
                    if(alpha[i].charAt(j) - 'A' >= 0 && alpha[i].charAt(j) - 'A' <= 25){
                        isC = false;
                        break;
                    }

                }
                if(!isC){
                    break;
                }else{
                    if(i==0){
                        ans.append(alpha[i].substring(0));
                    }else{
                        ans.append(alpha[i].toUpperCase().charAt(0));
                        ans.append(alpha[i].substring(1));
                    }
                }
            }



            if(isC){
                bw.write(ans.toString());
            }else{
                bw.write("Error!");
            }
        }else{
            boolean isJava = true;
            int now = 0;
            for (int i = 0; i < input.length(); i++) {
                if(i != 0){
                    if(input.charAt(i) - 'A' >= 0 && input.charAt(i) - 'A' <= 25){
                        ans.append(input.substring(now,now+1).toLowerCase());
                        ans.append(input.substring(now+1, i)).append("_");
                        now = i;
                    }
                }else{
                    if(input.charAt(i) - 'A' >= 0 && input.charAt(i) - 'A' <= 25){
                        isJava = false;
                        break;
                    }
                }
            }
            ans.append(input.substring(now,now+1).toLowerCase());
            ans.append(input.substring(now+1, input.length()));

            if(isJava){
                bw.write(ans.toString());
            }else{
                bw.write("Error!");
            }
        }

        br.close();
        bw.close();
    }

}

