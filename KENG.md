# 坑

1. 服务名写错了，导致Nacos的负载均衡达不到预期效果。一个“康师傅”，一个“康帅傅”，找了好久
   ```yaml
   userservice:
     ribbon:
       NFLoadBalancerRuleClassName: com.alibaba.cloud.nacos.ribbon.NacosRule  # 负载均衡规则
   ```