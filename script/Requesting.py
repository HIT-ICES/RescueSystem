import os
import Config
import json
import requests


def parse_http_file(file_path):
    with open(file_path, 'r', encoding='utf8') as file:
        lines = file.readlines()

    requests = []
    request = {}
    json_data = []
    reading_json = False

    for line in lines:
        stripped = line.strip()

        if stripped.startswith('###'):
            if request:
                if json_data:
                    request['data'] = ''.join(json_data)
                    json_data = []
                requests.append(request)
            request = {'description': stripped[3:].strip()}
            reading_json = False
        elif stripped.startswith(('GET', 'POST', 'PUT', 'DELETE')):
            spl = stripped.split(' ')
            if len(spl) != 2:
                print(
                    f'Bad Method/URL line in {file_path} ({len(spl)}): {stripped}')
                continue
            method, url = spl
            request['method'] = method
            request['url'] = url
            reading_json = False
        elif stripped.startswith(('{', '[')) or reading_json:
            json_data.append(stripped)
            reading_json = True
        elif ': ' in stripped and not reading_json:
            spl = stripped.split(': ')
            if len(spl) != 2:
                print(
                    f'Bad Header line in {file_path} ({len(spl)}): {stripped}')
                continue
            key, value = stripped.split(': ')
            if 'headers' in request:
                request['headers'][key] = value
            else:
                request['headers'] = {key: value}
        elif stripped == '':
            continue
        else:
            print(f'Unhandled line in {file_path}: {stripped}')

    if request:
        if json_data:
            request['data'] = ''.join(json_data)
        requests.append(request)

    return requests


def execute_request(request, repeat=10):
    if 'method' not in request:
        print(f'No method in {request}')
        return
    method = request['method']
    url = request['url']
    for place_holder in Config.HttpRequestPlaceHolders:
        url = url.replace(place_holder, Config.Host)

    headers = request.get('headers', {})
    data = request.get('data')

    if data:
        try:
            data = json.loads(data)
        except json.JSONDecodeError:
            pass

    for _ in range(repeat):
        response = requests.request(method, url, headers=headers, json=data)
        print(f"Response for {request['description']} ({method} {url}):")
        print(response.status_code)
        print(response.text)
        print("\n")


if __name__ == '__main__':
    for http_file in os.listdir(Config.RequestsDir):
        _requests = parse_http_file(os.path.join(Config.RequestsDir, http_file))
        for request in _requests:
            execute_request(request)



# import concurrent.futures


# if __name__ == '__main__':
#     requests_data = []
#     for http_file in os.listdir(Config.RequestsDir):
#         requests_data.extend(parse_http_file(os.path.join(Config.RequestsDir, http_file)))

#     with concurrent.futures.ThreadPoolExecutor(max_workers=5) as executor:
#         executor.map(execute_request, requests_data)