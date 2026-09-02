# Taller de CI/CD con Spring Boot y GitHub Actions

Este repositorio contiene la implementación práctica del pipeline de Integración y Despliegue Continuo (CI/CD) para una aplicación Spring Boot con Maven y Java 21.

## 🚀 Pipeline de CI/CD
El pipeline configurado en `.github/workflows/ci.yml` realiza:
1. **Checkout del código** (`actions/checkout@v4`).
2. **Configuración de Java 21** (`actions/setup-java@v4` Temurin).
3. **Compilación automática con Maven** (`mvn -B clean compile`).
4. **Ejecución de pruebas unitarias** (`mvn test` con JUnit 5 y MockMvc).
5. **Generación de reporte de cobertura con JaCoCo** (`mvn jacoco:report`).
6. **Publicación del artefacto de cobertura** (`actions/upload-artifact@v4`).
7. **Validación de variables de entorno y secretos** (`secrets.APP_ENV_DEMO`).

## 🛠️ Estructura del Proyecto
- `src/main/java/com/example/workshop/controller/`: Endpoints REST.
- `src/main/java/com/example/workshop/service/`: Lógica de negocio y cálculo de descuentos.
- `src/test/java/com/example/workshop/`: Pruebas de unidad de Service y Controller.
- `.github/workflows/ci.yml`: Definición del pipeline de GitHub Actions.
