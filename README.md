# Article-management-system-backend

## Overview

Article-management-system-backend 是一個用於管理文章的後端服務，提供用戶註冊、文章分類管理、文章管理以及個人資料管理功能。該服務使用 Spring Boot 構建，並整合了 MySQL 數據庫。

## Features

### 1. 用戶註冊與登入

- **註冊**: 新用戶可以通過輸入用戶名稱和密碼進行註冊。
- **登入**: 註冊後，用戶可以使用其名稱和密碼登入網站。

### 2. 文章分類管理

- **新增文章分類**: 使用者可以創建新的文章分類及其別名。
- **增刪改查分類**: 使用者可以對文章分類進行增刪改查操作。

### 3. 文章管理功能

- **新增文章**: 使用者可以創建新文章並選擇對應的文章分類。
- **撰寫文章內容**: 使用者可以在創建文章時撰寫內容。
- **增刪改查文章**: 使用者可以對文章進行增刪改查操作。
- **文章搜尋**: 可以通過文章分類和發布狀態來搜尋文章。

### 4. 個人資料管理

- **暱稱與信箱**: 使用者可以添加或更新自己的暱稱和信箱。
- **修改密碼**: 使用者可以更新自己的登入密碼。

## Technologies Used

- **Java 17**
- **Spring Boot 3.1.5**
  - **Spring Boot Starter Web**: 用於構建基於 Spring 的 Web 應用程序。
  - **Spring Boot Starter Validation**: 提供數據驗證功能。
  - **Spring Boot Starter Test**: 用於測試的依賴庫。
- **MySQL**: 用於數據持久化。
- **MyBatis Spring Boot Starter 3.0.0**: 整合 MyBatis 框架，用於數據庫操作。
- **Lombok**: 簡化 Java 代碼，減少樣板代碼（如 getter, setter）。
- **Java JWT (version 4.4.0)**: 用於處理 JSON Web Tokens (JWT) 的依賴庫，實現認證和授權功能。
- **PageHelper Spring Boot Starter 2.1.0**: 用於實現分頁功能的工具。
- **Maven**: 用於項目構建和依賴管理。

## Prerequisites

- Java 17 或更高版本
- Maven 3.6+
- MySQL 8.0+

## Getting Started

### 克隆此倉庫

```bash
git clone https://github.com/yourusername/Article-management-system-backend.git
cd Article-management-system-backend
