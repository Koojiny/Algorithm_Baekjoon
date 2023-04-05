class Solution {
    public String solution(String new_id) {
        
        // 1. 대문자 -> 소문자
        new_id = new_id.toLowerCase();
        
        // 2. 모든 문자 제거
        new_id = new_id.replaceAll("[^a-z0-9-_.]",""); // a-z0-9-_. 제외하고 모두 제거
        
        // 3. 마침표 2번 이상 연속 -> 마침표 1개
        new_id = new_id.replaceAll("[.]{2,}", ".");
        
        // 4. 마침표가 처음이나 끝에 있다면 제거
        new_id = new_id.replaceAll("^[.]|[.]$", "");
        
        // 5. 빈 문자열인 경우 "a" 대입
        if (new_id.length() == 0) new_id += "a";
        
        // 6. 길이가 16자 이상이면 첫 15개를 제외한 나머지 문자 모두 제거
        //    제거 후 마침표가 끝에 위치한다면 끝에 위치한 마침표 제거
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("[.]$", "");
        }
        
        // 7. 길이가 2자 이하라면 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 합침
        if (new_id.length() <= 2) {
            while (new_id.length() < 3) new_id += new_id.charAt(new_id.length() - 1);
        }
        
        return new_id;
    }
}