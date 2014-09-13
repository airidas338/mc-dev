package net.minecraft.server;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GenericAttributes {

   private static final Logger f = LogManager.getLogger();
   public static final IAttribute a = (new yg((IAttribute)null, "generic.maxHealth", 20.0D, 0.0D, Double.MAX_VALUE)).a("Max Health").a(true);
   public static final IAttribute b = (new yg((IAttribute)null, "generic.followRange", 32.0D, 0.0D, 2048.0D)).a("Follow Range");
   public static final IAttribute c = (new yg((IAttribute)null, "generic.knockbackResistance", 0.0D, 0.0D, 1.0D)).a("Knockback Resistance");
   public static final IAttribute d = (new yg((IAttribute)null, "generic.movementSpeed", 0.699999988079071D, 0.0D, Double.MAX_VALUE)).a("Movement Speed").a(true);
   public static final IAttribute e = new yg((IAttribute)null, "generic.attackDamage", 2.0D, 0.0D, Double.MAX_VALUE);


   public static fv a(AttributeMapBase var0) {
      fv var1 = new fv();
      Iterator var2 = var0.a().iterator();

      while(var2.hasNext()) {
         AttributeInstance var3 = (AttributeInstance)var2.next();
         var1.a((NBTBase)a(var3));
      }

      return var1;
   }

   private static NBTTagCompound a(AttributeInstance var0) {
      NBTTagCompound var1 = new NBTTagCompound();
      IAttribute var2 = var0.a();
      var1.a("Name", var2.a());
      var1.a("Base", var0.b());
      Collection var3 = var0.c();
      if(var3 != null && !var3.isEmpty()) {
         fv var4 = new fv();
         Iterator var5 = var3.iterator();

         while(var5.hasNext()) {
            ya var6 = (ya)var5.next();
            if(var6.e()) {
               var4.a((NBTBase)a(var6));
            }
         }

         var1.a("Modifiers", (NBTBase)var4);
      }

      return var1;
   }

   private static NBTTagCompound a(ya var0) {
      NBTTagCompound var1 = new NBTTagCompound();
      var1.a("Name", var0.b());
      var1.a("Amount", var0.d());
      var1.a("Operation", var0.c());
      var1.a("UUIDMost", var0.a().getMostSignificantBits());
      var1.a("UUIDLeast", var0.a().getLeastSignificantBits());
      return var1;
   }

   public static void a(AttributeMapBase var0, fv var1) {
      for(int var2 = 0; var2 < var1.c(); ++var2) {
         NBTTagCompound var3 = var1.b(var2);
         AttributeInstance var4 = var0.a(var3.j("Name"));
         if(var4 != null) {
            a(var4, var3);
         } else {
            f.warn("Ignoring unknown attribute \'" + var3.j("Name") + "\'");
         }
      }

   }

   private static void a(AttributeInstance var0, NBTTagCompound var1) {
      var0.a(var1.i("Base"));
      if(var1.b("Modifiers", 9)) {
         fv var2 = var1.c("Modifiers", 10);

         for(int var3 = 0; var3 < var2.c(); ++var3) {
            ya var4 = a(var2.b(var3));
            if(var4 != null) {
               ya var5 = var0.a(var4.a());
               if(var5 != null) {
                  var0.c(var5);
               }

               var0.b(var4);
            }
         }
      }

   }

   public static ya a(NBTTagCompound var0) {
      UUID var1 = new UUID(var0.g("UUIDMost"), var0.g("UUIDLeast"));

      try {
         return new ya(var1, var0.j("Name"), var0.i("Amount"), var0.f("Operation"));
      } catch (Exception var3) {
         f.warn("Unable to create attribute: " + var3.getMessage());
         return null;
      }
   }

}
