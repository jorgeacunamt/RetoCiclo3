package com.usa.ciclo3reto.cicloreto.reports;

import com.usa.ciclo3reto.cicloreto.model.Client;

public class CountClients {

    private Long total;
    private Client client;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public CountClients(Long total, Client client) {
        this.total = total;
        this.client = client;
    }



}
