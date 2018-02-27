## remd-web 模拟用户请求数据部分

### 数据的来源
用户的行为或者操作，就会在后端业务系统中产生浏览职位、搜索职位、收藏职位等记录数据。

### 数据的对接
1. 推荐系统立项后就可以和业务系统进行对接，业务系统现有用户行为数据是否能满足推荐系统的需求；
2. 双方进行相关约束（相关的字段，在业务中代表的意思等），埋点
3. 推荐系统怎么获取数据？业务系统传输数据过来，还是数据流到kafka，推荐系统部署agent?

### 数据的采集
1. 本推荐系统是业务系统log4j产生数据，flume-ng 采集数据
2. 我们重点就关注推荐系统，前面的业务系统和用户参数的数据就通过该项目模拟生成。


### 运行该项目
1. mvn打包
```sbtshell
cd $Project/remd-web/ 
mvn clean package
```
2. mini1,mini2模拟WEB服务器参数数据，上传jar到mini1,mini2，运行:
``` sbtshell
java -cp remd-web-1.0-SNAPSHOT-jar-with-dependencies.jar SimulationRequest SimulationRequest
```
3. 就会参数三个文件
```sbtshell
[root@mini1 data]# ll /opt/data/
total 12
-rw-r--r--. 1 root root 3871 Oct 22 18:56 access.log
-rw-r--r--. 1 root root 3462 Oct 22 18:56 ugchead.log
-rw-r--r--. 1 root root 3416 Oct 22 18:56 ugctail.log
```




