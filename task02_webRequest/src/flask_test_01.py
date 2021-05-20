#  返回显示'Hello world'的  web页面

from flask import Flask

## Flask 类实例化
app = Flask(__name__)

@app.route('/')
def hello_world():
    return '<h1>Hello World</h1>'

if __name__ == '__main__':
    # 使用默认IP 127.0.0.1 , 默认端口 5000
    app.run(host = '127.0.0.1', port = 5000)
    