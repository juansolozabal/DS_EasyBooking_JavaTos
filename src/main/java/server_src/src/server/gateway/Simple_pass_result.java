package src.server.gateway;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class Simple_pass_result implements M_Printable
{
    private String content;
    private JSONParser parser;

    public Simple_pass_result(String content) throws ParseException {

        // We need to parse the input as data is coming from python
        this.parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(content);
        this.content = (String) json.get("Password");
    }

    public String getContent()
    {
        return content;
    }

    public void setResult(String content)
    {
        this.content = content;
    }

    public long getContentNumber()
    {
    	System.out.println("Password: " + content);
        return Long.parseLong(content);
    }

    @Override
    public void print() {
        System.out.println("Content of Simple_pass_result class is: " + this.content);
    }
}
