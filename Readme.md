# Arquitectura MVC con Patrón Observer

En esta rama utilizaremos el patrón Observer

Los cambios de la velocidad que se hagan en el model serán observados por el Controller.

Para notificar a los observadores hacemos dos pasos:
- Actualizamos el estado de 'algo a cambiado' con `setChange()`
- Notificamos a los observadores `notifyObservers(valor)`

De esta manera se dispara en todos los observadores el método `update()`

---
## Diagrama de clases:

```mermaid
classDiagram
    class Observable{
        +setChanged()
        +notifyObserver(valor)
    }
    class Coche {
        String: matricula
        String: modelo
        Integer: velocidad
    }
      class Controller{
          +main()
      }
      class View {+mostrarVelocidad(String, Integer)}
      class Model {
          ArrayList~Coche~: parking
          +crearCoche(String, String, String)
          +getCoche(String)
          +aumentarVelocidad(String, Integer)
          +reducirVelocidad(String, Integer)
          +getVelocidad(String)
      }
      class IU {
          +crearVentana()
      }
      class Dialogo {
          +crearDialogo()
      }
      class ObserverVelocidad {
      +update()
      }
      class ObsExceso{
      update()
      }
    Controller "1" *-- "1" ObserverVelocidad : association
    Controller "1" *-- "1" ObsExceso : association
    Controller "1" *-- "1" Model : association
    Controller "1" *-- "1" View : association
    Model "1" *-- "1..n" Coche : association
    View "1" *-- "1..1" IU: association
    View "1" *-- "1..1" Dialogo : association
    Observable<|--Model
      
```

---

## Diagrama de Secuencia
### Evento en el View
El observer está para controlar el cambio de velocidad
```mermaid
sequenceDiagram
    actor User
    participant View
    participant Controller
    participant ObserverVelocidad
    participant ObsExceso
    participant Model
    
    User-->>View: Crea un coche
    activate View
    View-->>Controller: User quiere crear un coche
    activate Controller
    Controller->>Model: Puedes crear un coche?
    activate Model
    Model-->>Controller: Coche
    deactivate Model
    Controller-->>View: Coche creado
    deactivate Controller
    View-->>User: El coche se ha creado
    deactivate View
    
    User-->>View: Aumenta la velocidad del coche
    activate View
    View-->>Controller: User quiere aumentar la velocidad
    activate Controller
    Controller->>Model: Puedes aumentar la velocidad?
    activate Model
    Model-->>ObserverVelocidad: Notificación de aumento de velocidad
    deactivate Model
    activate Model
    Model-->>ObsExceso: Notificación de aumento de velocidad
    deactivate Model
    activate ObserverVelocidad
    ObserverVelocidad-->>+View: Muestra la velocidad
    deactivate ObserverVelocidad
    activate ObsExceso
    ObsExceso-->>+View: Muestra la velocidad
    deactivate ObsExceso
    deactivate Controller
    View-->>User: El coche ha aumentado su velocidad
    deactivate View
    View-->>User: Te has pasado!!
    deactivate View
    
    User-->>View: Reduce la velocidad del coche
    activate View
    View-->>Controller: User quiere reducir la velocidad
    activate Controller
    Controller->>Model: Puedes reducir la velocidad?
    activate Model
    Model-->>ObserverVelocidad: Notificación de reducción de velocidad
    deactivate Model
    activate ObserverVelocidad
    ObserverVelocidad-->>+View: Muestra la velocidad
    deactivate ObserverVelocidad
    deactivate Controller
    View-->>User: El coche ha reducido su velocidad
    deactivate View
```

El mismo diagrama con los nombres de los métodos
```mermaid
sequenceDiagram
actor User    
participant IU
participant Dialogo
participant View
participant Controller
participant ObserverVelocidad
participant obsExceso
participant Model

    User-->>IU: Crea un coche
    IU-->Controller: crearCoche(modelo,matricula)
    activate Controller
    Controller->>Model: crearCoche(modelo, matricula)
    activate Model
    Model-->>Controller: Coche
    deactivate Model
    Controller-->>+View: mostrarVelocidad(matricula, velocidad)
    deactivate Controller
    View-->>-Dialogo: crearDialogo(mensaje)
    
    User-->>IU: Aumenta la velocidad del coche
    IU-->>Controller: aumentarVelocidad(matricula,velocidad)
    activate Controller
    Controller->>Model: aumentarVelocidad(matricula,velocidad)
    activate Model
    Model-->>ObserverVelocidad: update()
    deactivate Model
    activate Model
    Model-->>ObsExceso: update()
    deactivate Model
    activate ObserverVelocidad
    ObserverVelocidad-->>+View: mostrarVelocidad(matricula, velocidad)
    deactivate ObserverVelocidad
    activate ObsExceso
    ObsExceso-->>+View: mostrarVelocidad2(matricula, velocidad)
    deactivate ObsExceso
    deactivate Controller
    View-->>-Dialogo: crearDialogo(mensaje)
    
    User-->>IU: Reduce la velocidad del coche
    IU-->>Controller: reducirVelocidad(matricula,velocidad)
    activate Controller
    Controller->>Model: reducirVelocidad(matricula,velocidad)
    activate Model
    Model-->>ObserverVelocidad: update()
    deactivate Model
    activate ObserverVelocidad
    ObserverVelocidad-->>+View: mostrarVelocidad(matricula, velocidad)
    deactivate ObserverVelocidad
    deactivate Controller
    View-->>-Dialogo: crearDialogo(mensaje)
```

Si sumamos otro observador, entonces el update() será en paralelo (par)
a todos los Observadores.
```mermaid
sequenceDiagram
participant View
participant Controller
participant ObserverVelocidad
participant ObserverOtro
participant Model

    Controller->>Model: cambiarVelocidad()
    activate Model
    par notificacion
        Model->>ObserverVelocidad: update()
    and notificacion
        Model->>ObserverOtro: update()
        end
    deactivate Model
    activate ObserverVelocidad
    activate ObserverOtro
    ObserverVelocidad->>+View: mostrarVelocidad
    deactivate ObserverVelocidad
    ObserverOtro->>-ObserverOtro: sout
    activate View
    View->>-View: sout
    deactivate View
 ```    
## Pasos para la configuración

1. Model
   * Extender `Observable` en `Model`
   * En el método en donde ocurra el cambio:
     * setChenged()
     * notifyObserver(valor)
2. Crear una clase que sea el observador, que implementa la interface `Observer`
    * definir el método `update()`
3. Controller
    * Instanciar el observer, definido en el punto anterior
    * Añadir este observer al observable con `addObserver()`
