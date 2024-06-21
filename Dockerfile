FROM openjdk:17-oracle

ENV APP_DIR /app
ENV JAVA_OPTS ""

COPY ./build/libs/shop-test-task-1.0-SNAPSHOT.jar ${APP_DIR}/app.jar

WORKDIR ${APP_DIR}

CMD exec java ${JAVA_OPTS} -jar ${APP_DIR}/app.jar