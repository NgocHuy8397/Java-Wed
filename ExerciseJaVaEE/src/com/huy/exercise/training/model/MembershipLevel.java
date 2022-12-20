package com.huy.exercise.training.model;

public enum MembershipLevel {
    Gold(100, 2),
    Silver(0, 0),
    Platinum(250, 5);
    
    private int point, freeTicket;

    private MembershipLevel(int point, int freeTicket) {
        this.point = point;
        this.freeTicket = freeTicket;
    }

    public int getPoint() {
        return point;
    }

    public int getFreeTicket() {
        return freeTicket;
    }

}

