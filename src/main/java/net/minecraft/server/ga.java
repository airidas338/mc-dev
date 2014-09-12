package net.minecraft.server;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.util.Iterator;
import java.util.UUID;

public final class ga {

   public static GameProfile a(fn var0) {
      String var1 = null;
      String var2 = null;
      if(var0.b("Name", 8)) {
         var1 = var0.j("Name");
      }

      if(var0.b("Id", 8)) {
         var2 = var0.j("Id");
      }

      if(vb.b(var1) && vb.b(var2)) {
         return null;
      } else {
         UUID var3;
         try {
            var3 = UUID.fromString(var2);
         } catch (Throwable var12) {
            var3 = null;
         }

         GameProfile var4 = new GameProfile(var3, var1);
         if(var0.b("Properties", 10)) {
            fn var5 = var0.m("Properties");
            Iterator var6 = var5.c().iterator();

            while(var6.hasNext()) {
               String var7 = (String)var6.next();
               fv var8 = var5.c(var7, 10);

               for(int var9 = 0; var9 < var8.c(); ++var9) {
                  fn var10 = var8.b(var9);
                  String var11 = var10.j("Value");
                  if(var10.b("Signature", 8)) {
                     var4.getProperties().put(var7, new Property(var7, var11, var10.j("Signature")));
                  } else {
                     var4.getProperties().put(var7, new Property(var7, var11));
                  }
               }
            }
         }

         return var4;
      }
   }

   public static fn a(fn var0, GameProfile var1) {
      if(!vb.b(var1.getName())) {
         var0.a("Name", var1.getName());
      }

      if(var1.getId() != null) {
         var0.a("Id", var1.getId().toString());
      }

      if(!var1.getProperties().isEmpty()) {
         fn var2 = new fn();
         Iterator var3 = var1.getProperties().keySet().iterator();

         while(var3.hasNext()) {
            String var4 = (String)var3.next();
            fv var5 = new fv();

            fn var8;
            for(Iterator var6 = var1.getProperties().get(var4).iterator(); var6.hasNext(); var5.a((gd)var8)) {
               Property var7 = (Property)var6.next();
               var8 = new fn();
               var8.a("Value", var7.getValue());
               if(var7.hasSignature()) {
                  var8.a("Signature", var7.getSignature());
               }
            }

            var2.a(var4, (gd)var5);
         }

         var0.a("Properties", (gd)var2);
      }

      return var0;
   }
}
