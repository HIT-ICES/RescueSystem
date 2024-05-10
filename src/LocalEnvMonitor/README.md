# `LocalEnvMonitor`

边缘测局部环境变化监控服务

## API说明
### `/envmonitor/getByEnvInfoId`
通过数据ID获取环境数据信息
#### Input
`EnvInfoIdBean`
#### Output
`MResponse`

| Parameter | Description                  |
|-----------|------------------------------|
| code      | 0 for success, 1 for failure |
| data      | EnvInfoBean                  |

### `/envmonitor/getByPeriod`
通过起止日期获取环境数据信息
#### Input
`EnvInfoPeriodBean`
#### Output
`MResponse`

| Parameter | Description                  |
|-----------|------------------------------|
| code      | 0 for success, 1 for failure |
| data      | List\<EnvInfoBean\>          |
