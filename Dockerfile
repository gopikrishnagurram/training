FROM java:8
ADD target/otp.jar otp.jar
CMD [ "java",  "-jar", "/otp.jar" ]
