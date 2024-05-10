基于 ImageAI 的图像识别，通过 flask 包装成 API 以供 Java 程序调用，传输的图片为 base64 转码后的字符串。

* docker 镜像：septemberhx/imagai-java:v1.2
  * python3.6
  * java-8
  * 工作目录 `/app`，内有必须的模型数据
