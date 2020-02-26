#keytool -importcert -file ./zzzzz-bundle.pem \
#-alias mainItem -keystore ./certstore.p12 -storepass changeit


keytool -importcert -file ./ca-bundle.pem \
-alias mainBundle -keystore ./certstore.p12 -storepass changeit