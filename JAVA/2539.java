import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 처음에는 2차원 배열을 이용하여 풀려고 했으나, 최대 입력값과 시간 제한을 봤을 때 TLE가 날것 같아 이분탐색으로 생각을 바꿨다
 * - 잘못된 Y와 X좌표값들을 리스트에 저장한다.
 * - 그리고 이분탐색을 위해 두 리스트 모두 오름차순 정렬을 하였다.
 * - 이 이분탐색의 해결책은 색종이의 넓이를 기준으로 진행하면 되는 문제였다
 * - 가릴 수 있는 색종이중 가장 작은 크기가 1이니 left를 1로 하고, row와 column중 더 작은 값이 최대 색종이 크기이므로(밑변에 붙이는 정사각형이기때문에) Math.min()을 통해 right로 선택한다
 * - mid는 (left+right)/2로 하며, 숨길 수 있는지 판단하는 canHide 메소드를 통해 true면 더 작은 값으로 숨길 수 있는지 판단하기 위해 right = mid-1로 한다
 * - 숨길 수 없으면 left = mid+1로 하여, 숨길 수 있는 더 큰 값을 찾는다
 * - 위 과정은 left<=right인 동안 계속한다.
 * - canHide 로직을 구현하는데, Y축은 놀랍게도 밑변에 맞추어 붙인다는 조건 떄문에 이전 Y축의 값을 갱신할 필요가 없다
 * - 따라서 이전 X축의 값만 파악하기 위해 lastX변수를 0으로 초기화 선언해준다
 * - 그리고 주어져 있는 색종이의 개수를 넘어설때도, 숨길 수 없으므로 chk변수를 0으로 초기화 선언해준다
 * - wrongY.size만큼 순회를 한다. 어차피 wrongX도 wrongY와 size가 같으므로 따로 분리해서 두번 해줄 필요도 없고, wrongY가 아니라 wrongX.size만큼 순회해줘도 상관은 없다
 * - 순회할 때마다 현재 y값과 x값을 가져오는 변수를 선언해서 리스트에 초기화해준다
 * - 만약 currentY가 덮을 수 있는 크기인 mid보다 큰 경우는 Y축을 밑변에서 띄울 수는 없으므로 무조건 false를 리턴한다
 * - 이어서 currentX가 0이거나(초기상태) lastX + (mid-1) < currentX인 경우, lastX에 currentX를 넣어주고 사용한 색종이의 개수인 chk를 증가시켜준다
 * - 위 조건은 초기상태는 당연히 덮어줘야 하고, 만약 이전 x축의 좌표를 덮었을 때의 값이 덮었을 때의 넓이인 mid의 커버리지 mid-1보다 현재 x축의 좌표가 더 큰경우 이전 x축에 덮힌 색종이로는 덮을 수 없음을 의미한다
 * - 따라서 다른 색종이로 현재 x축의 좌표를 덮어줘야한다.
 * - 이때 만약 chk가 주어진 색종이의 개수인 count보다 커지는 경우 결국 다 덮지 못하므로 넓이를 크게해야하기 떄문에, false를 리턴한다
 * - 위 false 분기를 모두 헤쳐나오면 true를 리턴한다.
 * - 위 이분탐색 과정을 통해서 나온 결과인 left를 리턴하면 정답이 된다.
 * - 가장 작은 색종이의 크기를 구하는 것이기 때문에 right가 아닌 left를 리턴하면 된다.
 *
 * 시간복잡도: O(logn)
 * 공간복잡도: O(n)
 *
 */





public class Main {


    static List<Integer> wrongYs;
    static List<Integer> wrongXs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());

        int count = Integer.parseInt(br.readLine());
        int wrong = Integer.parseInt(br.readLine());
        wrongYs = new ArrayList<>();
        wrongXs = new ArrayList<>();

        for(int i=0; i<wrong; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            wrongYs.add(y);
            wrongXs.add(x);
        }
        Collections.sort(wrongYs);
        Collections.sort(wrongXs);


        int left = 1;
        int right = Math.min(row,column);
        while(left <= right){
            int mid = (left+right)/2;

            if(canHide(mid, count)){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        bw.write(left+"");
        br.close();
        bw.close();
    }

    static boolean canHide(int mid, int count){
        int lastX = 0;
        int chk = 0;
        for(int i=0; i<wrongYs.size(); i++){
            int currentY = wrongYs.get(i);
            int currentX = wrongXs.get(i);
            if(currentY > mid){
                return false;
            }
            if(lastX == 0 || lastX+(mid-1) < currentX){
                lastX = currentX;
                chk++;
                if(chk > count){
                    return false;
                }
            }
        }
        return true;
    }

}
