package net.minecraft.server;
import com.google.common.base.Charsets;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import com.mojang.authlib.Agent;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.ProfileLookupCallback;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class sf {

   private static final Logger e = LogManager.getLogger();
   public static final File a = new File("banned-ips.txt");
   public static final File b = new File("banned-players.txt");
   public static final File c = new File("ops.txt");
   public static final File d = new File("white-list.txt");


   static List a(File var0, Map var1) throws IOException {
      List var2 = Files.readLines(var0, Charsets.UTF_8);
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         var4 = var4.trim();
         if(!var4.startsWith("#") && var4.length() >= 1) {
            String[] var5 = var4.split("\\|");
            var1.put(var5[0].toLowerCase(Locale.ROOT), var5);
         }
      }

      return var2;
   }

   private static void a(MinecraftServer var0, Collection var1, ProfileLookupCallback var2) {
      String[] var3 = (String[])Iterators.toArray(Iterators.filter(var1.iterator(), new sg()), String.class);
      if(var0.ae()) {
         var0.aC().findProfilesByNames(var3, Agent.MINECRAFT, var2);
      } else {
         String[] var4 = var3;
         int var5 = var3.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            String var7 = var4[var6];
            UUID var8 = ahd.a(new GameProfile((UUID)null, var7));
            GameProfile var9 = new GameProfile(var8, var7);
            var2.onProfileLookupSucceeded(var9);
         }
      }

   }

   public static boolean a(MinecraftServer var0) {
      sv var1 = new sv(PlayerList.a);
      if(b.exists() && b.isFile()) {
         if(var1.c().exists()) {
            try {
               var1.g();
            } catch (FileNotFoundException var6) {
               e.warn("Could not load existing file " + var1.c().getName(), var6);
            }
         }

         try {
            HashMap var2 = Maps.newHashMap();
            a(b, (Map)var2);
            sh var3 = new sh(var0, var2, var1);
            a(var0, var2.keySet(), var3);
            var1.f();
            c(b);
            return true;
         } catch (IOException var4) {
            e.warn("Could not read old user banlist to convert it!", var4);
            return false;
         } catch (sm var5) {
            e.error("Conversion failed, please try again later", var5);
            return false;
         }
      } else {
         return true;
      }
   }

   public static boolean b(MinecraftServer var0) {
      sd var1 = new sd(PlayerList.b);
      if(a.exists() && a.isFile()) {
         if(var1.c().exists()) {
            try {
               var1.g();
            } catch (FileNotFoundException var11) {
               e.warn("Could not load existing file " + var1.c().getName(), var11);
            }
         }

         try {
            HashMap var2 = Maps.newHashMap();
            a(a, (Map)var2);
            Iterator var3 = var2.keySet().iterator();

            while(var3.hasNext()) {
               String var4 = (String)var3.next();
               String[] var5 = (String[])var2.get(var4);
               Date var6 = var5.length > 1?b(var5[1], (Date)null):null;
               String var7 = var5.length > 2?var5[2]:null;
               Date var8 = var5.length > 3?b(var5[3], (Date)null):null;
               String var9 = var5.length > 4?var5[4]:null;
               var1.a((sr)(new se(var4, var6, var7, var8, var9)));
            }

            var1.f();
            c(a);
            return true;
         } catch (IOException var10) {
            e.warn("Could not parse old ip banlist to convert it!", var10);
            return false;
         }
      } else {
         return true;
      }
   }

   public static boolean c(MinecraftServer var0) {
      sp var1 = new sp(PlayerList.c);
      if(c.exists() && c.isFile()) {
         if(var1.c().exists()) {
            try {
               var1.g();
            } catch (FileNotFoundException var6) {
               e.warn("Could not load existing file " + var1.c().getName(), var6);
            }
         }

         try {
            List var2 = Files.readLines(c, Charsets.UTF_8);
            si var3 = new si(var0, var1);
            a(var0, var2, var3);
            var1.f();
            c(c);
            return true;
         } catch (IOException var4) {
            e.warn("Could not read old oplist to convert it!", var4);
            return false;
         } catch (sm var5) {
            e.error("Conversion failed, please try again later", var5);
            return false;
         }
      } else {
         return true;
      }
   }

   public static boolean d(MinecraftServer var0) {
      sx var1 = new sx(PlayerList.d);
      if(d.exists() && d.isFile()) {
         if(var1.c().exists()) {
            try {
               var1.g();
            } catch (FileNotFoundException var6) {
               e.warn("Could not load existing file " + var1.c().getName(), var6);
            }
         }

         try {
            List var2 = Files.readLines(d, Charsets.UTF_8);
            sj var3 = new sj(var0, var1);
            a(var0, var2, var3);
            var1.f();
            c(d);
            return true;
         } catch (IOException var4) {
            e.warn("Could not read old whitelist to convert it!", var4);
            return false;
         } catch (sm var5) {
            e.error("Conversion failed, please try again later", var5);
            return false;
         }
      } else {
         return true;
      }
   }

   public static String a(String var0) {
      if(!vb.b(var0) && var0.length() <= 16) {
         MinecraftServer var1 = MinecraftServer.M();
         GameProfile var2 = var1.aD().a(var0);
         if(var2 != null && var2.getId() != null) {
            return var2.getId().toString();
         } else if(!var1.S() && var1.ae()) {
            ArrayList var3 = Lists.newArrayList();
            sk var4 = new sk(var1, var3);
            a(var1, Lists.newArrayList(new String[]{var0}), var4);
            return var3.size() > 0 && ((GameProfile)var3.get(0)).getId() != null?((GameProfile)var3.get(0)).getId().toString():"";
         } else {
            return ahd.a(new GameProfile((UUID)null, var0)).toString();
         }
      } else {
         return var0;
      }
   }

   public static boolean a(DedicatedServer var0, pl var1) {
      File var2 = d(var1);
      File var3 = new File(var2.getParentFile(), "playerdata");
      File var4 = new File(var2.getParentFile(), "unknownplayers");
      if(var2.exists() && var2.isDirectory()) {
         File[] var5 = var2.listFiles();
         ArrayList var6 = Lists.newArrayList();
         File[] var7 = var5;
         int var8 = var5.length;

         for(int var9 = 0; var9 < var8; ++var9) {
            File var10 = var7[var9];
            String var11 = var10.getName();
            if(var11.toLowerCase(Locale.ROOT).endsWith(".dat")) {
               String var12 = var11.substring(0, var11.length() - ".dat".length());
               if(var12.length() > 0) {
                  var6.add(var12);
               }
            }
         }

         try {
            String[] var14 = (String[])var6.toArray(new String[var6.size()]);
            sl var15 = new sl(var0, var3, var4, var2, var14);
            a(var0, Lists.newArrayList(var14), var15);
            return true;
         } catch (sm var13) {
            e.error("Conversion failed, please try again later", var13);
            return false;
         }
      } else {
         return true;
      }
   }

   private static void b(File var0) {
      if(var0.exists()) {
         if(!var0.isDirectory()) {
            throw new sm("Can\'t create directory " + var0.getName() + " in world save directory.", (sg)null);
         }
      } else if(!var0.mkdirs()) {
         throw new sm("Can\'t create directory " + var0.getName() + " in world save directory.", (sg)null);
      }
   }

   public static boolean a(pl var0) {
      boolean var1 = b(var0);
      var1 = var1 && c(var0);
      return var1;
   }

   private static boolean b(pl var0) {
      boolean var1 = false;
      if(b.exists() && b.isFile()) {
         var1 = true;
      }

      boolean var2 = false;
      if(a.exists() && a.isFile()) {
         var2 = true;
      }

      boolean var3 = false;
      if(c.exists() && c.isFile()) {
         var3 = true;
      }

      boolean var4 = false;
      if(d.exists() && d.isFile()) {
         var4 = true;
      }

      if(!var1 && !var2 && !var3 && !var4) {
         return true;
      } else {
         e.warn("**** FAILED TO START THE SERVER AFTER ACCOUNT CONVERSION!");
         e.warn("** please remove the following files and restart the server:");
         if(var1) {
            e.warn("* " + b.getName());
         }

         if(var2) {
            e.warn("* " + a.getName());
         }

         if(var3) {
            e.warn("* " + c.getName());
         }

         if(var4) {
            e.warn("* " + d.getName());
         }

         return false;
      }
   }

   private static boolean c(pl var0) {
      File var1 = d(var0);
      if(var1.exists() && var1.isDirectory() && (var1.list().length > 0 || !var1.delete())) {
         e.warn("**** DETECTED OLD PLAYER DIRECTORY IN THE WORLD SAVE");
         e.warn("**** THIS USUALLY HAPPENS WHEN THE AUTOMATIC CONVERSION FAILED IN SOME WAY");
         e.warn("** please restart the server and if the problem persists, remove the directory \'{}\'", new Object[]{var1.getPath()});
         return false;
      } else {
         return true;
      }
   }

   private static File d(pl var0) {
      String var1 = var0.a("level-name", "world");
      File var2 = new File(var1);
      return new File(var2, "players");
   }

   private static void c(File var0) {
      File var1 = new File(var0.getName() + ".converted");
      var0.renameTo(var1);
   }

   private static Date b(String var0, Date var1) {
      Date var2;
      try {
         var2 = rx.a.parse(var0);
      } catch (ParseException var4) {
         var2 = var1;
      }

      return var2;
   }

   // $FF: synthetic method
   static Logger a() {
      return e;
   }

   // $FF: synthetic method
   static Date a(String var0, Date var1) {
      return b(var0, var1);
   }

   // $FF: synthetic method
   static void a(File var0) {
      b(var0);
   }

}
