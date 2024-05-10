#!/usr/bin/env python
# -*- coding: UTF-8 -*-

"""
@Project ：image_ai 
@File ：main.py
@Author ：septemberhx
@Date ：2021/10/21
@Description:
"""
import json
import base64
import uuid

from imageai.Detection import ObjectDetection
import os
from flask import Flask, request, jsonify

app = Flask(__name__)
execution_path = os.getcwd()
detector = ObjectDetection()
detector.setModelTypeAsRetinaNet()
detector.setModelPath(os.path.join(execution_path, "resnet50_coco_best_v2.1.0.h5"))
detector.loadModel()


@app.route('/imageai/detect', methods=['POST'])
def detect():
    if request.method == 'POST':
        data_json = json.loads(request.data.decode('utf-8'))
        if 'img' in data_json:
            raw_img_base64 = data_json['img']  # type: str
            if ',' in raw_img_base64:
                raw_img_base64 = raw_img_base64[raw_img_base64.index(',') + 1:]
            img = base64.b64decode(raw_img_base64)
            img_name = f'{uuid.uuid1()}'
            img_file_name = f'{img_name}.jpg'
            img_processed_file_name = f'{img_name}_processed.jpg'
            with open(img_file_name, 'wb') as f:
                f.write(img)
            detections = detector.detectObjectsFromImage(input_image=img_file_name,
                                                         output_image_path=img_processed_file_name)
            for eachObject in detections:
                print(eachObject["name"], eachObject["percentage_probability"])
            os.remove(img_file_name)
            with open(img_processed_file_name, 'rb') as f:
                img_base64 = base64.b64encode(f.read())
            os.remove(img_processed_file_name)
            return jsonify({"img": img_base64.decode('utf-8')})
    return jsonify({"code": 0})


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=12345)
