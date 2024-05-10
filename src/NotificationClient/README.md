## NotificationServiceServer 

通知服务端



- /client ： 主要是对用户提供接口

  | 路径            | 输入              | 输出 | 功能               | 方法 |
  | --------------- | ----------------- | ---- | ------------------ | ---- |
  | /receiveMessage | notice实体信息类  | 结果 | 接收信息           | Post |
  | /sendMessage    | notice实体信息类  | 结果 | 发送信息           | Post |
  | /radioToCLient  | Message实体信息类 |      | 广播所有的客户端   | Post |
  | /radioToServer  | Message实体信息类 |      | 广播所有的服务端   | Post |
  | /seeClients     | 无                |      | 查看可以通信的对象 | Get  |
  |                 |                   |      |                    |      |
  |                 |                   |      |                    |      |