package com.usa.ciclo3reto.cicloreto.reports;

public class ReservationStatus {

    private Integer completed;
    private Integer canceled;

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public Integer getCanceled() {
        return canceled;
    }

    public void setCanceled(Integer canceled) {
        this.canceled = canceled;
    }

    public ReservationStatus(Integer completed, Integer canceled) {
        this.completed = completed;
        this.canceled = canceled;
    }
}
