# AllLink

AllLink es una aplicación pensada para **adultos mayores y personas con poca experiencia tecnológica**, que ofrece una **interfaz simplificada** para el uso de dispositivos Android.  

Su objetivo es facilitar el acceso a funciones esenciales (recordatorios de medicamentos, citas médicas, llamadas de emergencia) y permitir que un **usuario auxiliar** (familiar o cuidador) pueda **dar soporte remoto** y recibir notificaciones.

---

## Contenido del Repositorio

- `wiki/` → Contiene la documentación del proyecto (Diseño, Fundamentos, Diagramas UML, etc.).  
- `alllink/` → Aplicación demo en **Java consola**, que implementa los patrones de diseño planteados en el proyecto.  
- `data/` → Simulación de base de datos en archivos JSON (usuarios registrados).  
- `Dockerfile` y `pom.xml` → Configuración para compilar y ejecutar el proyecto con Maven/Docker.  

---

## Cómo correr la aplicación demo

### Opción 1: Usando Docker (recomendado)

1. Clonar este repositorio:
   ```bash
   git clone https://github.com/PabloBoada03/ProyectoCorte1ArquiSoftwareDiazCorderoBoada.git
   cd ProyectoCorte1ArquiSoftwareDiazCorderoBoada/alllink
   ```

2. Construir la imagen:
   ```bash
   docker build -t alllink-app .
   ```

3. Ejecutar la aplicación:
   ```bash
   docker run -it --rm alllink-app
   ```

### Opción 2: Usando Maven y Java localmente

1. Asegúrate de tener instalado **Java 17+** y **Maven**.  
2. Compilar el proyecto:
   ```bash
   mvn clean package
   ```
3. Ejecutar:
   ```bash
   java -jar target/alllink-1.0-SNAPSHOT.jar
   ```

La aplicación abrirá un menú en consola donde puedes **registrar usuarios**, **iniciar sesión** y simular acciones (ej: "Tomar medicamento" → envía notificación al Auxiliar).

---

## Wiki del Proyecto

Toda la documentación teórica y técnica del proyecto (Fundamentos de Ingeniería de Software, Patrones de Diseño, UML, Arquitectura, etc.) está disponible en la **Wiki del repositorio**:  

👉 [📚 Ir a la Wiki](https://github.com/PabloBoada03/ProyectoCorte1ArquiSoftwareDiazCorderoBoada/wiki)

---

## Créditos

Proyecto desarrollado para el curso **Diseño y Arquitectura de Software**:

- **Ana María** → 20 años, tenista, Desarrollo Frontend (apps móviles y web).  
- **Isabela** → [Descripción pendiente en wiki].  
- **Pablo** → 22 años, músico (bajo, guitarra, canto) y desarrollador.  

---

## Estado del Proyecto
Este es un **demo de consola** (prototipo académico).  
En fases posteriores se planea:  
- Integración real con **Firebase**.  
- Implementación de **interfaz móvil** en Android.  
- Pruebas más avanzadas (unitarias, integración, carga).  
