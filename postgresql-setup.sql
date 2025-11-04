-- PostgreSQL Database Setup Script for PickPro API Server
-- Run this script as PostgreSQL superuser (postgres)

-- 1. Create database
CREATE DATABASE pickprodb
    WITH 
    ENCODING = 'UTF8'
    LC_COLLATE = 'C'
    LC_CTYPE = 'C'
    TEMPLATE = template0;

-- 2. Create user
CREATE USER pickpro WITH PASSWORD 'pickpro';

-- 3. Grant privileges
GRANT ALL PRIVILEGES ON DATABASE pickprodb TO pickpro;

-- 4. Connect to the database (in psql, use: \c pickprodb)
\c pickprodb

-- 5. Grant schema privileges
GRANT ALL ON SCHEMA public TO pickpro;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO pickpro;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO pickpro;

-- 6. Set default privileges for future objects
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON TABLES TO pickpro;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON SEQUENCES TO pickpro;

-- Done! You can now start your Spring Boot application

