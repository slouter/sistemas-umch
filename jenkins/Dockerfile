FROM jenkins/jenkins:lts

USER root

RUN apt-get update && \
    apt-get install -y docker.io git && \
    usermod -aG docker jenkins && \
    apt-get clean

USER jenkins

COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli --plugin-file /usr/share/jenkins/ref/plugins.txt

EXPOSE 8080