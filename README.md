# CalcuLatto — Smart, Lightweight Calculator for Android 🧮🤖

CalcuLatto is a compact, powerful calculator app for Android built with Java. It goes beyond basic arithmetic with 100+ calculators across math, physics, chemistry, statistics, health, and unit conversions. It integrates Firebase (analytics) 📊, Appodeal (ads) 📢, and Google Play Billing (subscriptions) 💳.

- ⚡ Lightweight install size
- 🚀 Fast and offline-first for calculations
- 🧭 Intuitive UI with deep functionality
- 🔒 Privacy-focused integrations and consent handling (see Privacy & Data)

## 🧾 Table of Contents
- ✨ Features at a Glance
- 📚 Supported Calculations
  - 🔢 Basic Calculator
  - ➗ Mathematics
  - 📈 Statistics
  - 🔁 Unit Converters
  - 🩺 Health
  - 🧪 Physics
  - ⚗️ Chemistry
- 💰 Monetization & Services
- 🔐 Permissions
- 🔏 Privacy & Data
- 📥 Install
- 🛠️ Build From Source
- 🤝 Contributing
- 🆘 Support
- 📄 License
- ⚠️ Disclaimer

---

## ✨ Features at a Glance
- 🧮 Basic calculator with full scientific functions (including trigonometry)
- 📦 100+ calculators and converters across multiple domains
- 🔢 Numeral systems support (base 2–16, including Roman numerals)
- 🧰 Smart helpers like date calculation, time zones, shapes, vectors, matrices
- 💎 Subscriptions for premium experience
- 🔗 Integrations for Analytics (usage insights), Ads (monetization), and Billing (subscriptions)

---

## 📚 Supported Calculations

### 🔢 Basic Calculator
- Standard and scientific functions
- Trigonometry and inverse trigonometry
- Long calculations view

### ➗ Mathematics
- Numeral Systems (including Roman Numerals; base 2–16)
- Percentage
- Median, Mean, Mode
- Ratio
- Fraction
- Greatest Common Factor & Least Common Multiple (GCF & LCM)
- Modulo
- Prime, Odd, and Even Numbers
- Binomial Coefficient
- Gamma Function
- Linear Equation
- Cofunction
- Date Calculation
- Clock Angle
- Shapes (1D, 2D, 3D)
- Matrix
- Vector
- Aquarium Tank
- Long Basic Calculator
- Time Zone

### 📈 Statistics
- Probability
- Coin Toss / Flip
- Combination and Permutation (CnP)
- Dice Roll

### 🔁 Unit Converters
- Length
- Area
- Speed
- Power
- Energy
- Temperature
- Mass
- Volume
- Time
- Angle
- Storage
- Torque
- Cooking
- Loudness
- Specific Heat Capacity
- Weight (force)
- Magnetic Flux
- Absorbed Dose of Ionizing Radiation
- Luminance
- Illumination
- Solid Angle
- Electric Potential
- Electric Dipole Moment
- Electric Current
- Electric Charge
- Kinematic Viscosity
- Dynamic Viscosity
- Flow
- Fuel Consumption
- Density

### 🩺 Health
- Body Mass Index (BMI) & Total Daily Energy Expenditure (TDEE)
- Body Surface Area (BSA)
- Waist Ratio
- Lean Body Mass (LBM)
- Relative Fat Mass (RFM)
- Fat-free Mass Index (FFMI)
- Blood Pressure
- Cardiac Index
- Basal Metabolic Rate (BMR)
- Calcium Correction
- BUN Creatinine Ratio
- Anion Gap
- Transferrin Saturation (TSAT)
- Serum-Ascites Albumin Gradient (SAAG)
- Iron Deficiency
- Corrected QT Interval (QTc)
- Low-density Lipoproteins (LDL)
- Insulin Resistance (HOMA-IR & QUICKI)

### 🧪 Physics (Kinematics, Statics, Dynamics, Relativity, Thermodynamics)
- Acceleration
- Displacement
- Velocity
- Momentum
- Friction
- Pressure
- Einstein's Theory
- Lorentz Factor
- Mach Number
- Electrical Power
- Heat Capacity
- Ideal Gas Law
- Energy Efficiency
- Force
- Water Heating
- Frequency

### ⚗️ Chemistry
- Avogadro's Number
- Bond Order
- Concentration
- Molarity
- Molality
- Neutralization

---

## 💰 Monetization & Services
- 📊 Analytics: Firebase (usage analytics to improve the app experience)
- 📢 Advertising: Appodeal (ad-mediation platform)
- 💳 Subscriptions: Google Play Billing (unlock premium, ad-free, or advanced features)

You can manage subscription status via Google Play. Ads respect user consent and platform policies.

---

## 🔐 Permissions
Depending on features and SDKs, the app may request:
- 🌐 Network access (to fetch ads, remote configs, or subscription status)
- 🧾 Billing/Payments (Google Play Billing)
- 🧩 Optional diagnostic/analytics permissions via SDKs

Exact permissions appear in the app listing and during install/runtime.

---

## 🔏 Privacy & Data
- 📉 Analytics: Anonymous usage metrics via Firebase to help improve features and stability.
- 🫧 Ads: Appodeal may use device signals to serve and measure ads. Consent dialogs are shown where required (e.g., GDPR/CCPA).
- 🧾 Subscriptions: Google Play Billing handles payments; the app stores minimal state required to reflect entitlement.

For more information, please refer to the app’s in-product consent flows and privacy policy link (if available in the store listing).

---

## 📥 Install
- Google Play: Search for “CalcuLatto” on the Play Store.
- Sideload: Build from source (see below).

---

## 🛠️ Build From Source

### ✅ Prerequisites
- Android Studio (latest stable)
- JDK 17 (recommended) or JDK 11 (per your Gradle setup)
- Android SDK and platform tools

### ⚙️ Project Setup
1. Clone the repository.
2. Open in Android Studio and allow it to sync dependencies.
3. Configure the following integrations:
   - 🔥 Firebase: Add your `google-services.json` to the `app/` module.
   - 📢 Appodeal: Add your Appodeal App Key via a secure mechanism (e.g., `local.properties`, Gradle properties, or environment variables). Follow Appodeal’s Android setup guide for ad units you plan to use.
   - 💳 Google Play Billing: Ensure Billing dependency is added and your Play Console products/subscriptions are created. Use the correct product IDs in your code or via remote config.
4. ▶️ Build and run on a device or emulator with Google Play services.

Notes:
- 🔑 Do not hardcode secrets in source control. Use build configs or remote config where possible.
- 🏗️ For release builds, configure signing and ProGuard/R8 as needed.

---

## 🤝 Contributing
Contributions are welcome! To propose improvements:
- Open an issue describing the bug/feature with clear steps or acceptance criteria.
- For code changes, fork the repo, create a feature branch, and open a pull request with:
  - A concise title and description
  - Screenshots or recordings if UI is affected
  - Tests where applicable

Please follow conventional code style and keep the APK size impact minimal.

---

## 🆘 Support
- 🐞 Issues and feedback: Use the repository’s Issues tab or the in-app feedback link (if available).
- 💬 For subscription or billing inquiries, manage your purchase via Google Play or contact support with your order ID.

---

## ⚠️ Disclaimer
DISCLAIMER: Syncertica makes no warranty and expressly disclaims all warranties as to the accuracy or reliability or suitability of any calculation results or information provided through its products. Syncertica is also not responsible for any damages, direct or indirect, which may occur by the calculation results or information provided through the products.
