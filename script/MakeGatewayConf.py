from ProjectInfoAutomation import Projects
import Config
import yaml


with open(Config.GatewayTemplate, 'r', encoding='utf8') as f:
    kube_conf_map = yaml.safe_load(f)

proxy_conf = yaml.safe_load(kube_conf_map['data']['application.yaml'])

routes = proxy_conf['spring']['cloud']['gateway']['routes']


def build_proxy_of_swagger(server):
    return {
        "id": f'{server}_swagger',
        'uri': f'http://{server}:8080',
        'predicates': [
            f'Path=/swagger/{server}/**'
        ],
        'filters': [
            f'RewritePath=/swagger/{server}/(?<path>.*), /$\{{path}}'
        ]
    }


def build_proxy_of_route(server, routes):

    predicates = [
        f'Path={route}/**' for route in routes
    ]
    return {
        "id": f'{server}_controllers',
        'uri': f'http://{server}:8080',
        'predicates': predicates
    }



for project in Projects:
    route= build_proxy_of_swagger(project.Name)
    if len(route["predicates"])!=0:
        routes.append(route)
    else:
        print("WARNING: empty route predicate: {}".format(project.Name))
    route= build_proxy_of_route(project.Name, project.Routes)
    if len(route["predicates"])!=0:
        routes.append(route)
    else:
        print("WARNING: empty route predicate: {}".format(project.Name))

proxy_conf['spring']['cloud']['gateway']['routes']=routes



kube_conf_map['data']['application.yaml']=yaml.dump(proxy_conf)


with open(Config.Gateway, 'w', encoding='utf8') as gateway:
    yaml.safe_dump(kube_conf_map, gateway)
