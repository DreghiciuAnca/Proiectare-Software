public class Main {

    public static void main(String[] args) {
        Product nou = new Product();
        nou.setName("");
        nou.setProdusId(5);
       // nou.delete();
        nou.insert();
        Product select = new Product();
        select = nou.select(nou.getProdusId());

        //nou.delete();


    }


}
