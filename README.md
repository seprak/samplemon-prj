# Build
mvn clean package && docker build -t com.vsprk/samplemon .

# RUN

docker rm -f samplemon || true && docker run -d -p 8080:8080 -p 4848:4848 --name samplemon com.vsprk/samplemon 