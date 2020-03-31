import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Product {

    private int produsId;

    private String name;

    public int getProdusId() {
        return produsId;
    }
    public void setProdusId(int produsId) {
        this.produsId = produsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        /*if(name.isEmpty()){
            System.out.println("Numele produsului nu poate fi inexistent!");
        }
        else*/
        this.name = name;
    }

    public Product select(int id){
        Connection con = ConnectionFactory.getConnection();
        String stringSel = "SELECT * FROM Product WHERE produsId = ?";

        ResultSet rs = null;
        PreparedStatement findStatement = null;

        Product product = new Product();
        try {
            findStatement = con.prepareStatement(stringSel);
            findStatement.setInt(1, this.produsId);
            rs = findStatement.executeQuery();

            if(rs.next()) {
                product.setName(rs.getString("name"));
                product.setProdusId(rs.getInt("produsId"));
                System.out.println(product.toString());
                return product;
            }
        }
        catch(Exception e){
            System.out.println("EROARE LA SELECTARE");
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(con);
        }
        return null;
    }

    public void insert(){
        Connection con = ConnectionFactory.getConnection();
        String stringIns = "INSERT INTO Product VALUES (?,?)";

        PreparedStatement insertStmt = null;
        try{
            insertStmt = con.prepareStatement(stringIns);
            insertStmt.setInt(1,this.produsId);
            insertStmt.setString(2,this.name);
            insertStmt.execute();
        }
        catch(Exception e){
            System.out.println("EROARE LA INSERARE");
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(insertStmt);
            ConnectionFactory.close(con);
        }
    }


    public void delete(){
        Connection con = ConnectionFactory.getConnection();
        String stringDel = "DELETE FROM Product WHERE produsId = ?";

        PreparedStatement deleteStmt = null;
        try{
            deleteStmt = con.prepareStatement(stringDel, Statement.RETURN_GENERATED_KEYS);
            deleteStmt.setInt(1,this.produsId);
            deleteStmt.execute();
            System.out.println("sters");
        }
        catch(Exception e){
            System.out.println("EROARE LA DELETE");
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(deleteStmt);
            ConnectionFactory.close(con);
        }
    }

    public void update(Product newProduct){
        Connection con = ConnectionFactory.getConnection();
        String stringUpd = "UPDATE Product SET name = ? WHERE id = ?";

        PreparedStatement updateStmt = null;
        try{
            updateStmt = con.prepareStatement(stringUpd, Statement.RETURN_GENERATED_KEYS);
            updateStmt.setString(1, newProduct.getName());

            updateStmt.execute();
        }
        catch(Exception e){
            System.out.println("EROARE LA UPDATE");
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(updateStmt);
            ConnectionFactory.close(con);
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "produsId=" + produsId +
                ", name='" + name + '\'' +
                '}';
    }
}
