public class Mian {
    public static void main(String[] args) {
        PizzaBillingSystem p=new PizzaBillingSystem(true);
        p.addextratoppins();
        p.addextracheez();p.takeaway();
        p.getbill();

        DeluxPizza d=new DeluxPizza(true);
       d.addextracheez();
        d.getbill();
    }
}
