
## Redis 安装使用

- 下载Redis安装包 
```
https://redis.io/download
tar zxvf redis-3.2.1.tar.gz  -C /home/redis/
cd redis-3.2.1
make
make install
```
>  注意：编译redis时 提示make cc Command not found
>  安装gcc环境 yum install gcc

- redis.conf 配置
- 修改前
```
daemonize no
bind 127.0.0.1
protected-mode yes
#requirepass foobared 
```
- 修改后
```
#守护进程
daemonize yes
#外网通信连接
#bind 127.0.0.1
protected-mode no
#初始化密码配置
requirepass 123.com
```
- 启动服务
```
cd redis-3.2.1/src
./redis-server /home/redis/redis-3.2.1/redis.conf
```
- 查看进程

```
ps -ef|grep redis
```

- 启动客户端
```
redis-cli -p 6379
```
- 修改密码

```
config set requirepass 123.com
```
- 防火墙 关闭6379端口

```
/sbin/iptables -I INPUT -p tcp --dport 6379 -j ACCEPT
/etc/rc.d/init.d/iptables save
```

## 开机自启配置

- 编辑Redis初始化文件

```
cd /home/redis/redis-3.2.1/utils
vi redis_init_script
```
- redis_init_script修改

- 修改内容包含：

```
1.开机自启 添加如下内容
# chkconfig:   2345 90 10
# description:  Redis is a persistent key-value database
2.目录定位配置
REDISPORT=6379
EXEC=/home/apk/redis-3.2.1/src/redis-server
CLIEXEC=/home/apk/redis-3.2.1/src/redis-cli

PIDFILE=/var/run/redis_${REDISPORT}.pid
CONF="/home/apk/redis-3.2.1/redis.conf"
3.服务关闭密码配置
$CLIEXEC -a "123.com" -p $REDISPORT shutdown

```
- 具体修改内容如下
```
#!/bin/sh
# 
# Simple Redis init.d script conceived to work on Linux systems
# as it does use of the /proc filesystem.
# chkconfig:   2345 90 10
# description:  Redis is a persistent key-value database

REDISPORT=6379
EXEC=/home/redis/redis-3.2.1/src/redis-server
CLIEXEC=/home/redis/redis-3.2.1/src/redis-cli

PIDFILE=/var/run/redis_${REDISPORT}.pid
CONF="/home/redis/redis-3.2.1/redis.conf"

case "$1" in
    start)
        if [ -f $PIDFILE ]
        then
                echo "$PIDFILE exists, process is already running or crashed"
        else
                echo "Starting Redis server..."
                $EXEC $CONF
        fi
        ;;
    stop)
        if [ ! -f $PIDFILE ]
        then
                echo "$PIDFILE does not exist, process is not running"
        else
                PID=$(cat $PIDFILE)
                echo "Stopping ..."
                $CLIEXEC -a "123.com" -p $REDISPORT shutdown
                while [ -x /proc/${PID} ]
                do
                    echo "Waiting for Redis to shutdown ..."
                    sleep 1
                done
                echo "Redis stopped"
        fi
        ;;
    *)
        echo "Please use start or stop as first argument"
        ;;
esac

```
- 将redis_init_script 脚本拷贝到/etc/init.d 下修改名字为redis

```
cp redis_init_script /etc/init.d/
mv redis_init_script redis
```
- 修改读写权限

```
chmod +x /etc/init.d/redis
```
- 尝试启动或停止redis服务

```
service redis start 
service redis stop
```
- 开启服务自启动

```
chkconfig redis on
```

- 开机服务自启动

```
chkconfig –add redis
```

>大功完成！机器重启就会看到redis已经启动了








