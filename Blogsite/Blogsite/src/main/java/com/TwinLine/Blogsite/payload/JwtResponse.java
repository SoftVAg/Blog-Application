package com.TwinLine.Blogsite.payload;

public class JwtResponse {
    private String token;
    private String username;

    // Private constructor to enforce usage of the builder
    private JwtResponse(Builder builder) {
        this.token = builder.token;
        this.username = builder.username;
    }

    // Getters
    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    // Static inner Builder class
    public static class Builder {
        private String token;
        private String username;

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public JwtResponse build() {
            return new JwtResponse(this);
        }
    }

    // Static method to get a new Builder instance
    public static Builder builder() {
        return new Builder();
    }
}
