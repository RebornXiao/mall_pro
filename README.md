# mall-pro
(spring mvc +spring +mybatis +Dubbo)

Hi ��λ��ũС����ǣ����Ľ�ʹ��maven����dubbo��spring��springmvc��mybatis��ܣ���ʹ��ȫע�����ʽ�����������ע�����
���ˣ�Ҳ����ϻ��ˣ�˵������Ҳû���ٷϻ��������ڳ�ѧ�ߣ����ڲ�������߲���ȷ�ĵط��������λ����ָ����

����Ҫ׼���Ļ����嵥���£�

1��eclipse:���ص�ַ��https://www.eclipse.org/downloads

2��maven���汾����>=3.0.4���ص�ַ��http://maven.apache.org/download.cgi

3��zookeeper��ע������ ���ص�ַ��win����http://download.csdn.net/download/u013286716/7167881
 
���ã�zoo.cfg���������ҵ������ļ�����ο��޸�

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
# ����zookepper ������Ŀ¼.��zookepper����־���Ŀ¼
dataDir=D:\\zookeeper-3.4.6\\data   
dataLogDir=D:\\zookeeper-3.4.6\\log
# �ͻ�������zooker�Ķ˿ں�
clientPort=2181
# the maximum number of client connections.t
# ����zookpper�����������
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






