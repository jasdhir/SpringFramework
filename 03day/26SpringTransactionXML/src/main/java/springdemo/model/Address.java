package springdemo.model;

public class Address {
    private int id;
    private String addrLine;
    private String city;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAddrLine() {
        return addrLine;
    }
    public void setAddrLine(String addrLine) {
        this.addrLine = addrLine;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
}
