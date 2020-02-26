#keystore password: changeit

keytool -genkeypair -alias tomcat   -keyalg RSA -keysize 2048 -keystore certstore.jks -validity 3650
#keytool -genkeypair -alias baeldung -keyalg RSA -keysize 2048 -keystore baeldung.jks  -validity 3650

keytool -importkeystore -srckeystore certstore.jks -destkeystore ccerts.p12 -deststoretype pkcs12
