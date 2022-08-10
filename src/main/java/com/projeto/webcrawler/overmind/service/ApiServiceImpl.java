package com.projeto.webcrawler.overmind.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projeto.webcrawler.overmind.model.Passing;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService{

    @Override
    public List<Passing> getFilmes() throws IOException {

        String url = "https://www.imdb.com/chart/bottom";
        Document doc = Jsoup.connect(url).get();
        Element table = doc.getElementsByClass("chart full-width").first();
        Element tbody = table.getElementsByTag("tbody").first();
        List<Element> players = tbody.getElementsByTag("tr");
        List<Passing> playersObjects = new ArrayList<>();
        for (Element player : players) {
            List<Element> attributes = player.getElementsByTag("td");
            Passing passing = new Passing(
                    attributes.get(1).text(),
                    attributes.get(2).text()

            );
            while (playersObjects.size() <= 9) {
                playersObjects.add(passing);
                break;
            }
        }
        for (Passing passing : playersObjects) {
            converterToJson(passing);
        }
        return playersObjects;
    }

    private static void converterToJson(Passing passing) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(passing);
            System.out.println("Objeto em JSON: " + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
