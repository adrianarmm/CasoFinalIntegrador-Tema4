-----------*****CASO FINAL 4*****---------------

Bienvenido a mi aplicacion funcional.
Voy a explicar lo que he ido haciendo hasta llegar al final del proyecto.

Para comenzar segui las normas del trabajo, creando una serie de clases, desde el seguimiento del puntero del raton hasta un editor de texto.
Comence creando los contactos para asi crear una agenda de contactos, cree tambien un validador de email, comparador de archivos y a su vez que cuente la repeticion de palabras dentro de un archivo de la palabra que desee.

Hay dos botones principales, archivo donde se encuentra un block de notas donde puede abrir cualquier archivo de su dispositivo y tambien le permite guardar el archivo que ha creado.
El otro boton es de herramientas donde se despliega todo el menu que mas abajo especificare. 
Y un ultimo boton extra que he añadido que consiste en un modo oscuro.

-----------*****ANALISIS MAS DETALLADO*****-----------------

1. **Declaración de clase**: Ha declarado una clase llamada `MAIN` que extiende `JFrame`. Esto significa que su clase es un tipo de JFrame, que es un contenedor de nivel superior en Swing.

2. **Variables**: Ha declarado varias variables miembro para su clase, incluidos los objetos `JMenuBar`, `JMenu` y `JMenuItem`. Se utilizan para crear la barra de menú y los menús de su aplicación.

3. **Constructor**: En el constructor de tu clase `MAIN`, estás llamando al método `inicializarUI()` para inicializar la interfaz de usuario y al método `mostrarMensajeBienvenida()` para mostrar un mensaje de bienvenida. También está configurando los colores de fondo y primer plano para la barra de menús y los menús.

  
4. **Método inicializarUI()**: Este método se utiliza para configurar la interfaz de usuario de su aplicación. Está configurando el título, el tamaño, la ubicación y la operación de cierre predeterminada para JFrame. También está creando la barra de menú, los menús y los elementos del menú, y agregándolos a la barra de menú. Estás configurando los colores de fondo y primer plano para la barra de menús y los menús, y la fuente para los elementos del menú. También está agregando detectores de acciones a los elementos del menú para realizar ciertas acciones cuando se hace clic en ellos.

5. **Método cargarIcono()**: Este método se utiliza para cargar un icono desde una ruta determinada. Si el icono no se puede cargar, muestra un mensaje de error.

6. **Método realizarBusquedaPalabras()**: Este método se utiliza para realizar una búsqueda de palabras. Abre un cuadro de diálogo de selección de archivos y, si se selecciona un archivo, analiza el texto del archivo para contar la frecuencia de cada palabra. A continuación, los resultados se muestran en un cuadro de diálogo.

7. **Método escalarImagen()**: Este método se utiliza para escalar una imagen al ancho y alto deseados.

8. **Método mostrarMensajeBienvenida()**: Este método se utiliza para mostrar un mensaje de bienvenida en un diálogo.

9. **Métodos abrirSeguimientoRaton() y abrirHerramientaDeDibujo()**: Estos métodos se utilizan para abrir ciertas herramientas cuando se llaman.

10. **Método cambiarAModoOscuro()**: Este método se utiliza para cambiar el color de fondo del panel de contenido a gris oscuro.

11. **Método main()**: Este es el punto de entrada de su aplicación. Establece la apariencia de la aplicación en Nimbus y luego crea una instancia de la clase "MAIN" y la hace visible.

Espero que le guste. 

**ADRIANA REYES MORERA**
