package com.example.numberstrivia;

import retrofit2.Call;

public class NumbersRepository {

    private NumbersApiService numbersApiService = NumbersApi.create();

    public Call<Trivia> getRandomNumberTrivia() {
        return numbersApiService.getRandomNumberTrivia();
    }
}
