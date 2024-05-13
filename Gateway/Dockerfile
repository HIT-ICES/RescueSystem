# 使用 Nginx 官方镜像作为基础镜像
FROM nginx

# 复制自定义的 Nginx 配置文件到容器
COPY nginx.conf /etc/nginx/nginx.conf

# 暴露容器的 80 端口
EXPOSE 80

# 启动 Nginx
CMD ["nginx", "-g", "daemon off;"]
