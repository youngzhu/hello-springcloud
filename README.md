## v0.0.1
两个服务可独立运行

问题：
订单服务无法获得用户基本信息

## v0.1.0
实现：查询订单时，将用户的基本信息一起返回

- 利用RestTemplate发起HTTP请求，获取用户信息

## v0.2.0-eureka
引入Eureka

- 搭建Eureka Server
  1. 引入eureka-server依赖
  2. 启动类添加 @EnableEurekaServer 注解
  3. 在 application.yml 配置 Eureka 的服务信息
- 注册服务
  1. 引入eureka-client依赖
  2. 在 application.yml 配置文件中添加Eureka的服务地址和自己的服务名称
- 使用服务
  1. 将原来调用服务时的IP+端口换成对应的服务名称
  2. 在RestTemplate上添加 @LoadBalanced 注解

## v0.3.0-nacos
使用Nacos

不用修改源代码，改配置文件即可，将 Eureka 换成 Nacos

- 服务注册与查找
  1. 引入 nacos 依赖包（pom.xml）
  2. 添加 nacos 服务地址（application.yml）
- Nacos服务分级存储模型
  1. 一级是服务，例如 userservice
  2. 二级是集群，例如 HZ 或 SH
  3. 三级是实例
- 集群属性
  - application.yml 中添加 `spring.cloud.nacos.discovery.cluster-name` 属性
  - 在没有配置负载均衡策略的情况下，即使有集群，还是轮巡调用
- 负载均衡
  - NacosRule，优先访问本集群的服务。如果有多个服务，采用*随机*的方式访问
  - 如果本集群内没有可用的服务，则会访问其他集群的服务