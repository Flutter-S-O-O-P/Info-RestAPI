package com.ohgiraffers.restapi;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class TestDTO {

    private int no;

    @NotNull(message = "아이디는 반드시 입력 되어야 함.")
    @NotBlank(message = "아이디에 공백 포함xxxx ")
    private String version;
    private String date;
    @NotNull(message = "이름은 반드시 입력되어야 합니다.")
    @Size(min = 2,message = "이름은 2글자 이상 입력해야 합니다.")
    private String teamName;


    // @Past 현재 날짜 보다 미래를 선택 못하게 검증 하는 부분
    @Past
    private Date enrollDate;

    public TestDTO() {}

    public TestDTO(int no, String version, String date, String teamName, Date enrollDate) {
        this.no = no;
        this.version = version;
        this.date = date;
        this.teamName = teamName;
        this.enrollDate = enrollDate;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    @Override
    public String toString() {
        return "TestDTO{" +
                "no=" + no +
                ", version='" + version + '\'' +
                ", date='" + date + '\'' +
                ", teamName='" + teamName + '\'' +
                ", enrollDate=" + enrollDate +
                '}';
    }
}
