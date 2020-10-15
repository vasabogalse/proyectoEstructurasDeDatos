<img src="https://www.flaticon.es/svg/static/icons/svg/2913/2913008.svg" width="1500" height="200" />

# Sistema de Gestión de Clínica de Salud Mental

Este sistema ha sido diseñado como herramienta para la interacción y un acompañamiento cercano entre pacientes y personal médico (psiquiatras) de una institución de salud mental.

Nuestro objetivo principal es administrar de manera eficiente la asignación de citas, particularmente de citas prioritarias (emergencias) a través del registro de emociones para que el paciente pueda tener un constante monitoreo, disminuyendo así las brechas de tiempo en el que paciente se encuentra en un estado mental que pueda significar un peligro para su integridad física.

Dentro del sistema se podrán acceder a distintas funciones dependiendo del rol de usuario con el que se es registrado, siendo estas:

-  Coordinador de Clínica.
-  Psiquiatra.
-  Paciente.

## Pre-requisitos 📋
- Tener instalado  [Maven](https://maven.apache.org/ "Maven").
- Tener algún entorno de desarrollo de su elección.

## Contenido📦

## Módulo Coordinador de Clínica.

El Coordinador de Clínica funge la función de administrador, puede gestionar al personal psiquiátrico, el inventario de médicamentos y la información de la clínica a la que pertenece.

Sus funciones especificas se detallan a continuación:

### Clínica

- Editar Clínica: El coordinador puede actualizar el nombre, la dirección o el teléfono de su clínica en caso de que alguno de estos datos haya cambiado a lo largo del tiempo sin la necesidad de crear una nueva clínica.

### Psiquiatra

- Registrar Psiquiatra: El coordinador tiene la capacidad de agregar nuevos especialistas a su equipo de profesionales a través de un simple registro que pide información personal del psiquiatra.

- Dar de baja a un psiquiatra registrado: El coordinador también puede dar de baja a algún psquiatra registrado en el sistema.

### Medicamento

- Controlar inventarios: El coordinador tiene la atribución de monitoriar los inventarios de médicamentos, de esa manera él recibe una notificación cuando el inventario de algún medicamento esta demasiado bajo para que pueda reponerlo. También puede eliminar medicamentos del registro.

## Módulo Psiquiatra
El Psiquiatra es el profesional que trabaja en alguna de las clínicas, su papel es monitoriar de manera directa a los pacientes para su pronta recuperación.

Sus funciones especificas se detallan a continuación:

### Paciente

- Crear y editar historias clínicas:  El psiquiatra es el encargado de mantener el registro de la información de sus pacientes, esta historia clínica esta compuesta por los datos personales del individuo, además de sus antecedentes, procesos y recomendaciones, también puede incluir alguna fórmula médica con médicamentos seleccionados del inventario.

### Citas
- Atender y cancelar citas: El psiquiatra tiene la posibilidad de atender o cancelar las citas que tiene en agenda.

## Módulo Paciente.
El paciente es el individuo interesado en el servicio que ofrece la clínica de salud mental, es importante mencionar que para su ingreso al  sistema es necesario que haga un registro donde establecerá un usuario y contraseña.

Sus atributos especificos se detallan a continuación:
### Psiquiatra
- Asiganción automática de psiquiatra: El paciente recibirá un psiquiatra por defecto al ingresar al sistema por primera vez.

### Citas
- Menejo de citas: La principal ventaja de este sistema con respecto a otros es que se le permitirá al paciente llenar un cuestionario donde, con preguntas de selección simple, él podrá expresar sus emociones. A través de estas respuestas el sistema determinará si el paciente se encuentra en una situación de riesgo y automáticamente se le asignará una cita prioritaria, de otro modo el paciente tiene la libertad de agendar una cita con su psiquiatra asignado en el momento en que el especialista este disponible.

También podrá editar sus datos en cualquier momento y si ya no quiere o no necesita los servicios de la clínica puede darse de baja del sistema cuando quiera.
## Construido con 🛠️
- [Maven](https://maven.apache.org/ "Maven") - Manejador de dependencias

## Autores ✒️
- **Andrés Felipe García Revuelta** - CC: 1017252071 - Ingeniería Mecánica - anfgarciare@unal.edu.co

- **Innis Dapney Salazar García** - CC: 1036688091 - Ingeniería de Control - isalazar@unal.edu.co

- **Valentina Sabogal Serrano** - CC: 1152472574 - Ingeniería de Control - vasabogalse@unal.edu.co

- **Ximena Castañeda Ochoa** - CC: 1000194793 - Estadística - xcastaneda@unal.edu.co

<img src="https://lh3.googleusercontent.com/proxy/4KQpGxwaSGYx-E1ARlvhvlbPCtSox_xyJJseTW86RM3ZwMMbIfVFXQodubjlD4-y3ZYuftDkmXm93ad3bqmNJb9jxlAu8qYfY2s79H0s4XfaDfAsDVsUFpiA82KALt7eeVbf7HersWymS7rWHVYA0CuwhoqBV_O0PHBoUCRN0H7WWqmE4f4MRWaz5ocO" width="1000" height="300" />

