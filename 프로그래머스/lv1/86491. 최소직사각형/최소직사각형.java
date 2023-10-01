class Solution {
    public int solution(int[][] sizes) {
        // 전체 명함의 가로, 세로 길이 비교하자
        // 이때 가로보다 세로의 길이가 길다면 가로와 세로의 위치를 변경
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }

        int wMax = 0; // 가로 최대 길이
        int hMax = 0; // 세로 최대 길이
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] > wMax) wMax = sizes[i][0];
            if (sizes[i][1] > hMax) hMax = sizes[i][1];
        }

        int answer = wMax * hMax;
        // 가로에서 가장 긴 명함의 길이와 세로에서 가장 긴 명함의 길이를 곱하면 정답
        return answer;
    }
}