package net.minecraft.server;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ty {

   protected static Map a = Maps.newHashMap();
   public static List b = Lists.newArrayList();
   public static List c = Lists.newArrayList();
   public static List d = Lists.newArrayList();
   public static List e = Lists.newArrayList();
   public static tq f = (new tn("stat.leaveGame", new ChatMessage("stat.leaveGame", new Object[0]))).i().h();
   public static tq g = (new tn("stat.playOneMinute", new ChatMessage("stat.playOneMinute", new Object[0]), tq.h)).i().h();
   public static tq h = (new tn("stat.timeSinceDeath", new ChatMessage("stat.timeSinceDeath", new Object[0]), tq.h)).i().h();
   public static tq i = (new tn("stat.walkOneCm", new ChatMessage("stat.walkOneCm", new Object[0]), tq.i)).i().h();
   public static tq j = (new tn("stat.crouchOneCm", new ChatMessage("stat.crouchOneCm", new Object[0]), tq.i)).i().h();
   public static tq k = (new tn("stat.sprintOneCm", new ChatMessage("stat.sprintOneCm", new Object[0]), tq.i)).i().h();
   public static tq l = (new tn("stat.swimOneCm", new ChatMessage("stat.swimOneCm", new Object[0]), tq.i)).i().h();
   public static tq m = (new tn("stat.fallOneCm", new ChatMessage("stat.fallOneCm", new Object[0]), tq.i)).i().h();
   public static tq n = (new tn("stat.climbOneCm", new ChatMessage("stat.climbOneCm", new Object[0]), tq.i)).i().h();
   public static tq o = (new tn("stat.flyOneCm", new ChatMessage("stat.flyOneCm", new Object[0]), tq.i)).i().h();
   public static tq p = (new tn("stat.diveOneCm", new ChatMessage("stat.diveOneCm", new Object[0]), tq.i)).i().h();
   public static tq q = (new tn("stat.minecartOneCm", new ChatMessage("stat.minecartOneCm", new Object[0]), tq.i)).i().h();
   public static tq r = (new tn("stat.boatOneCm", new ChatMessage("stat.boatOneCm", new Object[0]), tq.i)).i().h();
   public static tq s = (new tn("stat.pigOneCm", new ChatMessage("stat.pigOneCm", new Object[0]), tq.i)).i().h();
   public static tq t = (new tn("stat.horseOneCm", new ChatMessage("stat.horseOneCm", new Object[0]), tq.i)).i().h();
   public static tq u = (new tn("stat.jump", new ChatMessage("stat.jump", new Object[0]))).i().h();
   public static tq v = (new tn("stat.drop", new ChatMessage("stat.drop", new Object[0]))).i().h();
   public static tq w = (new tn("stat.damageDealt", new ChatMessage("stat.damageDealt", new Object[0]), tq.j)).h();
   public static tq x = (new tn("stat.damageTaken", new ChatMessage("stat.damageTaken", new Object[0]), tq.j)).h();
   public static tq y = (new tn("stat.deaths", new ChatMessage("stat.deaths", new Object[0]))).h();
   public static tq z = (new tn("stat.mobKills", new ChatMessage("stat.mobKills", new Object[0]))).h();
   public static tq A = (new tn("stat.animalsBred", new ChatMessage("stat.animalsBred", new Object[0]))).h();
   public static tq B = (new tn("stat.playerKills", new ChatMessage("stat.playerKills", new Object[0]))).h();
   public static tq C = (new tn("stat.fishCaught", new ChatMessage("stat.fishCaught", new Object[0]))).h();
   public static tq D = (new tn("stat.junkFished", new ChatMessage("stat.junkFished", new Object[0]))).h();
   public static tq E = (new tn("stat.treasureFished", new ChatMessage("stat.treasureFished", new Object[0]))).h();
   public static tq F = (new tn("stat.talkedToVillager", new ChatMessage("stat.talkedToVillager", new Object[0]))).h();
   public static tq G = (new tn("stat.tradedWithVillager", new ChatMessage("stat.tradedWithVillager", new Object[0]))).h();
   public static final tq[] H = new tq[4096];
   public static final tq[] I = new tq[32000];
   public static final tq[] J = new tq[32000];
   public static final tq[] K = new tq[32000];


   public static void a() {
      c();
      d();
      e();
      b();
      AchievementList.a();
      EntityTypes.a();
   }

   private static void b() {
      HashSet var0 = Sets.newHashSet();
      Iterator var1 = aop.a().b().iterator();

      while(var1.hasNext()) {
         aoo var2 = (aoo)var1.next();
         if(var2.b() != null) {
            var0.add(var2.b().b());
         }
      }

      var1 = aok.a().b().values().iterator();

      while(var1.hasNext()) {
         ItemStack var5 = (ItemStack)var1.next();
         var0.add(var5.b());
      }

      var1 = var0.iterator();

      while(var1.hasNext()) {
         Item var6 = (Item)var1.next();
         if(var6 != null) {
            int var3 = Item.b(var6);
            String var4 = a(var6);
            if(var4 != null) {
               I[var3] = (new to("stat.craftItem.", var4, new ChatMessage("stat.craftItem", new Object[]{(new ItemStack(var6)).C()}), var6)).h();
            }
         }
      }

      a(I);
   }

   private static void c() {
      Iterator var0 = Block.c.iterator();

      while(var0.hasNext()) {
         Block var1 = (Block)var0.next();
         Item var2 = Item.a(var1);
         if(var2 != null) {
            int var3 = Block.a(var1);
            String var4 = a(var2);
            if(var4 != null && var1.I()) {
               H[var3] = (new to("stat.mineBlock.", var4, new ChatMessage("stat.mineBlock", new Object[]{(new ItemStack(var1)).C()}), var2)).h();
               e.add((to)H[var3]);
            }
         }
      }

      a(H);
   }

   private static void d() {
      Iterator var0 = Item.e.iterator();

      while(var0.hasNext()) {
         Item var1 = (Item)var0.next();
         if(var1 != null) {
            int var2 = Item.b(var1);
            String var3 = a(var1);
            if(var3 != null) {
               J[var2] = (new to("stat.useItem.", var3, new ChatMessage("stat.useItem", new Object[]{(new ItemStack(var1)).C()}), var1)).h();
               if(!(var1 instanceof aju)) {
                  d.add((to)J[var2]);
               }
            }
         }
      }

      a(J);
   }

   private static void e() {
      Iterator var0 = Item.e.iterator();

      while(var0.hasNext()) {
         Item var1 = (Item)var0.next();
         if(var1 != null) {
            int var2 = Item.b(var1);
            String var3 = a(var1);
            if(var3 != null && var1.m()) {
               K[var2] = (new to("stat.breakItem.", var3, new ChatMessage("stat.breakItem", new Object[]{(new ItemStack(var1)).C()}), var1)).h();
            }
         }
      }

      a(K);
   }

   private static String a(Item var0) {
      RegistryPrepender var1 = (RegistryPrepender)Item.e.c(var0);
      return var1 != null?var1.toString().replace(':', '.'):null;
   }

   private static void a(tq[] var0) {
      a(var0, Blocks.STATIONARY_WATER, Blocks.WATER);
      a(var0, Blocks.STATIONARY_LAVA, Blocks.LAVA);
      a(var0, Blocks.JACK_O_LANTERN, Blocks.PUMPKIN);
      a(var0, Blocks.BURNING_FURNACE, Blocks.FURNACE);
      a(var0, Blocks.GLOWING_REDSTONE_ORE, Blocks.REDSTONE_ORE);
      a(var0, Blocks.DIODE_ON, Blocks.DIODE_OFF);
      a(var0, Blocks.REDSTONE_COMPARATOR_ON, Blocks.REDSTONE_COMPARATOR_OFF);
      a(var0, Blocks.REDSTONE_TORCH_ON, Blocks.REDSTONE_TORCH_OFF);
      a(var0, Blocks.REDSTONE_LAMP_ON, Blocks.REDSTONE_LAMP_OFF);
      a(var0, Blocks.DOUBLE_STEP1, Blocks.STEP1);
      a(var0, Blocks.WOOD_DOUBLE_STEP, Blocks.WOOD_STEP);
      a(var0, Blocks.DOUBLE_STEP2, Blocks.STEP2);
      a(var0, Blocks.GRASS, Blocks.DIRT);
      a(var0, Blocks.FARMLAND, Blocks.DIRT);
   }

   private static void a(tq[] var0, Block var1, Block var2) {
      int var3 = Block.a(var1);
      int var4 = Block.a(var2);
      if(var0[var3] != null && var0[var4] == null) {
         var0[var4] = var0[var3];
      } else {
         b.remove(var0[var3]);
         e.remove(var0[var3]);
         c.remove(var0[var3]);
         var0[var3] = var0[var4];
      }
   }

   public static tq a(MonsterEggInfo var0) {
      String var1 = EntityTypes.b(var0.a);
      return var1 == null?null:(new tq("stat.killEntity." + var1, new ChatMessage("stat.entityKill", new Object[]{new ChatMessage("entity." + var1 + ".name", new Object[0])}))).h();
   }

   public static tq b(MonsterEggInfo var0) {
      String var1 = EntityTypes.b(var0.a);
      return var1 == null?null:(new tq("stat.entityKilledBy." + var1, new ChatMessage("stat.entityKilledBy", new Object[]{new ChatMessage("entity." + var1 + ".name", new Object[0])}))).h();
   }

   public static tq a(String var0) {
      return (tq)a.get(var0);
   }

}
