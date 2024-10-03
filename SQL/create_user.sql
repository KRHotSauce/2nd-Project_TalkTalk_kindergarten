show pdbs;

-- 1. 기존 유저 삭제
DROP USER KRHOTSAUCE_DB CASCADE;

-- 2. 새로운 유저 생성
CREATE USER c##KRHOTSAUCE_DB IDENTIFIED BY 9210;

-- 3. 유저에게 필요한 권한 부여
-- DBA 권한 부여 (전체 권한)
GRANT DBA TO c##KRHOTSAUCE_DB;

-- 4. 유저가 테이블 등을 생성할 수 있도록 권한 추가 부여
grant all PRIVILEGES to c##krhotsauce_db;

commit;
