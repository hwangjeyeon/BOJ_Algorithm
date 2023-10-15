import java.io.*;


/**
 * 풀이 과정:
 * - 3중 반복문을 쓰는 것이 맞나에 대한 고민을 했지만 입력값이 작고, 시간 제한도 2초라서 시간복잡도로 계산해본 결과 문제없어서 3중 for문으로 문제를 풀었다
 * - j를 기준으로 j+1인 k부터 끝까지 오른쪽으로만 비교한다. 오른쪽으로 한번 비교하면 왼쪽 방향으로는 중복으로 비교하는 셈이 되기 때문에 굳이 할 필요가 없어서 한쪽 방향으로만 비교를 하였다.
 * - 일단 기준 문자와 오른쪽에서 비교하는 문자가 같은 경우 다음을 체크해준다
 * 1. 내 옆에 있는지
 * 2. 내 옆에 없지만 그 비교 대상의 양옆에 나랑 같은 문자열이 있고, 그 문자열이 나까지 이어지는지
 *
 * 위 로직을 아래 코드와 같이 구현하였다.
 * 1. tmp에 j를 넣어주고 같은 값이 있으면 k-j가 1일 경우 내 옆에 있다는 것이기 때문에 해당 k를 tmp에 넣어주고 반복한다
 * 2. 만약 1이 아니라면 그것은 내 옆에 없고 그룹 단어가 아니므로 tmp에 -1을 넣고 break를 한다
 * 3. 해당 과정을 통해 j로 반복되는 for 반복문도 break하고 tmp 값 여부에 따라 count의 증가 여부를 판단한다.
 *
 * 위와 같은 과정을 통해 그룹 단어 체커 문제를 풀었다.
 *
 * 시간복잡도: O(n^3)
 * 공간복잡도: O(1)
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i=0; i<N; i++){
            String s = br.readLine();
            int tmp = 0;
            for(int j=0; j<s.length()-1; j++){
                tmp = j;
                for(int k=j+1; k<s.length(); k++){
                    if(s.charAt(j) == s.charAt(k)){
                        if(k-tmp == 0){
                            continue;
                        }else if(k-tmp == 1){
                            tmp = k;
                        }else{
                            tmp = -1;
                            break;
                        }
                    }
                }
                if(tmp == -1){
                    break;
                }
            }

            if(tmp != -1){
                count++;
            }


        }
        bw.write(count + "");
        br.close();
        bw.close();
    }

}
