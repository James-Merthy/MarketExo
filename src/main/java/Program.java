import entities.Aisle;
import entities.Director;
import entities.Market;
import entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Program {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa");
        EntityManager manager = emf.createEntityManager();

        Product p1 = new Product("1" ,"boutteille" , "coca" , 2.5 );
        Product p2 = new Product("2" ,"boutteille" , "Jack-Dadiels" , 15.70 );
        Product p3 = new Product("3" ,"boutteille" , "Fanta" , 2.5 );
        Product p4 = new Product("4" ,"boutteille" , "Oasis" , 3.5 );
        Product p5 = new Product("5" ,"boutteille" , "Cristaline" , 1.5 );
        Product p6 = new Product("6" ,"boutteille" , "Jameson" , 21.5 );
        Product p7 = new Product("7" ,"boutteille" , "Poliakov" , 11.5 );
        Product p8 = new Product("8" ,"boutteille" , "Havana" , 31.5 );

        List <Product> stock = new ArrayList<>();

        stock.add(p1);
        stock.add(p2);
        stock.add(p3);
        stock.add(p4);
        stock.add(p5);
        stock.add(p6);
        stock.add(p7);
        stock.add(p8);
//
//        for (int i = 0 ; i <= 15 ; i ++){
//
//
//
//        }

        Market market = new Market(1,"Merthy-Prime","Rue du Wheesky" , "SingleMalt-City" , 45);
        Aisle soft = new Aisle(1,"Soft" ,market);
        Aisle alcool = new Aisle(2,"Alcool" ,market);


        Set<Aisle> aisles = new HashSet<>();

        aisles.add(soft);
        aisles.add(alcool);

        Director dirlo = new Director(1,"James" , "Merthy" , 20000 );




        manager.getTransaction().begin();
        stock.forEach(manager::persist);
        manager.persist(dirlo);
        aisles.forEach(manager::persist);
        manager.persist( market );
        manager.getTransaction().commit();


        emf.close();

        System.out.println();

    }
}
