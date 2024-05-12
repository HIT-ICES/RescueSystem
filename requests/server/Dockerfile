# 使用官方 Python 镜像作为基础镜像
FROM python:3.8-slim-buster

# 设置工作目录
WORKDIR /app

# 将当前目录的内容复制到工作目录中
COPY build/script/ /app/script/
COPY build/requests/ /app/requests/

COPY Config.py /app/script/

COPY requirements.txt /app



# 安装依赖
RUN pip install --no-cache-dir -r requirements.txt

# 运行脚本
CMD ["python", "/app/script/RequestServer.py"]