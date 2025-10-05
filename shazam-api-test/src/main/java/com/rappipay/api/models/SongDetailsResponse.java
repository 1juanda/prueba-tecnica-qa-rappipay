package com.rappipay.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

public class SongDetailsResponse {
    private List<Data> data;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        private Attributes attributes;

        public Attributes getAttributes() {
            return attributes;
        }

        public void setAttributes(Attributes attributes) {
            this.attributes = attributes;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Attributes {
        private String name;
        private String artistName;
        private String albumName;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getArtistName() {
            return artistName;
        }

        public void setArtistName(String artistName) {
            this.artistName = artistName;
        }

        public String getAlbumName() {
            return albumName;
        }

        public void setAlbumName(String albumName) {
            this.albumName = albumName;
        }
    }
}
