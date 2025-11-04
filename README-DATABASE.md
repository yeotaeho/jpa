# Database Configuration Guide

## 프로젝트 데이터베이스 설정

이 프로젝트는 **PostgreSQL**을 기본 데이터베이스로 사용하며, 개발 환경에서는 **H2 인메모리 데이터베이스**를 사용할 수 있습니다.

---

## 📋 데이터베이스 정보

### PostgreSQL (기본)
- **Database Name**: `pickprodb`
- **Username**: `pickpro`
- **Password**: `pickpro`
- **Port**: `5432`
- **Schema**: `public`

### H2 Database (개발용)
- **URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: (empty)
- **Console**: `http://localhost:8080/h2-console`

---

## 🚀 PostgreSQL 설치 및 설정

### 1. PostgreSQL 설치

#### Windows
```bash
# Chocolatey 사용
choco install postgresql

# 또는 공식 웹사이트에서 설치
# https://www.postgresql.org/download/windows/
```

#### macOS
```bash
brew install postgresql@15
brew services start postgresql@15
```

#### Linux (Ubuntu/Debian)
```bash
sudo apt update
sudo apt install postgresql postgresql-contrib
sudo systemctl start postgresql
sudo systemctl enable postgresql
```

### 2. 데이터베이스 생성

#### 방법 1: SQL 스크립트 사용
```bash
# PostgreSQL에 접속
sudo -u postgres psql

# 또는 Windows에서
psql -U postgres

# SQL 스크립트 실행
\i postgresql-setup.sql
```

#### 방법 2: 수동 생성
```sql
-- PostgreSQL에 접속 후 실행
CREATE DATABASE pickprodb WITH ENCODING = 'UTF8';
CREATE USER pickpro WITH PASSWORD 'pickpro';
GRANT ALL PRIVILEGES ON DATABASE pickprodb TO pickpro;

-- pickprodb 데이터베이스에 연결
\c pickprodb

-- 스키마 권한 부여
GRANT ALL ON SCHEMA public TO pickpro;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON TABLES TO pickpro;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON SEQUENCES TO pickpro;
```

### 3. 연결 확인
```bash
# pickpro 사용자로 데이터베이스 연결 테스트
psql -U pickpro -d pickprodb -h localhost
```

---

## 🔧 Spring Profile 설정

### 기본 (PostgreSQL)
```bash
# 아무 설정 없이 실행 - PostgreSQL 사용
./gradlew bootRun
```

### 개발 환경 (H2 Database)
```bash
# dev 프로필로 실행 - H2 인메모리 데이터베이스 사용
./gradlew bootRun --args='--spring.profiles.active=dev'

# 또는 IntelliJ IDEA에서
# Run Configuration > Active profiles: dev
```

### 운영 환경 (PostgreSQL)
```bash
# prod 프로필로 실행
./gradlew bootRun --args='--spring.profiles.active=prod'
```

---

## 📊 데이터베이스 테이블 구조

### pickpros (조직도 테이블)
```sql
CREATE TABLE pickpros (
    id SERIAL PRIMARY KEY,
    category VARCHAR(50),
    name VARCHAR(100),
    title VARCHAR(100),
    sub_units VARCHAR(500)
);
```

---

## 🔍 유용한 명령어

### PostgreSQL 명령어
```bash
# 데이터베이스 목록 확인
\l

# 현재 데이터베이스의 테이블 목록
\dt

# 테이블 구조 확인
\d pickpros

# 데이터 조회
SELECT * FROM pickpros;

# PostgreSQL 종료
\q
```

### Gradle 명령어
```bash
# 의존성 다운로드
./gradlew build --refresh-dependencies

# 애플리케이션 실행
./gradlew bootRun

# 특정 프로필로 실행
./gradlew bootRun --args='--spring.profiles.active=dev'
```

---

## ⚠️ 주의사항

### 1. 비밀번호 보안
운영 환경에서는 환경 변수를 사용하세요:

```yaml
spring:
  datasource:
    username: ${DB_USERNAME:pickpro}
    password: ${DB_PASSWORD:pickpro}
```

```bash
export DB_USERNAME=pickpro
export DB_PASSWORD=your_secure_password
```

### 2. ddl-auto 설정
- **개발**: `update` 또는 `create-drop`
- **운영**: `validate` (절대 `create` 또는 `create-drop` 사용 금지!)

### 3. Connection Pool
대규모 애플리케이션의 경우 HikariCP 설정 조정:
```yaml
spring:
  datasource:
    hikari:
      maximum-pool-size: 20
      minimum-idle: 10
```

---

## 🐛 문제 해결

### PostgreSQL 연결 실패
```bash
# PostgreSQL 상태 확인
sudo systemctl status postgresql

# PostgreSQL 재시작
sudo systemctl restart postgresql

# 포트 확인
sudo netstat -plnt | grep 5432
```

### 권한 오류
```sql
-- PostgreSQL에서 권한 다시 부여
\c pickprodb
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO pickpro;
```

### H2 Console 접속 안됨
- `dev` 프로필로 실행했는지 확인
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`

---

## 📚 참고 자료

- [PostgreSQL Documentation](https://www.postgresql.org/docs/)
- [Spring Data JPA Reference](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
- [HikariCP Configuration](https://github.com/brettwooldridge/HikariCP#configuration-knobs-baby)

