FROM java:8

MAINTAINER  François Templier <francois.templier@st-groupe.fr>

## Versions
#
ENV GROOVY_VERSION 2.3.9
ENV GRADLE_VERSION 2.2.1
ENV MAVEN_VERSION 3.2.5

## Maven environment variables
#
ENV M2_HOME /usr/local/apache-maven/apache-maven-$MAVEN_VERSION
ENV M2 $M2_HOME/bin
ENV PATH /usr/local/apache-maven/apache-maven-$MAVEN_VERSION/bin:$PATH


## groovy and gradle install
#
RUN curl -s get.gvmtool.net | bash
RUN bash -c "source ~/.gvm/bin/gvm-init.sh && gvm install groovy $GROOVY_VERSION; exit 0"
RUN bash -c "source ~/.gvm/bin/gvm-init.sh && gvm install gradle $GRADLE_VERSION; exit 0"

## maven install
#
RUN mkdir -p /usr/local/apache-maven \
  && curl -s http://apache.websitebeheerjd.nl/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz \
     | tar -zxC /usr/local/apache-maven


## set work directory
#
WORKDIR /root/