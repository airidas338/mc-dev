package net.minecraft.server;

public class anq extends alq {

   public anq() {
      this.c(1);
   }

   public amj a(amj var1, World var2, EntityHuman var3) {
      var3.a(var1);
      var3.b(ty.J[alq.b((alq)this)]);
      return var1;
   }

   public static boolean b(fn var0) {
      if(var0 == null) {
         return false;
      } else if(!var0.b("pages", 9)) {
         return false;
      } else {
         fv var1 = var0.c("pages", 8);

         for(int var2 = 0; var2 < var1.c(); ++var2) {
            String var3 = var1.f(var2);
            if(var3 == null) {
               return false;
            }

            if(var3.length() > 32767) {
               return false;
            }
         }

         return true;
      }
   }
}
