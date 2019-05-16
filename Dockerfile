FROM payara/micro
COPY ./target/samplemon.war $DEPLOY_DIR
EXPOSE 8080