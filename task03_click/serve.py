
# -*- coding: UTF-8 -*-

from flask import Flask
import click

# Flask 类实例化
app = Flask(__name__)
# 环境： production, development, testing   
app.config['ENV'] = 'development'
app.config['DEBUG'] = True 

# 定义全局量
NAME = ''

@click.command()
@click.option('--hostname', default = 'Alice', help='Specify server name')
def func(hostname): 
    # click.echo('I am %s' %hostname)
    global NAME
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
    # app.run()
    func()

