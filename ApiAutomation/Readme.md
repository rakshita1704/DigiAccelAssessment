
# 📦 JSONPlaceholder API Automation Framework

## 🔍 Overview
This project automates REST API testing for JSONPlaceholder using **Java + REST Assured**. It covers positive and negative test cases for GET, POST, PUT, PATCH, and DELETE endpoints.

## 🛠 Tech Stack
- Java
- REST Assured
- JUnit 5
- Maven

## 📁 Project Structure
src/test/java
	├── tests
	   ├── GetPostsTest.java
	   ├── GetUserTest.java
	   ├── PostTest.java
	   ├── PutPatchTest.java
	   ├── DeleteTest.java
	   └── NegativeTests.java
	├── utils
	   └── TestDataUtil.java
src/test/resources
	├── post_schema.json

## 🚀 How to Run
1. Install Java and Maven
2. Clone the repo
3. Run tests with:mvn test
