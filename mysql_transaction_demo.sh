#创建用户
CREATE USER 'chao'@'localhost' IDENTIFIED BY '1987521dch';

#查看当前登陆用户
SELECT USER()

#查看当前数据库
SELECT DATABASE()


#root用户创建一个数据库
CREATE DATABASE wallet;

#将该数据库的所有操作权限授权给chao用户
GRANT ALL ON wallet.* TO 'chao'@'localhost';
FLUSH PRIVILEGES;

#登陆chao用户
#创建user表
CREATE TABLE user(id int, password char(20), money int);

# 插入数据
INSERT INTO user(id, password, money) values(1007, 'abc', 10);
INSERT INTO user(id, password, money) values(1008, 'aaa', 20);
INSERT INTO user(id, password, money) values(1009, 'ccc', 30);

# 取消自动提交
set autocommit = 0;

# 开始事务
begin;

# 插入一个错误数据
INSERT INTO user(id, password, money) values(1010, 'dddd', 9999999);

# 查看表
select * from user;

# 发现错误数据，回滚，发现错误数据消失
rollback;

# 再一次插入错误数据
INSERT INTO user(id, password, money) values(1010, 'dddd', 9999999);

# commit
commit;

# 再一次查看表
select * from user;

# 发现错误，想要再回滚
rollback;

# 但是，发现已经回滚不了了，因为已经成功commit了。

# 查看server的端口号
show global variables like 'port';



























