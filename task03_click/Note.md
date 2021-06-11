## 1. 使用 flask_script

 安装成功后，导入失败  
![](.\pic\1.jpg)  

查看 `flask` 文件夹， `_compat.py` 缺失

原因： flask将不再维护_compat，并且认为flask-script是一个年久失修的模块，建议使用click来完成cli的功能  


## 2. 使用 click 

```python

# -*- coding: UTF-8 -*-
from flask import Flask
import click
# Flask 类实例化
app = Flask(__name__)
# 环境： production, development, testing   
app.config['ENV'] = 'development'
app.config['DEBUG'] = True 
# 定义全局变量
NAME = ''

@click.command()
@click.option('--hostname', default = 'Alice', help='Specify server name')
def func(hostname): 
    global NAME   # 声明全局
    NAME = hostname
    app.run(port = 5000)   

@app.route('/whoAreYou') 
def whoAmI():
    return ('I am %s' %NAME)

@app.route('/')  # 路由
def index():  # 视图函数
    return 'Hello'

if __name__ == '__main__':
    # 使用默认IP 127.0.0.1 , 默认端口 5000, debug 模式  
    func()

```

运行效果：

![](\pic\5.jpg)



#### 2.1 `tcpdump` 抓包

`tcpdump` 命令，`-i` 指定网络接口， `lo` 表示`localhost` ； `-X`表示将数据以16进制和ASCII码显示 

```bash
# 命令详情， `mam tcpdump` 查看

```

本地网络接口可通过 `ip addr` 进行查看

![](\pic\2.jpg)

![](\pic\3.jpg)

![](\pic\4.jpg)

【**数据包分析**】

状态位`flag` 的值，S 表示 `SYN` ，P 表示 `push` ，F 表示 `FIN` 

1. 三次握手
2. 客户端发送 `get` 请求，服务端回复`ack`
3. 服务端发送 `http` 状态码`200` OK，客户端回复`ack`
4. 服务端发送`server` 信息，客户端回复`ack`
5. 服务端回送请求信息`hostname`，客户端回复`ack`
6. 客户端请求断开连接，`FIN` 位置1
7. 服务端回复`ack` 同时请求断开连接
8. 客户端回复 `ack` 

>注意到在所抓取的报文中，tcp 四次挥手的过程被压缩到了三次，过程与三次握手类似。
>
>
