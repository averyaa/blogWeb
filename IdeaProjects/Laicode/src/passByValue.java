public class passByValue {
    public void Money(){
        int money = 5;
        PassByValue(money);
        System.out.println(money);
    }

    public void PassByValue(int money){
        money = money - 1;
        return;
    }
}



