package com.projeto.weatherapp;

import com.projeto.weatherapp.service.WeatherService;
import com.projeto.weatherapp.util.ApiKeyLoader;

import java.io.IOException;
import java.util.Scanner;

public class WeatherApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome da cidade: ");
        String cidade = scanner.nextLine(); 
        
        try {
            // Carregar chave da API
            String apiKey = ApiKeyLoader.loadApiKey();
            
            // Criar instância do serviço
            WeatherService weatherService = new WeatherService(apiKey);
            String dadosClimaticos = weatherService.getDadosClimaticos(cidade); // retorna um JSON
            
            // Código 1006 significa que a localização não foi encontrada
            if (dadosClimaticos.contains("\"code\":1006")) {
                System.out.println("Localização não encontrada. Por favor, tente novamente.");
            } else {
                weatherService.imprimirDadosClimaticos(dadosClimaticos);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
