package ohtu;

import com.google.gson.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        String studentNr;
        if (args.length == 0) {
            System.out.print("# > ");
            studentNr = new Scanner(System.in).nextLine();
        } else {
            studentNr = args[0];
        }
        
        String url = "http://ohtustats2017.herokuapp.com/students/" + 
                studentNr + "/submissions";
        
        String responseBody = Request.Get(url).execute().returnContent().asString();
        
        //System.out.println("json data:");
        //System.out.println(responseBody);
        
        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(responseBody, Submission[].class);
        Pattern rgx = Pattern.compile("a(\\d+)\":(true|false|null)");
        String[] su = responseBody.split("\\}");
        for (int i = 0; i < su.length; i++) {
            Matcher m = rgx.matcher(su[i]);
            while (m.find()) {
                if (!m.group(2).equals("null")) {
                    subs[i].addSubmission(m.group(2).equals("true"));
                }
            }
        }
        Course course = mapper.fromJson(
                Request.Get("http://ohtustats2017.herokuapp.com/courses/1.json")
                .execute().returnContent().asString(), Course.class);
        
        System.out.println("Kurssi: " + course.getName() + ", " + course.getTerm() + "\n\nPalautukset " + studentNr + ":\n");
        for (Submission sub : subs) {
            System.out.println(sub);
        }
        System.out.println("\nYhteensä: " + 
                Arrays.stream(subs).mapToInt(s -> s.doneCount()).sum() + 
                " tehtävää " + 
                Arrays.stream(subs).mapToInt(s -> s.getHours()).sum() + 
                " tuntia");
    }
}
