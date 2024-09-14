package com.projeto.weatherapp.service;

import com.projeto.weatherapp.model.WeatherData;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class WeatherService {

    private final String apiKey;

    public WeatherService(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Obtém dados climáticos para a cidade fornecida.
     * @param cidade Nome da cidade para obter dados climáticos.
     * @return Dados climáticos em formato JSON como String.
     * @throws IOException Se ocorrer um erro de I/O.
     * @throws InterruptedException Se a operação for interrompida.
     */
    public String getDadosClimaticos(String cidade) throws IOException, InterruptedException {
        String formataNomeCidade = URLEncoder.encode(cidade, StandardCharsets.UTF_8);
        String apiUrl = "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + formataNomeCidade;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();
        
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        return response.body();
    }

    /**
     * Imprime os dados climáticos fornecidos.
     * @param 
     */
    public void imprimirDadosClimaticos(String dados) {
        JSONObject dadosJson = new JSONObject(dados);
        JSONObject informacoesMetereologicas = dadosJson.getJSONObject("current");
        
        // Extrai os dados da localização
        String cidade = dadosJson.getJSONObject("location").getString("name");
        String pais = dadosJson.getJSONObject("location").getString("country");
        
        // Extrai os dados adicionais
        String condicaoTempo = informacoesMetereologicas.getJSONObject("condition").getString("text");
        int umidade = informacoesMetereologicas.getInt("humidity");
        float velocidadeVento = informacoesMetereologicas.getFloat("wind_kph");
        float pressaoAtmosferica = informacoesMetereologicas.getFloat("pressure_mb");
        float sensacaoTermica = informacoesMetereologicas.getFloat("feelslike_c");
        float temperaturaAtual = informacoesMetereologicas.getFloat("temp_c");
        
        // Extrai data e hora da String retornada pela API
        String dataHoraString = informacoesMetereologicas.getString("last_updated");
        
        // Imprime as informações atuais
        System.out.println("Informações Meteorológicas para " + cidade + ", " + pais);
        System.out.println("Data e Hora:  " + dataHoraString);
        System.out.println("Temperatura Atual: " + temperaturaAtual + " °C");
        System.out.println("Sensação Térmica: " + sensacaoTermica + " °C");
        System.out.println("Condição do Tempo: " + condicaoTempo);
        System.out.println("Umidade: " + umidade + "%");
        System.out.println("Velocidade do Vento: " + velocidadeVento + " Km/h");
        System.out.println("Pressão Atmosférica: " + pressaoAtmosferica + " mb");
    }
}
