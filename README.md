Overview
The Multithreaded Hotel Webpage is a modern web application designed to support internationalization (i18n) 
and localization (l10n) for a seamless user experience across different regions and languages. The project 
integrates a multithreaded back-end built with Java Spring Boot and a dynamic front-end using Angular. 
The application showcases hotel scheduling, displaying multilingual welcome messages and price formats in 
various currencies (USD, CAD, EUR).

🛠️ Features
Internationalization (i18n) and Localization (l10n):
Displays multilingual welcome messages (e.g., English and French) using resource bundles.
Formats pricing in multiple currencies (USD, CAD, EUR) for global customers.
Multithreaded Back-End:
Uses separate threads to fetch and serve localized content concurrently.
Ensures efficient processing of international data.
Dynamic Angular Front-End:
Fetches localized messages from the back end and displays them dynamically.
Uses ngFor and ngIf for responsive and interactive UI components.
Time Zone Converter:
Converts and displays times for live hotel presentations in ET, MT, and UTC formats.
Docker Deployment:
Fully containerized with a Dockerfile for consistent deployment of the back-end and front-end components.

🚀 Prerequisites
Java Development Kit (JDK): Version 8 or higher.
Spring Boot Framework: Latest version for back-end development.
Angular CLI: Version 12 or higher for front-end development.
Node.js: Version 14+ for Angular dependencies.
MySQL: Configured for storing hotel scheduling data.
Docker: For building and deploying the application.
