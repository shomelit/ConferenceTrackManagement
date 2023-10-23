# Conference Track Management
    Proyecto de consola en Java para procesar listado de charlas y organizarla de acuerdo a parametros pre-establecidos.
### Reglas
    1. La conferencia tiene múltiples temas, cada uno de los cuales tiene una sesión por la mañana y por la tarde.
    2. Cada sesión contiene múltiples charlas.
    3. Las sesiones de mañana comienzan a las 9h y deben finalizar a las 12h, para el almuerzo.
    4. Las sesiones de la tarde comienzan a la 1:00 p. m. y deben finalizar a tiempo para el evento de networking.
    5. El evento de networking no puede comenzar antes de las 4:00 ni después de las 5:00.
    6. Ningún título de charla tiene números.
    7. La duración de todas las conversaciones está expresada en minutos (no en horas) o en relámpagos (5 minutos).
    8. Los presentadores serán muy puntuales; no es necesario que haya intervalos entre sesiones.

### Entrada
    El archivo txt por defecto contiene el siguiente listado :

    Writing Fast Tests Against Enterprise Rails 60min
    Overdoing it in Python 45min
    Lua for the Masses 30min
    Ruby Errors from Mismatched Gem Versions 45min
    Common Ruby Errors 45min
    Rails for Python Developers lightning
    Communicating Over Distance 60min
    Accounting-Driven Development 45min
    Woah 30min
    Sit Down and Write 30min
    Pair Programming vs Noise 45min
    Rails Magic 60min
    Ruby on Rails: Why We Should Move On 60min
    Clojure Ate Scala (on my project) 45min
    Programming in the Boondocks of Seattle 30min
    Ruby vs. Clojure for Back-End Development 30min
    Ruby on Rails Legacy App Maintenance 60min
    A World Without HackerNews 30min
    User Interface CSS in Rails Apps 30min

### Solución
    1. Leer archivo precargado o desde direcctorio que se indique
    2. Ordenar archivo por método de similitud entre los nombres de las charlas
    3. Recorrer y mostrar listado ordenado, agregando horario a los titulos, agregar almuerzo y evento networking

### Salida del proyecto
    
    Se contruye método menú recursivo para mostrar opciones al usuario, donde podrá elegir una opción para ejecutar el proyecto.
    Se ordenan el listado de la siguiente manera:

    Track 1
    09:00 AM Writing Fast Tests Against Enterprise Rails 60min
    10:00 AM Overdoing it in Python 45min
    10:45 AM Lua for the Masses 30min
    11:15 AM Ruby Errors from Mismatched Gem Versions 45min
    12:00 PM Lunch
    01:00 PM Common Ruby Errors 45min
    01:45 PM Rails for Python Developers 5min
    01:50 PM Communicating Over Distance 60min
    02:50 PM Accounting-Driven Development 45min
    03:35 PM Woah 30min
    04:05 PM Sit Down and Write 30min
    04:35 PM Networking Event
    
    Track 2
    09:00 AM Pair Programming vs Noise 45min
    09:45 AM Rails Magic 60min
    10:45 AM Ruby on Rails: Why We Should Move On 60min
    12:00 PM Lunch
    12:45 PM Clojure Ate Scala (on my project) 45min
    01:30 PM Programming in the Boondocks of Seattle 30min
    02:00 PM Ruby vs. Clojure for Back-End Development 30min
    02:30 PM Ruby on Rails Legacy App Maintenance 60min
    03:30 PM A World Without HackerNews 30min
    04:00 PM User Interface CSS in Rails Apps 30min
    04:30 PM Networking Event

### Compilación
    
    Desarrollado en Windows 10.0, IntelliJ IDEA 2023.2.3 (Community Edition) version: 17.0.8.1+7-b1000.32 
    Java jdk 1.8.00_111
    
    Luego de clonar repositorio:
    
    1. Abrir proyecto con IntelliJ.
    2. Para ejecutar presione Mayus + F10
    3. Siga las instrucciones de la consola.
    
    