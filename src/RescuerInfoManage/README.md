## 救援人员信息管理
- 提供救援人员信息管理的功能 CURD

## API
### `/rescuer/getAll`
get all rescuer data
#### Input
no parameter
#### Output
`MResponse`

| Parameter | Description                  |
| --------- | ---------------------------- |
| code      | 0 for success, 1 for failure |
| data      | rescuer list  

### `/rescuer/getById`
get rescuer data by id
#### Input
`IdBean`
#### Output
`MResponse`

| Parameter | Description                  |
| --------- | ---------------------------- |
| code      | 0 for success, 1 for failure |
| data      | rescuer
| message   | fail reason

### `/rescuer/add`
add a rescuer
#### Input
`RescuerBean`
#### Output
`MResponse`

| Parameter | Description                  |
| --------- | ---------------------------- |
| code      | 0 for success, 1 for failure |
| data      | rescuer  

### `/rescuer/update`
update a rescuer data
#### Input
`Rescuer`
#### Output
`MResponse`

| Parameter | Description                  |
| --------- | ---------------------------- |
| code      | 0 for success, 1 for failure | 
| message   | fail reason

### `/rescuer/delete`
delete a rescuer data by id
#### Input
`IdBean`
#### Output
`MResponse`

| Parameter | Description                  |
| --------- | ---------------------------- |
| code      | 0 for success, 1 for failure |
| message   | fail reason  

