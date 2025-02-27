# JPA e Hibernate
## Dependencias
Como exemplo, usaremos base de datos h2
```xml
<dependencies>
    <!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
    <!-- Se precisa la dependencia de Hibernate y la de la API de Jakarta Persistence -->
    <dependency>
        <groupId>jakarta.persistence</groupId>
        <artifactId>jakarta.persistence-api</artifactId>
        <version>3.1.0</version>
    </dependency><!-- https://mvnrepository.com/artifact/org.hibernate.orm/hibernate-core -->
    <dependency>
        <groupId>org.hibernate.orm</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>6.6.4.Final</version>
    </dependency>

    <!-- https://mvnrepository.com/artifact/com.h2database/h2 -->
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <version>2.3.232</version>
    </dependency>
</dependencies>
```
## Configuracion
Para defininir la configuración y las unidades de persistencia crearemos el archivo:

`resources/META-INF/persistence.xml`

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<persistence xmlns="https://jakarta.ee/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="https://jakarta.ee/xml/ns/persistence https://jakarta.ee/xml/ns/persistence/persistence_3_0.xsd"
             version="3.0">
    <!-- 
    Unidad de persistencia, ven sendo unha conexión a unha bd concreta(jpa-hibernate-h2-estudiantes)
        - Faise referencia a ela medante o name (jpa-hibernate-h2-estudiantes)
        - Dentro definense as entidades xunto con toda a configuración
    -->
    <persistence-unit name="jpa-hibernate-h2-estudiantes">
        <!-- indica as clases que serán parte da bd de esta unidade de persistencia -->
        <class>org.example.ejer2Estudiante.Estudiante</class>
        
        
        <!-- 
        Indica que entidades xestionará a unidade de persistencia
            - true: solo terá en conta as entidades que estan indicadas con <class> nesta unidade
            - false: terá en conta todas as entidades dos paquetes do proxecto, escaneandoas automaticamente
        -->
        <exclude-unlisted-classes>true</exclude-unlisted-classes>

        <properties>
            <property name="jakarta.persistence.jdbc.driver" value="org.h2.Driver" />
            <property name="jakarta.persistence.jdbc.url"    value="jdbc:h2:./db/dbProba" />
            <property name="jakarta.persistence.jdbc.user"   value="" />
            <property name="jakarta.persistence.jdbc.password" value="" />
            <property name="jakarta.persistence.schema-generation.database.action" value="drop-and-create" />

            <property name="hibernate.dialect"    value="org.hibernate.dialect.H2Dialect" />
            <property name="hibernate.show_sql"   value="true" />
            <property name="hibernate.format_sql" value="true" />
        </properties>
    </persistence-unit>
</persistence>
```

# Teoria

## Tipos de generación de id dunha entidad
### Table
Indicar que esto é compatible con todas as bd, polo que é a estratexia mais flexible de todas

Vai crear unha tabla a parte para gardar os ids, se solo se lle indica a strategy sen establececer parametros de `@TableGenerator` todas as entidades compartirán a mesma tabla de ids 
```java
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long idPersona;
```

Podemos definir os atributos que vai ter a taboa usando `@TableGenerator`
```java
@TableGenerator(
        name = "generadorEmpleado",
        table = "ID_GEN",
        pkColumnName = "GEN_KEY",
        valueColumnName = "GEN_VALUE",
        pkColumnValue = "EMP_ID",
        allocationSize = 1)
@Id
@GeneratedValue(strategy = TABLE, generator = "generadorEmpleado")
int id;
```

### Sequence
É algo menos compatible que table, pero é o método mais eficiente.


### Mapeo do id en entidades debiles
Se queremos que unha entidad debil teña o mesmo id que a entidade fuerte da relacion, usaremos mappedBy. 

Por ejemplo, Empleado será a entidad force e Dirección a débil:

```java
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Empleado {
    @Id 
}
```