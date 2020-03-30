

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println("iesi odata undeva");
        Product nou = new Product();
        nou.setProdusId(4);
        nou.setName("fourth");
       // nou.delete();
        nou.insert();
        Product select = new Product();
        select = nou.select(nou.getProdusId());
        //System.out.println(select.getProdusId()+select.getName()+" ");
        //System.out.println(select.toString());

        //nou.delete();


    }


}
