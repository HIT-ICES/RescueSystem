from flask import Flask
from Requesting import parse_http_file,execute_request
import os
import Config

app = Flask(__name__)

@app.route('/run', methods=['GET'])
def run_request():
    for http_file in os.listdir(Config.RequestsDir):
        _requests = parse_http_file(os.path.join(Config.RequestsDir, http_file))
        for request in _requests:
            execute_request(request)
    return "Requests executed", 200

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8080)