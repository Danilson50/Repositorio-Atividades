package implement.util;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum hibernateUtil {

    INSTANCE;
    private final EntityManagerFactory entityManagerFactory;

    hibernateUtil(){
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("biblioteca");
        }catch (Exception e){
            throw new RuntimeException("Não foi possível efetuar conexão com o banco de dados: " + e.getMessage());
        }
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
