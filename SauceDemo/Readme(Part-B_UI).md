# 🧪 SauceDemo UI Automation
This project contains **UI automation tests** for [SauceDemo](https://www.saucedemo.com/) using **Selenium (Java, TestNG, Maven)** with the **Page Object Model (POM)** design pattern.
## 📌 Summary
- Covers **login (valid & invalid)**, **cart functionality**, and **checkout flow**.
- Implements **Page Object Model (POM)** for reusability and clean structure.
- Uses **TestNG** for test execution and assertions.
- Includes setup scripts, reusable helpers, and structured test cases.
## ✅ Test Scenarios
1. **Successful Login** → Valid credentials navigate to products page.  
2. **Invalid Login** → Locked out user shows proper error message.  
3. **Add Multiple Items to Cart** → Items added correctly, cart badge updated.  
4. **Checkout: Your Information** → Checkout info captured, overview page displayed.  
5. **Finish Checkout** → Successful order completion with confirmation message.  
## ⚙️ Tech Stack
- **Language:** Java  
- **Frameworks:** Selenium, TestNG  
- **Build Tool:** Maven  
- **Design:** Page Object Model (POM)  
## ▶️ How to Run
```bash
mvn clean test