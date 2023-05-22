# Arquitectura MVC

Aplicación que trabaja con objetos coches, los crea, modifica la velocidad y la muestra

---
## Diagrama de clases:

```mermaid
classDiagram
    class Coche {
        String: matricula
        String: modelo
        Integer: velocidad
    }
      class Controller{
          +main()
      }
      class View {+muestraVelocidad(String, Integer)}
      class Model {
          ArrayList~Coche~: parking
          +crearCoche(String, String, String)
          +getCoche(String)
          +subirVelocidad(String, Integer)
          +bajarVelocidad(String, Integer)
          +getVelocidad(String)
          
          
      }
      class IU{
      +crearVentana()
      }
      class Dialogo{
      +crearDialogo()
      }
    Controller "1" *-- "1" Model : association
    Controller "1" *-- "1" View : association
    Model "1" *-- "1..n" Coche : association
    View "1" *-- "1..1" IU : association
    View "1" *-- "1..1" Dialogo : association
    
      
```

---

## Diagrama de Secuencia

Ejemplo básico del procedimiento


```mermaid
sequenceDiagram
    participant Model
    participant Controller
    participant View
    actor User    
    
    User->>View: Crea un coche
    activate View
    View-->>Controller: User quiere crear un coche
    activate Controller    
    Controller->>Model: Puedes crear un coche?
    activate Model
    Model-->>Controller: Toma el coche
    Deactivate Model
    Controller-->>View: Coche creado
    deactivate Controller
    View-->>User: El coche se ha creado
    deactivate View
    
    User->>View: Quiero aumentar la velocidad
    activate View
    View-->>Controller: User quiere aumentar la velocidad
    activate Controller
    Controller->>Model: Puedes aumentar la velocidad?
    activate Model
    Model-->>Controller: Toma la velocidad aumentada
    deactivate Model
    Controller-->>View: Velocidad aumentada
    deactivate Controller
    View-->>User: La velocidad de tu coche se ha aumentado
    deactivate View
    
    User->>View: Quiero reducir la velocidad
    activate View
    View-->>Controller: User quiere reducir la velocidad
    activate Controller
    Controller->>Model: Puedes reducir la velocidad?
    activate Model
    Model-->>Controller: Toma la velocidad reducida
    deactivate Model
    Controller-->>View: Velocidad reducida
    deactivate Controller
    View-->>User: La velocidad de tu coche se ha reducido
    deactivate View

```

Mismo diagrama con los nombres de los métodos

```mermaid
sequenceDiagram
actor User
    participant IU
    participant Dialogo
    participant View
    participant Controller
    participant Model    
    
    
    User-->>IU: Crea un coche
    IU-->Controller: crearCoche(modelo,matricula)
    activate Controller
    Controller->>Model: crearCoche(modelo,matricula)
    activate Model
    Model-->>Controller: Coche
    deactivate Model
    Controller-->>+View: mostrarVelocidad(matricula,velocidad)
    deactivate Controller
    View-->>-Dialogo: mostrarVelocidad(matricula,velocidad)  
      
    User-->>IU: Aumenta velocidad del coche
    IU-->Controller: aumentarVelocidad(matricula,velocidad)
    activate Controller
    Controller->>Model: aumentarVelocidad(matricula,velocidad)
    activate Model
    Model-->>Controller: Coche con velocidad aumentada
    deactivate Model
    Controller-->>+View: mostrarVelocidad(matricula,velocidad)
    deactivate Controller
    View-->>-Dialogo: crearDialogo(mensaje) 
       
    User-->>IU: Reduce velocidad del coche
    IU-->Controller: reducirVelocidad(matricula,velocidad)
    activate Controller
    Controller->>Model: reducirVelocidad(matricula,velocidad)
    activate Model
    Model-->>Controller: Coche con velocidad reducida
    deactivate Model
    Controller-->>+View: mostrarVelocidad(matricula,velocidad)
    deactivate Controller
    View-->>-Dialogo: crearDialogo(mensaje)
    
    
   
```