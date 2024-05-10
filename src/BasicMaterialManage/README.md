该模板集成了 gitlab cli 配置，具体见 `.gitlab-cli` 配置文件。主要包含以下功能：

1. 自动测试
2. 代码质量检测（192.168.1.102:9000）
3. 自动构建
4. 镜像打包，并推送到 192.168.1.102:5000

> 每次提交后都会触发上述流程。在gitlab项目页面左侧的 CI/CD 即可查看。请务必确保 CI 通过。通过之后即可直接从 192.168.1.102:5000 上拉取镜像进行测试。

具体详情请见配置文件。

## 物资数据管理服务
为用户提供管理物资数据的功能，物资为抽象物资，只考虑数量的变化
- 物资管理
- 物资变更记录管理

## API
### `/material/getAll`
get all material data
#### Input
no parameter
#### Output
`MResponse`

| Parameter | Description                  |
| --------- | ---------------------------- |
| code      | 0 for success, 1 for failure |
| data      | material list                |

### `/material/getById`

get material data by material id

#### Input

`MaterialUserBean`

| Parameter    | Description |
| ------------ | ----------- |
| `materialId` | material id |
| `userId`     | user id     |

#### Output

`MResponse`

| Parameter | Description                  |
| --------- | ---------------------------- |
| code      | 0 for success, 1 for failure |
| data      | material                     |
| message   | fail reason                  |

### `/material/add`

add material

#### Input

`MaterialBean`

| Parameter | Description                       |
| --------- | --------------------------------- |
| `name`    | material name                     |
| `desc`    | description of material, optional |
| `number`  | number of material                |
| `userId`  | user id                           |

#### Output

`MResponse`

| Parameter    | Description                  |
| ------------ | ---------------------------- |
| code         | 0 for success, 1 for failure |
| message      | fail reason                  |
| `materialId` | record id                    |

### `/material/put`

improve material number

#### Input

`MaterialNumBean`

| Parameter    | Description                     |
| ------------ | ------------------------------- |
| `materialId` | material id                     |
| `number`     | number of material to be putted |
| `userId`     | user id                         |

#### Output

`MResponse`

| Parameter | Description                  |
| --------- | ---------------------------- |
| code      | 0 for success, 1 for failure |
| message   | fail reason                  |

### `/material/take`

reduce material number

#### Input

`MaterialNumBean`

| Parameter    | Description                   |
| ------------ | ----------------------------- |
| `materialId` | material id                   |
| `number`     | number of material to be take |
| `userId`     | user id                       |

#### Output

`MResponse`

| Parameter | Description                  |
| --------- | ---------------------------- |
| code      | 0 for success, 1 for failure |
| message   | fail reason                  |

### `/material/deleteById`

delete material by id

#### Input

`MaterialUserBean`

| Parameter    | Description |
| ------------ | ----------- |
| `materialId` | material id |
| `userId`     | user id     |

#### Output

`MResponse`

| Parameter | Description                  |
| --------- | ---------------------------- |
| code      | 0 for success, 1 for failure |
| message   | fail reason                  |

### `/materialRecord/getByRecordId`

get `materialRecord` by id

#### Input

`RecordIdBean`

| Parameter  | Description |
| ---------- | ----------- |
| `recordId` | record id   |

#### Output

`MResponse`

| Parameter | Description                  |
| --------- | ---------------------------- |
| code      | 0 for success, 1 for failure |
| message   | fail reason                  |
| data      | record                       |

### `/materialRecord/getAllByOptUserId`

get `materialRecord` by `optUserId`

#### Input

`RecordOptBean`

| Parameter | Description |
| --------- | ----------- |
| `userId`  | user id     |

#### Output

`MResponse`

| Parameter | Description                  |
| --------- | ---------------------------- |
| code      | 0 for success, 1 for failure |
| message   | fail reason                  |
| data      | record list                  |

### `/materialRecord/getAllByOptUserIdAndDate`

get `materialRecord` by `optUserId` and create time between start and end

#### Input

`RecordOptDateBean`

| Parameter | Description |
| --------- | ----------- |
| `userId`  | user id     |
| start     | start date  |
| end       | end date    |

#### Output

`MResponse`

| Parameter | Description                  |
| --------- | ---------------------------- |
| code      | 0 for success, 1 for failure |
| message   | fail reason                  |
| data      | record list                  |

### `/materialRecord/deleteById`

delete`materialRecord` by id

#### Input

`RecordIdBean`

| Parameter  | Description |
| ---------- | ----------- |
| `recordId` | record id   |

#### Output

`MResponse`

| Parameter | Description                  |
| --------- | ---------------------------- |
| code      | 0 for success, 1 for failure |
| message   | fail reason                  |

### `/materialRecord/deleteByOptUserId`

delete`materialRecord` by `OptUserId`

#### Input

`RecordOptBean`

| Parameter | Description |
| --------- | ----------- |
| `userId`  | user id     |

#### Output

`MResponse`

| Parameter | Description                  |
| --------- | ---------------------------- |
| code      | 0 for success, 1 for failure |
| message   | fail reason                  |

