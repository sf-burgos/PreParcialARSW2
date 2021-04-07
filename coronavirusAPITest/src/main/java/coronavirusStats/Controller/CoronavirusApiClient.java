package coronavirusStats.Controller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;

public class CoronavirusApiClient {
    public JSONArray allCases() throws UnirestException {
        //aqui debemos ir al api y copiar lo que nos de el
        HttpResponse<JsonNode> response = Unirest.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/total?country=Canada")
                .header("x-rapidapi-key", "4c6d7133ddmshf268ffdf74ff966p16d861jsn8ca61be9772a")
                .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                .asJson();

        return response.getBody().getObject().getJSONObject("data").getJSONArray("covid19Stats");

    }

    public <country> JSONArray casesByCountry(country String )  throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country=Canada")
                .header("x-rapidapi-key", "4c6d7133ddmshf268ffdf74ff966p16d861jsn8ca61be9772a")
                .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                .asJson();
        return response.getBody().getArray().getJSONObject(0).getJSONArray("latlng");
    }
}
