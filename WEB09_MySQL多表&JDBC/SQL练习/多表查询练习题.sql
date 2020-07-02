/*
1. 查出至少有一个员工的部门。显示部门编号、部门名称、部门位置、部门人数。
2. 列出薪金比关羽高的所有员工。
3. 列出所有员工的姓名及其直接上级的姓名。
4. 列出受雇日期早于直接上级的所有员工的编号、姓名、部门名称。
5. 列出部门名称和这些部门的员工信息，同时列出那些没有员工的部门。
6. 列出所有文员的姓名及其部门名称，部门的人数。
7. 列出最低薪金大于15000的各种工作及从事此工作的员工人数。
8. 列出在销售部工作的员工的姓名，假定不知道销售部的部门编号。
9. 列出薪金高于公司平均薪金的所有员工信息，所在部门名称，上级领导，工资等级。
10.列出与庞统从事相同工作的所有员工及部门名称。
11.列出薪金高于在部门30工作的所有员工的薪金的员工姓名和薪金、部门名称。
12.列出每个部门的员工数量、平均工资。
16.查出年份、利润、年度增长比
*/
SELECT * FROM emp e INNER JOIN dept d ON e.deptno=d.deptno;

/*
1. 查出至少有一个员工的部门。显示部门编号、部门名称、部门位置、部门人数。
*/
SELECT z.*,d.dname,d.loc
FROM dept d, (SELECT deptno, COUNT(*) cnt FROM emp GROUP BY deptno) z
WHERE z.deptno=d.deptno;

SELECT z.deptno,z.cnt,d.dname,d.loc
FROM dept d ,(SELECT deptno,COUNT(*) cnt FROM emp GROUP BY deptno) z
WHERE z.deptno=d.deptno

/*
2. 列出薪金比关羽高的所有员工。
*/
SELECT *
FROM emp
WHERE sal > ALL(SELECT sal FROM emp WHERE ename='关羽')
/*
3. 列出所有员工的姓名及其直接上级的姓名
*/
SELECT e.ename, m.ename 
FROM emp e LEFT OUTER JOIN emp m ON e.mgr=m.empno

/*
4. 列出受雇日期早于直接上级的所有员工的编号、姓名、部门名称。
*/
SELECT e.empno, e.ename, d.dname
FROM emp e 
INNER JOIN emp m ON e.mgr=m.empno 
INNER JOIN dept d ON e.deptno=d.deptno 
WHERE e.hiredate < m.hiredate;

/*
5. 列出部门名称和这些部门的员工信息，同时列出那些没有员工的部门。
*/
SELECT d.dname,e.*
FROM emp e RIGHT OUTER JOIN dept d ON e.deptno=d.deptno

/*
6. 列出所有文员的姓名及其部门名称，部门的人数。
*/
SELECT * FROM emp e,dept d WHERE e.deptno=d.deptno;

SELECT e.ename,d.dname,z.cnt
FROM emp e, dept d, (SELECT deptno,COUNT(*) cnt FROM emp GROUP BY deptno) z
WHERE job='文员' AND e.deptno=d.deptno AND d.deptno=z.deptno;
/*
7. 列出最低薪金大于15000的各种工作及从事此工作的员工人数。
*/
SELECT job,COUNT(*)
FROM emp
GROUP BY job
HAVING MIN(sal)>15000

/*
8. 列出在销售部工作的员工的姓名，假定不知道销售部的部门编号。
*/
SELECT * FROM emp e INNER JOIN dept d ON e.deptno=d.deptno 


SELECT ename dname
FROM emp e INNER JOIN dept d ON e.deptno=d.deptno
WHERE d.dname='销售部'

SELECT e.ename
FROM emp e
WHERE e.deptno = (SELECT deptno FROM dept WHERE dname='销售部');

/*
9. 列出薪金高于公司平均薪金的所有员工信息，所在部门名称，上级领导，工资等级。
*/
SELECT * FROM salgrade

SELECT e.*, d.dname,m.ename,g.grade
FROM emp e
 LEFT OUTER JOIN dept d ON e.deptno=d.deptno
 LEFT OUTER JOIN emp m ON e.mgr=m.empno
 LEFT OUTER JOIN salgrade g ON e.sal BETWEEN g.losal AND g.hisal
WHERE e.sal >(SELECT AVG(sal) FROM emp)

/*
10.列出与庞统从事相同工作的所有员工及部门名称。
*/
SELECT e.*, d.dname
FROM emp e INNER JOIN dept d ON e.deptno=d.deptno
WHERE e.job = (SELECT job FROM emp e WHERE e.ename='庞统')


/*
11.列出薪金高于在部门30工作的所有员工的薪金的员工姓名和薪金、部门名称。
*/
SELECT e.ename,e.sal,d.dname
FROM emp e INNER JOIN dept d ON e.deptno=d.deptno 
WHERE sal> ALL(SELECT sal FROM emp WHERE deptno=30) 

/*
12.列出每个部门的员工数量、平均工资。
*/
SELECT  d.dname,COUNT(*) con, AVG(sal) 
FROM emp e,dept d
WHERE e.deptno=d.deptno
GROUP BY dname

/*
16.查出年份、利润、年度增长比
*/

CREATE TABLE tb_year
(
 col_year INT,
 col_lirun INT
)
INSERT INTO tb_year VALUES(2001,100);
INSERT INTO tb_year VALUES(2002,120);
INSERT INTO tb_year VALUES(2003,180);
INSERT INTO tb_year VALUES(2004,300);

SELECT * FROM tb_year;

DROP TABLE tb_year;

SELECT col_year, col_lirun, 

