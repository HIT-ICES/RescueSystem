## 救援人员信息中心
- 提供救援人员物理状态管理的功能，记录每条上报信息（时间，地点，状态）
- 如救援人员状态发生变化，调用救援人员信息管理的接口更新状态

## API
### `/rescuerstatus/add`
add a rescuerStatus record
#### Input
rescuerId, location, status, desc,
#### Output
`MResponse`

| Parameter | Description                  |
| --------- | ---------------------------- |
| code      | 0 for success, 1 for failure |
| data      | RescuerStatus 

### `/rescuerstatus/getAllByRescuerId`
get all rescuer data by rescuer id
#### Input
RescuerIdBean
#### Output
`MResponse`

| Parameter | Description                  |
| --------- | ---------------------------- |
| code      | 0 for success, 1 for failure |
| data      | rescuer list  

### `/rescuerstatus/getAllByRescuerIdBetweenDate`
get all rescuer data by rescuer id between start and end date
#### Input
rescuerId, startDate, endDate
#### Output
`MResponse`

| Parameter | Description                  |
| --------- | ---------------------------- |
| code      | 0 for success, 1 for failure |
| data      | rescuer list 

### `/rescuerstatus/deleteById`
delete rescuerStatus record by id
#### Input
id
#### Output
`MResponse`

| Parameter | Description                  |
| --------- | ---------------------------- |
| code      | 0 for success, 1 for failure |

### `/rescuerstatus/deleteByRescuerId`
delete rescuerStatus record by rescuer id
#### Input
rescuerId
#### Output
`MResponse`

| Parameter | Description                  |
| --------- | ---------------------------- |
| code      | 0 for success, 1 for failure |

 