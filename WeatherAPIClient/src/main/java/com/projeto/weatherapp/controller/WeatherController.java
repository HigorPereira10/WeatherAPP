package com.projeto.weatherapp.controller;

import com.projeto.weatherapp.service.WeatherService;

public class WeatherController {
    private WeatherService weatherService;

    public WeatherController(String apiKey) {
        this.weatherService = new WeatherService(apiKey);
    }

    public void run() {
        
    }
}
