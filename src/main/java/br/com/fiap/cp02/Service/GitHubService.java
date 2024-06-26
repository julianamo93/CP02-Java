package br.com.fiap.cp02.Service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import br.com.fiap.cp02.Model.User;
import com.google.gson.Gson;

public class GitHubService {

    public static User getUser(String login) throws ClientProtocolException, IOException {

        User user = null;

        HttpGet request = new HttpGet("https://api.github.com/users/" + login);

        try (CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
             CloseableHttpResponse response = httpClient.execute(request)) {

            HttpEntity entity = response.getEntity();

            if (entity != null) {

                String result = EntityUtils.toString(entity);

                Gson gson = new Gson();

                user = gson.fromJson(result, User.class);
            }
        }

        return user;
    }
}






