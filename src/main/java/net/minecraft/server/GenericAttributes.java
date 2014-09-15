package net.minecraft.server;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GenericAttributes {

   private static final Logger f = LogManager.getLogger();
   public static final IAttribute a = (new AttributeRanged((IAttribute)null, "generic.maxHealth", 20.0D, 0.0D, Double.MAX_VALUE)).a("Max Health").a(true);
   public static final IAttribute b = (new AttributeRanged((IAttribute)null, "generic.followRange", 32.0D, 0.0D, 2048.0D)).a("Follow Range");
   public static final IAttribute c = (new AttributeRanged((IAttribute)null, "generic.knockbackResistance", 0.0D, 0.0D, 1.0D)).a("Knockback Resistance");
   public static final IAttribute d = (new AttributeRanged((IAttribute)null, "generic.movementSpeed", 0.699999988079071D, 0.0D, Double.MAX_VALUE)).a("Movement Speed").a(true);
   public static final IAttribute e = new AttributeRanged((IAttribute)null, "generic.attackDamage", 2.0D, 0.0D, Double.MAX_VALUE);


   public static NBTTagList a(AttributeMapBase var0) {
      NBTTagList var1 = new NBTTagList();
      Iterator var2 = var0.a().iterator();

      while(var2.hasNext()) {
         AttributeInstance var3 = (AttributeInstance)var2.next();
         var1.add((NBTBase)a(var3));
      }

      return var1;
   }

   private static NBTTagCompound a(AttributeInstance var0) {
      NBTTagCompound var1 = new NBTTagCompound();
      IAttribute var2 = var0.a();
      var1.setString("Name", var2.getName());
      var1.setDouble("Base", var0.b());
      Collection var3 = var0.c();
      if(var3 != null && !var3.isEmpty()) {
         NBTTagList var4 = new NBTTagList();
         Iterator var5 = var3.iterator();

         while(var5.hasNext()) {
            AttributeModifier var6 = (AttributeModifier)var5.next();
            if(var6.e()) {
               var4.add((NBTBase)a(var6));
            }
         }

         var1.set("Modifiers", (NBTBase)var4);
      }

      return var1;
   }

   private static NBTTagCompound a(AttributeModifier var0) {
      NBTTagCompound var1 = new NBTTagCompound();
      var1.setString("Name", var0.b());
      var1.setDouble("Amount", var0.d());
      var1.setInt("Operation", var0.c());
      var1.setLong("UUIDMost", var0.a().getMostSignificantBits());
      var1.setLong("UUIDLeast", var0.a().getLeastSignificantBits());
      return var1;
   }

   public static void a(AttributeMapBase var0, NBTTagList var1) {
      for(int var2 = 0; var2 < var1.size(); ++var2) {
         NBTTagCompound var3 = var1.get(var2);
         AttributeInstance var4 = var0.a(var3.getString("Name"));
         if(var4 != null) {
            a(var4, var3);
         } else {
            f.warn("Ignoring unknown attribute \'" + var3.getString("Name") + "\'");
         }
      }

   }

   private static void a(AttributeInstance var0, NBTTagCompound var1) {
      var0.a(var1.getDouble("Base"));
      if(var1.hasKeyOfType("Modifiers", 9)) {
         NBTTagList var2 = var1.getList("Modifiers", 10);

         for(int var3 = 0; var3 < var2.size(); ++var3) {
            AttributeModifier var4 = a(var2.get(var3));
            if(var4 != null) {
               AttributeModifier var5 = var0.a(var4.a());
               if(var5 != null) {
                  var0.c(var5);
               }

               var0.b(var4);
            }
         }
      }

   }

   public static AttributeModifier a(NBTTagCompound var0) {
      UUID var1 = new UUID(var0.getLong("UUIDMost"), var0.getLong("UUIDLeast"));

      try {
         return new AttributeModifier(var1, var0.getString("Name"), var0.getDouble("Amount"), var0.getInt("Operation"));
      } catch (Exception var3) {
         f.warn("Unable to create attribute: " + var3.getMessage());
         return null;
      }
   }

}
