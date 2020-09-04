FROM debian:stretch

RUN apt update && \
    apt -y upgrade && \
    apt -y install curl wget software-properties-common gnupg2 apt-transport-https

# Java
RUN wget -qO - https://adoptopenjdk.jfrog.io/adoptopenjdk/api/gpg/key/public | apt-key add -
RUN add-apt-repository --yes https://adoptopenjdk.jfrog.io/adoptopenjdk/deb/
RUN apt update
RUN apt -y install adoptopenjdk-11-hotspot

# Azure Application Insights
ENV APPLICATION_INSIGHTS_VERSION=3.0.0-PREVIEW.6
RUN wget -P "/opt/application-insights/application-insights.jar" "https://github.com/microsoft/ApplicationInsights-Java/releases/download/${APPLICATION_INSIGHTS_VERSION}/applicationinsights-agent-${APPLICATION_INSIGHTS_VERSION}.jar"

COPY ApplicationInsights.json /opt/application-insights/ApplicationInsights.json
COPY application/build/libs/application-1.0.0-all.jar /opt/app/ktor-debug.jar

ENTRYPOINT exec java $JAVA_OPTS -jar /opt/app/ktor-debug.jar