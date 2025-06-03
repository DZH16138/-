一个简单的学生信息管理系统，前端基于Swing组件，主要代码需求库仅需jdk19自带，个别需额外加入的与数据库相关包在lib中，运行前请务必将 lib 设置为库。
数据库中有三张表：usertbl、stutbl 和 curritbl。
usertbl 表示用户表，包含 uid(int)、uname(varchar)、upassword(varchar) 和 uright(varchar，三种权限：老师、学生和管理员) 等列。
stutbl 表示学生表，包含 sid(int)、sname(varchar)、sphone(varchar)、sage(int)、ssex(tinyint 0,1)、susername(varchar)、spassword(varchar)、semail(varchar)、sphone(varchar)、sqqnumber(varchar) 等列。
curritbl 表示课程表，包含 cstudent(varchar)、cname(varchar)、cid(varchar)、cteacher(varchar)、cgrade(int)。
开发工具包是 IntelliIdea 和 DataGrip，运行 jdk19 和 mysql。
很高兴能助力到你的学业。

a simple Student information Manage System
Be sure to set lib as library before you run
as for the database code i have no idea to upload.Comment if u know.
there are 3 tables in database:usertbl,stutbl,curritbl
usertbl means user table which has columns of uid(int),uname(varchar),upassword(varchar) and uright(varchar,three kinds of rights:teacher,student and manager)
stutbl means student table which has columns of sid(int),sname(varchar),sphone(varchar),sage(int),ssex(tinyint 0,1),susername(varchar),spassword(varchar),semail(varchar),sphone(varchar),sqqnumber(varchar)
curritbl means curricular table which has columns of cstudent(varchar),cname(varchar),cid(varchar),cteacher(varchar),cgrade(int)
development kit is IntelliIdea and DataGrip with jdk19 and mysql
Pleasure if can help u
