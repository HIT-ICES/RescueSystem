import os


def get_route_of_project(project_root):
    pkg_dir = 'src/main/java/com/hitices'
    pkg_name = os.listdir(os.path.join(project_root, pkg_dir))[0]
    routes = []
    controller_dir=os.path.join(project_root, pkg_dir, pkg_name, "controller")
    for controller_file in os.listdir(controller_dir):
        with open( os.path.join(controller_dir, controller_file), 'r',encoding="utf8" ) as controller:
            for line in controller:
                line=line.strip()
                if line.startswith('@RequestMapping('):
                    routes.append( line.split('"')[1])
    return routes

if __name__ == '__main__':
    existing_routes=[]
    for project_root in os.listdir("src"):
        routes=get_route_of_project(os.path.join("src" ,project_root))
        for route in routes:
            if route in existing_routes:
                print(f"Warning: found duplicate route {r} in project {project_root}")
        existing_routes+=routes
        print(f"{project_root}: {routes}")