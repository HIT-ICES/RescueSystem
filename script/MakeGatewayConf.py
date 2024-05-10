from ProjectInfoAutomation import Projects
import Config

with open(Config.GatewayTemplate, 'r', encoding='utf8') as gateway:
    origin = gateway.readall()

tmpl_prefix = ' '*8


def build_proxy_of_route(route, server):
    lines=[]
    lines.append(f'')
# location /api/ {
#     proxy_pass http://127.0.0.1:3000/;
# }
