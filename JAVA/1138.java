import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 머리풀기용 깡구현 문제
 * - 최대 입력값이 작아서, 다른 알고리즘 사용하기 보다는 그냥 이중 for문으로 쉽게 접근해서 풀면 되겠다고 생각했고 그렇게 구현하였다.
 * - 어떻게 배치 선정해야할까 고민하면서 예제를 확인했는데, 낮은 숫자부터 배치해야지 문제를 해결할 수 있음을 발견하였다.
 * - 배치될 줄의 배열 인덱스에는 각각 가능한 최대 시야를 넣어준다. 맨앞은 어떤 수가 와도 앞에 볼 수 있는 사람이 없기때문에 0이 된다.
 * - 이를 이용해서 가장 낮은 숫자가 원하는 앞에 보이는 사람의 수에 맞는 인덱스에 해당 수를 넣어준다.
 * - 그리고 그 인덱스의 뒤 인덱스부터 가능한 최대 시야의 수를 1씩 감소시킨다. 왜냐하면 가장 작은 수부터 배치를 했기 때문에, 뒤에 오는 수는 그 수보다 크므로 절대 배치한 수의 숫자를 볼 수 없다.
 * - 이를 활용하여, 모든 수를 배치하고 그 배치된 배열을 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 */





public class Main {

    static int[] people;
    static int[] eyesight;
    static int[] lineEyesight;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        people = new int[n];
        eyesight = new int[n];
        lineEyesight = new int[n];
        ans = new int[n];
        for(int i=0; i<n; i++){
            people[i] = i+1;
            lineEyesight[i] = i;
            eyesight[i] = Integer.parseInt(st.nextToken());
        }
        boolean chk = true;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(lineEyesight[j] == -1){
                    continue;
                }
                if(!chk){
                    lineEyesight[j]--;
                }

                if(chk && lineEyesight[j] == eyesight[i]){
                    ans[j] = people[i];
                    chk = false;
                    lineEyesight[j] = -1;
                }
            }
            chk = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            sb.append(i).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

}
