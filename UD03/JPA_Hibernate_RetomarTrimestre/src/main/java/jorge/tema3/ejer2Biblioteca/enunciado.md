
# 📚 Desarrollo de una Aplicación para una Biblioteca con JPA y Hibernate  

## 🏛️ A) Base de Datos  
La base de datos está formada por dos tablas: `Book` y `Contido`.  

### 📖 Tabla `Book`  
| Columna        | Tipo de Dato        | Descripción |
|---------------|--------------------|------------|
| `idBook`      | `int` (PK)         | Identificador único del libro |
| `isbn`        | `varchar(13)`      | Identificador del libro |
| `titulo`      | `varchar(100)`     | Título del libro |
| `autor`       | `varchar(100)`     | Autor del libro |
| `anho`        | `int`              | Año de publicación |
| `disponible`  | `boolean`          | Indica si el libro está disponible |
| `portada`     | `Blob`             | Portada en formato binario |
| `dataPublicacion` | `Date`        | Fecha de publicación |

#### 🛠️ SQL de creación:
```sql
CREATE TABLE PUBLIC.Book (
    idBook INTEGER NOT NULL AUTO_INCREMENT,
    isbn CHARACTER VARYING(13) NOT NULL,
    titulo CHARACTER VARYING(255) NOT NULL,
    autor CHARACTER VARYING(255),
    anho INTEGER,
    disponible BOOLEAN DEFAULT TRUE,
    portada BINARY LARGE OBJECT,
    dataPublicacion DATE,
    CONSTRAINT BOOK_PK PRIMARY KEY (idBook)
);
CREATE UNIQUE INDEX IdBookPK ON PUBLIC.Book (idBook);
CREATE INDEX IdxBookISBN ON PUBLIC.Book (isbn);
CREATE INDEX IdxBookTitle ON PUBLIC.Book (titulo);
CREATE UNIQUE INDEX PRIMARY_KEY_93 ON PUBLIC.Book (idBook);
```

### 📜 **Tabla `Contido`**

| Columna   | Tipo de Dato  | Descripción                         |
|-----------|--------------|-------------------------------------|
| `idContido` | `int (PK)`   | Identificador único del contenido  |
| `idBook`    | `int (FK)`   | Referencia al `idBook`             |
| `contido`   | `Blob`       | Contenido en formato binario       |


#### 🛠️ SQL de creación:


```sql
CREATE TABLE PUBLIC.Contido (
    idContido INTEGER NOT NULL AUTO_INCREMENT,
    idBook INTEGER NOT NULL,
    contido CHARACTER LARGE OBJECT,
    CONSTRAINT Contido_PK PRIMARY KEY (idContido)
);
CREATE INDEX FK_ID_BOOK_INDEX_9 ON PUBLIC.Contido (idBook);
CREATE UNIQUE INDEX PRIMARY_KEY_9 ON PUBLIC.Contido (idContido);
ALTER TABLE PUBLIC.Contido ADD CONSTRAINT FK_ID_BOOK 
FOREIGN KEY (idBook) REFERENCES PUBLIC.Book(idBook) 
ON DELETE CASCADE ON UPDATE CASCADE;
```
🛠️ Configuración de `persistence.xml`

```xml
<persistence xmlns="https://jakarta.ee/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="https://jakarta.ee/xml/ns/persistence https://jakarta.ee/xml/ns/persistence/persistence_3_0.xsd"
             version="3.0">
    <persistence-unit name="bibliotecaH2" transaction-type="RESOURCE_LOCAL">
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
        <exclude-unlisted-classes>false</exclude-unlisted-classes>
        <properties>
            <property name="jakarta.persistence.jdbc.url" value="jdbc:h2:rutaALaBaseDeDatos;DB_CLOSE_ON_EXIT=TRUE;DATABASE_TO_UPPER=FALSE;FILE_LOCK=NO"/>
            <property name="jakarta.persistence.jdbc.user" value=""/>
            <property name="jakarta.persistence.jdbc.password" value=""/>
            <property name="jakarta.persistence.jdbc.driver" value="org.h2.Driver"/>
            <property name="jakarta.persistence.schema-generation.database.action" value="none"/>
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>
            <property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect"/>
        </properties>
    </persistence-unit>
</persistence>
```
## 🏗️ B) Clase `BibliotecaJpaManager` 
(Patrón Singleton)Implementa el patrón **Singleton**  con **doble comprobación**  y un `Map` para gestionar diferentes `EntityManagerFactory` por unidad de persistencia.

```java
public class BibliotecaJpaManager {
    private static final Map<String, EntityManagerFactory> instancias = new HashMap<>();

    public static EntityManager getEntityManager(String persistenceUnitName) {
        instancias.computeIfAbsent(persistenceUnitName, Persistence::createEntityManagerFactory);
        return instancias.get(persistenceUnitName).createEntityManager();
    }
}
```
## 📖 C) Clase `Book` 
(Entidad JPA)La clase `Book` representa la tabla `Book` en la base de datos y implementa `Serializable`** .

```java
@Entity
@Table(name = "Book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBook;

    @Column(length = 13, nullable = false)
    private String isbn;

    @Column(name = "titulo", nullable = false)
    private String title;

    @Column(name = "autor")
    private String author;

    @Column(name = "anho")
    private Integer year;

    @Column(name = "disponible")
    private Boolean available;

    @Lob
    private byte[] portada;

    @Column(name = "dataPublicacion")
    private LocalDate publicationDate;

    @Transient
    private List<Contido> contenido;
    
    // Constructores, getters, setters y métodos adicionales...
}
```
## 📄 D) Clase `Contido`

```java
@Entity
@Table(name = "Contido")
public class Contido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContido;

    @Lob
    private String contido;

    @ManyToOne
    @JoinColumn(name = "idBook", nullable = false)
    private Book book;
}
```
## 🔄 E) Interface `DAO<T>` (CRUD)

```java
public interface DAO<T> {
    T get(long id);
    List<T> getAll();
    void save(T t);
    void update(T t);
    void delete(T t);
    boolean deleteById(long id);
    List<Integer> getAllIds();
    void updateLOB(T book, String f);
    void updateLOBById(long id, String f);
    void deleteAll();
}
```
## 📚 F) Implementación `BookJPADao`

```java
public class BookJPADao implements DAO<Book> {
    private EntityManager entityManager;

    public BookJPADao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Book get(long id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public List<Book> getAll() {
        return entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    @Override
    public void save(Book book) {
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Book book) {
        entityManager.getTransaction().begin();
        entityManager.merge(book);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Book book) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book));
        entityManager.getTransaction().commit();
    }
}
```
## 🏭 G) `BookDAOFactory`

```java
public class BookDaoFactory {
    public enum TipoDao { JDBC_H2, JPA_H2 }

    public static DAO<Book> getBookDAO(TipoDao tipo, String persistenceUnit) {
        switch (tipo) {
            case JPA_H2:
                return new BookJPADao(BibliotecaJpaManager.getEntityManager(persistenceUnit));
            default:
                return null;
        }
    }
}
```
## 🚀 H) Pruebas con `AppBiblioteca`

```java
DAO<Book> bookDao = BookDaoFactory.getBookDAO(BookDaoFactory.TipoDao.JPA_H2, "bibliotecaH2");
bookDao.save(new Book("9788424937744", "Tractatus Logico-Philosophicus", "Wittgenstein", 2017, false));
```