FROM openjdk:8-alpine

# Set destination for COPY
WORKDIR /app

COPY ./target/gateway.jar .

# 入口（启动服务）
ENTRYPOINT java -jar gateway.jar