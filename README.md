# ParcialFinal
# 🐾 Sistema de Gestión Veterinaria en Java (Swing + MVC)

Este proyecto es una aplicación de escritorio desarrollada en Java que permite gestionar toda la operación de una clínica veterinaria: desde el registro de mascotas y propietarios hasta la administración de consultas, historiales clínicos, pagos y reportes.

---

## 📌 Características principales

- 👤 Registro y administración de **propietarios** y **veterinarios**.
- 🐶 CRUD completo de **mascotas** (crear, consultar, actualizar, eliminar).
- 🩺 Registro de **consultas veterinarias**, incluyendo:
  - Diagnóstico, tratamiento y motivo
  - Check para marcar si se aplicó vacuna ✅
- 📋 **Historial clínico** por mascota.
- 💰 **Registro de pagos** asociados a mascotas y veterinarios.
- 📊 **Reportes visuales y exportación a PDF**.
- 🔁 Navegación fluida entre ventanas (menú principal).
- 🎨 Interfaz gráfica con estilo visual morado uniforme.
- 🧠 Validaciones con excepciones personalizadas.
- 🗃️ Persistencia de datos local mediante serialización (archivos `.dat`).
- 🧱 Arquitectura **MVC** con uso de **DTO**, **DAO** y patrón **Singleton**.

---

## 🧱 Estructura del proyecto

proyecto-raiz/
├── modelo/ → Entidades (Mascota, Veterinario, etc.)
├── dto/ → Data Transfer Objects
├── dao/ (ó accesoDatos/) → Clases DAO para acceso a datos
├── controlador/ → Lógica de negocio y validaciones
├── persistencia/ → Lectura/escritura binaria (GestorPersistencia)
├── vista/ → Interfaz gráfica Swing (formularios y menú)
├── utils/ → Generador de ID, estilos visuales
├── Excepcion/ → Excepciones personalizadas
├── data/ → Carpeta generada con archivos .dat
└── Main.java → Punto de entrada de la aplicación


