package model;

public class FormBean {

    private String name;
    private java.util.Date date;
    private java.lang.Integer number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public java.lang.Integer getNumber() {
        return number;
    }

    public void setNumber(java.lang.Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "FormBean [name=" + name + ", date=" + date + ", number="
                + number + "]";
    }

}
