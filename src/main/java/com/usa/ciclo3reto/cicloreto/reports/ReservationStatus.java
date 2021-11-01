package com.usa.ciclo3reto.cicloreto.reports;

public class ReservationStatus {

    private Integer completed;
    private Integer cancelled;

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public Integer getCanceled() {
        return cancelled;
    }

    public void setCanceled(Integer cancelled) {
        this.cancelled = cancelled;
    }

    public ReservationStatus(Integer completed, Integer cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }
}
