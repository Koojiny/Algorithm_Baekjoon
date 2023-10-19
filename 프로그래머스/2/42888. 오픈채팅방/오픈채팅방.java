import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> resultList = new ArrayList<>();
        
        for (int i = 0; i < record.length; i++) {
            String[] line = record[i].split(" ");
            String command = line[0];
            
            switch (command) {
                case "Enter":
                    map.put(line[1], line[2]);
                    resultList.add(line[1] + "/님이 들어왔습니다.");
                    break;
                
                case "Leave":
                    resultList.add(line[1] + "/님이 나갔습니다.");
                    break;
                    
                case "Change":
                    map.put(line[1], line[2]);
                    break;
                    
            }
        }
        // System.out.println(map);
        // System.out.println(resultList);
        
        String[] answer = new String[resultList.size()];
        
        for (int i = 0; i < resultList.size(); i++) {
            String[] curLine = resultList.get(i).split("/");
            String id = curLine[0];
            String other = curLine[1];
            
            answer[i] = map.get(id) + other;
        }
        
        return answer;
    }
}