FROM openjdk:8-jre

# (Optional / Best pratices) Author
MAINTAINER "Solirius Ltd. <https://github.com/Solirius>"
LABEL maintainer = "Solirius Ltd. <https://github.com/Solirius>"

# (Optional set your working directory need to all ready exist)
WORKDIR /opt/app

# Copy over the app
COPY build/install/solirius-springboot-bolierplate .

# No idea
HEALTHCHECK --interval=10s --timeout=10s --retries=10 CMD http_proxy="" curl --silent --fail http://localhost:8080/health

# Ports
EXPOSE 8080 5005

ENTRYPOINT ["bin/solirius-springboot-bolierplate"]
