package net.minecraft.server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class pq extends Thread {

   // $FF: synthetic field
   final po a;


   pq(po var1, String var2) {
      super(var2);
      this.a = var1;
   }

   public void run() {
      BufferedReader var1 = new BufferedReader(new InputStreamReader(System.in));

      String var2;
      try {
         while(!this.a.am() && this.a.t() && (var2 = var1.readLine()) != null) {
            this.a.a(var2, (ae)this.a);
         }
      } catch (IOException var4) {
         po.aR().error("Exception handling console input", var4);
      }

   }
}
