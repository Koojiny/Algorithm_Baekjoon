import java.util.*;

class Solution {
    public static int[] solution(int[] answers) {
        int[] answer;
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] cnt = new int[3];
        for (int i = 0; i < answers.length; i++) { // for문 돌면서 전체 문제에 대한 정답수 체크
            if (answers[i] == one[i % 5]) cnt[0]++;
            if (answers[i] == two[i % 8]) cnt[1]++;
            if (answers[i] == three[i % 10]) cnt[2]++;
        }

        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));

        ArrayList<Integer> list = new ArrayList<>();
        if (max == cnt[0]) list.add(1);
        if (max == cnt[1]) list.add(2);
        if (max == cnt[2]) list.add(3);

        answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}