FROM java:8
VOLUME /tmp
#springbootEureka-1.0-SNAPSHOT.jar本项目打得包  eureka.jar docker里的包
ADD target/drug-server-1.0-SNAPSHOT.jar drug-server.jar
#如果不想在打入docker时运行项目则不需要这行
RUN bash -c 'touch /drug-server.jar'
ENTRYPOINT ["java","-jar","/drug-server.jar","--spring.profiles.active=prod"]
EXPOSE 12001