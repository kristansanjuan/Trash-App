package com.example.imageclassifier;

import retrofit2.Call;
import retrofit2.http.GET;

public interface VersionAPI {
    @GET("version.json")  // This should be the correct path to your version file on GitHub
    Call<VersionResponse> getVersion();
}
