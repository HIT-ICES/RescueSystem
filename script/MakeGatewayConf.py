from ProjectInfoAutomation import Projects
import Config

with open(Config.GatewayTemplate, 'r', encoding='utf8') as gateway:
    origin = "\n".join(gateway.readlines())

tmpl_prefix = ' '*8


def build_proxy_of_swagger(server):
    return [
        f'{tmpl_prefix}location /swagger/{server} {{',
        f'{tmpl_prefix}    proxy_pass http://{server}:8080/;',
        f'{tmpl_prefix}    proxy_set_header x-b3-traceid $http_x_b3_traceid;',
        f'{tmpl_prefix}    proxy_set_header x-b3-spanid $http_x_b3_spanid;',
        f'{tmpl_prefix}    proxy_set_header x-b3-parentspanid $http_x_b3_parentspanid;',
        f'{tmpl_prefix}    proxy_set_header x-b3-sampled $http_x_b3_sampled;',
        f'{tmpl_prefix}    proxy_set_header x-b3-flags $http_x_b3_flags;',
        f'{tmpl_prefix}    proxy_set_header uber-trace-id $http_uber_trace_id;',
        f'{tmpl_prefix}}}',
        ''
    ]


def build_proxy_of_route(route, server):
    if not route.startswith('/'):
        route = '/' + route
    return [
        f'{tmpl_prefix}location {route} {{',
        f'{tmpl_prefix}    proxy_pass http://{server}:8080;',
        f'{tmpl_prefix}    proxy_set_header x-b3-traceid $http_x_b3_traceid;',
        f'{tmpl_prefix}    proxy_set_header x-b3-spanid $http_x_b3_spanid;',
        f'{tmpl_prefix}    proxy_set_header x-b3-parentspanid $http_x_b3_parentspanid;',
        f'{tmpl_prefix}    proxy_set_header x-b3-sampled $http_x_b3_sampled;',
        f'{tmpl_prefix}    proxy_set_header x-b3-flags $http_x_b3_flags;',
        f'{tmpl_prefix}    proxy_set_header uber-trace-id $http_uber_trace_id;',
        f'{tmpl_prefix}}}',
        ''
    ]


proxy_pass = [""]

for project in Projects:
    proxy_pass += build_proxy_of_swagger(project.Name)
    for route in project.Routes:
        proxy_pass += build_proxy_of_route(route, project.Name)

origin = origin.replace("$$PROXY_PASS$$", "\n".join(proxy_pass))

with open(Config.Gateway, 'w', encoding='utf8') as gateway:
    gateway.write(origin)
