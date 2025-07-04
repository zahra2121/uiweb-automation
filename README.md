# UI Automation Testing Framework

## Tujuan
Proyek ini bertujuan menguji aplikasi web secara otomatis menggunakan Selenium WebDriver,
Cucumber, dan Java dengan pendekatan Page Object Model (POM). 
Framework ini mendukung pengujian positif, negatif, dan batasan.

## Teknologi yang Digunakan
- Java
- Gradle
- Selenium
- Cucumber (Gherkin)
- JUnit

## Struktur Proyek
- pages/: Page Object Model 
- features/: Gherkin Feature Files 
- stepdefinitions/: Implementasi langkah-langkah Cucumber 
- runners/: Test Runner

## Jenis Pengujian
- Positif: Login berhasil dengan kredensial benar 
- Negatif: Login gagal dengan kredensial salah
- Login dengan boundary value username dan password

## Cara Jalankan
- ./gradlew test
- atau ./gradlew test --tests runners.CucumberTest

Laporan HTML:
Buka target/cucumber-report.html di browser.
atau laporan Cucumber Reports Update.png


