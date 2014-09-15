package net.minecraft.server;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServerStatisticsManager extends tz {

   private static final Logger b = LogManager.getLogger();
   private final MinecraftServer c;
   private final File d;
   private final Set e = Sets.newHashSet();
   private int f = -300;
   private boolean g = false;


   public ServerStatisticsManager(MinecraftServer var1, File var2) {
      this.c = var1;
      this.d = var2;
   }

   public void a() {
      if(this.d.isFile()) {
         try {
            this.a.clear();
            this.a.putAll(this.a(FileUtils.readFileToString(this.d)));
         } catch (IOException var2) {
            b.error("Couldn\'t read statistics file " + this.d, var2);
         } catch (JsonParseException var3) {
            b.error("Couldn\'t parse statistics file " + this.d, var3);
         }
      }

   }

   public void b() {
      try {
         FileUtils.writeStringToFile(this.d, a(this.a));
      } catch (IOException var2) {
         b.error("Couldn\'t save stats", var2);
      }

   }

   public void a(EntityHuman var1, tq var2, int var3) {
      int var4 = var2.d()?this.a(var2):0;
      super.a(var1, var2, var3);
      this.e.add(var2);
      if(var2.d() && var4 == 0 && var3 > 0) {
         this.g = true;
         if(this.c.az()) {
            this.c.an().a((IChatBaseComponent)(new ChatMessage("chat.type.achievement", new Object[]{var1.getScoreboardDisplayName(), var2.j()})));
         }
      }

      if(var2.d() && var4 > 0 && var3 == 0) {
         this.g = true;
         if(this.c.az()) {
            this.c.an().a((IChatBaseComponent)(new ChatMessage("chat.type.achievement.taken", new Object[]{var1.getScoreboardDisplayName(), var2.j()})));
         }
      }

   }

   public Set c() {
      HashSet var1 = Sets.newHashSet(this.e);
      this.e.clear();
      this.g = false;
      return var1;
   }

   public Map a(String var1) {
      JsonElement var2 = (new JsonParser()).parse(var1);
      if(!var2.isJsonObject()) {
         return Maps.newHashMap();
      } else {
         JsonObject var3 = var2.getAsJsonObject();
         HashMap var4 = Maps.newHashMap();
         Iterator var5 = var3.entrySet().iterator();

         while(var5.hasNext()) {
            Entry var6 = (Entry)var5.next();
            tq var7 = ty.a((String)var6.getKey());
            if(var7 != null) {
               tw var8 = new tw();
               if(((JsonElement)var6.getValue()).isJsonPrimitive() && ((JsonElement)var6.getValue()).getAsJsonPrimitive().isNumber()) {
                  var8.a(((JsonElement)var6.getValue()).getAsInt());
               } else if(((JsonElement)var6.getValue()).isJsonObject()) {
                  JsonObject var9 = ((JsonElement)var6.getValue()).getAsJsonObject();
                  if(var9.has("value") && var9.get("value").isJsonPrimitive() && var9.get("value").getAsJsonPrimitive().isNumber()) {
                     var8.a(var9.getAsJsonPrimitive("value").getAsInt());
                  }

                  if(var9.has("progress") && var7.l() != null) {
                     try {
                        Constructor var10 = var7.l().getConstructor(new Class[0]);
                        tx var11 = (tx)var10.newInstance(new Object[0]);
                        var11.a(var9.get("progress"));
                        var8.a(var11);
                     } catch (Throwable var12) {
                        b.warn("Invalid statistic progress in " + this.d, var12);
                     }
                  }
               }

               var4.put(var7, var8);
            } else {
               b.warn("Invalid statistic in " + this.d + ": Don\'t know what " + (String)var6.getKey() + " is");
            }
         }

         return var4;
      }
   }

   public static String a(Map var0) {
      JsonObject var1 = new JsonObject();
      Iterator var2 = var0.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if(((tw)var3.getValue()).b() != null) {
            JsonObject var4 = new JsonObject();
            var4.addProperty("value", Integer.valueOf(((tw)var3.getValue()).a()));

            try {
               var4.add("progress", ((tw)var3.getValue()).b().a());
            } catch (Throwable var6) {
               b.warn("Couldn\'t save statistic " + ((tq)var3.getKey()).e() + ": error serializing progress", var6);
            }

            var1.add(((tq)var3.getKey()).e, var4);
         } else {
            var1.addProperty(((tq)var3.getKey()).e, Integer.valueOf(((tw)var3.getValue()).a()));
         }
      }

      return var1.toString();
   }

   public void d() {
      Iterator var1 = this.a.keySet().iterator();

      while(var1.hasNext()) {
         tq var2 = (tq)var1.next();
         this.e.add(var2);
      }

   }

   public void a(EntityPlayer var1) {
      int var2 = this.c.ar();
      HashMap var3 = Maps.newHashMap();
      if(this.g || var2 - this.f > 300) {
         this.f = var2;
         Iterator var4 = this.c().iterator();

         while(var4.hasNext()) {
            tq var5 = (tq)var4.next();
            var3.put(var5, Integer.valueOf(this.a(var5)));
         }
      }

      var1.a.sendPacket((Packet)(new is(var3)));
   }

   public void b(EntityPlayer var1) {
      HashMap var2 = Maps.newHashMap();
      Iterator var3 = AchievementList.e.iterator();

      while(var3.hasNext()) {
         Achievement var4 = (Achievement)var3.next();
         if(this.a(var4)) {
            var2.put(var4, Integer.valueOf(this.a((tq)var4)));
            this.e.remove(var4);
         }
      }

      var1.a.sendPacket((Packet)(new is(var2)));
   }

   public boolean e() {
      return this.g;
   }

}
