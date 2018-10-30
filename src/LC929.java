import java.util.HashSet;
import java.util.Set;

/**
 * @Author Yoke
 * @Date 2018/10/28 上午9:50
 */
public class LC929 {

    public int numUniqueEmails(String[] emails) {
        if (emails.length == 0) {
            return 0;
        }
        Set<String> ret = new HashSet<>();
        for (String email : emails) {
            String[] strings = email.split("@");
            String localName = strings[0];
            String domainName = strings[1];
            int index = localName.indexOf("+");
            String newLocalName = localName.substring(0, index);
            StringBuilder builder = new StringBuilder();
            for (char c : newLocalName.toCharArray()) {
                if (c != '.') {
                    builder.append(c);
                }
            }
            builder.append(domainName);
            ret.add(builder.toString());
        }
        return ret.size();
    }
}
