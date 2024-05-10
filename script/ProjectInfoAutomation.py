from typing import NamedTuple  # Import NamedTuple from typing module
import logging
import os
import Config
from SpringControllerRouteGetter import get_route_of_project


class ProjectInfo(NamedTuple):
    Name: str  # name of microservice
    Profile: str  # profile of microservice
    Version: str  # version of microservice
    Directory: str  # source directory of microservice
    Routes: list


Projects = []
__existing_routes = []
for sub_dir in os.listdir(Config.SourceDir):
    makefile = os.path.join(Config.SourceDir, sub_dir, "Makefile")
    if not os.path.isfile(makefile):
        logging.warning(f"Failed to get Makefile: {makefile}")
        continue
    name = ''
    version = ''
    profile = ''
    with open(makefile, 'r', encoding='utf8') as f:
        for line in f:
            if line.startswith("APP_NAME"):
                name = line.split("=")[1].strip()
            if line.startswith("VERSION"):
                version = line.split("=")[1].strip()
            if line.startswith("PROFILE"):
                profile = line.split("=")[1].strip()
    if len(name) == 0 or len(version) == 0 or len(profile) == 0:
        logging.warning(f"Bad Makefile: {makefile}")
        continue
    routes = get_route_of_project(os.path.join(Config.SourceDir, sub_dir))
    for route in routes:
        if route in __existing_routes:
            print(f"Warning: found duplicate route {route} in project {sub_dir}")
    __existing_routes += routes
    directory = os.path.join(Config.SourceDir, sub_dir)
    Projects.append(ProjectInfo(Name=name, Profile=profile,
                                Version=version, Directory=directory, Routes=routes))

if __name__ == "__main__":
    print(Projects)
