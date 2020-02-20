> 采用一问一答的形式，还原面试官提问场景。

- 平时⽤到哪些 Linux 命令？
- ⽤一行命令查看文件的最后五行？
- ⽤一行命令输出正在运行的 java 进程？
- top 命令之后有哪些内容，有什么作用？
- 线上 CPU 爆高，请问你如何找到问题所在（vmstat、top、iostat、lsof、ip、netstat、tcpdump、sar）？
- 如何查找某个进程（ps aux |grep threadId）？
- 如何杀掉某个进程（kill，参数添加 -9 表示强制执行）？
- 如何查看某个端口是否被占用（netstat -anp |grep threadId）？
- Linux 什么命令可以查询 Java 调用栈？
- 硬链接、软链接区别？
- 文件处理命令 grep、awk、sed？
- 文件系统的理解（EXT4、XFS、BTRFS）？
- 文件权限怎么看（rwx）？
- 文件的三种时间（mtime、atime、ctime），分别在什么时候会改变？
- 


# 平时⽤到哪些 Linux 命令？

(1). 文件操作 lsof、cd、ls、touch、pwd、mkdir、cp、mv、ln、rm 
(2). 系统负载（重点） sar、top、uptime、free、vmstat、ps 
(3). 网络相关（重点） ifconﬁg、ping、netstat、ss、route、traceroute 
(4). 文本操作 grep、sed、awk、cat、less、more、head、tail、wc、sort、uniq 
(5). 用户管理、权限管理 useradd /adduser、userdel、usermod、passwd、chmod、chown、chgrp 
(6). 其他 &、 nohup、at、corntab、which、ﬁnd、whereis 
(7). 命令的综合运用统计文件夹下有多少文件名全为小写，后缀名为.cpp的文件、删除符合某条件的文件（比如删除10天前的文件，删除大小大于4M的文件）、文件中每行一个数字、输出他们的和。


# 参考

[Linux性能监测系列](https://www.jellythink.com/archives/490)