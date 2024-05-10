# 删除容器（如果有）
docker rm -f mss_rescuerInfoManage
# 拉取更新镜像
docker pull 192.168.1.102:5000/mss/rescuerinfomanage@sha256:7e47d0451ee071a30c1647233b6bab768842d3ae1b3db4df9ef35ec0b3e6ae16
# 创建启动 mysql 容器
docker run --name mss_rescuerDB -e MYSQL_ROOT_PASSWORD=root -d -p 3311:3306 mysql:5.7
# 启动 vqcmsmodel 容器
docker run -d -p 16037:8080 --name mss_rescuerInfoManage --link mss_rescuerDB 192.168.1.102:5000/mss/rescuerinfomanage:last_ci
