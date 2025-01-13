# JPA e Hibernate
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