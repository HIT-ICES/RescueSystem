## BasicUser

用户微服务



/user

| 路径             | 输入     | 输出     | 功能           | 方式   |
| ---------------- | -------- | -------- | -------------- | ------ |
| /welcome         |          |          |                |        |
| /get/{userId}    | userID   | 用户信息 | 得到用户信息   | Get    |
| /add             | 用户信息 | 添加结果 | 添加用户       | Post   |
| /remove/{userId} | userID   | 删除结果 | 删除某一个用户 | Delete |
