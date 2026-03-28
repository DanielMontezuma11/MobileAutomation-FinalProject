# Mobile Automation - Final Project

Proyecto de automatización mobile con **Appium**, **Selenium** y **TestNG** para testing de aplicaciones Android.

## Requisitos Previos

- **Java**: JDK 17 o superior instalado y configurado en PATH
- **Maven**: Maven 3.6+ instalado
- **Android Studio**: Con emulador configurado (Pixel 2, API 36.1 recomendado)
- **Appium Server**: Appium 2.0+ instalado globalmente (`npm install -g appium`)
- **APK**: La aplicación `android.wdio.native.app.v2.2.0.apk` descargada/disponible

---

## Configuración Inicial

### 1. Verificar Instalación de Java
```bash
java -version
```
Debe mostrar: `openjdk version "17"` o superior

### 2. Verificar Instalación de Maven
```bash
mvn --version
```
Debe mostrar: `Apache Maven 3.6+`

### 3. Iniciar Emulador Android
1. Abre **Android Studio**
2. Ve a **Device Manager** → Selecciona **Pixel 2** con **API 36.1**
3. Haz clic en **Play** para iniciar el emulador
4. Espera a que el emulador esté completamente cargado (verás la pantalla de inicio)

### 4. Verificar Conexión ADB
```bash
adb devices
```
Debes ver tu emulador listado:
```
List of attached devices
emulator-5554		device
```

### 5. Iniciar Appium Server
En una terminal separada, ejecuta:
```bash
appium
```
Debes ver algo como:
```
[Appium] Appium REST http interface listener started on 0.0.0.0:4723
```
**Deja esta terminal corriendo** mientras ejecutas los tests.

---

## Configuración del Proyecto

### 1. Actualizar Ruta del APK
En `src/test/java/tests/BaseTest.java`, línea ~20:
```java
.setApp("C:/Users/daniel.montezuma/Downloads/android.wdio.native.app.v2.2.0.apk")
```

Cambiar a la ruta donde tengas el APK en tu computadora:
```java
.setApp("C:/tu_usuario/ruta/al/apk.apk")
```

---

## Ejecutar los Tests

### Ejecutar Todos los Tests
```bash
mvn test
```

### Ejecutar un Test Específico (Ejemplo: Test #1 - Bottom Navigation)
```bash
mvn test -Dtest=BottomNavigationTest
```

### Ejecutar un Test Específico (Ejemplo: Test #4 - Swipe Cards)
```bash
mvn test -Dtest=SwipeCardsTest
```

---

## Estructura del Proyecto

```
MobileAutomation-FinalProject/
├── src/
│   ├── main/java/org/example/
│   │   └── Main.java
│   └── test/
│       ├── java/
│       │   ├── screens/          # Page Object Model - Pantallas
│       │   │   ├── BaseScreen.java
│       │   │   ├── SwipeScreen.java
│       │   │   ├── LoginScreen.java
│       │   │   └── ... otros screens
│       │   ├── tests/            # Tests
│       │   │   ├── BaseTest.java
│       │   │   ├── BottomNavigationTest.java
│       │   │   ├── SwipeCardsTest.java
│       │   │   └── ... otros tests
│       │   └── utils/            # Utilidades
│       │       ├── WaitUtils.java
│       │       └── DataGenerator.java
│       └── resources/
├── pom.xml
└── README.md
```

---

## Tests Disponibles

| Test | Descripción                                        | Archivo |
|------|----------------------------------------------------|---------|
| Test #1 | Bottom Navigation Bar - Navega todas las secciones | `BottomNavigationTest.java` |
| Test #2 | Sign Up - Flujo de registro                        | `SignUpTest.java` |
| Test #3 | Login - Flujo de autenticación                     | `LoginTest.java` |
| Test #4 | Swipe Cards - Gestos horizontales y verticales     | `SwipeCardsTest.java` |

---

## Dependencias del Proyecto

- **Appium Java Client**: 10.1.0
- **Selenium**: 4.18.1
- **TestNG**: 7.10.2
- **Java**: 17

---

