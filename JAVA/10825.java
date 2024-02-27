import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 처음에는 Map으로 구현해야겠다고 생각하였다.
 * - 그래서 name을 key로 하고 그 안에 과목 점수를 가지고 있는 리스트로 해야겠다고 접근하고 구현하였다.
 * - 하지만 접근 단계에서 다시 문제를 보고 생각을 해보니, 같은 리스트 내에서 정렬은 되지만 다른 리스트와의 정렬은 되지 않는 다는 문제를 발견하였다.
 * - 따라서 이 문제 접근 방법은 틀렸고, 결국 힌트를 참고해서 풀었다.
 * - 이 문제의 자바 풀이는 클래스를 만들고 각 요소를 필드로 하면 쉽게 풀리는 문제였다.
 * - 각 클래스 요소를 배열에 담아주고, Arrays.sort로 람다식으로 구현해서 조건에 맞게 해주면 되는 문제였다.
 * - 참고로 4번때문에 과목점수만이 아닌 이름도 필드로 넣어줘야한다. 문자열 비교는 compareTo로 해주면 된다.
 * - 이후 출력하면 정답이 된다
 * - 같은 리스트 내에서 정렬이라면 Map을 사용하고 리스트를 값으로 하면 되지만, 다른 리스트와 비교를 해야한다면 클래스로 만들어서 접근하는 방법도 생각해보자!
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */
class Student {
    String name;
    int korean;
    int english;
    int math;

    public Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            students[i] = new Student(st.nextToken(),Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(students, (o1, o2) -> {
            if(o1.korean != o2.korean){
                return o2.korean - o1.korean;
            }else{
                if(o1.english != o2.english){
                    return o1.english - o2.english;
                }else{
                    if(o1.math != o2.math){
                        return o2.math - o1.math;
                    }else{
                        return o1.name.compareTo(o2.name);
                    }
                }
            }
        });

        for(Student s : students){
            bw.write(s.name+"\n");
        }

        br.close();
        bw.close();
    }

}

