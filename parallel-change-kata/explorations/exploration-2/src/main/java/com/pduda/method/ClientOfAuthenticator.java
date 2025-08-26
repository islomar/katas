package com.pduda.method;

public class ClientOfAuthenticator {
    private AuthenticationService authenticationService;

    public static void main(String[] args) {
        new ClientOfAuthenticator(new AuthenticationService()).run();
    }

    public ClientOfAuthenticator(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public void run() {
        boolean authenticated = authenticationService.isAuthenticated(33);
        System.out.println("33 is authenticated = " + authenticated);
    }
}
