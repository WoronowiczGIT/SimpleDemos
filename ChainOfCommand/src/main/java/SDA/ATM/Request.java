package SDA.ATM;

public class Request {
    private Integer money;

    Request(Integer money){
        this.money = money;
    }
    public Integer getMoney() {
        return money;
    }
    public void setMoney(Integer money) {
        this.money = money;
    }
}
