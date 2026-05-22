Acest proiect reprezintă un framework complet de testare automată, construit de la zero, care acoperă atât testarea interfeței de utilizator (UI), cât și testarea serviciilor web (API).

Proiectul a fost dezvoltat respectând cele mai bune practici din industrie, inclusiv arhitectura Page Object Model (POM) și generarea de rapoarte vizuale detaliate.

## 🛠️ Tehnologii și Instrumente Folosite
* **Limbaj de programare:** Java
* **UI Testing:** Selenium WebDriver
* **API Testing:** RestAssured
* **Test Runner / Framework:** TestNG
* **Design Pattern:** Page Object Model (POM)
* **Build Tool:** Apache Maven
* **Rapoarte:** Extent Reports (HTML)
* **Reducerea codului repetitiv (Boilerplate):** Lombok



## 📂 Arhitectura Proiectului
Framework-ul este structurat logic, pe pachete independente, pentru a asigura o mentenanță ușoară și scalabilitate:

* `src/test/java/config` - Conține clasa `TestConfig` pentru gestionarea variabilelor globale și a URL-urilor de bază.
* `src/test/java/data` - Conține clasa `TestData` unde sunt stocate datele de testare (credențiale, date de intrare pentru formulare, cuvinte cheie).
* `src/test/java/models` - Conține POJO-uri (ex: `UserApi`) generate cu Lombok, folosite pentru serializarea și deserializarea payload-urilor în testele API.
* `src/test/java/pages` - Clasele Page Object Model (POM) care izolează locatorii web și acțiunile specifice fiecărei pagini (ex: `LoginPage`, `CartPage`, `HomePage` etc.).
* `src/test/java/tests/api` - Suita de teste pentru backend (ReqRes / DummyJSON).
* `src/test/java/tests/ui` - Suita de teste pentru frontend (Practice Software Testing), care extind clasa de bază `BaseTest` pentru gestionarea automată a browser-ului.
* `src/test/java/utils` - Utilitare pentru framework, incluzând `ExtentManager` și `TestListener` pentru generarea rapoartelor vizuale de testare.

## 🚀 Rularea Testelor
1. Asigurați-vă că aveți instalat **Java JDK** și **Maven**.
2. Clonați/descărcați proiectul local.
3. Actualizați dependențele rulând: mvn clean install
4. Testele pot fi rulate direct din IDE (IntelliJ/Eclipse) sau din linia de comandă: mvn test