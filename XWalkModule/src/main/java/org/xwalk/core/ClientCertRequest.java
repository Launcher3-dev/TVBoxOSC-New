package org.xwalk.core;

import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.List;

public interface ClientCertRequest {
   void cancel();

   void proceed(PrivateKey var1, List<X509Certificate> var2);

   void ignore();

   String getHost();

   int getPort();

   String[] getKeyTypes();

   Principal[] getPrincipals();


}
