package lottoHandler;

import org.json.JSONObject;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class NumberParser {

    public String extractNumbers(String json){
        JSONObject all = new JSONObject(json);
        JSONObject lotto = all.getJSONObject("Lotto");
        String numbers = lotto.getString("numerki");
        return numbers;
    }

    public Set<Integer> parseNumbers(String input) {
        Set<Integer> result = new HashSet<>();
        String[] array = new String[6];
        if (input.contains(",")) {
            array = input.split(",");
        } else if (input.contains("|")) {
            array = input.split("\\|");
        }
        for (String number : array) {
            result.add(Integer.valueOf(number));
        }
        return result;
    }

    public void compare(String c, Set<Integer> result){
        NumberParser np = new NumberParser();
        Set<Integer> current = np.parseNumbers(c);
        Iterator<Integer> iterator = current.iterator();
        while (iterator.hasNext()){
            int n = iterator.next();
            if(result.contains(n)){
                System.out.print(">"+n+"<");
            }else{
                System.out.print(n);
            }
        }
    }



    public static void main(String[] args) {
        NumberParser n = new NumberParser();
        Set<Integer> result = n.parseNumbers("1,2,3,4,5,6,");
        n.compare("1,2,3,7,8,9,",result);

    }


}
