package com.example.imageclassifier;

public class VersionResponse {
    private String version;  // Corresponds to "version" in the JSON
    private String url;      // Corresponds to "url" in the JSON

    // Getter for version
    public String getVersion() {
        return version;
    }

    // Setter for version
    public void setVersion(String version) {
        this.version = version;
    }

    // Getter for url
    public String getUrl() {
        return url;
    }

    // Setter for url
    public void setUrl(String url) {
        this.url = url;
    }
}