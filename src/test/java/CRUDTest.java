import org.junit.Test;

public class CRUDTest {

    @Test
    public void TestInsertWhenOk(){
        Product nou = new Product();
        nou.setName("test");
        nou.setProdusId(100);
        nou.insert();
        assert(nou.select(100)!=null);
        nou.delete();
    }

    @Test
    public void TestInsertWhenNameIsNull(){
        Product nou = new Product();
        nou.setName("");
        nou.setProdusId(100);

        nou.insert();
        assert(nou.select(100).getName().isEmpty());
        nou.delete();
    }

    @Test
    public void TestInsertWhenIDIsDuplicate() {
        int id = 1;

        Product nou = new Product();
        nou.setName("Test");
        nou.setProdusId(id);

        assert(nou.select(id)!=null);
    }

}
