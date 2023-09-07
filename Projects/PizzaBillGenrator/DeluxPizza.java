public class DeluxPizza extends PizzaBillingSystem{
    @Override
    public void addextracheez() {
    //    super.addextracheez();
    }

    @Override
    public void addextratoppins() {
      //  super.addextratoppins();
    }

    @Override
    public void takeaway() {
        super.takeaway();
    }

    DeluxPizza(Boolean veg) {
        super(veg);
        super.addextracheez();
        super.addextratoppins();
    }
}
