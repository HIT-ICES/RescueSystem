from ProjectInfoAutomation import Projects, ProjectInfo
import Config
import json

[
  {
    "id": "string",
    "name": "string",
    "repo": "string",
    "imageUrl": "string",
    "version": {
      "major": "string",
      "minor": "string",
      "patch": "string"
    },
    "swaggerUrl": "string",
    "idleResource": {
      "cpu": 0,
      "ram": 0,
      "disk": 0,
      "gpuCore": 0,
      "gpuMem": 0
    },
    "desiredResource": {
      "cpu": 0,
      "ram": 0,
      "disk": 0,
      "gpuCore": 0,
      "gpuMem": 0
    },
    "desiredCapability": 0
  }
]

def get_service_from_project(project:ProjectInfo):
    version=project.Version.split('.',3)
    if len(version) != 3:
        version+=["0"]*(3-len(version) )
    return {
    "id": f"{Config.Namespace}/{project.Name}",
    "name": f"{Config.Namespace}/{project.Name}",
    "repo": "https://github.com/HIT-ICES/RescueSystem",
    "imageUrl": f"{Config.DockerRepo}/{project.Name}:v{project.Version}",
    "version": {
      "major": version[0],
      "minor": version[1],
      "patch": version[2]
    },
    "swaggerUrl": f"http://{project.Name}.{Config.Namespace}.svc.cluster.local/v2/api-docs",
    "idleResource": {
      "cpu": 0,
      "ram": 0,
      "disk": 0,
      "gpuCore": 0,
      "gpuMem": 0
    },
    "desiredResource": {
      "cpu": 0,
      "ram": 0,
      "disk": 0,
      "gpuCore": 0,
      "gpuMem": 0
    },
    "desiredCapability": 0
  }

services=[get_service_from_project(project) for project in Projects]

print(json.dumps(services, indent=4, sort_keys=True))
