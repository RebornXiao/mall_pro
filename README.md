# mall-pro
(spring mvc +spring +mybatis +Dubbo)

Hi 各位码农小伙伴们，本文将使用maven整合dubbo、spring、springmvc、mybatis框架，并使用全注解的形式来发布服务和注册服务。
好了，也不多废话了，说白了我也没多少废话，纯属于初学者，存在不合理或者不正确的地方，还请各位给予指正。

您需要准备的环境清单如下：

1、eclipse:下载地址：https://www.eclipse.org/downloads

2、maven，版本管理>=3.0.4下载地址：http://maven.apache.org/download.cgi

3、zookeeper，注册中心 下载地址（win）：http://download.csdn.net/download/u013286716/7167881
 
配置：zoo.cfg，以下是我的配置文件，请参考修改

# The number of milliseconds of each tick
tickTime=2000
# The number of ticks that the initial 
# synchronization phase can take
initLimit=10
# The number of ticks that can pass between 
# sending a request and getting an acknowledgement
syncLimit=5
# the directory where the snapshot is stored.
# do not use /tmp for storage, /tmp here is just 
# 配置zookepper 的数据目录.和zookepper的日志输出目录
dataDir=D:\\zookeeper-3.4.6\\data   
dataLogDir=D:\\zookeeper-3.4.6\\log
# 客户端连接zooker的端口号
clientPort=2181
# the maximum number of client connections.t
# 配置zookpper的最大连接数
maxClientCnxns=60
#
# Be sure to read the maintenance section of the 
# administrator guide before turning on autopurge.
#
# http://zookeeper.apache.org/doc/current/zookeeperAdmin.html#sc_maintenance
#
# The number of snapshots to retain in dataDir
#autopurge.snapRetainCount=3
# Purge task interval in hours
# Set to "0" to disable auto purge feature
#autopurge.purgeInterval=1






