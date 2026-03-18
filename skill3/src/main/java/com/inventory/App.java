import org.hibernate.Session;

public class App {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        // STEP 1: Insert additional records
        session.beginTransaction();

        session.persist(new Product("Laptop","Electronics",55000,10));
        session.persist(new Product("Mouse","Electronics",500,50));
        session.persist(new Product("Keyboard","Electronics",2000,20));
        session.persist(new Product("Monitor","Electronics",15000,8));
        session.persist(new Product("Chair","Furniture",7000,5));
        session.persist(new Product("Table","Furniture",12000,4));

        session.getTransaction().commit();


        // TASK 4 – Sort by price ASC
        session.beginTransaction();

Query<Product> q1 = session.createQuery(
        "FROM Product ORDER BY price ASC", Product.class);

List<Product> list1 = q1.getResultList();

for(Product p : list1){
    System.out.println(p.getName()+" "+p.getPrice());
}

session.getTransaction().commit();
Query<Product> q2 = session.createQuery(
        "FROM Product ORDER BY price DESC", Product.class);

List<Product> list2 = q2.getResultList();

for(Product p : list2){
    System.out.println(p.getName()+" "+p.getPrice());
}

        // TASK 4 – Sort by price DESC


        // TASK 5 – Sort by quantity highest first

Query<Product> q3 = session.createQuery(
        "FROM Product ORDER BY quantity DESC", Product.class);

List<Product> list3 = q3.getResultList();

for(Product p : list3){
    System.out.println(p.getName()+" "+p.getQuantity());
}
        // TASK 6 – Pagination
Query<Product> q4 = session.createQuery(
        "FROM Product", Product.class);

q4.setFirstResult(0);
q4.setMaxResults(3);

List<Product> page1 = q4.getResultList();

for(Product p : page1){
    System.out.println(p.getName());
}
Query<Product> q5 = session.createQuery(
        "FROM Product", Product.class);

q5.setFirstResult(3);
q5.setMaxResults(3);

List<Product> page2 = q5.getResultList();

for(Product p : page2){
    System.out.println(p.getName());
}

        // TASK 7 – Aggregate functions

Query<Long> countQuery =
        session.createQuery("SELECT COUNT(*) FROM Product", Long.class);

System.out.println("Total products: "+countQuery.uniqueResult());
Query<Long> countAvailable =
        session.createQuery(
        "SELECT COUNT(*) FROM Product WHERE quantity > 0", Long.class);

System.out.println("Available products: "+countAvailable.uniqueResult());
Query<Object[]> groupCount =
        session.createQuery(
        "SELECT description, COUNT(*) FROM Product GROUP BY description");

List<Object[]> result = groupCount.getResultList();

for(Object[] row : result){
    System.out.println(row[0]+" "+row[1]);
}Query<Object[]> priceRange =
        session.createQuery(
        "SELECT MIN(price), MAX(price) FROM Product");

Object[] range = priceRange.uniqueResult();

System.out.println("Min price: "+range[0]);
System.out.println("Max price: "+range[1]);
        // TASK 8 – GROUP BY
Query<Object[]> groupQuery =
        session.createQuery(
        "SELECT description, COUNT(*) FROM Product GROUP BY description");

List<Object[]> groupList = groupQuery.getResultList();

for(Object[] row : groupList){
    System.out.println(row[0]+" "+row[1]);
}

        // TASK 9 – Price range filter

Query<Product> rangeQuery =
        session.createQuery(
        "FROM Product WHERE price BETWEEN 1000 AND 20000", Product.class);

List<Product> rangeList = rangeQuery.getResultList();

for(Product p : rangeList){
    System.out.println(p.getName()+" "+p.getPrice());
}
        // TASK 10 – LIKE queries

Query<Product> like1 =
session.createQuery("FROM Product WHERE name LIKE 'L%'", Product.class);
    }
}