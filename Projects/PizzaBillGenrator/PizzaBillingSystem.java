public class PizzaBillingSystem {
    private int  price;
    private Boolean veg;
    private int extracheez=100;
    private int extratoppins=150;
    private int backpack=20;
    private int basePizzaprice;
    private boolean isextracheezadded=false;
    private boolean isextratoppinadded=false;
    private boolean isoptedfortakeaway=false;


    PizzaBillingSystem(Boolean veg){
        this.veg=veg;
        if (this.veg){
            this.price=300;
        }
        else {
            this.price=400;
        }
        this.basePizzaprice=this.price;
    }

   public void addextracheez(){
        isextracheezadded=true;
      // System.out.println("Extra Cheez Added");
       this.price+=extracheez;


   }
   public void addextratoppins(){
        isextratoppinadded=true;
      // System.out.println("Extra toppins Added");
       this.price+=extratoppins;

   }
   public void takeaway(){
        isoptedfortakeaway=true;
     //  System.out.println("Take away opted");
       this.price+=backpack;

   }
   public void getbill(){
       String bill="";
       System.out.println("Pizza : "+basePizzaprice);
       if (isextracheezadded){
           bill+="Extra cheese Added: "+extracheez+"\n";
       }
       if (isextratoppinadded){
           bill+="Extra toppins Added: "+extratoppins+"\n";

       }
       if (isoptedfortakeaway){
           bill+="take away Added: "+backpack+"\n";
       }
       bill+="Bill: "+this.price+"\n";
       System.out.println(bill);

   }


}
