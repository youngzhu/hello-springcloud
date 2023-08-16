FROM openjdk:8-alpine

# Set destination for COPY
WORKDIR /app

COPY ./target/order-service.jar .

# 入口（启动服务）
ENTRYPOINT java -jar order-service.jar