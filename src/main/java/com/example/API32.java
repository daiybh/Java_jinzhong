package com.example;

public class API32 {
    private String brakeCode;
    private float brakeStatus;
    private float carDeviceStatus;
    private String videoDeviceCode;
    private float videoDeviceStatus;
    private String comCode;
    private String token;
    private String Sign;

    // Getter Methods

    public String getBrakeCode() {
        return brakeCode;
    }

    public float getBrakeStatus() {
        return brakeStatus;
    }

    public float getCarDeviceStatus() {
        return carDeviceStatus;
    }

    public String getVideoDeviceCode() {
        return videoDeviceCode;
    }

    public float getVideoDeviceStatus() {
        return videoDeviceStatus;
    }

    public String getComCode() {
        return comCode;
    }

    public String getToken() {
        return token;
    }

    public String getSign() {
        return Sign;
    }

    // Setter Methods

    public void setBrakeCode(String brakeCode) {
        this.brakeCode = brakeCode;
    }

    public void setBrakeStatus(float brakeStatus) {
        this.brakeStatus = brakeStatus;
    }

    public void setCarDeviceStatus(float carDeviceStatus) {
        this.carDeviceStatus = carDeviceStatus;
    }

    public void setVideoDeviceCode(String videoDeviceCode) {
        this.videoDeviceCode = videoDeviceCode;
    }

    public void setVideoDeviceStatus(float videoDeviceStatus) {
        this.videoDeviceStatus = videoDeviceStatus;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setSign(String Sign) {
        this.Sign = Sign;
    }
}