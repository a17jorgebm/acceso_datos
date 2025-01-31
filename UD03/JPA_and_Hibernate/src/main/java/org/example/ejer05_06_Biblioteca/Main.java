package org.example.ejer05_06_Biblioteca;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.EntityManagerUtil;

import java.util.Calendar;

/***
 * Amplía el ejercicio de la biblioteca para que la entidad Book tenga un identificador generado automáticamente por medio de una tabla.
 *
 * Además:
 *
 *     Crea una enumeración llamada Categoría con los siguientes valores: NOVELA
 *
 * , POESIA, ENSAYO, TEATRO
 *
 * y OTROS.
 *
 * Haz que la entidad Book tenga un atributo de tipo Categoría
 *
 * y que se persista en la base de datos como una cadena. Realiza una conversión de la enumeración a cadena y viceversa de modo que guarde la categoría con el nombre en mayúsculas sólo la primera letra y con acentos.
 *
 * Haz que la columna ISBN sea única, de un tamaño de 13 caracteres y que no pueda ser nula.
 *
 * Crea un atributo de tipo Calendar
 *
 * para la fecha de publicación del libro y haz que se persista en la base de datos como un tipo DATE.
 *
 * Crea un atributo transitorio que sea el número de días que han pasado desde la fecha de publicación hasta la fecha actual. Utiliza la clase java.time.LocalDate
 *
 * para obtener la fecha actual.
 *
 * Crea otro atributo transitorio con el ISBN en versión de 10 dígitos, teniendo en cuenta que el ISBN es un número de 13 dígitos. Para ello, puedes utilizar la clase java.math.BigInteger
 *
 * para realizar la conversión y el siguiente algoritmo:
 *
 *     Elimina los primeros tres dígitos (normalmente 978)
 *     Elimina el último dígito. Ahora tienes nueve dígitos
 *     Ahora necesitas calcular el ‘dígito de control’, que será el décimo dígito de tu ISBN. El objetivo del dígito de control es asegurarse de no haber cometido un error tipográfico: transponer dos dígitos, por ejemplo, o escribir mal uno. Esto es bastante complicado:
 *     Multiplica el primer dígito por 10, el segundo por 9, el tercero por 8 y así sucesivamente, hasta llegar al último dígito (multiplicado por 2).
 *     Ahora tienes una cadena de 9 números nuevos. Agrégalos todos juntos.
 *     Divide esta suma por once. Ahora estás interesado en el resto. Por ejemplo, si la suma fuera 242, que es exactamente 11 x 22, entonces el resto es cero. Si la suma fuera 243, entonces sobraría 1. Tendrás un resto que está entre 0 y 10.
 *     Resta ese resto de 11 para obtener el dígito de control.
 *     Si el resultado es 10, entonces el dígito de control es ‘X’.
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = EntityManagerUtil.getInstance().getEntityManager("dbEjer05_06_book");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Book book = new Book();

        // Configurar las propiedades del objeto
        book.setIsbn("9781234567897"); // Código ISBN (debe ser de 13 dígitos)
        book.setTitle("Aprendiendo Java");
        book.setAuthor("Juan Pérez");
        book.setAno(2023);
        book.setAvailable(true);

        // Portada (imagen representada como un arreglo de bytes)
        byte[] portada = {1, 2, 3, 4, 5}; // Simulación de datos binarios
        book.setPortada(portada);

        // Configurar la categoría (debes asegurarte de que la clase `Categoria` esté definida)
        Categoria categoria = Categoria.NOVELA;
        book.setCategoria(categoria);

        // Fecha de publicación
        Calendar fechaPublicacion = Calendar.getInstance();
        fechaPublicacion.set(2023, Calendar.JANUARY, 10); // Fecha: 10 de enero de 2023
        book.setFechaPublicacion(fechaPublicacion);

        entityManager.persist(book);
        entityManager.getTransaction().commit();


    }
}
