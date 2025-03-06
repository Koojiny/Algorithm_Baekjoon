import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String[]> arr = new ArrayList<>();
        StringTokenizer st;
        
        for (String r : record) {
            st = new StringTokenizer(r);
            String command = st.nextToken();
                        
            if (command.equals("Enter")) {
                String id = st.nextToken();
                String name = st.nextToken();
                if (map.containsKey(id)) {
                    map.put(id, name);
                } else {
                    map.put(id, name);
                }                
                arr.add(new String[]{id, "님이 들어왔습니다."});
            } else if (command.equals("Leave")) {
                String id = st.nextToken();
                arr.add(new String[]{id, "님이 나갔습니다."});
                // map.remove(id);                
            } else if (command.equals("Change")) {
                String id = st.nextToken();
                String name = st.nextToken();
                if (map.containsKey(id)) {
                    map.put(id, name);                    
                }
            }
        }
        
        // System.out.print(map);
        String[] answer = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            String[] cur = arr.get(i);
            String id = cur[0];
            answer[i] = map.get(id) + cur[1];
            // System.out.print(map.get(id) + cur[1] + " ");
        }            
        
        // System.out.print(arr.toString());
        
        
        return answer;
    }
}