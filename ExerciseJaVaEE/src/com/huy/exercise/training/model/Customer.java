package com.huy.exercise.training.model;

public class Customer {
    private int id;
    private String name;
    private String gender;
    private String phoneNumber;
    private String address;
    private MembershipLevel membershipLevel;
    private int point;
    private String email;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public MembershipLevel getMembershipLevel() {
        if (point < membershipLevel.Gold.getPoint()) {
            System.out.println("membershipLevel: " + membershipLevel);
            return membershipLevel.Silver;
        }

        if (point < membershipLevel.Platinum.getPoint()) {
            return membershipLevel.Gold;
        }

        return membershipLevel.Platinum;
    }

    public void setMembershipLevel(MembershipLevel membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    public int getTicketFree() {
        MembershipLevel level = getMembershipLevel();
        return level.getFreeTicket();
    }

}
