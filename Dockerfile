FROM debian:7

MAINTAINER  François Templier <francois.templier@st-groupe.fr>

## Versions
#
ENV GROOVY_VERSION 2.3.9
ENV GRADLE_VERSION 2.2.1
ENV MAVEN_VERSION 3.2.5
ENV JAVA_VERSION 1.8.0_25
ENV JDK_VERSION 8u25
ENV JDK_PACKAGE 8u25-b17

## Maven environment variables
#
ENV M2_HOME /usr/local/apache-maven/apache-maven-$MAVEN_VERSION
ENV M2 $M2_HOME/bin

## Java environment variables
#
ENV JAVA_HOME /usr/local/java/jdk$JAVA_VERSION

## Path
#
ENV PATH $JAVA_HOME/bin:$M2:$PATH

## Install cURL, unzip
#
RUN apt-get update \
  && apt-get -y install curl \
                        unzip \
  && apt-get clean \
  && rm -rf /var/lib/apt/lists/*

## Groovy and gradle install
#
RUN curl -s get.gvmtool.net | bash
RUN bash -c "source ~/.gvm/bin/gvm-init.sh && gvm install groovy $GROOVY_VERSION; exit 0"
RUN bash -c "source ~/.gvm/bin/gvm-init.sh && gvm install gradle $GRADLE_VERSION; exit 0"

## Maven install
#
RUN mkdir -p /usr/local/apache-maven \
  && curl -s http://www.us.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz \
     | tar -zxC /usr/local/apache-maven

## Java install
#
RUN mkdir -p /usr/local/java \
  && curl -sjkLH "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/$JDK_PACKAGE/jdk-$JDK_VERSION-linux-x64.tar.gz \
    | tar -zxC /usr/local/java
