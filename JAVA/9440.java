import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 그리디하게 생각해서 풀려고 했다. 
 * 2. 두 수의 총자리수를 나타내는 변수 두개를 두고 문자열을 더할때마다 그 값을 줄여나간다
 * 3. 홀수일 경우 A에 더 많은 자리수를 부여한다
 * 4. 두 자릿수 변수가 0이 아니면 순회를 계속하는데 pos 변수를 이용해서 문자열에 더해준다
 * 5. countA가 countB보다 크거나 같으면 첫번째 값에 해당 pos의 값을 넣어주고 해당 배열의 값은 -1로 해준다
 * 6. countB도 똑같이 한다
 * 7. pos는 매 순회마다 0으로 초기화하고, 만약 현재 pos가 -1이면 while문으로 아닐때까지 돌려준다
 * 8. 또한 현재 문자열이 비어있는데 pos 위치의 값이 0이면 안되므로 아닐떄까지 똑같이 pos++를 해주고, 또한 -1을때고 똑같이 pos++를 해준다
 * 9. 이런 조건을 만족시켜서 문자열을 각각 완성한 뒤 파싱해서 더해주면 정답이 된다.
 * 
 * 해결방법:
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = "";
        while(!(input = br.readLine()).equals("0")){
            String[] tmp = input.split(" ");
            int n = Integer.parseInt(tmp[0]);
            int countA = 0;
            int countB = 0;
            if(n % 2 == 1){
                countA = n/2 + 1;
            }else{
                countA = n/2;
            }
            countB = n/2;
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(tmp[i+1]);
            }
            Arrays.sort(arr);
            String first = "";
            String second = "";
            int pos = 0;
            while(countA != 0 || countB != 0){

                pos = 0;
                while(arr[pos] == -1){
                    pos++;
                }


                if(countA >= countB){
                    if(first.isEmpty() && arr[pos] == 0){
                        while(arr[pos] == 0 || arr[pos]== -1){
                            pos++;
                        }
                    }
                    first += arr[pos];
                    arr[pos] = -1;
                    countA--;
                }else{
                    if(second.isEmpty() && arr[pos] == 0){
                        while(arr[pos] == 0 || arr[pos]== -1){
                            pos++;
                        }
                    }
                    second += arr[pos];
                    arr[pos] = -1;
                    countB--;
                }

            }

            bw.write(Integer.parseInt(first) + Integer.parseInt(second) + "\n");
        }




        br.close();
        bw.close();
    }
}

