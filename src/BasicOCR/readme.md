# BasicOCR

## API

### `/ocr/rec`

Do ocr to one image and return the result

#### Input

POST + JSON

| Parameter | Description |
|---|---|
| lang | OCR language; only "chi_sim, chi_tra, eng" are supported |
| data | the image data encoded with Base64 |

#### Output

`MResponse<OCROnceResultBean>`

| Parameter | Description |
|---|---|
| text | OCR result. it will be empty if error happens |
| errorCode | error code. 0 stands success |

### `/ocr/recList`

Do ocr to an image list and result the results

#### Input

POST + JSON

| Parameter | Description |
|---|---|
| lang | OCR language; only "chi_sim, chi_tra, eng" are supported |
| dataList | the image data list. each of them is encoded with Base64 |

#### Output

`MResponse<OCRMultiResultBean>`

| Parameter | Description |
|---|---|
| textList | OCR results. it will be empty if error happens |
| errorCode | error code. 0 stands success |