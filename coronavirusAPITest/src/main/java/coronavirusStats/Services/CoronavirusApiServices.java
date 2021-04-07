package coronavirusStats.Services;

import com.mashape.unirest.http.exceptions.UnirestException;
import coronavirusStats.Controller.CoronavirusApiClient;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;

public class CoronavirusApiServices {

    @Autowired
    private CoronavirusApiClient client;

    public String allCases() throws UnirestException{
        JSONArray data = client.allCases();
        return data.toString();

    }

    public String casesByCountry(String country) throws UnirestException{
        JSONArray data = client.casesByCountry(country);
        return data.toString();

    }
}
