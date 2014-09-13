package net.minecraft.server;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;

import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.hash.TIntObjectHashMap;

import java.util.Iterator;
import java.util.Map;

import org.apache.logging.log4j.LogManager;

public enum gy {

   a("HANDSHAKING", 0, -1),
   b("PLAY", 1, 0),
   c("STATUS", 2, 1),
   d("LOGIN", 3, 2);
   private static final TIntObjectMap e = new TIntObjectHashMap();
   private static final Map f = Maps.newHashMap();
   private final int g;
   private final Map h;
   // $FF: synthetic field
   private static final gy[] i = new gy[]{a, b, c, d};


   private gy(String var1, int var2, int var3) {
      this.h = Maps.newEnumMap(EnumPacketDirection.class);
      this.g = var3;
   }

   protected gy a(EnumPacketDirection var1, Class var2) {
      Object var3 = (BiMap)this.h.get(var1);
      if(var3 == null) {
         var3 = HashBiMap.create();
         this.h.put(var1, var3);
      }

      if(((BiMap)var3).containsValue(var2)) {
         String var4 = var1 + " packet " + var2 + " is already known to ID " + ((BiMap)var3).inverse().get(var2);
         LogManager.getLogger().fatal(var4);
         throw new IllegalArgumentException(var4);
      } else {
         ((BiMap)var3).put(Integer.valueOf(((BiMap)var3).size()), var2);
         return this;
      }
   }

   public Integer a(EnumPacketDirection var1, Packet var2) {
      return (Integer)((BiMap)this.h.get(var1)).inverse().get(var2.getClass());
   }

   public Packet a(EnumPacketDirection var1, int var2) throws InstantiationException, IllegalAccessException {
      Class var3 = (Class)((BiMap)this.h.get(var1)).get(Integer.valueOf(var2));
      return var3 == null?null:(Packet)var3.newInstance();
   }

   public int a() {
      return this.g;
   }

   public static gy a(int var0) {
      return (gy)e.get(var0);
   }

   public static gy a(Packet var0) {
      return (gy)f.get(var0.getClass());
   }

   // $FF: synthetic method
   gy(String var1, int var2, int var3, gz var4) {
      this(var1, var2, var3);
   }

   static {
      gy[] var0 = values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         gy var3 = var0[var2];
         e.put(var3.a(), var3);
         Iterator var4 = var3.h.keySet().iterator();

         while(var4.hasNext()) {
            EnumPacketDirection var5 = (EnumPacketDirection)var4.next();

            Class var7;
            for(Iterator var6 = ((BiMap)var3.h.get(var5)).values().iterator(); var6.hasNext(); f.put(var7, var3)) {
               var7 = (Class)var6.next();
               if(f.containsKey(var7) && f.get(var7) != var3) {
                  throw new Error("Packet " + var7 + " is already assigned to protocol " + f.get(var7) + " - can\'t reassign to " + var3);
               }

               try {
                  var7.newInstance();
               } catch (Throwable var9) {
                  throw new Error("Packet " + var7 + " fails instantiation checks! " + var7);
               }
            }
         }
      }

   }
}
