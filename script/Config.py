import os

DockerRepo = '192.168.1.199:5000/rescue-system-2024'
Namespace = 'rescue-system-redive'
ProjectRoot = '..'


__current_file_path = os.path.abspath(__file__)
__current_dir_path = os.path.dirname(__current_file_path)
__project_root = os.path.join(__current_dir_path, ProjectRoot)


SourceDir = os.path.join(__project_root, 'src')
GatewayTemplate = os.path.join(__project_root, 'gateway/nginx.conf.template')
Gateway = os.path.join(__project_root, '/gateway/nginx.conf')
